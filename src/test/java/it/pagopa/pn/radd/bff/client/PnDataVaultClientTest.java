package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.radd.bff.config.DynamoConfiguration;
import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.ApiClient;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.api.RecipientsApi;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.BaseRecipientDto;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.RecipientType;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "AWS_REGION=eu-south-1",
        "PN_RADD_BFF_DYNAMODB_TABLENAME_PN_DOCUMENT=test"
})
class PnDataVaultClientTest {
    private static PnDataVaultClient pnDataVaultClient;

    @Mock
    private RecipientsApi recipientsApi;

    @Mock
    private ApiClient apiClient;

    @Mock
    DynamoConfiguration dynamoConfiguration;

    @Mock
    private static PnRaddBffConfig pnRaddBffConfig;

    @Mock
    private static ResponseExchangeFilter responseExchangeFilter;

    @Mock
    private  Scheduler scheduler;

    @BeforeAll
    static void init () {
        pnRaddBffConfig = new PnRaddBffConfig();
        pnRaddBffConfig.setClientPnDataVaultBasepath("http://localhost:8080");
        responseExchangeFilter = new ResponseExchangeFilter();
        pnDataVaultClient = new PnDataVaultClient(pnRaddBffConfig, responseExchangeFilter);
    }

    @Test
    void testGetRecipientDenominationByInternalId() {
        BaseRecipientDto baseRecipientDto = new BaseRecipientDto();

        baseRecipientDto.setRecipientType(RecipientType.PF);
        baseRecipientDto.setDenomination("Denomination");
        baseRecipientDto.setTaxId("TaxId");
        baseRecipientDto.setInternalId("InternalId");

        when(recipientsApi.getRecipientDenominationByInternalId(any()))
                .thenReturn(Flux.just(baseRecipientDto));

        StepVerifier.create(pnDataVaultClient.getRecipientDenominationByInternalId(List.of("InternalId")))
                .expectNext(baseRecipientDto);
    }
}

