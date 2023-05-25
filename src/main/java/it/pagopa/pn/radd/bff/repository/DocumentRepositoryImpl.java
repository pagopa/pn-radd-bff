package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.constant.DocumentConstant;
import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.exception.PnRaddBffException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.ERROR_CODE_DOCUMENT_NOT_FOUND;
import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.ERROR_MESSAGE_DOCUMENT_NOT_FOUND;

@Slf4j
@Component
public class DocumentRepositoryImpl implements DocumentRepository {
	private final DynamoDbAsyncTable<DocumentModel> table;
	private final DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient;

	public DocumentRepositoryImpl (DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient,
								   @Value ("${pn.radd.bff.dynamodb.tablename.pn-document}") String tableName) {
		this.table = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(DocumentModel.class));
		this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
	}
	@Override
	public Mono<DocumentModel> findByFileKey(String fileKey){
		Key key = Key.builder()
				.partitionValue(fileKey)
				.build();
		return Mono.fromFuture(table.getItem(key))
				.switchIfEmpty(Mono.error(new PnRaddBffException(ERROR_CODE_DOCUMENT_NOT_FOUND,
						ERROR_MESSAGE_DOCUMENT_NOT_FOUND, HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(), null, null)));
	}
}
