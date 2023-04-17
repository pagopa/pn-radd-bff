package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ResponseStatusDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ResponseStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {AorInquiryConverter.class})
@ExtendWith(SpringExtension.class)
class AorInquiryConverterTest {
    @Autowired
    private AorInquiryConverter aorInquiryConverter;


    /**
     * Method under test: {@link AorInquiryConverter#aorInquiryDtoToResponse(AORInquiryResponseDto)}
     */
    @Test
    void testAorInquiryDtoToResponse3() {
        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.code(ResponseStatusDto.CodeEnum.NUMBER_0);

        AORInquiryResponseDto aorInquiryResponseDto = new AORInquiryResponseDto();
        aorInquiryResponseDto.status(responseStatusDto);
        AORInquiryResponse actualAorInquiryDtoToResponseResult = aorInquiryConverter
                .aorInquiryDtoToResponse(aorInquiryResponseDto);
        assertNull(actualAorInquiryDtoToResponseResult.getResult());
        ResponseStatus status = actualAorInquiryDtoToResponseResult.getStatus();
        assertEquals(ResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }

    /**
     * Method under test: {@link AorInquiryConverter#aorInquiryDtoToResponse(AORInquiryResponseDto)}
     */
    @Test
    void testAorInquiryDtoToResponse4() {
        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.setCode(ResponseStatusDto.CodeEnum.NUMBER_0);

        AORInquiryResponseDto aorInquiryResponseDto = new AORInquiryResponseDto();
        aorInquiryResponseDto.status(responseStatusDto);
        AORInquiryResponse actualAorInquiryDtoToResponseResult = aorInquiryConverter
                .aorInquiryDtoToResponse(aorInquiryResponseDto);
        assertNull(actualAorInquiryDtoToResponseResult.getResult());
        ResponseStatus status = actualAorInquiryDtoToResponseResult.getStatus();
        assertEquals(ResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }
}

