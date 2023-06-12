package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ActTransactionManagementService {

    private final PnRaddFsuClient pnRaddFsuClient;

    private final TransactionManagementConverter transactionManagementConverter;

    public Mono<AbortTransactionResponse> abortActTransaction(String uid, Mono<AbortTransactionRequest> abortTransactionRequest) {
        return abortTransactionRequest.map(transactionManagementConverter::abortTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.abortActTransaction(uid, t))
                .map(transactionManagementConverter::abortTransactionDtoToResponse);
    }

    public Mono<CompleteTransactionResponse> completeActTransaction(String uid, Mono<CompleteTransactionRequest> completeTransactionRequest) {
        return completeTransactionRequest.map(transactionManagementConverter::completeTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.completeActTransaction(uid, t))
                .map(transactionManagementConverter::completeTransactionDtoToResponse);
    }

    public Mono<StartTransactionResponse> startActTransaction(String uid, Mono<ActStartTransactionRequest> actStartTransactionRequest) {
        return actStartTransactionRequest.map(transactionManagementConverter::actStartTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.startActTransaction(uid, t))
                .map(transactionManagementConverter::startTransactionDtoToResponse);
    }
}
