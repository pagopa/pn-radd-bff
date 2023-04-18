package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddBffException;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
public class PnRaddFsuClient extends CommonBaseClient {

    private DocumentUploadApi documentUploadApi;

    private ActDocumentInquiryApi actDocumentInquiryApi;
    private ActTransactionManagementApi actTransactionManagementApi;

    private AorDocumentInquiryApi aorDocumentInquiryApi;
    private AorTransactionManagementApi aorTransactionManagementApi;

    private final PnRaddBffConfig pnRaddBffConfig;
    private final ResponseExchangeFilter responseExchangeFilter;

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig, ResponseExchangeFilter responseExchangeFilter) {
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
        init();
    }

    public void init() {
        ApiClient apiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()
                .filters(f -> f.add(responseExchangeFilter))));
        apiClient.setBasePath(pnRaddBffConfig.getClientPnRaddFsuBasepath());
        this.documentUploadApi = new DocumentUploadApi(apiClient);
        this.actDocumentInquiryApi = new ActDocumentInquiryApi(apiClient);
        this.actTransactionManagementApi = new ActTransactionManagementApi(apiClient);
        this.aorDocumentInquiryApi = new AorDocumentInquiryApi(apiClient);
        this.aorTransactionManagementApi = new AorTransactionManagementApi(apiClient);
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

    public Mono<AbortTransactionResponseDto> abortActTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) throws WebClientResponseException {
        return actTransactionManagementApi
                .abortActTransaction(uid, abortTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<CompleteTransactionResponseDto> completeActTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) throws WebClientResponseException {
        return actTransactionManagementApi
                .completeActTransaction(uid, completeTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<StartTransactionResponseDto> startActTransaction(String uid, ActStartTransactionRequestDto actStartTransactionRequestDto) throws WebClientResponseException {
        return actTransactionManagementApi
                .startActTransaction(uid, actStartTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<AORInquiryResponseDto> aorInquiry(String uid, String recipientTaxId, String recipientType) {
        return aorDocumentInquiryApi.aorInquiry(uid, recipientTaxId, recipientType)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<AbortTransactionResponseDto> abortAorTransaction(String uid, AbortTransactionRequestDto abortTransactionRequestDto) throws WebClientResponseException {
        return aorTransactionManagementApi
                .abortAorTransaction(uid, abortTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<CompleteTransactionResponseDto> completeAorTransaction(String uid, CompleteTransactionRequestDto completeTransactionRequestDto) throws WebClientResponseException {
        return aorTransactionManagementApi
                .completeAorTransaction(uid, completeTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    public Mono<StartTransactionResponseDto> startAorTransaction(String uid, AorStartTransactionRequestDto aorStartTransactionRequestDto) throws WebClientResponseException {
        return aorTransactionManagementApi
                .startAorTransaction(uid, aorStartTransactionRequestDto)
                .doOnError(throwable -> {
                    if (throwable instanceof WebClientResponseException ex) {
                        throw new PnRaddBffException(ex.getMessage(), ex.getStatusCode().value(),
                                ex.getStatusText(), ex.getHeaders(), ex.getResponseBodyAsByteArray(),
                                Charset.defaultCharset(), ex.getClass());
                    }
                });
    }

    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}
