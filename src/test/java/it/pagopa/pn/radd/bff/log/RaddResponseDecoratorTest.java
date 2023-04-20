package it.pagopa.pn.radd.bff.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;

class RaddResponseDecoratorTest {
    /**
     * Method under test: {@link RaddResponseDecorator#RaddResponseDecorator(ServerHttpResponse)}
     */
    @Test
    void testConstructor() {
        RaddResponseDecorator actualRaddResponseDecorator = new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        assertEquals("", actualRaddResponseDecorator.getCapturedBody());
        assertNull(actualRaddResponseDecorator.getStatusCode());
    }

    /**
     * Method under test: {@link RaddResponseDecorator#writeWith(Publisher)}
     */
    @Test
    void testWriteWith() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))))
                .writeWith(mock(Publisher.class));
    }

    /**
     * Method under test: {@link RaddResponseDecorator#writeWith(Publisher)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWriteWith2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:208)
        //       at reactor.core.publisher.FluxSource.<init>(FluxSource.java:48)
        //       at reactor.core.publisher.Flux.wrap(Flux.java:10802)
        //       at reactor.core.publisher.Flux.from(Flux.java:1090)
        //       at it.pagopa.pn.radd.bff.log.RaddResponseDecorator.writeWith(RaddResponseDecorator.java:24)
        //   See https://diff.blue/R013 to resolve this issue.

        (new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))).writeWith(null);
    }

    /**
     * Method under test: {@link RaddResponseDecorator#writeWith(Publisher)}
     */
    @Test
    void testWriteWith3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new HttpHeadResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse())))))))))))
                .writeWith(mock(Publisher.class));
    }

    /**
     * Method under test: {@link RaddResponseDecorator#writeWith(Publisher)}
     */
    @Test
    void testWriteWith4() {
        ServerHttpResponseDecorator delegate = mock(ServerHttpResponseDecorator.class);
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(mock(Publisher.class),
                mock(Function.class));

        when(delegate.writeWith(Mockito.<Publisher<DataBuffer>>any())).thenReturn(channelSendOperator);
        assertSame(channelSendOperator, (new RaddResponseDecorator(delegate)).writeWith(mock(Publisher.class)));
        verify(delegate).writeWith(Mockito.<Publisher<DataBuffer>>any());
    }

    /**
     * Method under test: {@link RaddResponseDecorator#getCapturedBody()}
     */
    @Test
    void testGetCapturedBody() {
        assertEquals("", (new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse())))))).getCapturedBody());
    }
}

