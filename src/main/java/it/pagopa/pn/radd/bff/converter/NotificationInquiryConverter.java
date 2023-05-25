package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import org.springframework.stereotype.Component;


import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        transactionResponseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(transactionResponseStatusDto.getCode().getValue()));
        transactionResponseStatus.setMessage(transactionResponseStatusDto.getMessage());

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

        transactionResponseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(transactionResponseStatusDto.getCode().getValue()));
        transactionResponseStatus.setMessage(transactionResponseStatusDto.getMessage());

        completeTransactionResponse.setStatus(transactionResponseStatus);

        return completeTransactionResponse;
    }

    public StartTransactionResponse startTransactionDtoToResponse(StartTransactionResponseDto startTransactionResponseDto) {
        StartTransactionResponse startTransactionResponse = new StartTransactionResponse();

        StartTransactionResponseStatus startTransactionResponseStatus = new StartTransactionResponseStatus();
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = startTransactionResponseDto.getStatus();

        startTransactionResponseStatus.setCode(StartTransactionResponseStatus.CodeEnum.fromValue(startTransactionResponseStatusDto.getCode().getValue()));
        startTransactionResponseStatus.setMessage(startTransactionResponseStatusDto.getMessage());

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


    public OperationsAorDetailsResponse operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto operationsAorDetailsResponseDto) {
        OperationsAorDetailsResponse operationsAorDetailsResponse = new OperationsAorDetailsResponse();

        List<OperationAorDetailResponse> listOperationAorDetailResponse = new ArrayList<>();
        operationsAorDetailsResponseDto.getElements().stream().forEach(t -> {
            OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();

            operationAorDetailResponse.setOperationId(t.getOperationId());
            operationAorDetailResponse.setOperationStatus(t.getOperationStatus());
            operationAorDetailResponse.setFileKey(t.getFileKey());
            operationAorDetailResponse.setOperationType(t.getOperationType());
            operationAorDetailResponse.setDelegateTaxId(t.getDelegateTaxId());
            operationAorDetailResponse.setIuns(t.getIuns());
            operationAorDetailResponse.setQrCode(t.getQrCode());
            operationAorDetailResponse.setErrorReason(t.getErrorReason());
            operationAorDetailResponse.setRecipientType(t.getRecipientType());
            operationAorDetailResponse.setUid(t.getUid());
            if(t.getOperationEndDate()!=null)
                operationAorDetailResponse.setOperationEndDate(new Date(t.getOperationEndDate().toInstant().toEpochMilli()));
            if(t.getOperationStartDate()!=null)
                operationAorDetailResponse.setOperationStartDate(new Date(t.getOperationStartDate().toInstant().toEpochMilli()));
            operationAorDetailResponse.setRecipientTaxId(t.getRecipientTaxId());

            listOperationAorDetailResponse.add(operationAorDetailResponse);
        });

        operationsAorDetailsResponse.setElements(listOperationAorDetailResponse);
        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        OperationResponseStatusDto operationResponseStatusDto = operationsAorDetailsResponseDto.getStatus();
        if(operationResponseStatusDto!=null) {
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

        filterRequestDto.setFrom(filterRequest.getFrom().toInstant().atOffset(ZoneOffset.UTC));
        filterRequestDto.setTo(filterRequest.getTo().toInstant().atOffset(ZoneOffset.UTC));

        return filterRequestDto;
    }

    public OperationAorResponse operationAorDtoToResponse(OperationAorResponseDto operationAorResponseDto) {
        OperationAorResponse operationAorResponse = new OperationAorResponse();
        OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();
        OperationAorDetailResponseDto operationAorDetailResponseDto = operationAorResponseDto.getElement();
        operationAorDetailResponse.setOperationId(operationAorDetailResponseDto.getOperationId());
        operationAorDetailResponse.setOperationStatus(operationAorDetailResponseDto.getOperationStatus());
        operationAorDetailResponse.setFileKey(operationAorDetailResponseDto.getFileKey());
        operationAorDetailResponse.setOperationType(operationAorDetailResponseDto.getOperationType());
        operationAorDetailResponse.setDelegateTaxId(operationAorDetailResponseDto.getDelegateTaxId());
        operationAorDetailResponse.setIuns(operationAorDetailResponseDto.getIuns());
        operationAorDetailResponse.setQrCode(operationAorDetailResponseDto.getQrCode());
        operationAorDetailResponse.setErrorReason(operationAorDetailResponseDto.getErrorReason());
        operationAorDetailResponse.setRecipientType(operationAorDetailResponseDto.getRecipientType());
        operationAorDetailResponse.setUid(operationAorDetailResponseDto.getUid());
        if(operationAorDetailResponseDto.getOperationEndDate()!=null)
            operationAorDetailResponse.setOperationEndDate(new Date(operationAorDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
        if(operationAorDetailResponseDto.getOperationStartDate()!=null)
            operationAorDetailResponse.setOperationStartDate(new Date(operationAorDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));
        operationAorDetailResponse.setRecipientTaxId(operationAorDetailResponseDto.getRecipientTaxId());

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        operationAorResponse.setElement(operationAorDetailResponse);
        OperationResponseStatusDto operationResponseStatusDto = operationAorResponseDto.getStatus();
        if(operationResponseStatusDto!=null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationAorResponseDto.setStatus(operationResponseStatusDto);
        operationAorResponse.setResult(operationAorResponseDto.getResult());

        return operationAorResponse;
    }

    public OperationActResponse operationActDtoToResponse(OperationActResponseDto operationActResponseDto) {
        OperationActResponse operationActResponse = new OperationActResponse();
        OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();
        OperationActDetailResponseDto operationActDetailResponseDto = operationActResponseDto.getElement();
        operationActDetailResponse.setOperationId(operationActDetailResponseDto.getOperationId());
        operationActDetailResponse.setOperationStatus(operationActDetailResponseDto.getOperationStatus());
        operationActDetailResponse.setFileKey(operationActDetailResponseDto.getFileKey());
        operationActDetailResponse.setOperationType(operationActDetailResponseDto.getOperationType());
        operationActDetailResponse.setDelegateTaxId(operationActDetailResponseDto.getDelegateTaxId());
        operationActDetailResponse.setIun(operationActDetailResponseDto.getIun());
        operationActDetailResponse.setQrCode(operationActDetailResponseDto.getQrCode());
        operationActDetailResponse.setErrorReason(operationActDetailResponseDto.getErrorReason());
        operationActDetailResponse.setRecipientType(operationActDetailResponseDto.getRecipientType());
        operationActDetailResponse.setUid(operationActDetailResponseDto.getUid());
        if(operationActDetailResponseDto.getOperationEndDate()!=null)
            operationActDetailResponse.setOperationEndDate(new Date(operationActDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
        if(operationActDetailResponseDto.getOperationStartDate()!=null)
            operationActDetailResponse.setOperationStartDate(new Date(operationActDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));
        operationActDetailResponse.setRecipientTaxId(operationActDetailResponseDto.getRecipientTaxId());

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        operationActResponse.setElement(operationActDetailResponse);
        OperationResponseStatusDto operationResponseStatusDto = operationActResponseDto.getStatus();
        if(operationResponseStatusDto!=null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationActResponseDto.setStatus(operationResponseStatusDto);
        operationActResponse.setResult(operationActResponseDto.getResult());

        return operationActResponse;
    }

    public OperationsActDetailsResponse operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto operationsActDetailsResponseDto) {
        OperationsActDetailsResponse operationsActDetailsResponse = new OperationsActDetailsResponse();

        List<OperationActDetailResponse> listOperationActDetailResponse = new ArrayList<>();
        operationsActDetailsResponseDto.getElements().stream().forEach(t -> {
            OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();

            operationActDetailResponse.setOperationId(t.getOperationId());
            operationActDetailResponse.setOperationStatus(t.getOperationStatus());
            operationActDetailResponse.setFileKey(t.getFileKey());
            operationActDetailResponse.setOperationType(t.getOperationType());
            operationActDetailResponse.setDelegateTaxId(t.getDelegateTaxId());
            operationActDetailResponse.setIun(t.getIun());
            operationActDetailResponse.setQrCode(t.getQrCode());
            operationActDetailResponse.setErrorReason(t.getErrorReason());
            operationActDetailResponse.setRecipientType(t.getRecipientType());
            operationActDetailResponse.setUid(t.getUid());
            if(t.getOperationEndDate()!=null)
                operationActDetailResponse.setOperationEndDate(new Date(t.getOperationEndDate().toInstant().toEpochMilli()));
            if(t.getOperationStartDate()!=null)
                operationActDetailResponse.setOperationStartDate(new Date(t.getOperationStartDate().toInstant().toEpochMilli()));
            operationActDetailResponse.setRecipientTaxId(t.getRecipientTaxId());

            listOperationActDetailResponse.add(operationActDetailResponse);
        });

        operationsActDetailsResponse.setElements(listOperationActDetailResponse);
        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        OperationResponseStatusDto operationResponseStatusDto = operationsActDetailsResponseDto.getStatus();
        if(operationResponseStatusDto!=null) {
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
                                                      Boolean result,
                                                      OperationResponseStatusDto operationResponseStatusDto) {

        OperationsResponse operationsResponse = new OperationsResponse();

        operationsResponse.setResult(result);

        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        if(operationResponseStatusDto != null) {
            if (operationResponseStatusDto.getCode() != null) {
                operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
            }
            operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
        }
        operationsResponse.setStatus(operationResponseStatus);

        operationsResponse.setOperations(operationsDetailsResponses);
        return operationsResponse;
    }

    public OperationsDetailsResponse enrichAorData(OperationAorResponseDto operationAorResponseDto) {
        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();

        OperationAorDetailResponseDto operationAorDetailResponseDto = operationAorResponseDto.getElement();

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
        if(operationAorDetailResponseDto.getOperationEndDate()!=null)
            operationsDetailsResponse.setOperationEndDate(new Date(operationAorDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
        if(operationAorDetailResponseDto.getOperationStartDate()!=null)
            operationsDetailsResponse.setOperationStartDate(new Date(operationAorDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));

        return operationsDetailsResponse;

    }

    public OperationsDetailsResponse enrichActData(OperationActResponseDto operationActResponseDto) {
        OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();

        OperationActDetailResponseDto operationActDetailResponseDto = operationActResponseDto.getElement();

        operationsDetailsResponse.setOperationId(operationActDetailResponseDto.getOperationId());
        operationsDetailsResponse.setOperationStatus(operationActDetailResponseDto.getOperationStatus());
        operationsDetailsResponse.setFileKey(operationActDetailResponseDto.getFileKey());
        operationsDetailsResponse.setOperationType(operationActDetailResponseDto.getOperationType());
        operationsDetailsResponse.setIuns(List.of(operationActDetailResponseDto.getIun()));
        operationsDetailsResponse.setRecipientTaxId(operationActDetailResponseDto.getRecipientTaxId());
        operationsDetailsResponse.setDelegateTaxId(operationActDetailResponseDto.getDelegateTaxId());
        operationsDetailsResponse.setQrCode(operationActDetailResponseDto.getQrCode());
        operationsDetailsResponse.setErrorReason(operationActDetailResponseDto.getErrorReason());
        operationsDetailsResponse.setRecipientType(operationActDetailResponseDto.getRecipientType());
        operationsDetailsResponse.setUid(operationActDetailResponseDto.getUid());
        if(operationActDetailResponseDto.getOperationEndDate()!=null)
            operationsDetailsResponse.setOperationEndDate(new Date(operationActDetailResponseDto.getOperationEndDate().toInstant().toEpochMilli()));
        if(operationActDetailResponseDto.getOperationStartDate()!=null)
            operationsDetailsResponse.setOperationStartDate(new Date(operationActDetailResponseDto.getOperationStartDate().toInstant().toEpochMilli()));

        return operationsDetailsResponse;
    }
}
