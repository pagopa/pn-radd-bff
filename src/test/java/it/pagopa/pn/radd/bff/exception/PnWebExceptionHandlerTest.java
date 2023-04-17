package it.pagopa.pn.radd.bff.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;
import it.pagopa.pn.commons.exceptions.ExceptionHelper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;

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
    @Disabled("TODO: Complete this test")
    void testHandle() {
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
        DefaultServerWebExchange serverWebExchange = new DefaultServerWebExchange(request, response, sessionManager,
                codecConfigurer, new AcceptHeaderLocaleContextResolver());

        pnWebExceptionHandler.handle(serverWebExchange, new Throwable());
    }

    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandle2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.server.ServerWebExchange.getResponse()" because "serverWebExchange" is null
        //       at it.pagopa.pn.radd.bff.exception.PnWebExceptionHandler.handle(PnWebExceptionHandler.java:57)
        //   See https://diff.blue/R013 to resolve this issue.

        pnWebExceptionHandler.handle(null, new Throwable());
    }

    /**
     * Method under test: {@link PnWebExceptionHandler#handle(ServerWebExchange, Throwable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandle3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "it.pagopa.pn.radd.bff.model.RaddBffProblem.getStatus()" is null
        //       at it.pagopa.pn.radd.bff.exception.PnWebExceptionHandler.handle(PnWebExceptionHandler.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        when(exceptionHelper.handleException(any())).thenReturn(new Problem());
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
    }

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
    @Disabled("TODO: Complete this test")
    void testHandle7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.server.reactive.ServerHttpRequest.getURI()" because the return value of "org.springframework.web.server.ServerWebExchange.getRequest()" is null
        //       at it.pagopa.pn.radd.bff.exception.PnWebExceptionHandler.handle(PnWebExceptionHandler.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        Problem problem = mock(Problem.class);
        when(problem.status(any())).thenReturn(new Problem());
        when(problem.getStatus()).thenReturn(1);
        when(problem.getDetail()).thenReturn("Detail");
        when(problem.getTitle()).thenReturn("Dr");
        when(problem.getErrors()).thenReturn(new ArrayList<>());
        problem.status(1);
        when(exceptionHelper.handleException(any())).thenReturn(problem);
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest()).thenReturn(null);
        when(defaultServerWebExchange.getResponse()).thenReturn(new MockServerHttpResponse());
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(
                new ServerHttpRequestDecorator(new ServerHttpRequestDecorator(serverHttpRequestDecorator))));
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
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
    @Disabled("TODO: Complete this test")
    void testHandle9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.server.reactive.ServerHttpResponse.bufferFactory()" because the return value of "org.springframework.web.server.ServerWebExchange.getResponse()" is null
        //       at it.pagopa.pn.radd.bff.exception.PnWebExceptionHandler.handle(PnWebExceptionHandler.java:57)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(defaultServerWebExchange.getResponse()).thenReturn(null);
        pnWebExceptionHandler.handle(defaultServerWebExchange, new Throwable());
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

