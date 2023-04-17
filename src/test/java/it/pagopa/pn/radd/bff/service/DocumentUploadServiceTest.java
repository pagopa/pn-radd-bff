package it.pagopa.pn.radd.bff.service;

import static org.mockito.Mockito.mock;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.DocumentUploadConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentUploadRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {DocumentUploadService.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadServiceTest {
    @MockBean
    private DocumentUploadConverter documentUploadConverter;

    @Autowired
    private DocumentUploadService documentUploadService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    /**
     * Method under test: {@link DocumentUploadService#documentUpload(String, Mono)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDocumentUpload() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "documentUploadRequest" is null
        //       at it.pagopa.pn.radd.bff.service.DocumentUploadService.documentUpload(DocumentUploadService.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        documentUploadService.documentUpload("1234", null);
    }

    /**
     * Method under test: {@link DocumentUploadService#documentUpload(String, Mono)}
     */
    @Test
    void testDocumentUpload2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     DocumentUploadService.documentUploadConverter
        //     DocumentUploadService.pnRaddFsuClient

        documentUploadService.documentUpload("1234", (Mono<DocumentUploadRequest>) mock(Mono.class));
    }
}

