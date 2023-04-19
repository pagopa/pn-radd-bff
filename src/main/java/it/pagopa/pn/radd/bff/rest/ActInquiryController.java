package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.ActDocumentInquiryApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.service.ActInquiryService;
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
public class ActInquiryController implements ActDocumentInquiryApi {

    @Qualifier("raddBffScheduler")
    private final Scheduler scheduler;

    private final ActInquiryService actInquiryService;

    /**
     * GET /radd-web/act/inquiry
     * API utilizzata per la verifica della presenza a sistema di atti e attestazioni.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param recipientTaxId Codice Fiscale Destinatario (required)
     * @param recipientType Sigla, Persona fisica o giuridica (required)
     * @param qrCode Qr Code presente sull&#39;avviso di Avvenuta ricezione (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<ActInquiryResponse>> actInquiry(String xPagopaPnUid,
                                                               String recipientTaxId,
                                                               String recipientType,
                                                               String qrCode,
                                                               final ServerWebExchange exchange) {
        return actInquiryService.actInquiry(xPagopaPnUid, recipientTaxId, recipientType, qrCode)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }
}
