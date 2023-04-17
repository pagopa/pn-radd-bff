package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;
import it.pagopa.pn.commons.exceptions.ExceptionHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {PnWebExceptionHandler.class})
@ExtendWith(SpringExtension.class)
class PnWebExceptionHandlerTest {
    @MockBean
    private ExceptionHelper exceptionHelper;

    @Autowired
    private PnWebExceptionHandler pnWebExceptionHandler;

    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle4() throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        byte[] responseBody = "AAAAAAAA".getBytes(StandardCharsets.UTF_8);
        when(exceptionHelper.handleException(any())).thenThrow(
                new PnRaddBffException("An error occurred", 2, "Status Text", headers, responseBody, null, Object.class));
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        assertThrows(PnRaddBffException.class,
                () -> pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable()));
        verify(exceptionHelper).handleException(any());
        verify(defaultServerWebExchange).getResponse();
    }

    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle5() {
        Problem problem = new Problem();
        problem.status(1);
        when(exceptionHelper.handleException(any())).thenReturn(problem);
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest())
                .thenReturn(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator))))));
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
        verify(exceptionHelper).handleException(any());
        verify(defaultServerWebExchange).getRequest();
        verify(defaultServerWebExchange, atLeast(1)).getResponse();
        verify(serverHttpRequestDecorator).getURI();
    }

    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle6() {
        ArrayList<ProblemError> problemErrorList = new ArrayList<>();
        problemErrorList.add(new ProblemError("Code", "Element", "Detail"));
        Problem problem = mock(Problem.class);
        when(problem.status(any())).thenReturn(new Problem());
        when(problem.getStatus()).thenReturn(1);
        when(problem.getDetail()).thenReturn("Detail");
        when(problem.getTitle()).thenReturn("Dr");
        when(problem.getErrors()).thenReturn(problemErrorList);
        problem.status(1);
        when(exceptionHelper.handleException(any())).thenReturn(problem);
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest())
                .thenReturn(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator))))));
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
        verify(exceptionHelper).handleException(any());
        verify(problem).status(any());
        verify(problem).getStatus();
        verify(problem).getDetail();
        verify(problem).getTitle();
        verify(problem).getErrors();
        verify(defaultServerWebExchange).getRequest();
        verify(defaultServerWebExchange, atLeast(1)).getResponse();
        verify(serverHttpRequestDecorator).getURI();
    }


    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle8() {
        Problem problem = mock(Problem.class);
        when(problem.status(any())).thenReturn(new Problem());
        when(problem.getStatus()).thenReturn(1);
        when(problem.getDetail()).thenReturn("Detail");
        when(problem.getTitle()).thenReturn("Dr");
        when(problem.getErrors()).thenReturn(new ArrayList<>());
        problem.status(1);
        when(exceptionHelper.handleException(any())).thenReturn(problem);
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest())
                .thenReturn(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator))))));
        when(defaultServerWebExchange.getResponse())
                .thenReturn(new HttpHeadResponseDecorator(new MockServerHttpResponse()));
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
        verify(exceptionHelper).handleException(any());
        verify(problem).status(any());
        verify(problem).getStatus();
        verify(problem).getDetail();
        verify(problem).getTitle();
        verify(problem).getErrors();
        verify(defaultServerWebExchange).getRequest();
        verify(defaultServerWebExchange, atLeast(1)).getResponse();
        verify(serverHttpRequestDecorator).getURI();
    }


    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle10() throws UnsupportedEncodingException {
        Problem problem = mock(Problem.class);
        when(problem.status(any())).thenReturn(new Problem());
        when(problem.getStatus()).thenReturn(1);
        when(problem.getDetail()).thenReturn("Detail");
        when(problem.getTitle()).thenReturn("Dr");
        when(problem.getErrors()).thenReturn(new ArrayList<>());
        problem.status(1);
        when(exceptionHelper.handleException(any())).thenReturn(problem);
        HttpHeadResponseDecorator httpHeadResponseDecorator = mock(HttpHeadResponseDecorator.class);
        HttpHeaders headers = new HttpHeaders();
        when(httpHeadResponseDecorator.setStatusCode(any())).thenThrow(new WebClientResponseException(1,
                "Error -> statusCode: {}, message: {}, uri: {}", headers, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null));
        HttpHeaders headers1 = new HttpHeaders();
        when(httpHeadResponseDecorator.getHeaders()).thenThrow(new WebClientResponseException(1,
                "Error -> statusCode: {}, message: {}, uri: {}", headers1, "AAAAAAAA".getBytes(StandardCharsets.UTF_8), null));
        when(httpHeadResponseDecorator.bufferFactory()).thenReturn(new DefaultDataBufferFactory());
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest())
                .thenReturn(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator))))));
        when(defaultServerWebExchange.getResponse()).thenReturn(httpHeadResponseDecorator);
        assertThrows(WebClientResponseException.class,
                () -> pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable()));
        verify(exceptionHelper).handleException(any());
        verify(problem).status(any());
        verify(problem).getStatus();
        verify(problem).getDetail();
        verify(problem).getTitle();
        verify(problem).getErrors();
        verify(defaultServerWebExchange).getRequest();
        verify(defaultServerWebExchange, atLeast(1)).getResponse();
        verify(serverHttpRequestDecorator).getURI();
        verify(httpHeadResponseDecorator).setStatusCode(any());
        verify(httpHeadResponseDecorator).bufferFactory();
    }
}

