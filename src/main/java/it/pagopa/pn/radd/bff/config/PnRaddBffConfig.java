package it.pagopa.pn.radd.bff.config;

import it.pagopa.pn.commons.conf.SharedAutoConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "pn.radd.bff")
@Import(SharedAutoConfiguration.class)
public class PnRaddBffConfig {

    private String clientPnRaddFsuBasepath;

}
