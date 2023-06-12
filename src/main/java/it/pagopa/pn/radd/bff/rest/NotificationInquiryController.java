package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.generated.openapi.server.v1.api.*;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.service.NotificationInquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@RestController
@RequiredArgsConstructor
public class NotificationInquiryController implements NotificationInquiryApi {

    @Qualifier("raddBffScheduler")
    private final Scheduler scheduler;

    private final NotificationInquiryService notificationInquiryService;


    @Override
    public  Mono<ResponseEntity<OperationsActDetailsResponse>> getActPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest, final ServerWebExchange exchange) {
        return notificationInquiryService.getActPracticesByInternalId(taxId, filterRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    @Override
    public  Mono<ResponseEntity<OperationsResponse>> getActPracticesByIun(String iun, final ServerWebExchange exchange) {
        return notificationInquiryService.getActPracticesByIun(iun)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    @Override
    public  Mono<ResponseEntity<OperationActResponse>> getActTransactionByOperationId(String operationId, final ServerWebExchange exchange) {
        return notificationInquiryService.getActTransactionByOperationId(operationId)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    @Override
    public  Mono<ResponseEntity<OperationsAorDetailsResponse>> getAorPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest, final ServerWebExchange exchange) {
        return notificationInquiryService.getAorPracticesByInternalId(taxId, filterRequest)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    @Override
    public  Mono<ResponseEntity<OperationsResponse>> getAorPracticesByIun(String iun,  final ServerWebExchange exchange) {
        return notificationInquiryService.getAorPracticesByIun(iun)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }

    @Override
    public  Mono<ResponseEntity<OperationAorResponse>> getAorTransactionByOperationId(String operationId,  final ServerWebExchange exchange) {
        return notificationInquiryService.getAorTransactionByOperationId(operationId)
                .map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
                .publishOn(scheduler);
    }
}
