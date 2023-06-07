package it.pagopa.pn.radd.bff.queue.consumer;

import it.pagopa.pn.radd.bff.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class RaddBffHandler {

    private final DocumentService documentService;

    public RaddBffHandler(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Bean
    public Consumer<Message<PnRaddBffEvent.Payload>> pnRaddBffDocumentReadyConsumer() {
        return message -> {
            try {
                log.info("START - pnRaddBffDocumentReadyConsumer - message: {}", message);
                log.debug("pnRaddBffDocumentReadyConsumer - message: {}", message);
                documentService.setDocumentReadyRecord(message.getPayload().getKey());
                log.info("END - pnRaddBffDocumentReadyConsumer - message: {}", message);
            } catch (Exception e) {
                log.info("ERROR - pnRaddBffDocumentReadyConsumer - message: {}, {}", message, e.getMessage());
                HandleEventUtils.handleException(message.getHeaders(), e);
                throw e;
            }
        };
    }
}
