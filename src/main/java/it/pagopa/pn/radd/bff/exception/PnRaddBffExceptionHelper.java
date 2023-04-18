package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.commons.exceptions.*;

import it.pagopa.pn.radd.bff.utils.MaskDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static it.pagopa.pn.commons.exceptions.PnExceptionsCodes.ERROR_CODE_PN_GENERIC_ERROR;
import static it.pagopa.pn.commons.exceptions.PnExceptionsCodes.ERROR_CODE_PN_WEB_GENERIC_ERROR;
import static it.pagopa.pn.commons.log.MDCWebFilter.MDC_TRACE_ID_KEY;

@Slf4j
@Primary
@Component
public class PnRaddBffExceptionHelper extends ExceptionHelper {

    private static final String LOG_MSG = "pn-exception -> status: {}, message: {}, problem: {}";

    private final String appName;

    public PnRaddBffExceptionHelper(ObjectProvider<IValidationCustomMapper> customMapper,
                                    @Value("${spring.application.name:}") String appName) {
        super(Optional.ofNullable(customMapper.getIfAvailable()));
        this.appName = appName;
    }

    @Override
    public Problem handleException(Throwable throwable) {
        Problem problem;
        if (throwable instanceof ConstraintViolationException e) {
            // eccezione di constraint, recupero le info dei campi
            PnValidationException pnValidationException = new PnValidationExceptionBuilder<>(this)
                    .validationErrors(e.getConstraintViolations())
                    .cause(e)
                    .message(e.getMessage())
                    .build();
            problem = pnValidationException.getProblem();
        } else if (throwable instanceof WebExchangeBindException e) {
            // eccezione di spring riguardante errori di validazione, recupero le info dei campi
            PnValidationException pnValidationException = new PnValidationExceptionBuilder<>(this)
                    .fieldErrors(e.getFieldErrors())
                    .cause(e)
                    .message(e.getMessage())
                    .build();
            problem = pnValidationException.getProblem();
        } else if (throwable instanceof ResponseStatusException e) {
            // eccezione di spring riguardante errori di altra natura
            PnRuntimeException pnRuntimeException = new PnRuntimeException(
                    Objects.requireNonNull(e.getMessage() == null ? "Web error" : e.getMessage()),
                    Objects.requireNonNull(e.getReason() == null ?  "Web error" : e.getReason()),
                    e.getRawStatusCode(), ERROR_CODE_PN_WEB_GENERIC_ERROR, null, null, e);
            problem = pnRuntimeException.getProblem();
        } else if (throwable instanceof IPnException ex) {
            problem = ex.getProblem();
        } else {
            problem = new PnInternalException("Errore generico", ERROR_CODE_PN_GENERIC_ERROR, throwable).getProblem();
        }

        tryEnrichTraceIdIfMissing(problem);

        if (problem.getStatus() >= 500) {
            log.error(LOG_MSG, problem.getStatus(), MaskDataUtils.maskInfo(throwable.getMessage()), problem);
        } else {
            log.warn(LOG_MSG, problem.getStatus(), MaskDataUtils.maskInfo(throwable.getMessage()), problem);
        }

        return offuscate(problem);
    }

    private void tryEnrichTraceIdIfMissing(Problem problem) {
        if (problem.getTraceId() == null) {
            problem.setTraceId(getTraceId());
        }
    }

    private String getTraceId() {
        String traceId = null;
        try {
            traceId = MDC.get(MDC_TRACE_ID_KEY);
        } catch (Exception e) {
            log.warn("can not get traceId", e);
        }
        return traceId != null ? traceId : "FALLBACK-UUID:" + UUID.randomUUID();
    }

    private Problem offuscate(Problem problem) {
        if (problem.getStatus() >= 500) {
            problem.setTitle(MESSAGE_UNEXPECTED_ERROR);
        } else {
            problem.setTitle(MESSAGE_HANDLED_ERROR);
        }
        problem.setDetail(MESSAGE_SEE_LOGS_FOR_DETAILS + appName);
        return problem;
    }
}
