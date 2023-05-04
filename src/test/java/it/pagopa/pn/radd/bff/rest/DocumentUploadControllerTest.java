package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadResponse;
import it.pagopa.pn.radd.bff.service.DocumentUploadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {DocumentUploadController.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadControllerTest {
    @Autowired
    private DocumentUploadController documentUploadController;

    @MockBean
    private DocumentUploadService documentUploadService;

    @MockBean
    private Scheduler scheduler;

    @Mock
    ServerWebExchange serverWebExchange;


    /**
     * Method under test: {@link DocumentUploadController#documentUpload(String, Mono, ServerWebExchange)}
     */
    @Test
    void testDocumentUpload3() {
        when(documentUploadService.documentUpload(Mockito.any(), Mockito.any()))
                .thenReturn(mock(Mono.class));

        Mono<DocumentUploadRequest> documentUploadRequest = mock(Mono.class);
        DocumentUploadResponse documentUploadResponse = mock(DocumentUploadResponse.class);

        StepVerifier.create(documentUploadController.documentUpload("uid", documentUploadRequest, serverWebExchange))
                .expectNext(ResponseEntity.ok().body(documentUploadResponse));
    }
}

