package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ActInquiryResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ActInquiryResponseStatus;
import it.pagopa.pn.radd.bff.service.ActInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ActInquiryController.class})
@ExtendWith(SpringExtension.class)
class ActInquiryControllerTest {
    @Autowired
    private ActInquiryController actInquiryController;

    @MockBean
    private ActInquiryService actInquiryService;

    @MockBean
    private Scheduler scheduler;

    @Mock
    ServerWebExchange serverWebExchange;

    @Test
    void testActInquiry() {
        ActInquiryResponse actInquiryResponse = new ActInquiryResponse();

        ActInquiryResponseStatus actInquiryResponseStatus = new ActInquiryResponseStatus();
        actInquiryResponseStatus.setCode(ActInquiryResponseStatus.CodeEnum.NUMBER_0);
        actInquiryResponseStatus.setMessage("message");

        actInquiryResponse.setStatus(actInquiryResponseStatus);
        actInquiryResponse.setResult(true);

        when(actInquiryService.actInquiry("uid", "recipientTaxId", "PF", "qrCdde"))
                .thenReturn(Mono.just(actInquiryResponse));

        StepVerifier.create(actInquiryController.actInquiry("uid", "recipientTaxId", "PF", "qrCdde" ,serverWebExchange))
                .expectNext(ResponseEntity.ok().body(actInquiryResponse));
    }
}

