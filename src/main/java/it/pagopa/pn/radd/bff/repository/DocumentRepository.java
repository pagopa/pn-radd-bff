package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import reactor.core.publisher.Mono;

public interface DocumentRepository {
	public Mono<DocumentModel> findByFileKey(String fileKey);
}
