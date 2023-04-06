package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.DocumentUploadConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DocumentUploadService {

    private final PnRaddFsuClient pnRaddFsuClient;

    private final DocumentUploadConverter documentUploadConverter;

    public Mono<DocumentUploadResponse> documentUpload(String uid, Mono<DocumentUploadRequest> documentUploadRequest) {
        return documentUploadRequest.map(documentUploadConverter::documentUploadRequestToDto)
                .flatMap(t -> pnRaddFsuClient.documentUpload(uid, t))
                .map(documentUploadConverter::documentUploadDtoToResponse);
    }
}
