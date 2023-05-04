package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AbortTransactionResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.CompleteTransactionResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AorTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class AorTransactionManagementServiceTest {
    @Autowired
    private AorTransactionManagementService aorTransactionManagementService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @MockBean
    private TransactionManagementConverter transactionManagementConverter;

    @Test
    void testStartAorTransaction(){
        when(pnRaddFsuClient.startAorTransaction(any(), any()))
                .thenReturn((Mono<StartTransactionResponseDto>) mock(Mono.class));
        StartTransactionResponse startTransactionResponse = mock(StartTransactionResponse.class);
        when(transactionManagementConverter.startTransactionDtoToResponse(any()))
                .thenReturn(startTransactionResponse);
        AorStartTransactionRequest aorStartTransactionRequest = mock(AorStartTransactionRequest.class);
        StepVerifier.create(aorTransactionManagementService
                .startAorTransaction("uid",Mono.just(aorStartTransactionRequest))).expectNext(startTransactionResponse);
    }
    @Test
    void testCompleteAorTransaction() {
        when(pnRaddFsuClient.completeAorTransaction(any(), any()))
                .thenReturn((Mono<CompleteTransactionResponseDto>) mock(Mono.class));
        CompleteTransactionResponse completeTransactionResponse = mock(CompleteTransactionResponse.class);
        when(transactionManagementConverter.completeTransactionDtoToResponse(any()))
                .thenReturn(completeTransactionResponse);
        CompleteTransactionRequest completeTransactionRequest = mock(CompleteTransactionRequest.class);
        StepVerifier.create(aorTransactionManagementService
                .completeAorTransaction("uid",Mono.just(completeTransactionRequest)))
                .expectNext(completeTransactionResponse);
    }
    @Test
    void testAbortAorTransaction() {
        when(pnRaddFsuClient.abortAorTransaction(any(), any()))
                .thenReturn((Mono<AbortTransactionResponseDto>) mock(Mono.class));
        AbortTransactionResponse abortTransactionResponse = mock(AbortTransactionResponse.class);
        when(transactionManagementConverter.abortTransactionDtoToResponse(any()))
                .thenReturn(abortTransactionResponse);
        AbortTransactionRequest abortTransactionRequest = mock(AbortTransactionRequest.class);
        StepVerifier.create(aorTransactionManagementService
                        .abortAorTransaction("uid",Mono.just(abortTransactionRequest)))
                .expectNext(abortTransactionResponse);
    }
}

