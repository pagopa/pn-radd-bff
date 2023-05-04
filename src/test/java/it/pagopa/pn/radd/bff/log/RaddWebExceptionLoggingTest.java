package it.pagopa.pn.radd.bff.log;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.commons.exceptions.ExceptionHelper;
import it.pagopa.pn.commons.exceptions.IValidationCustomMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.*;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.Mockito.*;

class RaddWebExceptionLoggingTest {
    /**
     * Method under test: {@link RaddWebExceptionLogging#RaddWebExceptionLogging(ExceptionHelper)}
     */
    @Test
    void testConstructor() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PnErrorWebExceptionHandler.exceptionHelper
        //     PnErrorWebExceptionHandler.objectMapper
        //     ExceptionHelper.applicationName
        //     ExceptionHelper.validationMap

        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        RaddWebExceptionLogging actualRaddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        actualRaddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#RaddWebExceptionLogging(ExceptionHelper)}
     */
    @Test
    void testConstructor5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PnErrorWebExceptionHandler.exceptionHelper
        //     PnErrorWebExceptionHandler.objectMapper
        //     ExceptionHelper.applicationName
        //     ExceptionHelper.validationMap

        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        Optional.of(iValidationCustomMapper);
        Problem problem = mock(Problem.class);
        when(problem.getStatus()).thenReturn(1);
        ExceptionHelper exceptionHelper = mock(ExceptionHelper.class);
        when(exceptionHelper.generateFallbackProblem()).thenReturn("Generate Fallback Problem");
        when(exceptionHelper.handleException(Mockito.<Throwable>any())).thenReturn(problem);
        RaddWebExceptionLogging actualRaddWebExceptionLogging = new RaddWebExceptionLogging(exceptionHelper);
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        actualRaddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(exceptionHelper).handleException(Mockito.<Throwable>any());
        verify(exceptionHelper).generateFallbackProblem();
        verify(problem).getStatus();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#RaddWebExceptionLogging(ExceptionHelper)}
     */
    @Test
    void testConstructor6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PnErrorWebExceptionHandler.exceptionHelper
        //     PnErrorWebExceptionHandler.objectMapper
        //     ExceptionHelper.applicationName
        //     ExceptionHelper.validationMap

        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        Optional.of(iValidationCustomMapper);
        Problem problem = mock(Problem.class);
        when(problem.getStatus()).thenReturn(1);
        ExceptionHelper exceptionHelper = mock(ExceptionHelper.class);
        when(exceptionHelper.generateFallbackProblem()).thenReturn("Generate Fallback Problem");
        when(exceptionHelper.handleException(Mockito.<Throwable>any())).thenReturn(problem);
        RaddWebExceptionLogging actualRaddWebExceptionLogging = new RaddWebExceptionLogging(exceptionHelper);
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        ServerHttpResponse delegate2 = mock(ServerHttpResponse.class);
        when(delegate2.writeWith(Mockito.<Publisher<DataBuffer>>any()))
                .thenReturn(new ChannelSendOperator<>(mock(Publisher.class), mock(Function.class)));
        when(delegate2.getHeaders()).thenReturn(new HttpHeaders());
        when(delegate2.setStatusCode(Mockito.<HttpStatus>any())).thenReturn(true);
        when(delegate2.bufferFactory()).thenReturn(new DefaultDataBufferFactory());
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse()).thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(delegate2))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        actualRaddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(exceptionHelper).handleException(Mockito.<Throwable>any());
        verify(exceptionHelper).generateFallbackProblem();
        verify(problem).getStatus();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate2).setStatusCode(Mockito.<HttpStatus>any());
        verify(delegate2).bufferFactory();
        verify(delegate2).getHeaders();
        verify(delegate2).writeWith(Mockito.<Publisher<DataBuffer>>any());
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#RaddWebExceptionLogging(ExceptionHelper)}
     */
    @Test
    void testConstructor9() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PnErrorWebExceptionHandler.exceptionHelper
        //     PnErrorWebExceptionHandler.objectMapper
        //     ExceptionHelper.applicationName
        //     ExceptionHelper.validationMap

        Problem problem = mock(Problem.class);
        when(problem.getStatus()).thenReturn(1);
        ExceptionHelper exceptionHelper = mock(ExceptionHelper.class);
        when(exceptionHelper.generateFallbackProblem()).thenReturn("Generate Fallback Problem");
        when(exceptionHelper.handleException(Mockito.<Throwable>any())).thenReturn(problem);
        RaddWebExceptionLogging actualRaddWebExceptionLogging = new RaddWebExceptionLogging(exceptionHelper);
        ServerHttpRequestDecorator delegate = mock(ServerHttpRequestDecorator.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse()).thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new HttpHeadResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse())))))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        actualRaddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(exceptionHelper).handleException(Mockito.<Throwable>any());
        verify(exceptionHelper).generateFallbackProblem();
        verify(problem).getStatus();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle3() {
        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        RaddWebExceptionLogging raddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        ServerHttpRequest delegate = mock(ServerHttpRequest.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        raddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle4() {
        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("recipientTaxId=U", "42");
        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(stringStringMap);
        RaddWebExceptionLogging raddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        ServerHttpRequest delegate = mock(ServerHttpRequest.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        raddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle6() {
        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        RaddWebExceptionLogging raddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        ServerHttpRequest delegate = mock(ServerHttpRequest.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "recipientTaxId=U").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        raddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle7() {
        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        RaddWebExceptionLogging raddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        ServerHttpRequest delegate = mock(ServerHttpRequest.class);
        when(delegate.getURI())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "recipientTaxId=U", "Errore generico").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(delegate, "Masked URI"), "Masked URI"), "Masked URI"),
                "Masked URI"), "Masked URI");

        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        raddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }

    /**
     * Method under test: {@link RaddWebExceptionLogging#handle(ServerWebExchange, Throwable)}
     */
    @Test
    void testHandle8() {
        IValidationCustomMapper iValidationCustomMapper = mock(IValidationCustomMapper.class);
        when(iValidationCustomMapper.getValidationCodeCustomMapping()).thenReturn(new HashMap<>());
        RaddWebExceptionLogging raddWebExceptionLogging = new RaddWebExceptionLogging(
                new ExceptionHelper(Optional.of(iValidationCustomMapper)));
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
        ServerHttpRequest delegate = mock(ServerHttpRequest.class);
        when(delegate.getURI()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
        when(delegate.getMethod()).thenReturn(HttpMethod.GET);
        RaddRequestDecorator raddRequestDecorator = new RaddRequestDecorator(
                new RaddRequestDecorator(
                        new RaddRequestDecorator(new RaddRequestDecorator(
                                new ServerHttpRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                        new RaddRequestDecorator(delegate, "recipientTaxId=U"), "recipientTaxId=U"), "recipientTaxId=U")),
                                "Masked URI"), "Masked URI"),
                        "Masked URI"),
                "Masked URI");

        ServerWebExchange exchange = mock(ServerWebExchange.class);
        when(exchange.getResponse()).thenReturn(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new HttpHeadResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                                new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse())))))))))));
        when(exchange.getRequest()).thenReturn(raddRequestDecorator);
        RaddWebExchangeDecorator exchange2 = new RaddWebExchangeDecorator(
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"),
                "Masked URI");

        raddWebExceptionLogging.handle(exchange2, new Throwable());
        verify(iValidationCustomMapper).getValidationCodeCustomMapping();
        verify(exchange).getRequest();
        verify(exchange).getResponse();
        verify(delegate).getURI();
        verify(delegate).getMethod();
    }
}

