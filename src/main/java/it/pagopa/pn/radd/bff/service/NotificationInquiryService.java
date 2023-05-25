package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

@Component
@RequiredArgsConstructor
public class NotificationInquiryService {


    private final PnRaddFsuClient pnRaddFsuClient;

    private final NotificationInquiryConverter notificationInquiryConverter;

    public Mono<OperationsActDetailsResponse> getActPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.map(notificationInquiryConverter::filterRequestToDto)
                .flatMap(t -> pnRaddFsuClient.getActPracticesByInternalId(taxId, t))
                .map(notificationInquiryConverter::operationsActDetailsDtoToResponse);
    }

    public  Mono<OperationsResponse> getActPracticesByIun(String iun) {
        return pnRaddFsuClient.getActPracticesByIun(iun)
                .flatMap(t -> Flux.fromStream(t.getOperationIds().stream())
                        .flatMap(pnRaddFsuClient::getActTransactionByOperationId)
                        .map(notificationInquiryConverter::enrichActData)
                        .collectList()
                        .map(v -> Tuples.of(v, t.getResult(), t.getStatus())))
                .map(y -> notificationInquiryConverter.operationsDtoToResponse(y.getT1(), y.getT2(), y.getT3()));
    }


    public  Mono<OperationActResponse> getActTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getActTransactionByOperationId(operationId)
                .map(notificationInquiryConverter::operationActDtoToResponse);

    }

    public  Mono<OperationsAorDetailsResponse> getAorPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.map(notificationInquiryConverter::filterRequestToDto)
                .flatMap(t -> pnRaddFsuClient.getAorPracticesByInternalId(taxId, t))
                .map(notificationInquiryConverter::operationsAorDetailsDtoToResponse);
    }

    public  Mono<OperationsResponse> getAorPracticesByIun(String iun) {
        return pnRaddFsuClient.getAorPracticesByIun(iun)
                .flatMap(t -> Flux.fromStream(t.getOperationIds().stream())
                        .flatMap(pnRaddFsuClient::getAorTransactionByOperationId)
                        .map(notificationInquiryConverter::enrichAorData)
                        .collectList()
                        .map(v -> Tuples.of(v, t.getResult(), t.getStatus())))
                .map(y -> notificationInquiryConverter.operationsDtoToResponse(y.getT1(), y.getT2(), y.getT3()));
    }

    public  Mono<OperationAorResponse> getAorTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getAorTransactionByOperationId(operationId)
                .map(notificationInquiryConverter::operationAorDtoToResponse);
    }

}
