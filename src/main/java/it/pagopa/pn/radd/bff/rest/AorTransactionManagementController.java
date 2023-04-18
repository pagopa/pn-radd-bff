package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.AorTransactionManagementApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.AorTransactionManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AorTransactionManagementController implements AorTransactionManagementApi {

    private final AorTransactionManagementService aorTransactionManagementService;


    @Override
    public Mono<ResponseEntity<AbortTransactionResponse>> abortAorTransaction(String uid, Mono<AbortTransactionRequest> abortTransactionRequest, final ServerWebExchange exchange) {
        return aorTransactionManagementService.abortAorTransaction(uid, abortTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }

    @Override
    public Mono<ResponseEntity<CompleteTransactionResponse>> completeAorTransaction(String uid, Mono<CompleteTransactionRequest> completeTransactionRequest, final ServerWebExchange exchange) {
        return aorTransactionManagementService.completeAorTransaction(uid, completeTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }

    @Override
    public  Mono<ResponseEntity<StartTransactionResponse>> startAorTransaction(String uid, Mono<AorStartTransactionRequest> aorStartTransactionRequest,  final ServerWebExchange exchange) {
        return aorTransactionManagementService.startAorTransaction(uid, aorStartTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
