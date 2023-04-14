package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
public class PnRaddFsuClient extends CommonBaseClient {

    private DocumentUploadApi documentUploadApi;

    private ActDocumentInquiryApi actDocumentInquiryApi;
    private ActTransactionManagementApi actTransactionManagementApi;

    private AorDocumentInquiryApi aorDocumentInquiryApi;
    private AorTransactionManagementApi aorTransactionManagementApi;

    private NotificationInquiryApi notificationInquiryApi;

    private final PnRaddBffConfig pnRaddBffConfig;
    private final ResponseExchangeFilter responseExchangeFilter;

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig,
                           ResponseExchangeFilter responseExchangeFilter) {
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
    }

    @PostConstruct
    public void init() {
        ApiClient apiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()
                .filters(f -> f.add(responseExchangeFilter))));
        apiClient.setBasePath(pnRaddBffConfig.getClientPnRaddFsuBasepath());
        this.documentUploadApi = new DocumentUploadApi(apiClient);
        this.actDocumentInquiryApi = new ActDocumentInquiryApi(apiClient);
        this.actTransactionManagementApi = new ActTransactionManagementApi(apiClient);
        this.aorDocumentInquiryApi = new AorDocumentInquiryApi(apiClient);
        this.aorTransactionManagementApi = new AorTransactionManagementApi(apiClient);
        this.notificationInquiryApi = new NotificationInquiryApi(apiClient);
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

    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}
