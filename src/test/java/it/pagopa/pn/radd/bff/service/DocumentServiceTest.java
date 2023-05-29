package it.pagopa.pn.radd.bff.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.converter.DocumentConverter;
import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.repository.DocumentRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration (classes = {DocumentService.class})
@ExtendWith (SpringExtension.class)
class DocumentServiceTest {
	@MockBean
	private DocumentConverter documentConverter;

	@MockBean
	private DocumentRepository documentRepository;

	@Autowired
	private DocumentService documentService;

	/**
	 * Method under test: {@link DocumentService#getDocumentByFileKey(String)}
	 */
	@Test
	@Disabled ("TODO: Complete this test")
	void testGetDocumentByFileKey () {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.repository.DocumentRepository.findByFileKey(String)" is null
		//       at it.pagopa.pn.radd.bff.service.DocumentService.getDocumentByFileKey(DocumentService.java:18)
		//   See https://diff.blue/R013 to resolve this issue.

		// Arrange
		when(documentRepository.findByFileKey(Mockito.<String>any())).thenReturn(null);

		// Act
		documentService.getDocumentByFileKey("File Key");
	}

	/**
	 * Method under test: {@link DocumentService#getDocumentByFileKey(String)}
	 */
	@Test
	void testGetDocumentByFileKey2 () {
		// Arrange
		when(documentRepository.findByFileKey(Mockito.<String>any())).thenReturn(mock(Mono.class));

		// Act
		documentService.getDocumentByFileKey("File Key");

		// Assert
		verify(documentRepository).findByFileKey(Mockito.<String>any());
	}
}

