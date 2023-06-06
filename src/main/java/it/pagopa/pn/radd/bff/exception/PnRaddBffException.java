package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.commons.exceptions.PnRuntimeException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class PnRaddBffException extends PnRuntimeException {
    public PnRaddBffException(@NonNull String message, @NonNull String description, int status,
                              @NonNull String errorCode, @Nullable String element, @Nullable String detail) {
        super(message, description, status, errorCode, element, detail);
    }
}
