package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnDataVaultClient;
import it.pagopa.pn.radd.bff.converter.DataVaultConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {DataVaultService.class})
@ExtendWith(SpringExtension.class)
class DataVaultServiceTest {
    @MockBean
    private DataVaultConverter dataVaultConverter;

    @Autowired
    private DataVaultService dataVaultService;

    @MockBean
    private PnDataVaultClient pnDataVaultClient;

    /**
     * Method under test: {@link DataVaultService#getRecipientDenominationByInternalId(Map)}
     */
    @Test
    void testGetRecipientDenominationByInternalId() {
        when(pnDataVaultClient.getRecipientDenominationByInternalId(Mockito.<List<String>>any()))
                .thenReturn(DirectProcessor.create());
        dataVaultService.getRecipientDenominationByInternalId(new HashMap<>());
        verify(pnDataVaultClient).getRecipientDenominationByInternalId(Mockito.<List<String>>any());
    }

	@Test
	void testGetAnonymousByTaxId () {
		when(pnDataVaultClient.getAnonymousByTaxId(any(), anyString()))
				.thenReturn(Mono.empty());
		dataVaultService.getAnonymousByTaxId(any(), anyString());
		verify(pnDataVaultClient).getAnonymousByTaxId(any(), anyString());
	}
}

