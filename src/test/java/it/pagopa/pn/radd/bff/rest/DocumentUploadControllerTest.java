package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.log.RaddRequestDecorator;
import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.service.DocumentUploadService;
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

@ContextConfiguration(classes = {DocumentUploadController.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadControllerTest {
    @Autowired
    private DocumentUploadController documentUploadController;

    @MockBean
    private DocumentUploadService documentUploadService;

    @MockBean
    private Scheduler scheduler;

    /**
     * Method under test: {@link DocumentUploadController#documentUpload(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDocumentUpload() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        documentUploadController.documentUpload("1234", null,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"), "Masked URI"),
                        "Masked URI"));
    }

    /**
     * Method under test: {@link DocumentUploadController#documentUpload(String, Mono, ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDocumentUpload2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.service.DocumentUploadService.documentUpload(String, reactor.core.publisher.Mono)" is null
        //       at it.pagopa.pn.radd.bff.rest.DocumentUploadController.documentUpload(DocumentUploadController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        when(documentUploadService.documentUpload(Mockito.<String>any(), Mockito.<Mono<DocumentUploadRequest>>any()))
                .thenReturn(null);
        Mono<DocumentUploadRequest> documentUploadRequest = mock(Mono.class);
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
        documentUploadController.documentUpload("1234", documentUploadRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
    }

    /**
     * Method under test: {@link DocumentUploadController#documentUpload(String, Mono, ServerWebExchange)}
     */
    @Test
    void testDocumentUpload3() {
        when(documentUploadService.documentUpload(Mockito.<String>any(), Mockito.<Mono<DocumentUploadRequest>>any()))
                .thenReturn(mock(Mono.class));
        Mono<DocumentUploadRequest> documentUploadRequest = mock(Mono.class);
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
        documentUploadController.documentUpload("1234", documentUploadRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(documentUploadService).documentUpload(Mockito.<String>any(), Mockito.<Mono<DocumentUploadRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }
}

