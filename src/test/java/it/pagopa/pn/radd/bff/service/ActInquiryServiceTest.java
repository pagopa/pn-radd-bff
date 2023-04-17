package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.ActInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActInquiryResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ActInquiryService.class})
@ExtendWith(SpringExtension.class)
class ActInquiryServiceTest {
    @MockBean
    private ActInquiryConverter actInquiryConverter;

    @Autowired
    private ActInquiryService actInquiryService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    /**
     * Method under test: {@link ActInquiryService#actInquiry(String, String, String, String)}
     */
    @Test
    void testActInquiry2() {
        when(pnRaddFsuClient.actInquiry(any(), any(), any(), any()))
                .thenReturn((Mono<ActInquiryResponseDto>) mock(Mono.class));
        actInquiryService.actInquiry("1234", "42", "Recipient Type", "Qr Code");
        verify(pnRaddFsuClient).actInquiry(any(), any(), any(), any());
    }

    /**
     * Method under test: {@link ActInquiryService#actInquiry(String, String, String, String)}
     */
    @Test
    void testActInquiry3() {
        when(pnRaddFsuClient.actInquiry(any(), any(), any(), any()))
                .thenReturn((Mono<ActInquiryResponseDto>) mock(Mono.class));
        actInquiryService.actInquiry("Uid", "42", "Recipient Type", "Qr Code");
        verify(pnRaddFsuClient).actInquiry(any(), any(), any(), any());
    }
}

