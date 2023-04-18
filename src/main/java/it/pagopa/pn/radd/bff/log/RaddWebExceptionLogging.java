package it.pagopa.pn.radd.bff.log;

import it.pagopa.pn.commons.exceptions.ExceptionHelper;
import it.pagopa.pn.commons.exceptions.PnErrorWebExceptionHandler;
import it.pagopa.pn.radd.bff.utils.MaskDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static it.pagopa.pn.radd.bff.log.RaddRequestResponseLoggingFilter.LOG_RESPONSE_KO;

@Slf4j
public class RaddWebExceptionLogging extends PnErrorWebExceptionHandler {

    public RaddWebExceptionLogging(ExceptionHelper exceptionHelper) {
        super(exceptionHelper);
    }

    @Override
    public @NotNull Mono<Void> handle(@NotNull ServerWebExchange exchange, @NotNull Throwable throwable) {
        final ServerHttpRequest httpRequest = exchange.getRequest();

        final HttpMethod httpMethod = httpRequest.getMethod();
        final String maskedURI = MaskDataUtils.maskInfo(httpRequest.getURI().toString());

        RaddWebExchangeDecorator webExchangeDecorator = new RaddWebExchangeDecorator(exchange, maskedURI);

        return super.handle(webExchangeDecorator, throwable)
                .doOnTerminate(() -> {
                    var statusCode = webExchangeDecorator.getResponse().getStatusCode();
                    var body = webExchangeDecorator.getResponse().getCapturedBody();
                    log.info(LOG_RESPONSE_KO, statusCode, httpMethod, maskedURI, body);
                });
    }
}
