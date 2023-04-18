package it.pagopa.pn.radd.bff.config;

import it.pagopa.pn.commons.exceptions.ExceptionHelper;
import it.pagopa.pn.radd.bff.log.RaddWebExceptionLogging;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

@Order(-2)
@Configuration
@Import(ExceptionHelper.class)
public class PnRaddBffWebExceptionConfig extends RaddWebExceptionLogging {

    public PnRaddBffWebExceptionConfig(ExceptionHelper exceptionHelper) {
        super(exceptionHelper);
    }
}
