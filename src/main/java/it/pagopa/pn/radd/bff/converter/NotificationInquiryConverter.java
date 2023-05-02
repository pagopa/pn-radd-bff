package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
            operationAorDetailResponse.setOperationEndDate(new Date(t.getOperationEndDate().toInstant().toEpochMilli()));
            operationAorDetailResponse.setOperationStartDate(new Date(t.getOperationStartDate().toInstant().toEpochMilli()));
            operationAorDetailResponse.setRecipientTaxId(t.getRecipientTaxId());


            listOperationAorDetailResponse.add(operationAorDetailResponse);
        });

        operationsAorDetailsResponse.setElements(listOperationAorDetailResponse);
        OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
        OperationResponseStatusDto operationResponseStatusDto = operationsAorDetailsResponseDto.getStatus();

        operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.fromValue(operationResponseStatusDto.getCode().getValue()));
        operationResponseStatus.setMessage(operationResponseStatusDto.getMessage());
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

    public Mono<OperationsResponse> operationsActDtoToResponse(Flux<OperationActResponseDto> operationsResponseDto) {
        OperationsResponse operationsResponse = new OperationsResponse();

        return Mono.empty();
    }

    public Mono<OperationsResponse> operationsAorDtoToResponse(Flux<OperationAorResponseDto> operationsResponseDto) {
        OperationsResponse operationsResponse = new OperationsResponse();

        return Mono.empty();
    }

    public OperationAorResponse operationAorDtoToResponse(OperationAorResponseDto operationAorResponseDto) {
        return null;
    }

    public OperationActResponse operationActDtoToResponse(OperationActResponseDto operationActResponseDto) {
        return null;
    }

    public OperationsActDetailsResponse operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto operationsActDetailsResponseDto) {
        return null;
    }
}
