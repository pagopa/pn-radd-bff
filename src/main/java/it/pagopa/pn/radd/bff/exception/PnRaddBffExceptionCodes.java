package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.commons.exceptions.PnExceptionsCodes;

public class PnRaddBffExceptionCodes extends PnExceptionsCodes {

    public static final String ERROR_CODE_ACT_INQUIRY = "PN_RADD_BFF_ACT_INQUIRY";
    public static final String ERROR_CODE_AOR_INQUIRY = "PN_RADD_BFF_AOR_INQUIRY";
    public static final String ERROR_CODE_DOCUMENT_UPLOAD = "PN_RADD_BFF_DOCUMENT_UPLOAD";

    public static final String ERROR_MESSAGE_ACT_INQUIRY = "Errore durante la chiamata al servizio Act Inquiry di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_INQUIRY = "Errore durante la chiamata al servizio AOR Inquiry di pn-radd-fsu";
    public static final String ERROR_MESSAGE_DOCUMENT_UPLOAD = "Errore durante la chiamata al servizio Document Upload di pn-radd-fsu";

}
