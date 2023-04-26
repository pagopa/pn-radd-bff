package it.pagopa.pn.radd.bff.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

class RaddWebExchangeDecoratorTest {

    /**
     * Method under test: {@link RaddWebExchangeDecorator#RaddWebExchangeDecorator(ServerWebExchange, String)}
     */
    @Test
    void testConstructor3() {
        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(new RaddRequestDecorator(
                        new RaddRequestDecorator(mock(ServerHttpRequest.class), "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"));
        RaddWebExchangeDecorator actualRaddWebExchangeDecorator = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI");

        assertNull(actualRaddWebExchangeDecorator.getApplicationContext());
        RaddRequestDecorator request = actualRaddWebExchangeDecorator.getRequest();
        assertNull(request.getMethodValue());
        RaddResponseDecorator response = actualRaddWebExchangeDecorator.getResponse();
        assertEquals("", response.getCapturedBody());
        assertEquals("", request.getCapturedBody());
        assertNull(response.getStatusCode());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    /**
     * Method under test: {@link RaddWebExchangeDecorator#getRequest()}
     */
    @Test
    void testGetRequest3() {
        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(new RaddRequestDecorator(
                        new RaddRequestDecorator(mock(ServerHttpRequest.class), "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"));
        (new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"), "Masked URI")).getRequest();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }


    /**
     * Method under test: {@link RaddWebExchangeDecorator#getResponse()}
     */
    @Test
    void testGetResponse3() {
        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(new RaddRequestDecorator(
                        new RaddRequestDecorator(mock(ServerHttpRequest.class), "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"));
        (new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI"), "Masked URI")).getResponse();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }
}

