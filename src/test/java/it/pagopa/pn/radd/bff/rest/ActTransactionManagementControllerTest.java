package it.pagopa.pn.radd.bff.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.log.RaddRequestDecorator;
import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.StartTransactionResponse;
import it.pagopa.pn.radd.bff.service.ActTransactionManagementService;
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

@ContextConfiguration(classes = {ActTransactionManagementController.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementControllerTest {
    @Autowired
    private ActTransactionManagementController actTransactionManagementController;

    @MockBean
    private ActTransactionManagementService actTransactionManagementService;

    @MockBean
    private Scheduler scheduler;

    /**
     * Method under test: {@link ActTransactionManagementController#abortActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementController.abortActTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"), "Masked URI"),
                        "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#abortActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.ActTransactionManagementService.abortActTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.ActTransactionManagementController.abortActTransaction(ActTransactionManagementController.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        when(actTransactionManagementService.abortActTransaction(Mockito.<String>any(),
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
        actTransactionManagementController.abortActTransaction("1234", abortTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#abortActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortActTransaction3() {
        when(actTransactionManagementService.abortActTransaction(Mockito.<String>any(),
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
        actTransactionManagementController.abortActTransaction("1234", abortTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(actTransactionManagementService).abortActTransaction(Mockito.<String>any(),
                Mockito.<Mono<AbortTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    /**
     * Method under test: {@link ActTransactionManagementController#completeActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompleteActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementController.completeActTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#completeActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompleteActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.ActTransactionManagementService.completeActTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.ActTransactionManagementController.completeActTransaction(ActTransactionManagementController.java:64)
        //   See https://diff.blue/R013 to resolve this issue.

        when(actTransactionManagementService.completeActTransaction(Mockito.<String>any(),
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
        actTransactionManagementController.completeActTransaction("1234", completeTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#completeActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteActTransaction3() {
        when(actTransactionManagementService.completeActTransaction(Mockito.<String>any(),
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
        actTransactionManagementController.completeActTransaction("1234", completeTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(actTransactionManagementService).completeActTransaction(Mockito.<String>any(),
                Mockito.<Mono<CompleteTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    /**
     * Method under test: {@link ActTransactionManagementController#startActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStartActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementController.startActTransaction("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#startActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStartActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.ActTransactionManagementService.startActTransaction(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.ActTransactionManagementController.startActTransaction(ActTransactionManagementController.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        when(actTransactionManagementService.startActTransaction(Mockito.<String>any(),
                Mockito.<Mono<ActStartTransactionRequest>>any())).thenReturn(null);
        Mono<ActStartTransactionRequest> actStartTransactionRequest = mock(Mono.class);
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
        actTransactionManagementController.startActTransaction("1234", actStartTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link ActTransactionManagementController#startActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartActTransaction3() {
        when(actTransactionManagementService.startActTransaction(Mockito.<String>any(),
                Mockito.<Mono<ActStartTransactionRequest>>any())).thenReturn(mock(Mono.class));
        Mono<ActStartTransactionRequest> actStartTransactionRequest = mock(Mono.class);
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
        actTransactionManagementController.startActTransaction("1234", actStartTransactionRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(actTransactionManagementService).startActTransaction(Mockito.<String>any(),
                Mockito.<Mono<ActStartTransactionRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }
}

