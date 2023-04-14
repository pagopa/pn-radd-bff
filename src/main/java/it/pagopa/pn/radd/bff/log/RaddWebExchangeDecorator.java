package it.pagopa.pn.radd.bff.log;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

public class RaddWebExchangeDecorator extends ServerWebExchangeDecorator {

    private final RaddRequestDecorator requestDecorator;
    private final RaddResponseDecorator responseDecorator;

    public RaddWebExchangeDecorator(ServerWebExchange exchange, String maskedURI) {
        super(exchange);
        requestDecorator = new RaddRequestDecorator(exchange.getRequest(), maskedURI);
        responseDecorator = new RaddResponseDecorator(exchange.getResponse());
    }

    @Override
    public @NotNull RaddRequestDecorator getRequest() {
        return requestDecorator;
    }

    @Override
    public @NotNull RaddResponseDecorator getResponse() {
        return responseDecorator;
    }
}
