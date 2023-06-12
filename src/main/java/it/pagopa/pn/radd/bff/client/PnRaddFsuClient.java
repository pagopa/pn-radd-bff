package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import lombok.CustomLog;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
@CustomLog
public class PnRaddFsuClient extends CommonBaseClient {

    private final DocumentUploadApi documentUploadApi;
    private final ActDocumentInquiryApi actDocumentInquiryApi;
    private final ActTransactionManagementApi actTransactionManagementApi;
    private final AorDocumentInquiryApi aorDocumentInquiryApi;
    private final AorTransactionManagementApi aorTransactionManagementApi;
    private final NotificationInquiryApi notificationInquiryApi;

    private final PnRaddBffConfig pnRaddBffConfig;
    private final ResponseExchangeFilter responseExchangeFilter;

    private static final String PN_RADD_FSU = "PN-RADD-FSU";

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig, ResponseExchangeFilter responseExchangeFilter) {
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
        ApiClient apiClient = init();
        this.documentUploadApi = new DocumentUploadApi(apiClient);
        this.actDocumentInquiryApi = new ActDocumentInquiryApi(apiClient);
        this.actTransactionManagementApi = new ActTransactionManagementApi(apiClient);
        this.aorDocumentInquiryApi = new AorDocumentInquiryApi(apiClient);
        this.aorTransactionManagementApi = new AorTransactionManagementApi(apiClient);
        this.notificationInquiryApi = new NotificationInquiryApi(apiClient);
    }

    private ApiClient init() {
        ApiClient apiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()
                .filters(f -> f.add(responseExchangeFilter))));
        apiClient.setBasePath(pnRaddBffConfig.getClientPnRaddFsuBasepath());
        return apiClient;
    }

    public Mono<ActInquiryResponseDto> actInquiry(String uid, String recipientTaxId, String recipientType, String qrCode) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Act Inquiry");
        return actDocumentInquiryApi.actInquiry(uid, recipientTaxId, recipientType, qrCode)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_INQUIRY, ERROR_MESSAGE_ACT_INQUIRY, e));
    }

    public Mono<AORInquiryResponseDto> aorInquiry(String uid, String recipientTaxId, String recipientType) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Aor Inquiry");
        return aorDocumentInquiryApi.aorInquiry(uid, recipientTaxId, recipientType)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_INQUIRY, ERROR_MESSAGE_AOR_INQUIRY, e));
    }

    public Mono<DocumentUploadResponseDto> documentUpload(String uid, DocumentUploadRequestDto documentUploadRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Document Upload");
        return documentUploadApi.documentUpload(uid, documentUploadRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_DOCUMENT_UPLOAD, ERROR_MESSAGE_DOCUMENT_UPLOAD, e));
    }

    public Mono<StartTransactionResponseDto> startActTransaction(String uid, ActStartTransactionRequestDto actStartTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Act Transaction");
        return actTransactionManagementApi.startActTransaction(uid, actStartTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_START_TRANSACTION, e));
    }

    public Mono<AbortTransactionResponseDto> abortActTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Abort Act Transaction");
        return actTransactionManagementApi.abortActTransaction(uid, abortTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_ABORT_TRANSACTION, e));
    }

    public Mono<CompleteTransactionResponseDto> completeActTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Complete Act Transaction");
        return actTransactionManagementApi.completeActTransaction(uid, completeTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_COMPLETE_TRANSACTION, e));
    }

    public Mono<StartTransactionResponseDto> startAorTransaction(String uid, AorStartTransactionRequestDto aorStartTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Aor Transaction");
        return aorTransactionManagementApi.startAorTransaction(uid, aorStartTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_START_TRANSACTION, e));
    }

    public Mono<AbortTransactionResponseDto> abortAorTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Abort Aor Transaction");
        return aorTransactionManagementApi.abortAorTransaction(uid, abortTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_ABORT_TRANSACTION, e));
    }

    public Mono<CompleteTransactionResponseDto> completeAorTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Complete Aor Transaction");
        return aorTransactionManagementApi.completeAorTransaction(uid, completeTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_COMPLETE_TRANSACTION, e));
    }

    public  Mono<OperationsActDetailsResponseDto> getActPracticesByInternalId(String taxId, FilterRequestDto filterRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Act Practices By Internal Id");
        return notificationInquiryApi.getActPracticesByInternalId(taxId, filterRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATIONS_BY_INTERNAL_ID, e));
    }

    public  Mono<OperationsResponseDto> getActPracticesByIun(String iun) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Act Practices By Iun");
        return notificationInquiryApi.getActPracticesByIun(iun)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATIONS_BY_IUN, e));
    }

    public  Mono<OperationActResponseDto> getActTransactionByOperationId(String operationId) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Act Transaction By Operation Id");
        return notificationInquiryApi.getActTransactionByOperationId(operationId)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATION_BY_ID, e));
    }

    public  Mono<OperationsAorDetailsResponseDto> getAorPracticesByInternalId(String taxId, FilterRequestDto filterRequestDto) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Aor Practices By Internal Id");
        return notificationInquiryApi.getAorPracticesByInternalId(taxId, filterRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATIONS_BY_INTERNAL_ID, e));
    }

    public  Mono<OperationsResponseDto> getAorPracticesByIun(String iun) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Aor Practices By Iun");
        return notificationInquiryApi
                .getAorPracticesByIun(iun)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATIONS_BY_IUN, e));
    }

    public  Mono<OperationAorResponseDto> getAorTransactionByOperationId(String operationId) {
        log.logInvokingExternalService(PN_RADD_FSU, "Calling Get Aor Transaction By Operation Id");
        return notificationInquiryApi.getAorTransactionByOperationId(operationId)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATION_BY_ID, e));
    }


    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}
