package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadResponse;
import it.pagopa.pn.radd.bff.service.DocumentUploadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DocumentUploadController.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadControllerTest {
    @Autowired
    private DocumentUploadController documentUploadController;

    @MockBean
    private DocumentUploadService documentUploadService;

    /**
     * Method under test: {@link DocumentUploadController#documentUpload(String, Mono, ServerWebExchange)}
     */
    @Test
    void testDocumentUpload3() {
        when(documentUploadService.documentUpload(any(), any()))
                .thenReturn((Mono<DocumentUploadResponse>) mock(Mono.class));
        documentUploadController.documentUpload("1234", null, null);
        verify(documentUploadService).documentUpload(any(), any());
    }
}

