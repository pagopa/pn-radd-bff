package it.pagopa.pn.radd.bff.log;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferWrapper;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.reactive.function.client.support.ClientResponseWrapper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ResponseExchangeFilter.class})
@ExtendWith(SpringExtension.class)
class ResponseExchangeFilterTest {
    @Autowired
    private ResponseExchangeFilter responseExchangeFilter;

    /**
     * Method under test: {@link ResponseExchangeFilter#filter(ClientRequest, ExchangeFunction)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ClientRequest must not be null
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.interceptBody(ResponseExchangeFilter.java:56)
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.filter(ResponseExchangeFilter.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        responseExchangeFilter.filter(null, mock(ExchangeFunction.class));
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, String, ClientResponse, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogResponseBody() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Delegate is required
        //   See https://diff.blue/R013 to resolve this issue.

        responseExchangeFilter.logResponseBody(1L, "Not all who wander are lost", new ClientResponseWrapper(
                new ClientResponseWrapper(new ClientResponseWrapper(new ClientResponseWrapper(null)))), null);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, String, ClientResponse, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogResponseBody2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.reactive.function.client.ClientRequest.url()" because "request" is null
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logResponseBody(ResponseExchangeFilter.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        responseExchangeFilter.logResponseBody(1L, "Not all who wander are lost",
                new ClientResponseWrapper(new ClientResponseWrapper(
                        new ClientResponseWrapper(new ClientResponseWrapper(mock(ClientResponseWrapper.class))))),
                null);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogResponseBody3() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.reactive.function.client.ClientRequest.url()" because "request" is null
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logResponseBody(ResponseExchangeFilter.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        HttpHeaders headers = new HttpHeaders();
        responseExchangeFilter.logResponseBody(1L,
                new WebClientResponseException(1, "Status Text", headers, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null), null);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogResponseBody4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.reactive.function.client.ClientRequest.url()" because "request" is null
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logResponseBody(ResponseExchangeFilter.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        responseExchangeFilter.logResponseBody(1L, mock(UnknownHttpStatusCodeException.class), null);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogResponseBody5() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No matching constant for [1]
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logResponseBody(ResponseExchangeFilter.java:49)
        //   See https://diff.blue/R013 to resolve this issue.

        HttpHeaders headers = new HttpHeaders();
        WebClientResponseException exception = new WebClientResponseException(1, "Status Text", headers,
                "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null);

        ClientRequest clientRequest = mock(ClientRequest.class);
        when(clientRequest.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        responseExchangeFilter.logResponseBody(1L, exception, clientRequest);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    void testLogResponseBody6() {
        UnknownHttpStatusCodeException unknownHttpStatusCodeException = mock(UnknownHttpStatusCodeException.class);
        when(unknownHttpStatusCodeException.getResponseBodyAsString()).thenReturn("Not all who wander are lost");
        when(unknownHttpStatusCodeException.getStatusCode()).thenReturn(HttpStatus.CONTINUE);
        ClientRequest clientRequest = mock(ClientRequest.class);
        when(clientRequest.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        responseExchangeFilter.logResponseBody(1L, unknownHttpStatusCodeException, clientRequest);
        verify(unknownHttpStatusCodeException).getResponseBodyAsString();
        verify(unknownHttpStatusCodeException, atLeast(1)).getStatusCode();
        verify(clientRequest).url();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    void testLogResponseBody7() throws UnsupportedEncodingException {
        UnknownHttpStatusCodeException unknownHttpStatusCodeException = mock(UnknownHttpStatusCodeException.class);
        HttpHeaders headers = new HttpHeaders();
        when(unknownHttpStatusCodeException.getResponseBodyAsString()).thenThrow(new WebClientResponseException(5,
                "Response HTTP from {} {} {} - body: {} - timelapse: {}ms", headers, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null));
        when(unknownHttpStatusCodeException.getStatusCode()).thenReturn(HttpStatus.CONTINUE);
        ClientRequest clientRequest = mock(ClientRequest.class);
        when(clientRequest.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        assertThrows(WebClientResponseException.class,
                () -> responseExchangeFilter.logResponseBody(1L, unknownHttpStatusCodeException, clientRequest));
        verify(unknownHttpStatusCodeException).getResponseBodyAsString();
        verify(unknownHttpStatusCodeException, atLeast(1)).getStatusCode();
        verify(clientRequest).url();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logRequestBody(DataBuffer, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogRequestBody() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.reactive.function.client.ClientRequest.method()" because "request" is null
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logRequestBody(ResponseExchangeFilter.java:69)
        //   See https://diff.blue/R013 to resolve this issue.

        responseExchangeFilter.logRequestBody(
                new DataBufferWrapper(
                        new DataBufferWrapper(new DataBufferWrapper(new DataBufferWrapper(mock(DefaultDataBuffer.class))))),
                null);
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logRequestBody(DataBuffer, ClientRequest)}
     */
    @Test
    void testLogRequestBody2() {
        DefaultDataBuffer defaultDataBuffer = mock(DefaultDataBuffer.class);
        when(defaultDataBuffer.toString(any())).thenReturn("String");
        DataBufferWrapper dataBuffer = new DataBufferWrapper(
                new DataBufferWrapper(new DataBufferWrapper(new DataBufferWrapper(defaultDataBuffer))));
        ClientRequest clientRequest = mock(ClientRequest.class);
        when(clientRequest.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(clientRequest.method()).thenReturn(HttpMethod.GET);
        responseExchangeFilter.logRequestBody(dataBuffer, clientRequest);
        verify(defaultDataBuffer).toString(any());
        verify(clientRequest).url();
        verify(clientRequest).method();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logRequestBody(DataBuffer, ClientRequest)}
     */
    @Test
    void testLogRequestBody3() throws UnsupportedEncodingException {
        DefaultDataBuffer defaultDataBuffer = mock(DefaultDataBuffer.class);
        when(defaultDataBuffer.toString(any())).thenReturn("String");
        DataBufferWrapper dataBuffer = new DataBufferWrapper(
                new DataBufferWrapper(new DataBufferWrapper(new DataBufferWrapper(defaultDataBuffer))));
        ClientRequest clientRequest = mock(ClientRequest.class);
        HttpHeaders headers = new HttpHeaders();
        when(clientRequest.url()).thenThrow(new WebClientResponseException(3, "Request HTTP {} to: {} - body: {}",
                headers, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null));
        when(clientRequest.method()).thenReturn(HttpMethod.GET);
        assertThrows(WebClientResponseException.class,
                () -> responseExchangeFilter.logRequestBody(dataBuffer, clientRequest));
        verify(clientRequest).url();
        verify(clientRequest).method();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logRequestBody(DataBuffer, ClientRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogRequestBody4() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.web.reactive.function.client.WebClientResponseException: 1 Status Text
        //       at it.pagopa.pn.radd.bff.log.ResponseExchangeFilter.logRequestBody(ResponseExchangeFilter.java:71)
        //   See https://diff.blue/R013 to resolve this issue.

        DefaultDataBuffer defaultDataBuffer = mock(DefaultDataBuffer.class);
        HttpHeaders headers = new HttpHeaders();
        when(defaultDataBuffer.toString(any()))
                .thenThrow(new WebClientResponseException(1, "Status Text", headers, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null));
        DataBufferWrapper dataBuffer = new DataBufferWrapper(
                new DataBufferWrapper(new DataBufferWrapper(defaultDataBuffer)));
        ClientRequest clientRequest = mock(ClientRequest.class);
        when(clientRequest.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(clientRequest.method()).thenReturn(HttpMethod.GET);
        responseExchangeFilter.logRequestBody(dataBuffer, clientRequest);
    }
}

