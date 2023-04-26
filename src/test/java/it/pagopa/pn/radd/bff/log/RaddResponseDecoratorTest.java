package it.pagopa.pn.radd.bff.log;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

