package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.converter.DocumentConverter;
import it.pagopa.pn.radd.bff.repository.DocumentRepositoryImpl;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import it.pagopa.pn.radd.bff.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration (classes = {DocumentController.class, DocumentService.class, DocumentConverter.class})
@ExtendWith (SpringExtension.class)
class DocumentControllerTest {

	@Autowired
	private DocumentController documentController;
	@MockBean
	private DocumentService documentService;

	@MockBean
	private DocumentRepositoryImpl documentRepositoryImpl;
	@MockBean
	DocumentConverter documentConverter;

	@MockBean
	private Scheduler scheduler;
	@Mock
	ServerWebExchange serverWebExchange;

	/**
	 * Method under test: {@link DocumentController#getDocumentByFileKey(String, ServerWebExchange)}
	 */
	@Test
	void testGetDocumentByFileKey () {
		DocumentResponse documentResponse = mock(DocumentResponse.class);
		when(documentService.getDocumentByFileKey(any())).thenReturn(Mono.just(documentResponse));
		StepVerifier.create(documentController.getDocumentByFileKey("File Key", serverWebExchange))
				.expectNext(ResponseEntity.ok().body(documentResponse));
	}
}

