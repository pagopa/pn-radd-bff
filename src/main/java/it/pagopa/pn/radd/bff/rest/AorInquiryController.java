package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.AorDocumentInquiryApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.service.AorInquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@RestController
@RequiredArgsConstructor
public class AorInquiryController implements AorDocumentInquiryApi {

    @Qualifier("raddBffScheduler")
    private final Scheduler scheduler;

    private final AorInquiryService aorInquiryService;

    /**
     * GET /radd-web/aor/inquiry
     * API utilizzata per la verifica della presenza a sistema di avvisi di avvenuta ricezione per il cliente.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param recipientTaxId Codice Fiscale Destinatario (required)
     * @param recipientType Sigla, Persona fisica o giuridica (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<AORInquiryResponse>> aorInquiry(String xPagopaPnUid,
                                                               String recipientTaxId,
                                                               String recipientType,
                                                               final ServerWebExchange exchange) {
        return aorInquiryService.aorInquiry(xPagopaPnUid, recipientTaxId, recipientType)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }
}
