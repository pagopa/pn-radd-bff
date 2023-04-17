package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class TransactionManagementConverter {

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
}
