package it.pagopa.pn.radd.bff.rest;


import it.pagopa.pn.radd.bff.generated.openapi.server.v1.api.ActTransactionManagementApi;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.service.ActTransactionManagementService;
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
public class ActTransactionManagementController implements ActTransactionManagementApi {

    @Qualifier("raddBffScheduler")
    private final Scheduler scheduler;

    private final ActTransactionManagementService actTransactionManagementService;

    /**
     * POST /radd-web/act/transaction/abort
     * API utilizzata per la notifica dell&#39;annullamento dell&#39;operazione di consegna dell&#39;atto e delle eventuali attestazioni.
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
    public Mono<ResponseEntity<AbortTransactionResponse>> abortActTransaction(String xPagopaPnUid,
                                                                              Mono<AbortTransactionRequest> abortTransactionRequest,
                                                                              final ServerWebExchange exchange) {
        return actTransactionManagementService.abortActTransaction(xPagopaPnUid, abortTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    /**
     * POST /radd-web/act/transaction/complete
     * API utilizzata per la notifica del completamento dell&#39;operazione di consegna dell&#39;atto e delle eventuali attestazioni.
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
    public Mono<ResponseEntity<CompleteTransactionResponse>> completeActTransaction(String xPagopaPnUid,
                                                                                    Mono<CompleteTransactionRequest> completeTransactionRequest,
                                                                                    final ServerWebExchange exchange) {
        return actTransactionManagementService.completeActTransaction(xPagopaPnUid, completeTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    /**
     * POST /radd-web/act/transaction/start
     * API utilizzata per la richiesta di avvio dell&#39;operazione di scaricamento e consegna dell&#39;atto e delle eventuali attestazioni.
     *
     * @param xPagopaPnUid User Identifier (required)
     * @param actStartTransactionRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Method not allowed (status code 405)
     *         or Internal Server Error (status code 500)
     */
    @Override
    public Mono<ResponseEntity<StartTransactionResponse>> startActTransaction(String xPagopaPnUid,
                                                                              Mono<ActStartTransactionRequest> actStartTransactionRequest,
                                                                              final ServerWebExchange exchange) {
        return actTransactionManagementService.startActTransaction(xPagopaPnUid, actStartTransactionRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }
}
