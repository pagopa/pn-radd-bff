package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.BaseRecipientDto;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.RecipientType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataVaultConverter {


    public Map<String, String> mapToBaseRecipient(List<BaseRecipientDto> baseRecipientDtoList) {

        return baseRecipientDtoList
                .stream()
                .filter(baseRecipientDtoDto -> baseRecipientDtoDto.getTaxId() != null)
                .collect(Collectors
                       .toMap(BaseRecipientDto::getInternalId, BaseRecipientDto::getTaxId)
               );
    }
}
