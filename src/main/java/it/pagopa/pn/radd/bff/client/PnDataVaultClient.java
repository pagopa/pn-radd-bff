package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.commons.pnclients.CommonBaseClient;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.exception.PnRaddFsuException;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.ApiClient;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.api.RecipientsApi;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.dto.BaseRecipientDtoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import java.util.List;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
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

    public Flux<BaseRecipientDtoDto> getRecipientDenominationByInternalId(List<String> internalIds) {
        return recipientsApi.getRecipientDenominationByInternalId(internalIds)
                .onErrorMap(WebClientResponseException.class, e -> wrap(ERROR_CODE_PN_DATA_VAULT_RECIPIENT_DENOMINATION, ERROR_MESSAGE_PN_DATA_VAULT_RECIPIENT_DENOMINATION, e));
    }

    private PnRaddFsuException wrap(String code, String message, WebClientResponseException e) {
        return new PnRaddFsuException(e.getMessage(), code, message, e.getStatusCode().value(), e.getStatusText(), e);
    }
}


