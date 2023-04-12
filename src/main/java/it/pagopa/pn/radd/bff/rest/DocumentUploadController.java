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

    /**
     * POST /radd/documents/upload
     * API utilizzata per la richiesta della presigned URL utilizzata per il caricamento della scansione dei documenti presentati a sportello dal cliente.
     *
     * @param uid Identificativo del client giustapposizione dei campi frazionario-pdl-timestamp (required)
     * @param documentUploadRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<DocumentUploadResponse>> documentUpload(String uid,
                                                                       Mono<DocumentUploadRequest> documentUploadRequest,
                                                                       final ServerWebExchange exchange) {
        return documentUploadService.documentUpload(uid, documentUploadRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
