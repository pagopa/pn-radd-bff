package it.pagopa.pn.radd.bff.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.log.RaddRequestDecorator;
import it.pagopa.pn.radd.bff.log.RaddResponseDecorator;
import it.pagopa.pn.radd.bff.log.RaddWebExchangeDecorator;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.NotificationInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {NotificationInquiryController.class})
@ExtendWith(SpringExtension.class)
class NotificationInquiryControllerTest {
    @Autowired
    private NotificationInquiryController notificationInquiryController;

    @MockBean
    private NotificationInquiryService notificationInquiryService;

    @Mock
    ServerWebExchange serverWebExchange;

    @MockBean
    private Scheduler scheduler;

    /**
     * Method under test: {@link NotificationInquiryController#getActPracticesByInternalId(String, Mono, ServerWebExchange)}
     */
    @Test
    void testGetActPracticesByInternalId3() {
        when(notificationInquiryService.getActPracticesByInternalId(Mockito.<String>any(),
                Mockito.<Mono<FilterRequest>>any())).thenReturn(mock(Mono.class));
        Mono<FilterRequest> filterRequest = mock(Mono.class);
        DefaultServerWebExchange exchange = mock(DefaultServerWebExchange.class);
        when(exchange.getResponse())
                .thenReturn(new RaddResponseDecorator(new RaddResponseDecorator(new RaddResponseDecorator(
                        new RaddResponseDecorator(new RaddResponseDecorator(new MockServerHttpResponse()))))));
        when(exchange.getRequest())
                .thenReturn(
                        new RaddRequestDecorator(new RaddRequestDecorator(new RaddRequestDecorator(
                                new RaddRequestDecorator(
                                        new RaddRequestDecorator(mock(ServerHttpRequestDecorator.class), "Masked URI"), "Masked URI"),
                                "Masked URI"), "Masked URI"), "Masked URI"));
        notificationInquiryController.getActPracticesByInternalId("42", filterRequest,
                new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(
                        new RaddWebExchangeDecorator(new RaddWebExchangeDecorator(exchange, "Masked URI"), "Masked URI"),
                        "Masked URI"), "Masked URI"));
        verify(notificationInquiryService).getActPracticesByInternalId(Mockito.<String>any(),
                Mockito.<Mono<FilterRequest>>any());
        verify(exchange).getRequest();
        verify(exchange).getResponse();
    }

    @Test
    void testGetActPracticesByIun() {
        OperationsResponse operationsResponse = new OperationsResponse();

        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
        operationsDetailsResponse.setOperationId("operationId");
        operationsDetailsResponse.setOperationStatus("operationStatus");
        operationsDetailsResponse.setFileKey("fileKey");
        operationsDetailsResponse.setOperationType("operationType");
        operationsDetailsResponse.setQrCode("qrCode");
        operationsDetailsResponse.setErrorReason("errorReason");
        operationsDetailsResponse.setRecipientType("recipientType");
        operationsDetailsResponse.setUid("uid");
        operationsDetailsResponse.setOperationEndDate(new Date(System.currentTimeMillis() + 1000000L));
        operationsDetailsResponse.setOperationStartDate(new Date(System.currentTimeMillis()));
        operationsDetailsResponse.setIun("iun");

        operationsResponse.setOperations(List.of(operationsDetailsResponse));
        operationsResponse.setResult(true);

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
        operationResponseStatus.setMessage("message");

        operationsResponse.setStatus(operationResponseStatus);

        when(notificationInquiryService.getActPracticesByIun("iun"))
                .thenReturn(Mono.just(operationsResponse));

        StepVerifier.create(notificationInquiryController.getActPracticesByIun("iun", serverWebExchange))
                .expectNext(ResponseEntity.ok().body(operationsResponse));
    }

    @Test
    void testGetAorPracticesByIun() {
        OperationsResponse operationsResponse = new OperationsResponse();

        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
        operationsDetailsResponse.setOperationId("operationId");
        operationsDetailsResponse.setOperationStatus("operationStatus");
        operationsDetailsResponse.setFileKey("fileKey");
        operationsDetailsResponse.setOperationType("operationType");
        operationsDetailsResponse.setQrCode("qrCode");
        operationsDetailsResponse.setErrorReason("errorReason");
        operationsDetailsResponse.setRecipientType("recipientType");
        operationsDetailsResponse.setUid("uid");
        operationsDetailsResponse.setOperationEndDate(new Date(System.currentTimeMillis() + 1000000L));
        operationsDetailsResponse.setOperationStartDate(new Date(System.currentTimeMillis()));
        operationsDetailsResponse.setIun("iun");

        operationsResponse.setOperations(List.of(operationsDetailsResponse));
        operationsResponse.setResult(true);

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
        operationResponseStatus.setMessage("message");

        operationsResponse.setStatus(operationResponseStatus);

        when(notificationInquiryService.getAorPracticesByIun("iun"))
                .thenReturn(Mono.just(operationsResponse));

        StepVerifier.create(notificationInquiryController.getAorPracticesByIun("iun", serverWebExchange))
                .expectNext(ResponseEntity.ok().body(operationsResponse));
    }

}

