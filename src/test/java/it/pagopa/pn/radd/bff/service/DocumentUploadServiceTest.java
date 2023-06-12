package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.DocumentUploadConverter;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.DocumentUploadResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ResponseStatus;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ResponseStatusDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith (SpringExtension.class)
@TestPropertySource(properties = {
        "AWS_REGION=eu-south-1",
        "PN_RADD_BFF_DYNAMODB_TABLENAME_PN_DOCUMENT=test"
})
class DocumentUploadServiceTest {
    @MockBean
    private DocumentUploadConverter documentUploadConverter;

    @Autowired
    private DocumentUploadService documentUploadService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @Test
    void testDocumentUpload () {
        DocumentUploadResponse documentUploadResponse = new DocumentUploadResponse();

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.CodeEnum.NUMBER_0);
        responseStatus.setMessage("message");


        documentUploadResponse.setUrl("url");
        documentUploadResponse.setSecret("secret");
        documentUploadResponse.setStatus(responseStatus);
        documentUploadResponse.setFileKey("fileKey");

        DocumentUploadRequestDto documentUploadRequestDto = new DocumentUploadRequestDto();

        documentUploadRequestDto.setBundleId("bundleId");
        documentUploadRequestDto.setContentType("contentType");
        documentUploadRequestDto.setChecksum("checksum");

        DocumentUploadResponseDto documentUploadResponseDto = new DocumentUploadResponseDto();

        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.setCode(ResponseStatusDto.CodeEnum.NUMBER_0);
        responseStatusDto.setMessage("message");

        documentUploadResponseDto.setUrl("url");
        documentUploadResponseDto.setSecret("secret");
        documentUploadResponseDto.setStatus(responseStatusDto);
        documentUploadResponseDto.setFileKey("fileKey");

        DocumentUploadRequest documentUploadRequest = new DocumentUploadRequest();

        documentUploadRequest.setBundleId("bundleId");
        documentUploadRequest.setContentType("contentType");
        documentUploadRequest.setChecksum("checksum");

        when(documentUploadConverter.documentUploadRequestToDto(any()))
                .thenReturn(documentUploadRequestDto);

        when(pnRaddFsuClient.documentUpload(any(), any()))
                .thenReturn(Mono.just(documentUploadResponseDto));

        when(documentUploadConverter.documentUploadDtoToResponse(any()))
                .thenReturn(documentUploadResponse);

        StepVerifier.create(documentUploadService.documentUpload("uid", Mono.just(documentUploadRequest)))
                .expectNext(documentUploadResponse);
    }
}

