package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.AorDocumentInquiryApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.service.AorInquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AorInquiryController implements AorDocumentInquiryApi {

    private final AorInquiryService aorInquiryService;


    @Override
    public Mono<ResponseEntity<AORInquiryResponse>> aorInquiry(String uid, String recipientTaxId, String recipientType, final ServerWebExchange exchange) {
        return aorInquiryService.aorInquiry(uid, recipientTaxId, recipientType).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
