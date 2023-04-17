package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddBffException;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.ProxyProvider;

import java.nio.charset.Charset;
import java.time.Duration;

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

    public PnRaddFsuClient(PnRaddBffConfig pnRaddBffConfig, ResponseExchangeFilter responseExchangeFilter) {
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
        init();
    }

    private void init() {
        String baseUrl = pnRaddBffConfig.getClientPnRaddFsuBasepath();
        ConnectionProvider connectionProvider = ConnectionProvider.builder("fixed")
                .maxConnections(100)
                .pendingAcquireMaxCount(100)
                .pendingAcquireTimeout(Duration.ofMillis(100))
                .maxIdleTime(Duration.ofMillis(100))
                .build();
        HttpClient httpClient = HttpClient.create(connectionProvider)
                .proxy(spec -> spec.type(ProxyProvider.Proxy.SOCKS5)
                        .host("localhost") .port(5001)
                        .connectTimeoutMillis(20_000));

        WebClient.Builder webClientBuilder = WebClient.builder()
                .baseUrl(baseUrl)
                .codecs(c -> c.defaultCodecs().enableLoggingRequestDetails(true))
                .filters(exchangeFilterFunctions -> exchangeFilterFunctions.add(responseExchangeFilter))
                .clientConnector(new ReactorClientHttpConnector(httpClient));

        ApiClient apiClient = new ApiClient(webClientBuilder
                .filters(f -> f.add(responseExchangeFilter)).build());

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

    public Mono<DocumentUploadResponseDto> documentUpload(String uid, DocumentUploadRequestDto documentUploadRequestDto) {
        return documentUploadApi.documentUpload(uid, documentUploadRequestDto);
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
}
