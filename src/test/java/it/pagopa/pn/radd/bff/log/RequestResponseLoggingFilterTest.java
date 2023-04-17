package it.pagopa.pn.radd.bff.log;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RequestResponseLoggingFilter.class})
@ExtendWith(SpringExtension.class)
class RequestResponseLoggingFilterTest {
    @Autowired
    private RequestResponseLoggingFilter requestResponseLoggingFilter;


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
}

