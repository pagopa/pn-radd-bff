package it.pagopa.pn.radd.bff.rest;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;

@ContextConfiguration(classes = {HealthCheckApiController.class})
@ExtendWith(SpringExtension.class)
class HealthCheckApiControllerTest {
    @Autowired
    private HealthCheckApiController healthCheckApiController;

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
        //   java.lang.IllegalArgumentException: Delegate is required
        //   See https://diff.blue/R013 to resolve this issue.

        ServerHttpRequestDecorator request = new ServerHttpRequestDecorator(
                new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(null)));
        MockServerHttpResponse response = new MockServerHttpResponse();
        WebSessionManager sessionManager = mock(WebSessionManager.class);
        DefaultServerCodecConfigurer codecConfigurer = new DefaultServerCodecConfigurer();
        healthCheckApiController.status(new DefaultServerWebExchange(request, response, sessionManager, codecConfigurer,
                new AcceptHeaderLocaleContextResolver()));
    }

    /**
     * Method under test: {@link HealthCheckApiController#status(ServerWebExchange)}
     */
    @Test
    void testStatus2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        healthCheckApiController.status(null);
    }
}

