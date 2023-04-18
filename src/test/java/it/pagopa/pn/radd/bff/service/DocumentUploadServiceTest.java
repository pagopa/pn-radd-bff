package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.DocumentUploadConverter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DocumentUploadService.class})
@ExtendWith(SpringExtension.class)
class DocumentUploadServiceTest {
    @MockBean
    private DocumentUploadConverter documentUploadConverter;

    @Autowired
    private DocumentUploadService documentUploadService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

}

