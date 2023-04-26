package it.pagopa.pn.radd.bff.log;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Paths;
import java.util.function.Function;
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
}

