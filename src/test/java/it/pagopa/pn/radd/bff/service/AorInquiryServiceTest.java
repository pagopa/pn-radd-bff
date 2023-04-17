package it.pagopa.pn.radd.bff.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.AorInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AORInquiryResponseDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

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
    @Disabled("TODO: Complete this test")
    void testAorInquiry() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "it.pagopa.pn.radd.bff.client.PnRaddFsuClient.aorInquiry(String, String, String)" is null
        //       at it.pagopa.pn.radd.bff.service.AorInquiryService.aorInquiry(AorInquiryService.java:18)
        //   See https://diff.blue/R013 to resolve this issue.

        when(pnRaddFsuClient.aorInquiry(any(), any(), any())).thenReturn(null);
        aorInquiryService.aorInquiry("1234", "42", "Recipient Type");
    }

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

