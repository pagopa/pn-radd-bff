package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd_bff.microservice.client.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DocumentUploadConverter {


    public DocumentUploadRequestDto documentUploadRequestToDto(DocumentUploadRequest documentUploadRequest) {
        DocumentUploadRequestDto documentUploadRequestDto = new DocumentUploadRequestDto();

        documentUploadRequestDto.setBundleId(documentUploadRequest.getBundleId());
        documentUploadRequestDto.setChecksum(documentUploadRequest.getChecksum());
        documentUploadRequestDto.setContentType(documentUploadRequest.getContentType());

        return documentUploadRequestDto;
    }

    public DocumentUploadResponse documentUploadDtoToResponse(DocumentUploadResponseDto documentUploadResponseDto) {
        DocumentUploadResponse documentUploadResponse = new DocumentUploadResponse();

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.CodeEnum.fromValue(documentUploadResponseDto.getStatus().getCode().getValue()));
        responseStatus.setMessage(documentUploadResponseDto.getStatus().getMessage());

        documentUploadResponse.setStatus(responseStatus);
        documentUploadResponse.setSecret(documentUploadResponseDto.getSecret());
        documentUploadResponse.setUrl(documentUploadResponseDto.getUrl());
        documentUploadResponseDto.setFileKey(documentUploadResponseDto.getFileKey());
        return documentUploadResponse;
    }
}
