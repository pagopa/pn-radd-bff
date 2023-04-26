package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.AorInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AorInquiryService.class})
@ExtendWith(SpringExtension.class)
class AorInquiryServiceTest {
    @MockBean
    private AorInquiryConverter aorInquiryConverter;

    @Autowired
    private AorInquiryService aorInquiryService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    /**
     * Method under test: {@link AorInquiryService#aorInquiry(String, String, String)}
     */
    @Test
    void testAorInquiry2() {
        when(pnRaddFsuClient.aorInquiry(any(), any(), any()))
                .thenReturn((Mono<AORInquiryResponseDto>) mock(Mono.class));
        aorInquiryService.aorInquiry("1234", "42", "Recipient Type");
        verify(pnRaddFsuClient).aorInquiry(any(), any(), any());
    }

    /**
     * Method under test: {@link AorInquiryService#aorInquiry(String, String, String)}
     */
    @Test
    void testAorInquiry3() {
        when(pnRaddFsuClient.aorInquiry(any(), any(), any()))
                .thenReturn((Mono<AORInquiryResponseDto>) mock(Mono.class));
        aorInquiryService.aorInquiry("Uid", "42", "Recipient Type");
        verify(pnRaddFsuClient).aorInquiry(any(), any(), any());
    }
}

