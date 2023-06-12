package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import reactor.test.StepVerifier;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ContextConfiguration (classes = {DocumentRepositoryImpl.class})
@ExtendWith(MockitoExtension.class)
class DocumentRepositoryImplTest {

	@Mock
	private DynamoDbAsyncTable<Object> table;
	@Mock
	private DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient;

	@Test
	void testFindByFileKey() {
		when(dynamoDbEnhancedAsyncClient.table(any(), any()))
				.thenReturn(table);
		DocumentRepository documentRepository = new DocumentRepositoryImpl(dynamoDbEnhancedAsyncClient, "");
		when(table.getItem(any(Key.class)))
				.thenReturn(CompletableFuture.completedFuture(new DocumentModel()));
		StepVerifier.create(documentRepository.findByFileKey("fileKey"))
				.expectNextCount(1)
				.verifyComplete();
	}


	@Test
	void testPutDocumentReadyRecord() {
		when(dynamoDbEnhancedAsyncClient.table(any(), any()))
				.thenReturn(table);
		DocumentRepository documentRepository = new DocumentRepositoryImpl(dynamoDbEnhancedAsyncClient, "");
		CompletableFuture<Void> completableFuture = new CompletableFuture<>();
		completableFuture.complete(null);
		when(table.putItem(any(DocumentModel.class)))
				.thenReturn(completableFuture);
		StepVerifier.create(documentRepository.putDocumentReadyRecord("fileKey"))
				.verifyComplete();
	}
}

