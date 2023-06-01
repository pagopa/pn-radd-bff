package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationResponseStatusDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class NotificationInquiryService {


    private final PnRaddFsuClient pnRaddFsuClient;

    private final DataVaultService dataVaultService;

    private final NotificationInquiryConverter notificationInquiryConverter;

    public Mono<OperationsActDetailsResponse> getActPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.map(notificationInquiryConverter::filterRequestToDto)
                .flatMap(t -> pnRaddFsuClient.getActPracticesByInternalId(taxId, t))
                .map(notificationInquiryConverter::operationsActDetailsDtoToResponse);
    }

    public  Mono<OperationsResponse> getActPracticesByIun(String iun) {
        return pnRaddFsuClient.getActPracticesByIun(iun)
                .flatMap(operationsResponseDto -> {
                    if (operationsResponseDto.getOperationIds() != null && operationsResponseDto.getOperationIds().isEmpty())
                        return Mono.just(notificationInquiryConverter.noAssociatedOperationFoundResponse(operationsResponseDto));
                    return Flux.fromStream(operationsResponseDto.getOperationIds().stream())
                            .flatMap(pnRaddFsuClient::getActTransactionByOperationId)
                            .map(notificationInquiryConverter::enrichActData)
                            .collectList()
                            .flatMap(operationsDetailsResponsesList -> dataVaultService.getRecipientDenominationByInternalId(getTaxIds(operationsDetailsResponsesList))
                                    .map(deanonymizedTaxIds -> Tuples.of(operationsDetailsResponsesList,
                                            deanonymizedTaxIds)))
                            .map(resultToConverter -> {
                                if (operationsResponseDto.getResult() != null && (operationsResponseDto.getStatus() != null)) {
                                        return Tuples.of(resultToConverter.getT1(),
                                                resultToConverter.getT2(),
                                                operationsResponseDto.getResult(),
                                                operationsResponseDto.getStatus());

                                }
                                return Tuples.of(resultToConverter.getT1(),
                                        resultToConverter.getT2(),
                                        false,
                                        new OperationResponseStatusDto().code(OperationResponseStatusDto.CodeEnum.NUMBER_99));
                            })
                            .map(resultToFinalConverter -> notificationInquiryConverter.operationsDtoToResponse(resultToFinalConverter.getT1(),
                                    resultToFinalConverter.getT2(),
                                    resultToFinalConverter.getT3(),
                                    resultToFinalConverter.getT4()));
                });
    }


    public  Mono<OperationActResponse> getActTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getActTransactionByOperationId(operationId)
                .flatMap(operationActResponseDto -> {
                    if (operationActResponseDto.getElement() != null && (operationActResponseDto.getElement().getRecipientTaxId() != null) && (operationActResponseDto.getElement().getDelegateTaxId() != null)) {
                            return Mono.just(Map.of(operationActResponseDto.getElement().getRecipientTaxId(), operationActResponseDto.getElement().getRecipientTaxId(), operationActResponseDto.getElement().getDelegateTaxId(), operationActResponseDto.getElement().getDelegateTaxId()))
                                    .flatMap(dataVaultService::getRecipientDenominationByInternalId)
                                    .map(deanonymizedTaxIds -> Tuples.of(operationActResponseDto, deanonymizedTaxIds));

                    }
                    return Mono.just(Tuples.of(operationActResponseDto, new HashMap<String, String>()));
                })
                .map(resultToFinalConverter -> notificationInquiryConverter.operationActDtoToResponse(resultToFinalConverter.getT1(), resultToFinalConverter.getT2()));
    }

    public  Mono<OperationsAorDetailsResponse> getAorPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.map(notificationInquiryConverter::filterRequestToDto)
                .flatMap(t -> pnRaddFsuClient.getAorPracticesByInternalId(taxId, t))
                .map(notificationInquiryConverter::operationsAorDetailsDtoToResponse);
    }

    public  Mono<OperationsResponse> getAorPracticesByIun(String iun) {
        return pnRaddFsuClient.getAorPracticesByIun(iun)
                .flatMap(operationsResponseDto -> {
                    if (operationsResponseDto.getOperationIds() != null && operationsResponseDto.getOperationIds().isEmpty())
                        return Mono.just(notificationInquiryConverter.noAssociatedOperationFoundResponse(operationsResponseDto));
                    return Flux.fromStream(operationsResponseDto.getOperationIds().stream())
                        .flatMap(pnRaddFsuClient::getAorTransactionByOperationId)
                        .map(notificationInquiryConverter::enrichAorData)
                        .collectList()
                        .flatMap(operationsDetailsResponsesList -> dataVaultService.getRecipientDenominationByInternalId(getTaxIds(operationsDetailsResponsesList))
                                .map(deanonymizedTaxIds -> Tuples.of(operationsDetailsResponsesList,
                                        deanonymizedTaxIds)))
                        .map(resultToConverter -> {
                            if (operationsResponseDto.getResult() != null && (operationsResponseDto.getStatus() != null)) {
                                    return Tuples.of(resultToConverter.getT1(),
                                            resultToConverter.getT2(),
                                            operationsResponseDto.getResult(),
                                            operationsResponseDto.getStatus());

                            }
                            return Tuples.of(resultToConverter.getT1(),
                                    resultToConverter.getT2(),
                                    false,
                                    new OperationResponseStatusDto().code(OperationResponseStatusDto.CodeEnum.NUMBER_99));
                        })
                .map(resultToFinalConverter -> notificationInquiryConverter.operationsDtoToResponse(resultToFinalConverter.getT1(),
                        resultToFinalConverter.getT2(),
                        resultToFinalConverter.getT3(),
                        resultToFinalConverter.getT4()));
                });
    }

    private Map<String, String> getTaxIds(List<OperationsDetailsResponse> operationsDetailsResponseList) {
        Stream<String> recipientTaxIds = operationsDetailsResponseList.stream()
                .map(OperationsDetailsResponse::getRecipientTaxId);

        Stream<String> delegateTaxIds = operationsDetailsResponseList.stream()
                .map(OperationsDetailsResponse::getDelegateTaxId);

        Stream<String> taxIds = Stream.concat(recipientTaxIds, delegateTaxIds);

        return taxIds.distinct()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

    public  Mono<OperationAorResponse> getAorTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getAorTransactionByOperationId(operationId)
                .flatMap(operationAorResponseDto -> {
                    if (operationAorResponseDto.getElement() != null && (operationAorResponseDto.getElement().getRecipientTaxId() != null) && (operationAorResponseDto.getElement().getDelegateTaxId() != null)) {
                                return Mono.just(Map.of(operationAorResponseDto.getElement().getRecipientTaxId(), operationAorResponseDto.getElement().getRecipientTaxId(), operationAorResponseDto.getElement().getDelegateTaxId(), operationAorResponseDto.getElement().getDelegateTaxId()))
                                        .flatMap(dataVaultService::getRecipientDenominationByInternalId)
                                        .map(deanonymizedTaxIds -> Tuples.of(operationAorResponseDto, deanonymizedTaxIds));
                    }
                    return Mono.just(Tuples.of(operationAorResponseDto, new HashMap<String, String>()));
                })
                .map(resultToFinalConverter -> notificationInquiryConverter.operationAorDtoToResponse(resultToFinalConverter.getT1(), resultToFinalConverter.getT2()));
    }
}
