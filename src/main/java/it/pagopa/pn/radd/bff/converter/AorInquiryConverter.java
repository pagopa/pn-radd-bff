package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ResponseStatus;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AorInquiryConverter {

    public AORInquiryResponse aorInquiryDtoToResponse(AORInquiryResponseDto aorInquiryResponseDto) {
        AORInquiryResponse aorInquiryResponse = new AORInquiryResponse();

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.CodeEnum.fromValue(aorInquiryResponseDto.getStatus().getCode().getValue()));
        responseStatus.setMessage(aorInquiryResponseDto.getStatus().getMessage());

        aorInquiryResponse.setStatus(responseStatus);
        aorInquiryResponse.setResult(aorInquiryResponseDto.getResult());
        return aorInquiryResponse;
    }
}
