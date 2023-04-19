package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.log.RaddRequestDecorator;
import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import it.pagopa.pn.radd.bff.service.AorTransactionManagementService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

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

    /**
     * Method under test: {@link AorTransactionManagementController#abortAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementController.abortAorTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"), "Masked URI"),
                        "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#abortAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.AorTransactionManagementService.abortAorTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.AorTransactionManagementController.abortAorTransaction(AorTransactionManagementController.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        when(aorTransactionManagementService.abortAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AbortTransactionRequest>>any())).thenReturn(null);
        Mono<AbortTransactionRequest> abortTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.abortAorTransaction("1234", abortTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#abortAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortAorTransaction3() {
        when(aorTransactionManagementService.abortAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AbortTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<AbortTransactionRequest> abortTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.abortAorTransaction("1234", abortTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(aorTransactionManagementService).abortAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AbortTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    /**
     * Method under test: {@link AorTransactionManagementController#completeAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompleteAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementController.completeAorTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#completeAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompleteAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.AorTransactionManagementService.completeAorTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.AorTransactionManagementController.completeAorTransaction(AorTransactionManagementController.java:64)
        //   See https://diff.blue/R013 to resolve this issue.

        when(aorTransactionManagementService.completeAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<CompleteTransactionRequest>>any())).thenReturn(null);
        Mono<CompleteTransactionRequest> completeTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.completeAorTransaction("1234", completeTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#completeAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteAorTransaction3() {
        when(aorTransactionManagementService.completeAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<CompleteTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<CompleteTransactionRequest> completeTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.completeAorTransaction("1234", completeTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(aorTransactionManagementService).completeAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<CompleteTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    /**
     * Method under test: {@link AorTransactionManagementController#startAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStartAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementController.startAorTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#startAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStartAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.AorTransactionManagementService.startAorTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.AorTransactionManagementController.startAorTransaction(AorTransactionManagementController.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        when(aorTransactionManagementService.startAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AorStartTransactionRequest>>any())).thenReturn(null);
        Mono<AorStartTransactionRequest> aorStartTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.startAorTransaction("1234", aorStartTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link AorTransactionManagementController#startAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartAorTransaction3() {
        when(aorTransactionManagementService.startAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AorStartTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<AorStartTransactionRequest> aorStartTransactionRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        aorTransactionManagementController.startAorTransaction("1234", aorStartTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(aorTransactionManagementService).startAorTransaction(Mockito.<String>any(),
                Mockito.<Mono<AorStartTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }
}

