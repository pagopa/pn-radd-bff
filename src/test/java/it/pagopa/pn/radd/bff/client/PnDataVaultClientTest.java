package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.api.RecipientsApi;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.dto.BaseRecipientDtoDto;
import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.dto.RecipientTypeDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PnDataVaultClientTest {

    private static PnDataVaultClient pnDataVaultClient;

    @Mock
    private  RecipientsApi recipientsApi;

    @Mock
    private static PnRaddBffConfig pnRaddBffConfig;

    @Mock
    private static ResponseExchangeFilter responseExchangeFilter;


    @BeforeAll
    static void init () {
        pnRaddBffConfig = new PnRaddBffConfig();
        pnRaddBffConfig.setClientPnDataVaultBasepath("http://localhost:8080");
        responseExchangeFilter = new ResponseExchangeFilter();
        pnDataVaultClient = new PnDataVaultClient(pnRaddBffConfig, responseExchangeFilter);
    }


    @Test
    void testGetRecipientDenominationByInternalId() {

        BaseRecipientDtoDto baseRecipientDtoDto = new BaseRecipientDtoDto();

        baseRecipientDtoDto.setRecipientType(RecipientTypeDto.PF);
        baseRecipientDtoDto.setDenomination("Denomination");
        baseRecipientDtoDto.setTaxId("TaxId");
        baseRecipientDtoDto.setInternalId("InternalId");

        when(recipientsApi.getRecipientDenominationByInternalId(any()))
                .thenReturn(Flux.just(baseRecipientDtoDto));

        StepVerifier.create(pnDataVaultClient.getRecipientDenominationByInternalId(List.of("InternalId")))
                .expectNext(baseRecipientDtoDto);
    }
}

