package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponseStatus;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ActInquiryConverter {

    public ActInquiryResponse actInquiryDtoToResponse(ActInquiryResponseDto actInquiryResponseDto) {
        ActInquiryResponse actInquiryResponse = new ActInquiryResponse();

        ActInquiryResponseStatus actInquiryResponseStatus = new ActInquiryResponseStatus();
        actInquiryResponseStatus.setCode(ActInquiryResponseStatus.CodeEnum.fromValue(actInquiryResponseDto.getStatus().getCode().getValue()));
        actInquiryResponseStatus.setMessage(actInquiryResponseDto.getStatus().getMessage());

        actInquiryResponse.setStatus(actInquiryResponseStatus);
        actInquiryResponse.setResult(actInquiryResponseDto.getResult());
        return actInquiryResponse;
    }
}
