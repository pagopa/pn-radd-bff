package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.api.ActTransactionManagementApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.ActTransactionManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ActTransactionManagementController implements ActTransactionManagementApi {

    private final ActTransactionManagementService actTransactionManagementService;


    @Override
    public Mono<ResponseEntity<AbortTransactionResponse>> abortActTransaction(String uid, Mono<AbortTransactionRequest> abortTransactionRequest, final ServerWebExchange exchange) {
        return actTransactionManagementService.abortActTransaction(uid, abortTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }

    @Override
    public Mono<ResponseEntity<CompleteTransactionResponse>> completeActTransaction(String uid, Mono<CompleteTransactionRequest> completeTransactionRequest, final ServerWebExchange exchange) {
        return actTransactionManagementService.completeActTransaction(uid, completeTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }

    @Override
    public Mono<ResponseEntity<StartTransactionResponse>> startActTransaction(String uid, Mono<ActStartTransactionRequest> actStartTransactionRequest,  final ServerWebExchange exchange) {
        return actTransactionManagementService.startActTransaction(uid, actStartTransactionRequest).map(m -> ResponseEntity.status(HttpStatus.OK).body(m));
    }
}
