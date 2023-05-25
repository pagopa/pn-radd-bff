package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

public interface DocumentRepository {
	public Mono<Page<DocumentModel>> getAllDocumentByStatus(String fileKey, DocumentPageable pageable);
}
