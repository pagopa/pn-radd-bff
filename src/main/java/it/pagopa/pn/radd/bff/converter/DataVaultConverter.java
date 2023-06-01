package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.data.vault.v1.dto.BaseRecipientDtoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataVaultConverter {


    public Map<String, String> mapToBaseRecipient(List<BaseRecipientDtoDto> baseRecipientDtoList) {

        return baseRecipientDtoList
                .stream()
                .filter(baseRecipientDtoDto -> baseRecipientDtoDto.getTaxId() != null)
                .collect(Collectors
                       .toMap(BaseRecipientDtoDto::getInternalId, BaseRecipientDtoDto::getTaxId)
               );
    }
}
