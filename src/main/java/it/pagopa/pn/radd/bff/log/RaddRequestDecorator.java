package it.pagopa.pn.radd.bff.log;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.StandardCharsets;

public class RaddRequestDecorator extends ServerHttpRequestDecorator {

    private final StringBuilder body = new StringBuilder();

    public RaddRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
    }

    @Override
    public @NotNull Flux<DataBuffer> getBody() {
        return super.getBody()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(this::capture);
    }

    public String getCapturedBody() {
        return body.toString();
    }

    private void capture(DataBuffer buffer) {
        var decoded = StandardCharsets.UTF_8.decode(buffer.asByteBuffer().asReadOnlyBuffer());
        body.append(decoded);
    }
}
