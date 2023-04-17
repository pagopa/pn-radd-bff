package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.service.ActInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ActInquiryController.class})
@ExtendWith(SpringExtension.class)
class ActInquiryControllerTest {
    @Autowired
    private ActInquiryController actInquiryController;

    @MockBean
    private ActInquiryService actInquiryService;

    /**
     * Method under test: {@link ActInquiryController#actInquiry(String, String, String, String, ServerWebExchange)}
     */
    @Test
    void testActInquiry3() {
        when(actInquiryService.actInquiry(any(), any(), any(), any()))
                .thenReturn((Mono<ActInquiryResponse>) mock(Mono.class));
        actInquiryController.actInquiry("1234", "42", "Recipient Type", "Qr Code", null);
        verify(actInquiryService).actInquiry(any(), any(), any(), any());
    }
}

