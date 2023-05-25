package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.repository.DocumentPageable;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DocumentService {
	private final PnRaddFsuClient pnRaddFsuClient;
	private final DocumentService documentService;

	public Mono<DocumentResponse> getAllDocumentByStatus (String status, DocumentPageable pageable) {
		return 	documentService.getAllDocumentByStatus(status, pageable);
	}
}
