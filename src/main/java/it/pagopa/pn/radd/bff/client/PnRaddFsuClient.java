package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

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
        return actDocumentInquiryApi.actInquiry(uid, recipientTaxId, recipientType, qrCode);
    }

    public Mono<AORInquiryResponseDto> aorInquiry(String uid, String recipientTaxId, String recipientType) {
        return aorDocumentInquiryApi.aorInquiry(uid, recipientTaxId, recipientType);
    }

    public Mono<DocumentUploadResponseDto> documentUpload(String uid, DocumentUploadRequestDto documentUploadRequestDto) {
        return documentUploadApi.documentUpload(uid, documentUploadRequestDto);
    }
}
