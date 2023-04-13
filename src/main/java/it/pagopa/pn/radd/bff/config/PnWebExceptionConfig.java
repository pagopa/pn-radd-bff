package it.pagopa.pn.radd.bff.config;

import it.pagopa.pn.commons.exceptions.ExceptionHelper;
import it.pagopa.pn.commons.exceptions.PnErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

@Order(-2)
@Configuration
@Import(ExceptionHelper.class)
public class PnWebExceptionConfig extends PnErrorWebExceptionHandler {

    public PnWebExceptionConfig(ExceptionHelper exceptionHelper) {
        super(exceptionHelper);
    }
}
