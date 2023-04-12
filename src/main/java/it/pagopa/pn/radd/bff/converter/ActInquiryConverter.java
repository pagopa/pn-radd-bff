package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponseStatus;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ActInquiryConverter {

    public ActInquiryResponse actInquiryDtoToResponse(ActInquiryResponseDto dto) {
        ActInquiryResponseStatus responseStatus = new ActInquiryResponseStatus();
        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(ActInquiryResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        ActInquiryResponse response = new ActInquiryResponse();
        response.setStatus(responseStatus);
        response.setResult(dto.getResult());
        return response;
    }
}
