package it.pagopa.pn.radd.bff.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class CorsGlobalConfig implements WebFluxConfigurer {

    private final List<String> corsAllowedDomains;

    public CorsGlobalConfig(@Value("${cors.allowed.domains:}") List<String> corsAllowedDomains,
                            @Value("${pn.radd.bff.amplify.cors.domain:}") String amplifyCorsDomain) {
        this.corsAllowedDomains = concatCorsAllowedDomains(corsAllowedDomains, amplifyCorsDomain);
    }

    @Override
    public void addCorsMappings(@NotNull CorsRegistry corsRegistry) {
        if (log.isInfoEnabled()) {
            log.info("allowed domains:" + String.join(", ", corsAllowedDomains));
        }
        corsRegistry.addMapping("/**")
                .allowedOrigins(corsAllowedDomains.toArray(new String[0]))
                .allowedMethods("GET", "HEAD", "OPTIONS", "POST", "PUT", "DELETE", "PATCH")
                .maxAge(3600);
    }

    private List<String> concatCorsAllowedDomains(List<String> corsAllowedDomains, String amplifyCorsDomain) {
        List<String> result = new ArrayList<>(corsAllowedDomains);
        if (amplifyCorsDomain != null && !amplifyCorsDomain.isEmpty()) {
            result.add(amplifyCorsDomain);
        }
        return result;
    }
}
