package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.commons.exceptions.PnExceptionsCodes;

public class PnRaddBffExceptionCodes extends PnExceptionsCodes {

    public static final String ERROR_CODE_ACT_INQUIRY = "PN_RADD_BFF_ACT_INQUIRY";
    public static final String ERROR_CODE_AOR_INQUIRY = "PN_RADD_BFF_AOR_INQUIRY";
    public static final String ERROR_CODE_DOCUMENT_UPLOAD = "PN_RADD_BFF_DOCUMENT_UPLOAD";
    public static final String ERROR_CODE_ACT_TRANSACTION = "PN_RADD_BFF_ACT_TRANSACTION";
    public static final String ERROR_CODE_AOR_TRANSACTION = "PN_RADD_BFF_AOR_TRANSACTION";
    public static final String ERROR_CODE_ACT_NOTIFICATION_INQUIRY = "PN_RADD_BFF_ACT_NOTIFICATION_INQUIRY";
    public static final String ERROR_CODE_AOR_NOTIFICATION_INQUIRY = "PN_RADD_BFF_AOR_NOTIFICATION_INQUIRY";
    public static final String ERROR_CODE_DOCUMENT_NOT_FOUND = "PN_RADD_BFF_DOCUMENT_NOT_FOUND";
    public static final String ERROR_MESSAGE_DOCUMENT_NOT_FOUND = "Errore durante la chiamata al servizio getDocument di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_INQUIRY = "Errore durante la chiamata al servizio Act Inquiry di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_INQUIRY = "Errore durante la chiamata al servizio AOR Inquiry di pn-radd-fsu";
    public static final String ERROR_MESSAGE_DOCUMENT_UPLOAD = "Errore durante la chiamata al servizio Document Upload di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_START_TRANSACTION = "Errore durante la chiamata al servizio Start Act Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_COMPLETE_TRANSACTION = "Errore durante la chiamata al servizio Complete Act Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_ABORT_TRANSACTION = "Errore durante la chiamata al servizio Abort Act Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_START_TRANSACTION = "Errore durante la chiamata al servizio Start Aor Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_COMPLETE_TRANSACTION = "Errore durante la chiamata al servizio Complete Aor Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_ABORT_TRANSACTION = "Errore durante la chiamata al servizio Abort Aor Transaction di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_OPERATION_BY_ID = "Errore durante la chiamata al servizio Act Operation by Id di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_OPERATION_BY_ID = "Errore durante la chiamata al servizio AOR Operation by Id di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_OPERATIONS_BY_IUN = "Errore durante la chiamata al servizio Act Operations by Iun di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_OPERATIONS_BY_IUN = "Errore durante la chiamata al servizio AOR Operations by Iun di pn-radd-fsu";
    public static final String ERROR_MESSAGE_ACT_OPERATIONS_BY_INTERNAL_ID = "Errore durante la chiamata al servizio Act Operations by Internal Id di pn-radd-fsu";
    public static final String ERROR_MESSAGE_AOR_OPERATIONS_BY_INTERNAL_ID = "Errore durante la chiamata al servizio AOR Operations by Internal Id di pn-radd-fsu";

    public static final String ERROR_CODE_PN_DATA_VAULT_RECIPIENT_DENOMINATION = "PN_DATA_VAULT_RECIPIENT_DENOMINATION";
    public static final String ERROR_MESSAGE_PN_DATA_VAULT_RECIPIENT_DENOMINATION = "Errore durante la chiamata al servizio Recipient Denomination di pn-data-vault";


}
