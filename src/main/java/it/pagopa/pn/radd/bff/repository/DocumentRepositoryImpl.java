package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.constant.DocumentConstant;
import it.pagopa.pn.radd.bff.entity.DocumentModel;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class DocumentRepositoryImpl implements DocumentRepository {
	private final DynamoDbAsyncTable<DocumentModel> table;
	private final DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient;
	private final String gsiPageableDocument;

	public DocumentRepositoryImpl (DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient,
								   @Value ("${pn.radd.bff.document.gsi-pageable-id}") String gsiPageableDocument,
								   @Value ("${pn.radd.bff.dynamodb.tablename.pn-document}") String tableName) {
		this.table = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(DocumentModel.class));
		this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
		this.gsiPageableDocument = gsiPageableDocument;
	}

	@Override
	public Mono<Page<DocumentModel>> getAllDocumentByStatus (String status, DocumentPageable pageable) {
		Map<String, String> expressionNames = new HashMap<>();
		expressionNames.put("#status", "status");


		Map<String, AttributeValue> expressionValues = new HashMap<>();
		expressionValues.put(":status", AttributeValue.builder().s(status).build());


		Map<String, AttributeValue> attributeValue = null;


		if (pageable.isPage()) {
			attributeValue = new HashMap<>();
			attributeValue.put(DocumentConstant.DOCUMENT_ID, AttributeValue.builder().s(pageable.getLastEvaluatedId()).build());
			attributeValue.put(DocumentConstant.PAGEABLE, AttributeValue.builder().s(DocumentConstant.PAGEABLE_VALUE).build());
		}


		QueryConditional queryConditional = QueryConditional.sortBeginsWith(Key.builder()
				.partitionValue(DocumentConstant.PAGEABLE_VALUE)
				.build());


		QueryEnhancedRequest queryEnhancedRequest = QueryEnhancedRequest.builder()
				.queryConditional(queryConditional)
				.filterExpression(expressionBuilder("(#status = :status)", expressionValues, expressionNames))
				.exclusiveStartKey(attributeValue)
				.limit(pageable.getLimit())
				.build();


		if (pageable.hasLimit()) {
			return Mono.from(table.index(gsiPageableDocument).query(queryEnhancedRequest));
		} else {
			return Flux.from(table.index(gsiPageableDocument).query(queryEnhancedRequest).flatMapIterable(Page::items))
					.collectList()
					.map(Page::create);
		}
	}

	private static Expression expressionBuilder (String expression, Map<String, AttributeValue> expressionValues, Map<String, String> expressionNames) {
		Expression.Builder expressionBuilder = Expression.builder();
		if (expression != null) {
			expressionBuilder.expression(expression);
		}
		if (expressionValues != null) {
			expressionBuilder.expressionValues(expressionValues);
		}
		if (expressionNames != null) {
			expressionBuilder.expressionNames(expressionNames);
		}
		return expressionBuilder.build();
	}
}
