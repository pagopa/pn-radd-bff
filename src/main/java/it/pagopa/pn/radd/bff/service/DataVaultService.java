package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnDataVaultClient;
import it.pagopa.pn.radd.bff.converter.DataVaultConverter;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.RecipientType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataVaultService {

    private final PnDataVaultClient pnDataVaultClient;

    private final DataVaultConverter dataVaultConverter;

    public Mono<Map<String, String>> getRecipientDenominationByInternalId(Map<String, String> strings) {
        return pnDataVaultClient.getRecipientDenominationByInternalId(strings.keySet().stream().toList())
                .collectList()
                .map(dataVaultConverter::mapToBaseRecipient);
    }
    public Mono<String> getAnonymizedTaxId(RecipientType recipientType,String taxId) {
        return pnDataVaultClient.getAnonymousByTaxId(recipientType,taxId)
                .map(dataVaultConverter::mapToAnonymizedTaxId);
    }
}
