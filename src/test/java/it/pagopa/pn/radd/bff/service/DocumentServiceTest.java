package it.pagopa.pn.radd.bff.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.converter.DocumentConverter;
import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.repository.DocumentRepository;
import it.pagopa.pn.radd.bff.repository.DocumentRepositoryImpl;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration (classes = {DocumentService.class})
@ExtendWith (SpringExtension.class)
class DocumentServiceTest {
	@MockBean
	private DocumentConverter documentConverter;

	@MockBean
	private DocumentRepositoryImpl documentRepository;

	@Autowired
	private DocumentService documentService;

	/**
	 * Method under test: {@link DocumentService#getDocumentByFileKey(String)}
	 */
	@Test
	void testGetDocumentByFileKey () {
		DocumentResponse documentResponse = mock(DocumentResponse.class);
		when(documentConverter.documentModelToResponse(Mockito.any(DocumentModel.class), Mockito.anyBoolean())).thenReturn(documentResponse);
		when(documentRepository.findByFileKey("fileKey")).thenReturn(Mono.just(mock(DocumentModel.class)));
		StepVerifier.create(documentService.getDocumentByFileKey("fileKey"))
				.expectNext(documentResponse)
				.verifyComplete();
		when(documentRepository.findByFileKey("fileKey")).thenReturn(Mono.empty());
		StepVerifier.create(documentService.getDocumentByFileKey("fileKey"))
				.expectNext(documentResponse)
				.verifyComplete();

	}
}

