package it.pagopa.pn.radd.bff.exception;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.nio.charset.Charset;

public class PnRaddBFFException extends WebClientResponseException {

    @Getter
    private final Class<?> className;

    public PnRaddBFFException(String message, int statusCode, String statusText, HttpHeaders headers, byte[] responseBody, Charset charset, Class<?> className) {
        super(message, statusCode, statusText, headers, responseBody, charset);
        this.className = className;
    }
}
