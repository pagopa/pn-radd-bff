package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AorTransactionManagementService {

    private final PnRaddFsuClient pnRaddFsuClient;

    private final TransactionManagementConverter transactionManagementConverter;

    public Mono<AbortTransactionResponse> abortAorTransaction(String uid, Mono<AbortTransactionRequest> abortTransactionRequest) {
        return abortTransactionRequest.map(transactionManagementConverter::abortTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.abortAorTransaction(uid, t))
                .map(transactionManagementConverter::abortTransactionDtoToResponse);
    }

    public Mono<CompleteTransactionResponse> completeAorTransaction(String uid, Mono<CompleteTransactionRequest> completeTransactionRequest) {
        return completeTransactionRequest.map(transactionManagementConverter::completeTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.completeAorTransaction(uid, t))
                .map(transactionManagementConverter::completeTransactionDtoToResponse);
    }

    public Mono<StartTransactionResponse> startAorTransaction(String uid, Mono<AorStartTransactionRequest> aorStartTransactionRequest) {
        return aorStartTransactionRequest.map(transactionManagementConverter::aorStartTransactionRequestToDto)
                .flatMap(t -> pnRaddFsuClient.startAorTransaction(uid, t))
                .map(transactionManagementConverter::startTransactionDtoToResponse);
    }
}
