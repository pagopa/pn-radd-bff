package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.log.RaddRequestDecorator;
import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.AorTransactionManagementService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AorTransactionManagementController.class})
@ExtendWith(SpringExtension.class)
class AorTransactionManagementControllerTest {
    @Autowired
    private AorTransactionManagementController aorTransactionManagementController;

    @MockBean
    private AorTransactionManagementService aorTransactionManagementService;

    @MockBean
    private Scheduler scheduler;

    @Mock
    ServerWebExchange serverWebExchange;

    /**
     * Method under test: {@link AorTransactionManagementController#abortAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortAorTransaction3() {
        when(aorTransactionManagementService.abortAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AbortTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<AbortTransactionRequest> abortTransactionRequest = mock(Mono.class);
        AbortTransactionResponse abortTransactionResponse = mock(AbortTransactionResponse.class);

        StepVerifier.create(aorTransactionManagementController.abortAorTransaction("uid", abortTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(abortTransactionResponse));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#completeAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteAorTransaction3() {
        when(aorTransactionManagementService.completeAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<CompleteTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<CompleteTransactionRequest> completeTransactionRequest = mock(Mono.class);
        CompleteTransactionResponse completeTransactionResponse = mock(CompleteTransactionResponse.class);

        StepVerifier.create(aorTransactionManagementController.completeAorTransaction("uid", completeTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(completeTransactionResponse));

    }

    /**
     * Method under test: {@link AorTransactionManagementController#startAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartAorTransaction3() {
        when(aorTransactionManagementService.startAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AorStartTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<AorStartTransactionRequest> aorStartTransactionRequest = mock(Mono.class);
        StartTransactionResponse startTransactionResponse = mock(StartTransactionResponse.class);

        StepVerifier.create(aorTransactionManagementController.startAorTransaction("uid", aorStartTransactionRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(startTransactionResponse));
    }
}

