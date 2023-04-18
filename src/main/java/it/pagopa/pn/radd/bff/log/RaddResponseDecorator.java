package it.pagopa.pn.radd.bff.log;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.StandardCharsets;

public class RaddResponseDecorator extends ServerHttpResponseDecorator {

    private final StringBuilder body = new StringBuilder();

    public RaddResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
    }

    @Override
    public @NotNull Mono<Void> writeWith(@NotNull Publisher<? extends DataBuffer> body) {
        Flux<DataBuffer> buffer = Flux.from(body);
        return super.writeWith(buffer.publishOn(Schedulers.boundedElastic())
                .doOnNext(this::capture));
    }

    public String getCapturedBody() {
        return body.toString();
    }

    private void capture(DataBuffer buffer) {
        var decoded = StandardCharsets.UTF_8.decode(buffer.asByteBuffer().asReadOnlyBuffer());
        body.append(decoded);
    }
}
