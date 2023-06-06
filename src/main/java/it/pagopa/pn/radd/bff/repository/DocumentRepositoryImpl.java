package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Slf4j
@Component

public class DocumentRepositoryImpl implements DocumentRepository {
	private final DynamoDbAsyncTable<DocumentModel> table;

	public DocumentRepositoryImpl (DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient,
								   @Value ("${pn.radd.bff.dynamodb.tablename.pn-document}") String tableName) {
		this.table = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(DocumentModel.class));
	}

	@Override
	public Mono<DocumentModel> findByFileKey (String fileKey) {
		Key key = Key.builder()
				.partitionValue(fileKey)
				.build();
		return Mono.fromFuture(table.getItem(key));
	}
}
