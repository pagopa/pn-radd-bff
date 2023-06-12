package it.pagopa.pn.radd.bff.queue.consumer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pn.radd.bff.event")
public class EventHandler {
    private String handlerDocumentReady;
}
