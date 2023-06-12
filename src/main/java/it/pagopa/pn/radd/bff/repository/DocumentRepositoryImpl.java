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

import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
		log.debug("Getting data {} from DynamoDB table {}", fileKey, table.tableName());
		Key key = Key.builder()
				.partitionValue(fileKey)
				.build();
		return Mono.fromFuture(table.getItem(key))
				.map(v -> {
					log.info("Got data from DynamoDB table {}", table.tableName());
					return v;
				});
	}

	@Override
	public Mono<Void> putDocumentReadyRecord(String fileKey) {
		log.debug("Inserting data {} in DynamoDB table {}", fileKey, table.tableName());
		DocumentModel documentModel = new DocumentModel();
		documentModel.setFileKey(fileKey);
		documentModel.setTtl(LocalDateTime.now().plusHours(1).toEpochSecond(ZoneOffset.UTC));
		return Mono.fromFuture(table.putItem(documentModel))
				.map(v -> {
					log.info("Inserted data in DynamoDB table {}", table.tableName());
					return v;
				});
	}
}
