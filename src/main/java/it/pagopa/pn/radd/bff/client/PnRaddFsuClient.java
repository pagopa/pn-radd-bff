package it.pagopa.pn.radd.bff.client;


import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class PnRaddFsuClient extends CommonBaseClient {

    private ActDocumentInquiryApi actDocumentInquiryApi;
    private ActTransactionManagementApi actTransactionManagementApi;

    private AorDocumentInquiryApi aorDocumentInquiryApi;

    private AorTransactionManagementApi aorTransactionManagementApi;

    private DocumentUploadApi documentUploadApi;

    private NotificationInquiryApi notificationInquiryApi;

    private final PnRaddBffConfig pnRaddBffConfig;

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig) {
        this.pnRaddBffConfig = pnRaddBffConfig;
    }

    @PostConstruct
    public void init(){
        ApiClient newApiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()));
        newApiClient.setBasePath(pnRaddBffConfig.getClientPnRaddFsuBasepath());
        this.actDocumentInquiryApi = new ActDocumentInquiryApi(newApiClient);
        this.actTransactionManagementApi = new ActTransactionManagementApi(newApiClient);
        this.aorDocumentInquiryApi = new AorDocumentInquiryApi(newApiClient);
        this.aorTransactionManagementApi = new AorTransactionManagementApi(newApiClient);
        this.documentUploadApi = new DocumentUploadApi(newApiClient);
        this.notificationInquiryApi = new NotificationInquiryApi(newApiClient);

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
