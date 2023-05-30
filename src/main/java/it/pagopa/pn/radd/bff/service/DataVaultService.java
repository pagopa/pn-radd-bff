package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnDataVaultClient;
import it.pagopa.pn.radd.bff.converter.DataVaultConverter;
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
}
