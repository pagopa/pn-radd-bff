package it.pagopa.pn.radd.bff.log;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Paths;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

@ContextConfiguration(classes = {RaddRequestResponseLoggingFilter.class, String.class})
@ExtendWith(SpringExtension.class)
class RaddRequestResponseLoggingFilterTest {
    @Autowired
    private RaddRequestResponseLoggingFilter raddRequestResponseLoggingFilter;

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ServerWebExchange 'delegate' is required.
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        raddRequestResponseLoggingFilter.filter(new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(null, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.server.ServerWebExchange.getRequest()" because "exchange" is null
        //       at it.pagopa.pn.radd.bff.log.RaddRequestResponseLoggingFilter.filter(RaddRequestResponseLoggingFilter.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        raddRequestResponseLoggingFilter.filter(null, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "org.springframework.http.server.reactive.ServerHttpRequest.getPath()" is null
        //       at it.pagopa.pn.radd.bff.log.RaddRequestResponseLoggingFilter.filter(RaddRequestResponseLoggingFilter.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getPath()).thenReturn(null);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getRequest()).thenReturn(new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"));
        raddRequestResponseLoggingFilter.filter(exchange, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.server.reactive.ServerHttpRequest.getPath()" because "httpRequest" is null
        //       at it.pagopa.pn.radd.bff.log.RaddRequestResponseLoggingFilter.filter(RaddRequestResponseLoggingFilter.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getRequest()).thenReturn(null);
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getPath()).thenReturn(null);
        new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI");

        raddRequestResponseLoggingFilter.filter(exchange, mock(WebFilterChain.class));
    }

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    void testFilter5() {
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getHeaders()).thenReturn(new HttpHeaders());
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        when(delegate.getPath()).thenReturn(mock(RequestPath.class));
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        WebFilterChain chain = mock(WebFilterChain.class);
        when(chain.filter(Mockito.<ServerWebExchange>any()))
                .thenReturn(new ChannelSendOperator<>(mock(Publisher.class), mock(Function.class)));
        raddRequestResponseLoggingFilter.filter(exchange, chain);
        verify(exchange, atLeast(1)).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getHeaders();
        verify(delegate).getMethod();
        verify(delegate).getPath();
        verify(chain).filter(Mockito.<ServerWebExchange>any());
    }

    /**
     * Method under test: {@link RaddRequestResponseLoggingFilter#filter(ServerWebExchange, WebFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Delegate is required
        //       at it.pagopa.pn.radd.bff.log.RaddResponseDecorator.<init>(RaddResponseDecorator.java:19)
        //       at it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator.<init>(RaddWebExchangeDecorator.java:15)
        //       at it.pagopa.pn.radd.bff.log.RaddRequestResponseLoggingFilter.filter(RaddRequestResponseLoggingFilter.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getHeaders()).thenReturn(new HttpHeaders());
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        when(delegate.getPath()).thenReturn(mock(RequestPath.class));
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse()).thenReturn(null);
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        WebFilterChain chain = mock(WebFilterChain.class);
        when(chain.filter(Mockito.<ServerWebExchange>any()))
                .thenReturn(new ChannelSendOperator<>(mock(Publisher.class), mock(Function.class)));
        raddRequestResponseLoggingFilter.filter(exchange, chain);
    }
}

