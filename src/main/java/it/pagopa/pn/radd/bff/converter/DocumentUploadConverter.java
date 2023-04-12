package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DocumentUploadConverter {

    public DocumentUploadRequestDto documentUploadRequestToDto(DocumentUploadRequest request) {
        DocumentUploadRequestDto dto = new DocumentUploadRequestDto();

        dto.setBundleId(request.getBundleId());
        dto.setChecksum(request.getChecksum());
        dto.setContentType(request.getContentType());

        return dto;
    }

    public DocumentUploadResponse documentUploadDtoToResponse(DocumentUploadResponseDto dto) {
        ResponseStatus responseStatus = new ResponseStatus();
        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(ResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        DocumentUploadResponse response = new DocumentUploadResponse();
        response.setStatus(responseStatus);
        response.setSecret(dto.getSecret());
        response.setUrl(dto.getUrl());
        response.setFileKey(dto.getFileKey());
        return response;
    }
}
