package it.pagopa.pn.radd.bff.rest;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {HealthCheckApiController.class})
@ExtendWith(SpringExtension.class)
class HealthCheckApiControllerTest {
    /**
     * Method under test: {@link HealthCheckApiController#status(ServerWebExchange)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStatus() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        healthCheckApiController.status(new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"));
    }

    /**
     * Method under test: {@link HealthCheckApiController#status(ServerWebExchange)}
     */
    @Test
    void testStatus2() {
        ServerHttpRequestDecorator request = mock(ServerHttpRequestDecorator.class);
        when(request.getHeaders()).thenReturn(new HttpHeaders());
        when(request.getId()).thenReturn("https://example.org/example");
        WebSessionManager sessionManager = mock(WebSessionManager.class);
        when(sessionManager.getSession(Mockito.<ServerWebExchange>any())).thenReturn(mock(Mono.class));
        RaddResponseDecorator response = new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))));
        DefaultServerCodecConfigurer codecConfigurer = new DefaultServerCodecConfigurer();
        healthCheckApiController.status(new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(new DefaultServerWebExchange(request, response,
                        sessionManager, codecConfigurer, new AcceptHeaderLocaleContextResolver()), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"));
        verify(request).getId();
        verify(request, atLeast(1)).getHeaders();
        verify(sessionManager).getSession(Mockito.<ServerWebExchange>any());
    }

    @Autowired
    private HealthCheckApiController healthCheckApiController;

}

