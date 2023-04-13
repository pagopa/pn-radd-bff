package it.pagopa.pn.radd.bff.log;

import it.pagopa.pn.radd.bff.utils.MaskDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RequestResponseLoggingFilter implements WebFilter {

    @Override
    public @NotNull Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final ServerHttpRequest httpRequest = exchange.getRequest();

        final HttpMethod httpMethod = httpRequest.getMethod();
        final String httpUrl = MaskDataUtils.maskInfo(httpRequest.getURI().toString());

        long startTime = System.currentTimeMillis();

        RaddWebExchangeDecorator webExchangeDecorator = new RaddWebExchangeDecorator(exchange);
        return chain.filter(webExchangeDecorator)
                .doOnSuccess(s -> {
                    var elapsed = System.currentTimeMillis() - startTime;
                    log.info("Request HTTP {} to {} - body: {}", httpMethod, httpUrl, webExchangeDecorator.getRequest().getCapturedBody());
                    log.info("Response from {} - body: {} - timelapse: {}ms", httpUrl, webExchangeDecorator.getResponse().getCapturedBody(), elapsed);
                })
                .doOnError(e -> {
                    var elapsed = System.currentTimeMillis() - startTime;
                    log.info("Request HTTP {} to {} - body: {}", httpMethod, httpUrl, webExchangeDecorator.getRequest().getCapturedBody());
                    log.info("Response from {} - body: {} - timelapse: {}ms", httpUrl, webExchangeDecorator.getResponse().getCapturedBody(), elapsed);
                });
    }

}
