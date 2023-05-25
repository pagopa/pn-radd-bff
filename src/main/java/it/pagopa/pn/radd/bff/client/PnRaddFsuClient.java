package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
public class PnRaddFsuClient extends CommonBaseClient {

    private final DocumentUploadApi documentUploadApi;
    private final ActDocumentInquiryApi actDocumentInquiryApi;
    private final ActTransactionManagementApi actTransactionManagementApi;
    private final AorDocumentInquiryApi aorDocumentInquiryApi;
    private final AorTransactionManagementApi aorTransactionManagementApi;
    private final NotificationInquiryApi notificationInquiryApi;

    private final PnRaddBffConfig pnRaddBffConfig;
    private final ResponseExchangeFilter responseExchangeFilter;

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig, ResponseExchangeFilter responseExchangeFilter) {
        this.notificationInquiryApi = new NotificationInquiryApi();
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
        ApiClient apiClient = init();
        this.documentUploadApi = new DocumentUploadApi(apiClient);
        this.actDocumentInquiryApi = new ActDocumentInquiryApi(apiClient);
        this.actTransactionManagementApi = new ActTransactionManagementApi(apiClient);
        this.aorDocumentInquiryApi = new AorDocumentInquiryApi(apiClient);
        this.aorTransactionManagementApi = new AorTransactionManagementApi(apiClient);
    }

    private ApiClient init() {
        ApiClient apiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()
                .filters(f -> f.add(responseExchangeFilter))));
        apiClient.setBasePath(pnRaddBffConfig.getClientPnRaddFsuBasepath());
        return apiClient;
    }

    public Mono<ActInquiryResponseDto> actInquiry(String uid, String recipientTaxId, String recipientType, String qrCode) {
        return actDocumentInquiryApi.actInquiry(uid, recipientTaxId, recipientType, qrCode)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_INQUIRY, ERROR_MESSAGE_ACT_INQUIRY, e));
    }

    public Mono<AORInquiryResponseDto> aorInquiry(String uid, String recipientTaxId, String recipientType) {
        return aorDocumentInquiryApi.aorInquiry(uid, recipientTaxId, recipientType)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_INQUIRY, ERROR_MESSAGE_AOR_INQUIRY, e));
    }

    public Mono<DocumentUploadResponseDto> documentUpload(String uid, DocumentUploadRequestDto documentUploadRequestDto) {
        return documentUploadApi.documentUpload(uid, documentUploadRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_DOCUMENT_UPLOAD, ERROR_MESSAGE_DOCUMENT_UPLOAD, e));
    }

    public Mono<StartTransactionResponseDto> startActTransaction(String uid, ActStartTransactionRequestDto actStartTransactionRequestDto) {
        return actTransactionManagementApi.startActTransaction(uid, actStartTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_START_TRANSACTION, e));
    }

    public Mono<AbortTransactionResponseDto> abortActTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) {
        return actTransactionManagementApi.abortActTransaction(uid, abortTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_ABORT_TRANSACTION, e));
    }

    public Mono<CompleteTransactionResponseDto> completeActTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) {
        return actTransactionManagementApi.completeActTransaction(uid, completeTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_TRANSACTION, ERROR_MESSAGE_ACT_COMPLETE_TRANSACTION, e));
    }

    public Mono<StartTransactionResponseDto> startAorTransaction(String uid, AorStartTransactionRequestDto aorStartTransactionRequestDto) {
        return aorTransactionManagementApi.startAorTransaction(uid, aorStartTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_START_TRANSACTION, e));
    }

    public Mono<AbortTransactionResponseDto> abortAorTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) {
        return aorTransactionManagementApi.abortAorTransaction(uid, abortTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_ABORT_TRANSACTION, e));
    }

    public Mono<CompleteTransactionResponseDto> completeAorTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) {
        return aorTransactionManagementApi.completeAorTransaction(uid, completeTransactionRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_TRANSACTION, ERROR_MESSAGE_AOR_COMPLETE_TRANSACTION, e));
    }

    public  Mono<OperationsActDetailsResponseDto> getActPracticesByInternalId(String taxId, FilterRequestDto filterRequestDto) {
        return notificationInquiryApi.getActPracticesByInternalId(taxId, filterRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATIONS_BY_INTERNAL_ID, e));
    }

    public  Mono<OperationsResponseDto> getActPracticesByIun(String iun) {
        return notificationInquiryApi.getActPracticesByIun(iun)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATIONS_BY_IUN, e));
    }

    public  Mono<OperationActResponseDto> getActTransactionByOperationId(String operationId) {
        return notificationInquiryApi.getActTransactionByOperationId(operationId)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_ACT_NOTIFICATION_INQUIRY, ERROR_MESSAGE_ACT_OPERATION_BY_ID, e));
    }

    public  Mono<OperationsAorDetailsResponseDto> getAorPracticesByInternalId(String taxId, FilterRequestDto filterRequestDto) {
        return notificationInquiryApi.getAorPracticesByInternalId(taxId, filterRequestDto)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATIONS_BY_INTERNAL_ID, e));
    }

    public  Mono<OperationsResponseDto> getAorPracticesByIun(String iun) {
        return notificationInquiryApi
                .getAorPracticesByIun(iun)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATIONS_BY_IUN, e));
    }

    public  Mono<OperationAorResponseDto> getAorTransactionByOperationId(String operationId) {
        return notificationInquiryApi.getAorTransactionByOperationId(operationId)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_AOR_NOTIFICATION_INQUIRY, ERROR_MESSAGE_AOR_OPERATION_BY_ID, e));
    }


    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}
