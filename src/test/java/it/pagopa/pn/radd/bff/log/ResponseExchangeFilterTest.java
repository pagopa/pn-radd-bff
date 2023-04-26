package it.pagopa.pn.radd.bff.log;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferWrapper;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.UnknownHttpStatusCodeException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    void testLogResponseBody8() {
        UnknownHttpStatusCodeException exception = mock(UnknownHttpStatusCodeException.class);
        when(exception.getResponseBodyAsString()).thenReturn("Not all who wander are lost");
        when(exception.getStatusCode()).thenReturn(HttpStatus.CONTINUE);
        ClientRequest request = mock(ClientRequest.class);
        when(request.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        responseExchangeFilter.logResponseBody(1L, exception, request);
        verify(exception).getResponseBodyAsString();
        verify(exception, atLeast(1)).getStatusCode();
        verify(request).url();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logResponseBody(long, WebClientResponseException, ClientRequest)}
     */
    @Test
    void testLogResponseBody9() {
        UnknownHttpStatusCodeException exception = mock(UnknownHttpStatusCodeException.class);
        when(exception.getResponseBodyAsString())
                .thenThrow(new WebClientResponseException(5, "Response HTTP from {} {} {} - body: {} - timelapse: {}ms",
                        new HttpHeaders(), new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5}, null));
        when(exception.getStatusCode()).thenReturn(HttpStatus.CONTINUE);
        ClientRequest request = mock(ClientRequest.class);
        when(request.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        responseExchangeFilter.logResponseBody(1L, exception, request);
        verify(exception).getResponseBodyAsString();
        verify(exception, atLeast(1)).getStatusCode();
        verify(request).url();
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
    void testLogRequestBody4() {
        DefaultDataBuffer delegate = mock(DefaultDataBuffer.class);
        when(delegate.toString(Mockito.any())).thenReturn("String");
        DataBufferWrapper dataBuffer = new DataBufferWrapper(
                new DataBufferWrapper(new DataBufferWrapper(new DataBufferWrapper(delegate))));
        ClientRequest request = mock(ClientRequest.class);
        when(request.url()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(request.method()).thenReturn(HttpMethod.GET);
        responseExchangeFilter.logRequestBody(dataBuffer, request);
        verify(delegate).toString(Mockito.any());
        verify(request).url();
        verify(request).method();
    }

    /**
     * Method under test: {@link ResponseExchangeFilter#logRequestBody(DataBuffer, ClientRequest)}
     */
    @Test
    void testLogRequestBody5() {
        DefaultDataBuffer delegate = mock(DefaultDataBuffer.class);
        when(delegate.toString(Mockito.any())).thenReturn("String");
        DataBufferWrapper dataBuffer = new DataBufferWrapper(
                new DataBufferWrapper(new DataBufferWrapper(new DataBufferWrapper(delegate))));
        ClientRequest request = mock(ClientRequest.class);
        when(request.url()).thenThrow(new WebClientResponseException(3, "Request HTTP {} to: {} - body: {}",
                new HttpHeaders(), new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, null));
        when(request.method()).thenReturn(HttpMethod.GET);
        assertThrows(WebClientResponseException.class, () -> responseExchangeFilter.logRequestBody(dataBuffer, request));
        verify(request).url();
        verify(request).method();
    }
}

