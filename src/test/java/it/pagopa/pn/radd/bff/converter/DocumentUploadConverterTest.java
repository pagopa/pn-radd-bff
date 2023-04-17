package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.DocumentUploadResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ResponseStatusDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ResponseStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DocumentUploadConverter.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadConverterTest {
    @Autowired
    private DocumentUploadConverter documentUploadConverter;

    /**
     * Method under test: {@link DocumentUploadConverter#documentUploadRequestToDto(DocumentUploadRequest)}
     */
    @Test
    void testDocumentUploadRequestToDto() {
        DocumentUploadRequestDto actualDocumentUploadRequestToDtoResult = documentUploadConverter
                .documentUploadRequestToDto(new DocumentUploadRequest());
        assertNull(actualDocumentUploadRequestToDtoResult.getBundleId());
        assertNull(actualDocumentUploadRequestToDtoResult.getContentType());
        assertNull(actualDocumentUploadRequestToDtoResult.getChecksum());
    }


    /**
     * Method under test: {@link DocumentUploadConverter#documentUploadRequestToDto(DocumentUploadRequest)}
     */
    @Test
    void testDocumentUploadRequestToDto3() {
        DocumentUploadRequest documentUploadRequest = mock(DocumentUploadRequest.class);
        when(documentUploadRequest.getBundleId()).thenReturn("42");
        when(documentUploadRequest.getChecksum()).thenReturn("Checksum");
        when(documentUploadRequest.getContentType()).thenReturn("text/plain");
        DocumentUploadRequestDto actualDocumentUploadRequestToDtoResult = documentUploadConverter
                .documentUploadRequestToDto(documentUploadRequest);
        assertEquals("42", actualDocumentUploadRequestToDtoResult.getBundleId());
        assertEquals("text/plain", actualDocumentUploadRequestToDtoResult.getContentType());
        assertEquals("Checksum", actualDocumentUploadRequestToDtoResult.getChecksum());
        verify(documentUploadRequest).getBundleId();
        verify(documentUploadRequest).getChecksum();
        verify(documentUploadRequest).getContentType();
    }

    /**
     * Method under test: {@link DocumentUploadConverter#documentUploadDtoToResponse(DocumentUploadResponseDto)}
     */
    @Test
    void testDocumentUploadDtoToResponse3() {
        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.code(ResponseStatusDto.CodeEnum.NUMBER_0);

        DocumentUploadResponseDto documentUploadResponseDto = new DocumentUploadResponseDto();
        documentUploadResponseDto.status(responseStatusDto);
        DocumentUploadResponse actualDocumentUploadDtoToResponseResult = documentUploadConverter
                .documentUploadDtoToResponse(documentUploadResponseDto);
        assertNull(actualDocumentUploadDtoToResponseResult.getUrl());
        assertNull(actualDocumentUploadDtoToResponseResult.getSecret());
        ResponseStatus status = actualDocumentUploadDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(ResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(documentUploadResponseDto.getFileKey());
    }

    /**
     * Method under test: {@link DocumentUploadConverter#documentUploadDtoToResponse(DocumentUploadResponseDto)}
     */
    @Test
    void testDocumentUploadDtoToResponse4() {
        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.setCode(ResponseStatusDto.CodeEnum.NUMBER_0);

        DocumentUploadResponseDto documentUploadResponseDto = new DocumentUploadResponseDto();
        documentUploadResponseDto.status(responseStatusDto);
        DocumentUploadResponse actualDocumentUploadDtoToResponseResult = documentUploadConverter
                .documentUploadDtoToResponse(documentUploadResponseDto);
        assertNull(actualDocumentUploadDtoToResponseResult.getUrl());
        assertNull(actualDocumentUploadDtoToResponseResult.getSecret());
        ResponseStatus status = actualDocumentUploadDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(ResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(documentUploadResponseDto.getFileKey());
    }
}

