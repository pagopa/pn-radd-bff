package it.pagopa.pn.radd.bff.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration (classes = {DocumentConverter.class})
@ExtendWith (SpringExtension.class)
class DocumentConverterTest {
	@Autowired
	private DocumentConverter documentConverter;

	/**
	 * Method under test: {@link DocumentConverter#documentModelToResponse(DocumentModel, boolean)}
	 */
	@Test
	void testDocumentModelToResponse () {
		// Arrange
		DocumentModel documentModel = new DocumentModel();
		documentModel.setFileKey("File Key");
		documentModel.setTtl(1L);

		// Act
		DocumentResponse actualDocumentModelToResponseResult = documentConverter.documentModelToResponse(documentModel,
				true);

		// Assert
		assertEquals("File Key", actualDocumentModelToResponseResult.getFileKey());
		assertTrue(actualDocumentModelToResponseResult.getReady());
	}
}

