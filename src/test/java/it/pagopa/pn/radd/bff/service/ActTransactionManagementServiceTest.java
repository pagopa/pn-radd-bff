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

@ContextConfiguration(classes = {ActTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementServiceTest {
    @Autowired
    private ActTransactionManagementService actTransactionManagementService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @MockBean
    private TransactionManagementConverter transactionManagementConverter;

    @Test
    void testStartActTransaction() {
        when(pnRaddFsuClient.startActTransaction(any(), any()))
                .thenReturn((Mono<StartTransactionResponseDto>) mock(Mono.class));

        StartTransactionResponse startTransactionResponse = mock(StartTransactionResponse.class);
        when(transactionManagementConverter.startTransactionDtoToResponse(any())).thenReturn(startTransactionResponse);

        ActStartTransactionRequest actStartTransactionRequest = mock(ActStartTransactionRequest.class);

        StepVerifier.create(actTransactionManagementService.startActTransaction("1234", Mono.just(actStartTransactionRequest)))
                .expectNext(startTransactionResponse);
    }

    @Test
    void testAbortActTransaction() {
        when(pnRaddFsuClient.abortActTransaction(any(), any()))
                .thenReturn((Mono<AbortTransactionResponseDto>) mock(Mono.class));

        AbortTransactionResponse abortTransactionResponse = mock(AbortTransactionResponse.class);
        when(transactionManagementConverter.abortTransactionDtoToResponse(any())).thenReturn(abortTransactionResponse);

        AbortTransactionRequest abortTransactionRequest = mock(AbortTransactionRequest.class);

        StepVerifier.create(actTransactionManagementService.abortActTransaction("1234", Mono.just(abortTransactionRequest)))
                .expectNext(abortTransactionResponse);
    }

    @Test
    void testCompleteActTransaction() {
        when(pnRaddFsuClient.completeActTransaction(any(), any()))
                .thenReturn((Mono<CompleteTransactionResponseDto>) mock(Mono.class));

        CompleteTransactionResponse completeTransactionResponse = mock(CompleteTransactionResponse.class);
        when(transactionManagementConverter.completeTransactionDtoToResponse(any())).thenReturn(completeTransactionResponse);

        CompleteTransactionRequest completeTransactionRequest = mock(CompleteTransactionRequest.class);

        StepVerifier.create(actTransactionManagementService.completeActTransaction("1234", Mono.just(completeTransactionRequest)))
                .expectNext(completeTransactionResponse);
    }
}

