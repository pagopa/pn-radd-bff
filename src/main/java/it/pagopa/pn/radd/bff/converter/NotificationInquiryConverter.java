package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.AbortTransactionResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ActStartTransactionRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.CompleteTransactionRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.CompleteTransactionResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.FilterRequest;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationActDetailResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationActResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationAorDetailResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationAorResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationResponseStatus;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationsActDetailsResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationsAorDetailsResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.OperationsResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.StartTransactionResponse;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.StartTransactionResponseStatus;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.TransactionResponseStatus;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.springframework.stereotype.Component;


import java.time.ZoneOffset;
import java.util.*;

@Component
public class NotificationInquiryConverter {

    public AbortTransactionRequestDto abortTransactionRequestToDto(AbortTransactionRequest abortTransactionRequest) {
        AbortTransactionRequestDto abortTransactionRequestDto = new AbortTransactionRequestDto();

        abortTransactionRequestDto.setOperationId(abortTransactionRequest.getOperationId());
        abortTransactionRequestDto.setReason(abortTransactionRequest.getReason());
        abortTransactionRequestDto.setOperationDate(abortTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));

        return abortTransactionRequestDto;
    }

    public AbortTransactionResponse abortTransactionDtoToResponse(AbortTransactionResponseDto abortTransactionResponseDto) {
        AbortTransactionResponse abortTransactionResponse = new AbortTransactionResponse();

        TransactionResponseStatus transactionResponseStatus = new TransactionResponseStatus();
        TransactionResponseStatusDto transactionResponseStatusDto = abortTransactionResponseDto.getStatus();

        if (transactionResponseStatusDto != null && (transactionResponseStatusDto.getCode() != null)) {
            transactionResponseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(transactionResponseStatusDto.getCode().getValue()));

        }
        if (transactionResponseStatusDto != null) {
            transactionResponseStatus.setMessage(transactionResponseStatusDto.getMessage());
        }

        abortTransactionResponse.setStatus(transactionResponseStatus);

        return abortTransactionResponse;
    }

    public CompleteTransactionRequestDto completeTransactionRequestToDto(CompleteTransactionRequest completeTransactionRequest) {
        CompleteTransactionRequestDto completeTransactionRequestDto = new CompleteTransactionRequestDto();

        completeTransactionRequestDto.setOperationId(completeTransactionRequest.getOperationId());
        completeTransactionRequestDto.setOperationDate(completeTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));

        return completeTransactionRequestDto;
    }

    public CompleteTransactionResponse completeTransactionDtoToResponse(CompleteTransactionResponseDto completeTransactionResponseDto) {
        CompleteTransactionResponse completeTransactionResponse = new CompleteTransactionResponse();

        TransactionResponseStatus transactionResponseStatus = new TransactionResponseStatus();
        TransactionResponseStatusDto transactionResponseStatusDto = completeTransactionResponseDto.getStatus();

        if (transactionResponseStatusDto != null && transactionResponseStatusDto.getCode() != null) {
            transactionResponseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(transactionResponseStatusDto.getCode().getValue()));
        }
        if (transactionResponseStatusDto != null) {
            transactionResponseStatus.setMessage(transactionResponseStatusDto.getMessage());
        }

        completeTransactionResponse.setStatus(transactionResponseStatus);

        return completeTransactionResponse;
    }

    public StartTransactionResponse startTransactionDtoToResponse(StartTransactionResponseDto startTransactionResponseDto) {
        StartTransactionResponse startTransactionResponse = new StartTransactionResponse();

        StartTransactionResponseStatus startTransactionResponseStatus = new StartTransactionResponseStatus();
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = startTransactionResponseDto.getStatus();

        if (startTransactionResponseStatusDto != null && (startTransactionResponseStatusDto.getCode() != null)) {
            startTransactionResponseStatus.setCode(StartTransactionResponseStatus.CodeEnum.fromValue(startTransactionResponseStatusDto.getCode().getValue()));

        }
        if (startTransactionResponseStatusDto != null) {
            startTransactionResponseStatus.setMessage(startTransactionResponseStatusDto.getMessage());
        }

        startTransactionResponse.setStatus(startTransactionResponseStatus);

        return startTransactionResponse;
    }

    public ActStartTransactionRequestDto actStartTransactionRequestToDto(ActStartTransactionRequest actStartTransactionRequest) {
        ActStartTransactionRequestDto actStartTransactionRequestDto = new ActStartTransactionRequestDto();

        actStartTransactionRequestDto.setChecksum(actStartTransactionRequest.getChecksum());
        actStartTransactionRequestDto.setFileKey(actStartTransactionRequest.getFileKey());
        actStartTransactionRequestDto.setDelegateTaxId(actStartTransactionRequest.getDelegateTaxId());
        actStartTransactionRequestDto.setQrCode(actStartTransactionRequest.getQrCode());
        actStartTransactionRequestDto.setVersionToken(actStartTransactionRequest.getVersionToken());
        actStartTransactionRequestDto.setRecipientTaxId(actStartTransactionRequest.getRecipientTaxId());
        actStartTransactionRequestDto.setRecipientType(ActStartTransactionRequestDto.RecipientTypeEnum.fromValue(actStartTransactionRequest.getRecipientType().getValue()));
        actStartTransactionRequestDto.setOperationId(actStartTransactionRequest.getOperationId());
        actStartTransactionRequestDto.setOperationDate(actStartTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));

        return actStartTransactionRequestDto;
    }

    public AorStartTransactionRequestDto aorStartTransactionRequestToDto(AorStartTransactionRequest aorStartTransactionRequest) {
        AorStartTransactionRequestDto aorStartTransactionRequestDto = new AorStartTransactionRequestDto();

        aorStartTransactionRequestDto.setChecksum(aorStartTransactionRequest.getChecksum());
        aorStartTransactionRequestDto.setFileKey(aorStartTransactionRequest.getFileKey());
        aorStartTransactionRequestDto.setDelegateTaxId(aorStartTransactionRequest.getDelegateTaxId());
        aorStartTransactionRequestDto.setVersionToken(aorStartTransactionRequest.getVersionToken());
        aorStartTransactionRequestDto.setRecipientType(AorStartTransactionRequestDto.RecipientTypeEnum.fromValue(aorStartTransactionRequest.getRecipientType().getValue()));
        aorStartTransactionRequestDto.setRecipientTaxId(aorStartTransactionRequest.getRecipientTaxId());
        aorStartTransactionRequestDto.setOperationId(aorStartTransactionRequest.getOperationId());
        aorStartTransactionRequestDto.setOperationDate(aorStartTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));

        return aorStartTransactionRequestDto;
    }


    public OperationsAorDetailsResponse operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto operationsAorDetailsResponseDto, String taxId, Map<String, String> deanonymizedDelegateTaxIds) {
        OperationsAorDetailsResponse operationsAorDetailsResponse = new OperationsAorDetailsResponse();

        List<OperationAorDetailResponse> listOperationAorDetailResponse = new ArrayList<>();
        if (operationsAorDetailsResponseDto.getElements() != null) {
            operationsAorDetailsResponseDto.getElements().forEach(t -> {
                OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();

                operationAorDetailResponse.setOperationId(t.getOperationId());
                operationAorDetailResponse.setOperationStatus(t.getOperationStatus());
                operationAorDetailResponse.setFileKey(t.getFileKey());
                operationAorDetailResponse.setOperationType(t.getOperationType());
                if (t.getDelegateTaxId() != null)
                    operationAorDetailResponse.setDelegateTaxId(deanonymizedDelegateTaxIds.get(t.getDelegateTaxId()));
                operationAorDetailResponse.setIuns(t.getIuns());
                operationAorDetailResponse.setQrCode(t.getQrCode());
                operationAorDetailResponse.setErrorReason(t.getErrorReason());
                operationAorDetailResponse.setRecipientType(t.getRecipientType());
                operationAorDetailResponse.setUid(t.getUid());
                if (t.getOperationEndDate() != null)
                    operationAorDetailResponse.setOperationEndDate(new Date(t.getOperationEndDate().toInstant().toEpochMilli()));
                if (t.getOperationStartDate() != null)
                    operationAorDetailResponse.setOperationStartDate(new Date(t.getOperationStartDate().toInstant().toEpochMilli()));
                operationAorDetailResponse.setRecipientTaxId(taxId);

                listOperationAorDetailResponse.add(operationAorDetailResponse);
                listOperationAorDetailResponse.sort(Comparator.comparing(OperationAorDetailResponse::getOperationStartDate).reversed());
            });
        }

        operationsAorDetailsResponse.setElements(listOperationAorDetailResponse);
        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        OperationResponseStatusDto operationResponseStatusDto = operationsAorDetailsResponseDto.getStatus();
        if (operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationsAorDetailsResponse.setStatus(operationResponseStatus);
        operationsAorDetailsResponse.setResult(operationsAorDetailsResponseDto.getResult());
        return operationsAorDetailsResponse;
    }
    public FilterRequestDto filterRequestToDto(FilterRequest filterRequest) {
        FilterRequestDto filterRequestDto = new FilterRequestDto();

        if (filterRequest.getFrom() != null) {
            filterRequestDto.setFrom(filterRequest.getFrom().toInstant().atOffset(ZoneOffset.UTC));
        }
        if (filterRequest.getTo() != null) {
            filterRequestDto.setTo(filterRequest.getTo().toInstant().atOffset(ZoneOffset.UTC));
        }
        return filterRequestDto;
    }

    public OperationAorResponse operationAorDtoToResponse(OperationAorResponseDto operationAorResponseDto, Map<String, String> denominations) {
        OperationAorResponse operationAorResponse = new OperationAorResponse();
        OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();
        OperationResponseStatus operationResponseStatus;
        operationResponseStatus = new OperationResponseStatus();
        OperationAorDetailResponseDto operationAorDetailResponseDto = operationAorResponseDto.getElement();

        if (operationAorDetailResponseDto != null) {
            operationAorDetailResponse.setOperationStatus(operationAorDetailResponseDto.getOperationStatus());
            operationAorDetailResponse.setFileKey(operationAorDetailResponseDto.getFileKey());
            operationAorDetailResponse.setOperationType(operationAorDetailResponseDto.getOperationType());
            if (denominations.containsKey(operationAorDetailResponseDto.getRecipientTaxId()))
                operationAorDetailResponse.setRecipientTaxId(denominations.get(operationAorDetailResponseDto.getRecipientTaxId()));
            if (denominations.containsKey(operationAorDetailResponseDto.getDelegateTaxId()))
                operationAorDetailResponse.setDelegateTaxId(denominations.get(operationAorDetailResponseDto.getDelegateTaxId()));
            operationAorDetailResponse.setIuns(operationAorDetailResponseDto.getIuns());
            operationAorDetailResponse.setQrCode(operationAorDetailResponseDto.getQrCode());
            operationAorDetailResponse.setErrorReason(operationAorDetailResponseDto.getErrorReason());
            operationAorDetailResponse.setRecipientType(operationAorDetailResponseDto.getRecipientType());
            operationAorDetailResponse.setUid(operationAorDetailResponseDto.getUid());
            if (operationAorDetailResponseDto.getOperationEndDate() != null)
                operationAorDetailResponse.setOperationEndDate(new Date(operationAorDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
            if (operationAorDetailResponseDto.getOperationStartDate() != null)
                operationAorDetailResponse.setOperationStartDate(new Date(operationAorDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));
            operationAorDetailResponse.setOperationId(operationAorDetailResponseDto.getOperationId());
            operationAorResponse.setElement(operationAorDetailResponse);
        }
        OperationResponseStatusDto operationResponseStatusDto = operationAorResponseDto.getStatus();
        if (operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationAorResponse.setStatus(operationResponseStatus);
        operationAorResponse.setResult(operationAorResponseDto.getResult());

        return operationAorResponse;
    }

    public OperationActResponse operationActDtoToResponse(OperationActResponseDto operationActResponseDto, Map<String, String> deanonymizedTaxIds) {

        OperationActResponse operationActResponse = new OperationActResponse();
        OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();
        OperationActDetailResponseDto operationActDetailResponseDto = operationActResponseDto.getElement();
        OperationResponseStatus operationResponseStatus;
        operationResponseStatus = new OperationResponseStatus();
        if (operationActDetailResponseDto != null) {
            operationActDetailResponse.setOperationId(operationActDetailResponseDto.getOperationId());

            operationActDetailResponse.setOperationStatus(operationActDetailResponseDto.getOperationStatus());
            operationActDetailResponse.setFileKey(operationActDetailResponseDto.getFileKey());
            operationActDetailResponse.setOperationType(operationActDetailResponseDto.getOperationType());
            if (deanonymizedTaxIds.containsKey(operationActDetailResponseDto.getRecipientTaxId()))
                operationActDetailResponse.setRecipientTaxId(deanonymizedTaxIds.get(operationActDetailResponseDto.getRecipientTaxId()));
            if (deanonymizedTaxIds.containsKey(operationActDetailResponseDto.getDelegateTaxId()))
                operationActDetailResponse.setDelegateTaxId(deanonymizedTaxIds.get(operationActDetailResponseDto.getDelegateTaxId()));
            operationActDetailResponse.setIun(operationActDetailResponseDto.getIun());
            operationActDetailResponse.setQrCode(operationActDetailResponseDto.getQrCode());
            operationActDetailResponse.setErrorReason(operationActDetailResponseDto.getErrorReason());
            operationActDetailResponse.setRecipientType(operationActDetailResponseDto.getRecipientType());
            operationActDetailResponse.setUid(operationActDetailResponseDto.getUid());
            operationActDetailResponse.setOperationId(operationActDetailResponseDto.getOperationId());
            if (operationActDetailResponseDto.getOperationEndDate() != null)
                operationActDetailResponse.setOperationEndDate(new Date(operationActDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
            if (operationActDetailResponseDto.getOperationStartDate() != null)
                operationActDetailResponse.setOperationStartDate(new Date(operationActDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));

            operationActResponse.setElement(operationActDetailResponse);
        }
        OperationResponseStatusDto operationResponseStatusDto = operationActResponseDto.getStatus();
        if (operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationActResponse.setStatus(operationResponseStatus);
        operationActResponse.setResult(operationActResponseDto.getResult());
        return operationActResponse;
    }

    public OperationsActDetailsResponse operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto operationsActDetailsResponseDto, String taxId, Map<String, String> deanonymizedDelegateTaxIds) {
        OperationsActDetailsResponse operationsActDetailsResponse = new OperationsActDetailsResponse();

        List<OperationActDetailResponse> listOperationActDetailResponse = new ArrayList<>();
        if (operationsActDetailsResponseDto.getElements() != null) {
            operationsActDetailsResponseDto.getElements().forEach(t -> {
                OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();

                operationActDetailResponse.setOperationId(t.getOperationId());
                operationActDetailResponse.setOperationStatus(t.getOperationStatus());
                operationActDetailResponse.setFileKey(t.getFileKey());
                operationActDetailResponse.setOperationType(t.getOperationType());
                if (t.getDelegateTaxId() != null)
                    operationActDetailResponse.setDelegateTaxId(deanonymizedDelegateTaxIds.get(t.getDelegateTaxId()));
                operationActDetailResponse.setIun(t.getIun());
                operationActDetailResponse.setQrCode(t.getQrCode());
                operationActDetailResponse.setErrorReason(t.getErrorReason());
                operationActDetailResponse.setRecipientType(t.getRecipientType());
                operationActDetailResponse.setUid(t.getUid());
                if (t.getOperationEndDate() != null)
                    operationActDetailResponse.setOperationEndDate(new Date(t.getOperationEndDate().toInstant().toEpochMilli()));
                if (t.getOperationStartDate() != null)
                    operationActDetailResponse.setOperationStartDate(new Date(t.getOperationStartDate().toInstant().toEpochMilli()));
                operationActDetailResponse.setRecipientTaxId(taxId);

                listOperationActDetailResponse.add(operationActDetailResponse);
                listOperationActDetailResponse.sort(Comparator.comparing(OperationActDetailResponse::getOperationStartDate).reversed());
            });
        }

        operationsActDetailsResponse.setElements(listOperationActDetailResponse);
        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        OperationResponseStatusDto operationResponseStatusDto = operationsActDetailsResponseDto.getStatus();
        if (operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationsActDetailsResponse.setStatus(operationResponseStatus);
        operationsActDetailsResponse.setResult(operationsActDetailsResponseDto.getResult());
        return operationsActDetailsResponse;
    }

    public OperationsResponse operationsDtoToResponse(List<OperationsDetailsResponse> operationsDetailsResponses,
                                                      Map<String, String> deanonymizedTaxIds,
                                                      Boolean result,
                                                      OperationResponseStatusDto operationResponseStatusDto) {

        OperationsResponse operationsResponse = new OperationsResponse();

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        if (operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }

        operationsResponse.setResult(result);
        operationsResponse.setStatus(operationResponseStatus);
        operationsResponse.setOperations(deanonymizeTaxIds(operationsDetailsResponses, deanonymizedTaxIds));

        return operationsResponse;
    }

    private List<OperationsDetailsResponse> deanonymizeTaxIds(List<OperationsDetailsResponse> operationsDetailsResponses, Map<String, String> deanonymizedTaxIds) {
        operationsDetailsResponses.forEach(response -> {
            response.setRecipientTaxId(deanonymizedTaxIds.get(response.getRecipientTaxId()));
            response.setDelegateTaxId(deanonymizedTaxIds.get(response.getDelegateTaxId()));
        });
        return operationsDetailsResponses;
    }

    public OperationsDetailsResponse enrichAorData(OperationAorResponseDto operationAorResponseDto) {
        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();

        OperationAorDetailResponseDto operationAorDetailResponseDto = operationAorResponseDto.getElement();
        if (operationAorDetailResponseDto != null) {
            operationsDetailsResponse.setOperationId(operationAorDetailResponseDto.getOperationId());
            operationsDetailsResponse.setOperationStatus(operationAorDetailResponseDto.getOperationStatus());
            operationsDetailsResponse.setFileKey(operationAorDetailResponseDto.getFileKey());
            operationsDetailsResponse.setOperationType(operationAorDetailResponseDto.getOperationType());
            operationsDetailsResponse.setIuns(operationAorDetailResponseDto.getIuns());
            operationsDetailsResponse.setRecipientTaxId(operationAorDetailResponseDto.getRecipientTaxId());
            operationsDetailsResponse.setDelegateTaxId(operationAorDetailResponseDto.getDelegateTaxId());
            operationsDetailsResponse.setQrCode(operationAorDetailResponseDto.getQrCode());
            operationsDetailsResponse.setErrorReason(operationAorDetailResponseDto.getErrorReason());
            operationsDetailsResponse.setRecipientType(operationAorDetailResponseDto.getRecipientType());
            operationsDetailsResponse.setUid(operationAorDetailResponseDto.getUid());
            if (operationAorDetailResponseDto.getOperationEndDate() != null)
                operationsDetailsResponse.setOperationEndDate(new Date(operationAorDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
            if (operationAorDetailResponseDto.getOperationStartDate() != null)
                operationsDetailsResponse.setOperationStartDate(new Date(operationAorDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));
        }
        return operationsDetailsResponse;

    }

    public OperationsDetailsResponse enrichActData(OperationActResponseDto operationActResponseDto) {
        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();

        OperationActDetailResponseDto operationActDetailResponseDto = operationActResponseDto.getElement();
        if (operationActDetailResponseDto != null) {
            operationsDetailsResponse.setOperationId(operationActDetailResponseDto.getOperationId());
            operationsDetailsResponse.setOperationStatus(operationActDetailResponseDto.getOperationStatus());
            operationsDetailsResponse.setFileKey(operationActDetailResponseDto.getFileKey());
            operationsDetailsResponse.setOperationType(operationActDetailResponseDto.getOperationType());
            if (operationActDetailResponseDto.getIun() != null) {
                operationsDetailsResponse.setIuns(List.of(operationActDetailResponseDto.getIun()));
            }
            operationsDetailsResponse.setRecipientTaxId(operationActDetailResponseDto.getRecipientTaxId());
            operationsDetailsResponse.setDelegateTaxId(operationActDetailResponseDto.getDelegateTaxId());
            operationsDetailsResponse.setQrCode(operationActDetailResponseDto.getQrCode());
            operationsDetailsResponse.setErrorReason(operationActDetailResponseDto.getErrorReason());
            operationsDetailsResponse.setRecipientType(operationActDetailResponseDto.getRecipientType());
            operationsDetailsResponse.setUid(operationActDetailResponseDto.getUid());
            if (operationActDetailResponseDto.getOperationEndDate() != null)
                operationsDetailsResponse.setOperationEndDate(new Date(operationActDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
            if (operationActDetailResponseDto.getOperationStartDate() != null)
                operationsDetailsResponse.setOperationStartDate(new Date(operationActDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));
        }
        return operationsDetailsResponse;
    }

    public OperationsResponse noAssociatedOperationFoundResponse(OperationsResponseDto operationsResponseDto) {
        OperationsResponse operationsResponse = new OperationsResponse();
        operationsResponse.setOperations(new ArrayList<>());
        operationsResponse.setResult(operationsResponseDto.getResult());
        if (operationsResponseDto.getStatus() != null && operationsResponseDto.getStatus().getCode() != null) {
                operationsResponse.setStatus(new OperationResponseStatus()
                        .code(OperationResponseStatus.CodeEnum.fromValue(operationsResponseDto.getStatus().getCode().getValue()))
                        .message(operationsResponseDto.getStatus().getMessage()));
        }
        return operationsResponse;
    }
}
