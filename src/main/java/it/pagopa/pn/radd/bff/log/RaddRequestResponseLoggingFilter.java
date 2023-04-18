package it.pagopa.pn.radd.bff.log;

import it.pagopa.pn.radd.bff.utils.MaskDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RaddRequestResponseLoggingFilter implements WebFilter {

    static final String LOG_REQUEST = "Request HTTP {} to {}";
    static final String LOG_REQUEST_BODY = "Request HTTP {} to {} - body: {}";

    static final String LOG_RESPONSE_OK = "Response from {} {} - body: {} - timelapse: {}ms";
    static final String LOG_RESPONSE_KO = "Response {} from {} {} - body: {}";

    @Override
    public @NotNull Mono<Void> filter(ServerWebExchange exchange, @NotNull WebFilterChain chain) {
        final ServerHttpRequest httpRequest = exchange.getRequest();

        final HttpMethod httpMethod = httpRequest.getMethod();
        final String maskedURI = MaskDataUtils.maskInfo(httpRequest.getURI().toString());

        long startTime = System.currentTimeMillis();

        RaddWebExchangeDecorator webExchangeDecorator = new RaddWebExchangeDecorator(exchange, maskedURI);

        HttpHeaders headers = webExchangeDecorator.getRequest().getHeaders();
        if (headers.getContentLength() <= 0) {
            // if the request does not include a body, then I run the log here,
            // but if the body is present the request is logged by the RequestDecorator
            log.info(LOG_REQUEST, httpMethod, maskedURI);
        }

        return chain.filter(webExchangeDecorator)
                .doOnTerminate(() -> {
                    var body = webExchangeDecorator.getResponse().getCapturedBody();
                    var elapsed = System.currentTimeMillis() - startTime;
                    log.info(LOG_RESPONSE_OK, httpMethod, maskedURI, body, elapsed);
                });
    }
}
