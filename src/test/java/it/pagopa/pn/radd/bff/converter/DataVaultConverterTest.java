package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.BaseRecipientDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DataVaultConverter.class})
@ExtendWith(SpringExtension.class)
class DataVaultConverterTest {
    @Autowired
    private DataVaultConverter dataVaultConverter;

    /**
     * Method under test: {@link DataVaultConverter#mapToBaseRecipient(List)}
     */
    @Test
    void testMapToBaseRecipient() {
        assertTrue(dataVaultConverter.mapToBaseRecipient(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link DataVaultConverter#mapToBaseRecipient(List)}
     */
    @Test
    void testMapToBaseRecipient2() {
        ArrayList<BaseRecipientDto> baseRecipientDtoList = new ArrayList<>();
        baseRecipientDtoList.add(new BaseRecipientDto());
        assertTrue(dataVaultConverter.mapToBaseRecipient(baseRecipientDtoList).isEmpty());
    }

    /**
     * Method under test: {@link DataVaultConverter#mapToBaseRecipient(List)}
     */
    @Test
    void testMapToBaseRecipient3() {
        ArrayList<BaseRecipientDto> baseRecipientDtoList = new ArrayList<>();
        baseRecipientDtoList.add(new BaseRecipientDto());
        baseRecipientDtoList.add(new BaseRecipientDto());
        assertTrue(dataVaultConverter.mapToBaseRecipient(baseRecipientDtoList).isEmpty());
    }


    /**
     * Method under test: {@link DataVaultConverter#mapToBaseRecipient(List)}
     */
    @Test
    void testMapToBaseRecipient5() {
        BaseRecipientDto baseRecipientDtoDto = mock(BaseRecipientDto.class);
        when(baseRecipientDtoDto.getInternalId()).thenReturn("42");
        when(baseRecipientDtoDto.getTaxId()).thenReturn("42");

        ArrayList<BaseRecipientDto> baseRecipientDtoList = new ArrayList<>();
        baseRecipientDtoList.add(baseRecipientDtoDto);
        Map<String, String> actualMapToBaseRecipientResult = dataVaultConverter.mapToBaseRecipient(baseRecipientDtoList);
        assertEquals(1, actualMapToBaseRecipientResult.size());
        assertEquals("42", actualMapToBaseRecipientResult.get("42"));
        verify(baseRecipientDtoDto).getInternalId();
        verify(baseRecipientDtoDto, atLeast(1)).getTaxId();
    }

}

