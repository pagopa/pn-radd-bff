package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ResponseStatus;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AorInquiryConverter {

    public AORInquiryResponse aorInquiryDtoToResponse(AORInquiryResponseDto dto) {
        ResponseStatus responseStatus = new ResponseStatus();
        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(ResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        AORInquiryResponse response = new AORInquiryResponse();
        response.setStatus(responseStatus);
        response.setResult(dto.getResult());
        return response;
    }
}
