package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.AorTransactionManagementApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.AorTransactionManagementService;
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
public class AorTransactionManagementController implements AorTransactionManagementApi {

    @Qualifier("raddBffScheduler")
    private final Scheduler scheduler;

    private final AorTransactionManagementService aorTransactionManagementService;

    /**
     * POST /radd-web/aor/transaction/abort
     * API utilizzata per la notifica dell&#39;annullamento dell&#39;operazione di consegna del/degli avviso/i di avvenuta ricezione.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param abortTransactionRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<AbortTransactionResponse>> abortAorTransaction(String xPagopaPnUid,
                                                                              Mono<AbortTransactionRequest> abortTransactionRequest,
                                                                              final ServerWebExchange exchange) {
        return aorTransactionManagementService.abortAorTransaction(xPagopaPnUid, abortTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    /**
     * POST /radd-web/aor/transaction/complete
     * API utilizzata per la notifica del completamento dell&#39;operazione di consegna dell&#39;atto.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param completeTransactionRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<CompleteTransactionResponse>> completeAorTransaction(String xPagopaPnUid,
                                                                                    Mono<CompleteTransactionRequest> completeTransactionRequest,
                                                                                    final ServerWebExchange exchange) {
        return aorTransactionManagementService.completeAorTransaction(xPagopaPnUid, completeTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    /**
     * POST /radd-web/aor/transaction/start
     * API utilizzata per la richiesta di avvio delloperazione di scaricamento e consegna degli avvisi di avvenuta ricezione.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param aorStartTransactionRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public  Mono<ResponseEntity<StartTransactionResponse>> startAorTransaction(String xPagopaPnUid,
                                                                               Mono<AorStartTransactionRequest> aorStartTransactionRequest,
                                                                               final ServerWebExchange exchange) {
        return aorTransactionManagementService.startAorTransaction(xPagopaPnUid, aorStartTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }
}
