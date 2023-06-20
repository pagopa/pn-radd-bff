package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.commons.exceptions.PnRuntimeException;
import it.pagopa.pn.radd.bff.utils.MaskDataUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class PnRaddFsuException extends PnRuntimeException {

    public PnRaddFsuException(@Nullable String message,
                              @NonNull String code,
                              @NonNull String detail,
                              int statusCode,
                              @NonNull String statusText,
                              @Nullable Throwable cause) {
        super(statusText, mask(message), statusCode, code, null, detail, cause);
    }

    private static String mask(String message) {
        if (message != null) {
            return MaskDataUtils.maskUri(message);
        }
        return "Errore durante la chiamata a pn-radd-fsu";
    }
}
