package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.ActDocumentInquiryApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.service.ActInquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ActInquiryController implements ActDocumentInquiryApi {

    private final ActInquiryService actInquiryService;


    @Override
    public Mono<ResponseEntity<ActInquiryResponse>> actInquiry(String uid, String recipientTaxId, String recipientType, String qrCode, final ServerWebExchange exchange) {
        return actInquiryService.actInquiry(uid, recipientTaxId, recipientType, qrCode).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
