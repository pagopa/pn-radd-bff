package it.pagopa.pn.radd.bff.queue.consumer;

import it.pagopa.pn.radd.bff.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RaddBffHandlerTest {

    @Test
    void testPnRaddBffDocumentReadyConsumer() {
        DocumentService documentService = mock(DocumentService.class);
        RaddBffHandler pnRaddBff = createPnRaddBff(documentService);

        // Create a sample message for testing
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setKey("documentKey");
        Message<PnRaddBffEvent.Payload> message = MessageBuilder.withPayload(payload).build();

        // Invoke the pnRaddBffDocumentReadyConsumer method
        pnRaddBff.pnRaddBffDocumentReadyConsumer().accept(message);

        // Verify the behavior and assertions
        verify(documentService, times(1)).setDocumentReadyRecord("documentKey");

        // You can also add additional assertions or verifications as needed
    }
    @Test
    void testPnRaddBffDocumentReadyConsumer2() {
        DocumentService documentService = mock(DocumentService.class);
        RaddBffHandler pnRaddBff = createPnRaddBff(documentService);

        // Create a sample message for testing
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setKey("documentKey");
        Message<PnRaddBffEvent.Payload> message = MessageBuilder.withPayload(payload).build();

        // Invoke the pnRaddBffDocumentReadyConsumer method
        pnRaddBff.pnRaddBffDocumentReadyConsumer().accept(message);

        Consumer<Message<PnRaddBffEvent.Payload>> consumer = pnRaddBff.pnRaddBffDocumentReadyConsumer();
        assertThrows(NullPointerException.class, () -> {
           consumer.accept(null);
        });
        // Verify the behavior and assertions

        // You can also add additional assertions or verifications as needed
    }
    private RaddBffHandler createPnRaddBff(DocumentService documentService) {
        return new RaddBffHandler(documentService);
    }
}