package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import org.springframework.stereotype.Component;

@Component
public class DocumentConverter {

	public DocumentResponse documentModelToResponse(DocumentModel documentModel) {
		DocumentResponse documentResponse = new DocumentResponse();
		documentResponse.setFileKey(documentModel.getFileKey());
		documentResponse.setReady(true);
		return documentResponse;
	}

}
