package it.pagopa.pn.radd.bff.queue.consumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PnEventInboundServiceTest {

    @InjectMocks
    private PnEventInboundService pnEventInboundService;

    @Mock
    private EventHandler eventHandler;

    @Test
    void testCustomRouter() {
        String expectedDocumentReady = "Document ready";
        eventHandler = mock(EventHandler.class);

        when(eventHandler.getHandlerDocumentReady()).thenReturn(expectedDocumentReady);

        pnEventInboundService = new PnEventInboundService(eventHandler);
        EventHandler eventHandler = mock(EventHandler.class);

        // Create a sample message for testing
        Message<?> message = MessageBuilder.withPayload("Test message").setHeader("aws_messageId", "test")
                .setHeader("X-Amzn-Trace-Id", "test").build();

        // Set up mock behavior for eventHandler.getHandlerDocumentReady()
        MessageRoutingCallback customRouter = pnEventInboundService.customRouter();

        // Invoke the routingResult method
        MessageRoutingCallback.FunctionRoutingResult result = customRouter.routingResult(message);

        // Verify the behavior and assertions
        assertEquals("Document ready", expectedDocumentReady);

        // You can also add additional assertions or verifications as needed
        // For example, you can verify if the trace ID is properly set
    }

    @Test
    void testCustomRouter2() {
        String expectedDocumentReady = "Document ready";
        eventHandler = mock(EventHandler.class);

        when(eventHandler.getHandlerDocumentReady()).thenReturn(expectedDocumentReady);

        pnEventInboundService = new PnEventInboundService(eventHandler);
        EventHandler eventHandler = mock(EventHandler.class);

        // Create a sample message for testing
        Message<?> message = MessageBuilder.withPayload("Test message").setHeader("aws_messageId", "test").build();

        // Set up mock behavior for eventHandler.getHandlerDocumentReady()
        MessageRoutingCallback customRouter = pnEventInboundService.customRouter();

        // Invoke the routingResult method
        MessageRoutingCallback.FunctionRoutingResult result = customRouter.routingResult(message);

        // Verify the behavior and assertions
        assertEquals("Document ready", expectedDocumentReady);

        // You can also add additional assertions or verifications as needed
        // For example, you can verify if the trace ID is properly set
    }
}