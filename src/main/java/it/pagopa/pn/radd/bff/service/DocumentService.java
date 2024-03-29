package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.converter.DocumentConverter;
import it.pagopa.pn.radd.bff.entity.DocumentModel;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.DocumentResponse;
import it.pagopa.pn.radd.bff.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DocumentService {
	private final DocumentRepository documentRepository;
	private final DocumentConverter documentConverter;
	public Mono<DocumentResponse> getDocumentByFileKey (String fileKey) {
		return documentRepository.findByFileKey(fileKey)
				.map(response -> documentConverter.documentModelToResponse(response,true))
				.switchIfEmpty(Mono.just(new DocumentModel()).map(response -> {
					response.setFileKey(fileKey);
					return documentConverter.documentModelToResponse(response,false);
				}));
	}

    public Mono<Void> setDocumentReadyRecord(String fileKey) {
		return documentRepository.putDocumentReadyRecord(fileKey);
    }
}
