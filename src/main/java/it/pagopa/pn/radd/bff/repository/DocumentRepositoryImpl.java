package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.exception.PnRaddBffException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.ERROR_CODE_DOCUMENT_NOT_FOUND;
import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.ERROR_MESSAGE_DOCUMENT_NOT_FOUND;

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
		return Mono.fromFuture(table.getItem(key))
				.switchIfEmpty(Mono.error(new PnRaddBffException(ERROR_CODE_DOCUMENT_NOT_FOUND,
						ERROR_MESSAGE_DOCUMENT_NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),
						null, null)));
	}
}
