package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.log.PnLogger;
import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.ApiClient;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.api.RecipientsApi;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.BaseRecipientDto;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;

import lombok.CustomLog;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import java.util.List;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
@CustomLog
public class PnDataVaultClient extends CommonBaseClient {

    private final RecipientsApi recipientsApi;
    private final PnRaddBffConfig pnRaddBffConfig;
    private final ResponseExchangeFilter responseExchangeFilter;


    public PnDataVaultClient(PnRaddBffConfig pnRaddBffConfig, ResponseExchangeFilter responseExchangeFilter) {
        this.pnRaddBffConfig = pnRaddBffConfig;
        this.responseExchangeFilter = responseExchangeFilter;
        ApiClient apiClient = init();
        this.recipientsApi = new RecipientsApi(apiClient);

    }
    private ApiClient init() {
        ApiClient apiClient = new ApiClient(super.initWebClient(ApiClient.buildWebClientBuilder()
                .filters(f -> f.add(responseExchangeFilter))));
        apiClient.setBasePath(pnRaddBffConfig.getClientPnDataVaultBasepath());
        return apiClient;
    }

    public Flux<BaseRecipientDto> getRecipientDenominationByInternalId(List<String> internalIds) {
        log.logInvokingExternalService(PnLogger.EXTERNAL_SERVICES.PN_DATA_VAULT, "Getting CF deanonymization by internalId from pn-data-vault");
        return recipientsApi.getRecipientDenominationByInternalId(internalIds)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_PN_DATA_VAULT_RECIPIENT_DENOMINATION, ERROR_MESSAGE_PN_DATA_VAULT_RECIPIENT_DENOMINATION, e));
    }

    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}


