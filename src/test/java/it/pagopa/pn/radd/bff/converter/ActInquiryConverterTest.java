package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseStatusDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponseStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {ActInquiryConverter.class})
@ExtendWith(SpringExtension.class)
class ActInquiryConverterTest {
    @Autowired
    private ActInquiryConverter actInquiryConverter;

    /**
     * Method under test: {@link ActInquiryConverter#actInquiryDtoToResponse(ActInquiryResponseDto)}
     */
    @Test
    void testActInquiryDtoToResponse3() {
        ActInquiryResponseStatusDto actInquiryResponseStatusDto = new ActInquiryResponseStatusDto();
        actInquiryResponseStatusDto.code(ActInquiryResponseStatusDto.CodeEnum.NUMBER_0);

        ActInquiryResponseDto actInquiryResponseDto = new ActInquiryResponseDto();
        actInquiryResponseDto.status(actInquiryResponseStatusDto);
        ActInquiryResponse actualActInquiryDtoToResponseResult = actInquiryConverter
                .actInquiryDtoToResponse(actInquiryResponseDto);
        assertNull(actualActInquiryDtoToResponseResult.getResult());
        ActInquiryResponseStatus status = actualActInquiryDtoToResponseResult.getStatus();
        assertEquals(ActInquiryResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }

    /**
     * Method under test: {@link ActInquiryConverter#actInquiryDtoToResponse(ActInquiryResponseDto)}
     */
    @Test
    void testActInquiryDtoToResponse4() {
        ActInquiryResponseStatusDto actInquiryResponseStatusDto = new ActInquiryResponseStatusDto();
        actInquiryResponseStatusDto.setCode(ActInquiryResponseStatusDto.CodeEnum.NUMBER_0);

        ActInquiryResponseDto actInquiryResponseDto = new ActInquiryResponseDto();
        actInquiryResponseDto.status(actInquiryResponseStatusDto);
        ActInquiryResponse actualActInquiryDtoToResponseResult = actInquiryConverter
                .actInquiryDtoToResponse(actInquiryResponseDto);
        assertNull(actualActInquiryDtoToResponseResult.getResult());
        ActInquiryResponseStatus status = actualActInquiryDtoToResponseResult.getStatus();
        assertEquals(ActInquiryResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }
}

