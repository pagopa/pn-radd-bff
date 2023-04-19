package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.AORInquiryResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.ResponseStatus;
import it.pagopa.pn.radd.bff.service.AorInquiryService;
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

@ContextConfiguration(classes = {AorInquiryController.class})
@ExtendWith(SpringExtension.class)
class AorInquiryControllerTest {
    @Autowired
    private AorInquiryController aorInquiryController;

    @MockBean
    private AorInquiryService aorInquiryService;

    @MockBean
    private Scheduler scheduler;

    @Mock
    ServerWebExchange serverWebExchange;

    @Test
    void testAorInquiry() {
        AORInquiryResponse aorInquiryResponse = new AORInquiryResponse();

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.CodeEnum.NUMBER_0);
        responseStatus.setMessage("message");

        aorInquiryResponse.setStatus(responseStatus);
        aorInquiryResponse.setResult(true);

        when(aorInquiryService.aorInquiry("uid", "recipientTaxId", "PF"))
                .thenReturn(Mono.just(aorInquiryResponse));

        StepVerifier.create(aorInquiryController.aorInquiry("uid", "recipientTaxId", "PF" ,serverWebExchange))
                .expectNext(ResponseEntity.ok().body(aorInquiryResponse));
    }
}

