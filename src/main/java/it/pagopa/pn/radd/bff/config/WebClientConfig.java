package it.pagopa.pn.radd.bff.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pn.radd.bff.webclient")
public class WebClientConfig {
    private Integer tcpMaxPoolSize;
    private Integer tcpMaxQueuedConnections;
    private Integer tcpPendingAcquiredTimeout;
    private Integer tcpPoolIdleTimeout;
}
