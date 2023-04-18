package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.service.AorInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AorInquiryController.class})
@ExtendWith(SpringExtension.class)
class AorInquiryControllerTest {
    @Autowired
    private AorInquiryController aorInquiryController;

    @MockBean
    private AorInquiryService aorInquiryService;

    /**
     * Method under test: {@link AorInquiryController#aorInquiry(String, String, String, ServerWebExchange)}
     */
    @Test
    void testAorInquiry3() {
        when(aorInquiryService.aorInquiry(any(), any(), any()))
                .thenReturn((Mono<AORInquiryResponse>) mock(Mono.class));
        aorInquiryController.aorInquiry("1234", "42", "Recipient Type", null);
        verify(aorInquiryService).aorInquiry(any(), any(), any());
    }
}

