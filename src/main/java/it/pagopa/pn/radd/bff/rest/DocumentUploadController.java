package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.DocumentUploadApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadResponse;
import it.pagopa.pn.radd.bff.service.DocumentUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DocumentUploadController implements DocumentUploadApi {

    private final DocumentUploadService documentUploadService;


    @Override
    public Mono<ResponseEntity<DocumentUploadResponse>> documentUpload(String uid, Mono<DocumentUploadRequest> documentUploadRequest, final ServerWebExchange exchange) {
        return documentUploadService.documentUpload(uid, documentUploadRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
