package it.pagopa.pn.radd.bff.log;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Paths;

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
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;

@ContextConfiguration(classes = {RequestResponseLoggingFilter.class})
@ExtendWith(SpringExtension.class)
class RequestResponseLoggingFilterTest {
    @Autowired
    private RequestResponseLoggingFilter requestResponseLoggingFilter;

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter() {
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
        requestResponseLoggingFilter.filter(new DefaultServerWebExchange(request, response, sessionManager, codecConfigurer,
                new AcceptHeaderLocaleContextResolver()), mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.server.ServerWebExchange.getRequest()" because "exchange" is null
        //       at it.pagopa.pn.radd.bff.log.RequestResponseLoggingFilter.filter(RequestResponseLoggingFilter.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        requestResponseLoggingFilter.filter(null, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.server.ServerWebExchange$Builder.request(org.springframework.http.server.reactive.ServerHttpRequest)" because the return value of "org.springframework.web.server.ServerWebExchange.mutate()" is null
        //       at it.pagopa.pn.radd.bff.log.RequestResponseLoggingFilter.filter(RequestResponseLoggingFilter.java:70)
        //   See https://diff.blue/R013 to resolve this issue.

        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        ServerHttpRequestDecorator serverHttpRequestDecorator1 = new ServerHttpRequestDecorator(
                new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator)))));
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.mutate()).thenReturn(null);
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        when(defaultServerWebExchange.getRequest()).thenReturn(serverHttpRequestDecorator1);
        requestResponseLoggingFilter.filter(defaultServerWebExchange, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    void testFilter4() {
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        ServerHttpRequestDecorator serverHttpRequestDecorator1 = new ServerHttpRequestDecorator(
                new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator)))));
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.mutate()).thenThrow(new IllegalStateException());
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        when(defaultServerWebExchange.getRequest()).thenReturn(serverHttpRequestDecorator1);
        assertThrows(IllegalStateException.class,
                () -> requestResponseLoggingFilter.filter(defaultServerWebExchange, mock(WebFilterChain.class)));
        verify(defaultServerWebExchange).mutate();
        verify(defaultServerWebExchange, atLeast(1)).getRequest();
        verify(defaultServerWebExchange).getResponse();
        verify(serverHttpRequestDecorator).getURI();
    }

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Delegate is required
        //       at it.pagopa.pn.radd.bff.log.RequestResponseLoggingFilter$2.<init>(RequestResponseLoggingFilter.java:50)
        //       at it.pagopa.pn.radd.bff.log.RequestResponseLoggingFilter.filter(RequestResponseLoggingFilter.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        ServerHttpRequestDecorator serverHttpRequestDecorator1 = new ServerHttpRequestDecorator(
                new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator)))));
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.mutate()).thenReturn(null);
        when(defaultServerWebExchange.getResponse()).thenReturn(null);
        when(defaultServerWebExchange.getRequest()).thenReturn(serverHttpRequestDecorator1);
        requestResponseLoggingFilter.filter(defaultServerWebExchange, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.server.reactive.ServerHttpRequest.getURI()" because "httpRequest" is null
        //       at it.pagopa.pn.radd.bff.log.RequestResponseLoggingFilter.filter(RequestResponseLoggingFilter.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.mutate()).thenReturn(null);
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        when(defaultServerWebExchange.getRequest()).thenReturn(null);
        requestResponseLoggingFilter.filter(defaultServerWebExchange, mock(WebFilterChain.class));
    }
}

