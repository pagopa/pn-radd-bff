package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.exception.PnRaddBffException;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.data.vault.v1.dto.RecipientType;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionCodes.*;

@Component
@lombok.CustomLog
@RequiredArgsConstructor
public class NotificationInquiryService {


    private final PnRaddFsuClient pnRaddFsuClient;

    private final DataVaultService dataVaultService;

    private final NotificationInquiryConverter notificationInquiryConverter;

    public Mono<OperationsActDetailsResponse> getActPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.flatMap(filterRequest1 -> {
                    FilterRequestDto filterRequestDto = notificationInquiryConverter.filterRequestToDto(filterRequest1);
                    return dataVaultService.getAnonymousByTaxId(RecipientType.fromValue(filterRequest1.getRecipientType().getValue()), taxId)
                            .flatMap(anonymousTaxId -> pnRaddFsuClient.getActPracticesByInternalId(anonymousTaxId, filterRequestDto));
                })
                .flatMap(response -> dataVaultService.getRecipientDenominationByInternalId(delegateTaxIdActMapBuilder(response))
                        .map(deanonymizedTaxIds -> Tuples.of(response, deanonymizedTaxIds)))
                .map(toConverter -> notificationInquiryConverter.operationsActDetailsDtoToResponse(toConverter.getT1(), taxId, toConverter.getT2()));
    }

    private Map<String, String> delegateTaxIdActMapBuilder(OperationsActDetailsResponseDto response) {
        Map<String, String> delegateTaxIdMap = new HashMap<>();
        if (response.getElements() != null && !response.getElements().isEmpty()) {
            response.getElements().forEach(operationActDetailResponseDto -> {
                if (operationActDetailResponseDto.getDelegateTaxId() != null && !operationActDetailResponseDto.getDelegateTaxId().isEmpty()) {
                    delegateTaxIdMap.put(operationActDetailResponseDto.getDelegateTaxId(), operationActDetailResponseDto.getDelegateTaxId());
                }
            });
        }
        return delegateTaxIdMap;
    }

    public Mono<OperationsResponse> getActPracticesByIun(String iun) {
        return pnRaddFsuClient.getActPracticesByIun(iun)
                .flatMap(operationsResponseDto -> {
                    if (operationsResponseDto.getOperationIds() != null && operationsResponseDto.getOperationIds().isEmpty())
                        return Mono.just(notificationInquiryConverter.noAssociatedOperationFoundResponse(operationsResponseDto));
                    return Flux.fromStream(operationsResponseDto.getOperationIds().stream())
                            .flatMap(pnRaddFsuClient::getActTransactionByOperationId)
                            .map(notificationInquiryConverter::enrichActData)
                            .collectList()
                            .flatMap(operationsDetailsResponsesList -> dataVaultService.getRecipientDenominationByInternalId(getTaxIds(operationsDetailsResponsesList))
                                    .map(deAnonymizedTaxIds -> Tuples.of(operationsDetailsResponsesList,
                                            deAnonymizedTaxIds)))
                            .map(resultToConverter -> {
                                if (operationsResponseDto.getResult() != null && (operationsResponseDto.getStatus() != null)) {
                                    return Tuples.of(resultToConverter.getT1(),
                                            resultToConverter.getT2(),
                                            operationsResponseDto.getResult(),
                                            operationsResponseDto.getStatus());

                                }
                                throw new PnRaddBffException(ERROR_MESSAGE_ACT_OPERATIONS_BY_IUN,
                                        "Corrupted data.", 500, ERROR_CODE_ACT_NOTIFICATION_INQUIRY, null, null);
                            })
                            .map(resultToFinalConverter -> notificationInquiryConverter.operationsDtoToResponse(resultToFinalConverter.getT1(),
                                    resultToFinalConverter.getT2(),
                                    resultToFinalConverter.getT3(),
                                    resultToFinalConverter.getT4()));
                });
    }


    public Mono<OperationActResponse> getActTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getActTransactionByOperationId(operationId)
                .flatMap(operationActResponseDto -> Mono.just(taxIdsActMapBuilder(operationActResponseDto))
                        .flatMap(dataVaultService::getRecipientDenominationByInternalId)
                        .map(deanonymizedTaxIds -> Tuples.of(operationActResponseDto, deanonymizedTaxIds)))
                .map(resultToFinalConverter -> notificationInquiryConverter.operationActDtoToResponse(resultToFinalConverter.getT1(), resultToFinalConverter.getT2()));
    }

    public Mono<OperationsAorDetailsResponse> getAorPracticesByInternalId(String taxId, Mono<FilterRequest> filterRequest) {
        return filterRequest.flatMap(filterRequest1 -> {
                    FilterRequestDto filterRequestDto = notificationInquiryConverter.filterRequestToDto(filterRequest1);
                    return dataVaultService.getAnonymousByTaxId(RecipientType.fromValue(filterRequest1.getRecipientType().getValue()), taxId)
                            .flatMap(anonymousTaxId ->
                                    pnRaddFsuClient.getAorPracticesByInternalId(anonymousTaxId, filterRequestDto));
                })
                .flatMap(response -> dataVaultService.getRecipientDenominationByInternalId(delegateTaxIdAorMapBuilder(response))
                        .map(deanonymizedTaxIds -> Tuples.of(response, deanonymizedTaxIds)))
                .map(toConverter -> notificationInquiryConverter.operationsAorDetailsDtoToResponse(toConverter.getT1(), taxId, toConverter.getT2()));
    }

    private Map<String, String> delegateTaxIdAorMapBuilder(OperationsAorDetailsResponseDto response) {
        Map<String, String> delegateTaxIdMap = new HashMap<>();
        if (response.getElements() != null && !response.getElements().isEmpty()) {
            response.getElements().forEach(operationAorResponseDto -> {
                if (operationAorResponseDto.getDelegateTaxId() != null && !operationAorResponseDto.getDelegateTaxId().isEmpty()) {
                    delegateTaxIdMap.put(operationAorResponseDto.getDelegateTaxId(), operationAorResponseDto.getDelegateTaxId());
                }
            });
        }
        return delegateTaxIdMap;
    }

    public Mono<OperationsResponse> getAorPracticesByIun(String iun) {
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
                                throw new PnRaddBffException(ERROR_MESSAGE_AOR_OPERATIONS_BY_IUN,
                                        "Corrupted data.", 500, ERROR_CODE_AOR_NOTIFICATION_INQUIRY, null, null);
                            })
                            .map(resultToFinalConverter -> notificationInquiryConverter.operationsDtoToResponse(resultToFinalConverter.getT1(),
                                    resultToFinalConverter.getT2(),
                                    resultToFinalConverter.getT3(),
                                    resultToFinalConverter.getT4()));
                });
    }

    private Map<String, String> getTaxIds(List<OperationsDetailsResponse> operationsDetailsResponseList) {
        Stream<String> recipientTaxIds = operationsDetailsResponseList.stream()
                .map(OperationsDetailsResponse::getRecipientTaxId)
                .filter(Objects::nonNull);

        Stream<String> delegateTaxIds = operationsDetailsResponseList.stream()
                .map(OperationsDetailsResponse::getDelegateTaxId)
                .filter(Objects::nonNull);

        Stream<String> taxIds = Stream.concat(recipientTaxIds, delegateTaxIds);

        return taxIds.distinct()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

    public Mono<OperationAorResponse> getAorTransactionByOperationId(String operationId) {
        return pnRaddFsuClient.getAorTransactionByOperationId(operationId)
                .flatMap(operationAorResponseDto -> Mono.just(taxIdsAorMapBuilder(operationAorResponseDto))
                        .flatMap(dataVaultService::getRecipientDenominationByInternalId)
                        .map(deanonymizedTaxIds -> Tuples.of(operationAorResponseDto, deanonymizedTaxIds)))
                .map(resultToFinalConverter -> notificationInquiryConverter.operationAorDtoToResponse(resultToFinalConverter.getT1(), resultToFinalConverter.getT2()));
    }

    private Map<String, String> taxIdsAorMapBuilder(OperationAorResponseDto operationAorResponseDto) {
        Map<String, String> taxIdsMap = new HashMap<>();
        if (operationAorResponseDto.getElement() != null && operationAorResponseDto.getElement().getRecipientTaxId() != null) {
            taxIdsMap.put(operationAorResponseDto.getElement().getRecipientTaxId(), operationAorResponseDto.getElement().getRecipientTaxId());
        }
        if (operationAorResponseDto.getElement().getDelegateTaxId() != null) {
            taxIdsMap.put(operationAorResponseDto.getElement().getDelegateTaxId(), operationAorResponseDto.getElement().getDelegateTaxId());
        }
        return taxIdsMap;
    }

    private Map<String, String> taxIdsActMapBuilder(OperationActResponseDto operationActResponseDto) {
        Map<String, String> taxIdsMap = new HashMap<>();
        if (operationActResponseDto.getElement() != null && operationActResponseDto.getElement().getRecipientTaxId() != null) {
            taxIdsMap.put(operationActResponseDto.getElement().getRecipientTaxId(), operationActResponseDto.getElement().getRecipientTaxId());
        }
        if (operationActResponseDto.getElement().getDelegateTaxId() != null) {
            taxIdsMap.put(operationActResponseDto.getElement().getDelegateTaxId(), operationActResponseDto.getElement().getDelegateTaxId());
        }
        return taxIdsMap;
    }
}
