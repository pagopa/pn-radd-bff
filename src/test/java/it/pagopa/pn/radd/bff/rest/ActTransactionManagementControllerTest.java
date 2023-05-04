package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.ActTransactionManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ActTransactionManagementController.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementControllerTest {
    @Autowired
    private ActTransactionManagementController actTransactionManagementController;

    @MockBean
    private ActTransactionManagementService actTransactionManagementService;

    @MockBean
    private Scheduler scheduler;
    @Mock
    ServerWebExchange serverWebExchange;

    /**
     * Method under test: {@link ActTransactionManagementController#abortActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortActTransaction3() {
        when(actTransactionManagementService.abortActTransaction(Mockito.any(),
                Mockito.any())).thenReturn(mock(Mono.class));
        Mono<AbortTransactionRequest> abortTransactionRequest = mock(Mono.class);

        AbortTransactionResponse abortTransactionResponse = mock(AbortTransactionResponse.class);

        StepVerifier.create(actTransactionManagementController.abortActTransaction("uid", abortTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(abortTransactionResponse));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#completeActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteActTransaction3() {
        when(actTransactionManagementService.completeActTransaction(Mockito.any(),
                Mockito.any())).thenReturn(mock(Mono.class));
        Mono<CompleteTransactionRequest> completeTransactionRequest = mock(Mono.class);
        CompleteTransactionResponse completeTransactionResponse = mock(CompleteTransactionResponse.class);

        StepVerifier.create(actTransactionManagementController.completeActTransaction("uid", completeTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(completeTransactionResponse));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#startActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartActTransaction3() {
        when(actTransactionManagementService.startActTransaction(Mockito.any(),
                Mockito.any())).thenReturn(mock(Mono.class));
        Mono<ActStartTransactionRequest> actStartTransactionRequest = mock(Mono.class);
        StartTransactionResponse startTransactionResponse = mock(StartTransactionResponse.class);

        StepVerifier.create(actTransactionManagementController.startActTransaction("uid", actStartTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(startTransactionResponse));
    }
}

