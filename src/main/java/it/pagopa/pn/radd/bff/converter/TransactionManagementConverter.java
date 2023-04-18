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

    public AbortTransactionResponse abortTransactionDtoToResponse(AbortTransactionResponseDto dto) {
        TransactionResponseStatus responseStatus = new TransactionResponseStatus();
        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        AbortTransactionResponse response = new AbortTransactionResponse();
        response.setStatus(responseStatus);
        return response;
    }

    public CompleteTransactionRequestDto completeTransactionRequestToDto(CompleteTransactionRequest completeTransactionRequest) {
        CompleteTransactionRequestDto completeTransactionRequestDto = new CompleteTransactionRequestDto();

        completeTransactionRequestDto.setOperationId(completeTransactionRequest.getOperationId());
        completeTransactionRequestDto.setOperationDate(completeTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));

        return completeTransactionRequestDto;
    }

    public CompleteTransactionResponse completeTransactionDtoToResponse(CompleteTransactionResponseDto dto) {
        TransactionResponseStatus responseStatus = new TransactionResponseStatus();

        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(TransactionResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        CompleteTransactionResponse response = new CompleteTransactionResponse();
        response.setStatus(responseStatus);
        return response;
    }

    public StartTransactionResponse startTransactionDtoToResponse(StartTransactionResponseDto dto) {
        StartTransactionResponseStatus responseStatus = new StartTransactionResponseStatus();
        if (dto.getStatus() != null) {
            if (dto.getStatus().getCode() != null) {
                responseStatus.setCode(StartTransactionResponseStatus.CodeEnum.fromValue(dto.getStatus().getCode().getValue()));
            }
            responseStatus.setMessage(dto.getStatus().getMessage());
        }

        StartTransactionResponse response = new StartTransactionResponse();
        response.setStatus(responseStatus);
        return response;
    }

    public ActStartTransactionRequestDto actStartTransactionRequestToDto(ActStartTransactionRequest actStartTransactionRequest) {
        ActStartTransactionRequestDto actStartTransactionRequestDto = new ActStartTransactionRequestDto();

        actStartTransactionRequestDto.setChecksum(actStartTransactionRequest.getChecksum());
        actStartTransactionRequestDto.setFileKey(actStartTransactionRequest.getFileKey());
        actStartTransactionRequestDto.setDelegateTaxId(actStartTransactionRequest.getDelegateTaxId());
        actStartTransactionRequestDto.setQrCode(actStartTransactionRequest.getQrCode());
        actStartTransactionRequestDto.setVersionToken(actStartTransactionRequest.getVersionToken());
        actStartTransactionRequestDto.setRecipientTaxId(actStartTransactionRequest.getRecipientTaxId());
        if (actStartTransactionRequest.getRecipientType() != null) {
            actStartTransactionRequestDto.setRecipientType(ActStartTransactionRequestDto.RecipientTypeEnum.fromValue(actStartTransactionRequest.getRecipientType().getValue()));
        }
        actStartTransactionRequestDto.setOperationId(actStartTransactionRequest.getOperationId());
        if (actStartTransactionRequest.getOperationDate() != null) {
            actStartTransactionRequestDto.setOperationDate(actStartTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));
        }

        return actStartTransactionRequestDto;
    }

    public AorStartTransactionRequestDto aorStartTransactionRequestToDto(AorStartTransactionRequest aorStartTransactionRequest) {
        AorStartTransactionRequestDto aorStartTransactionRequestDto = new AorStartTransactionRequestDto();

        aorStartTransactionRequestDto.setChecksum(aorStartTransactionRequest.getChecksum());
        aorStartTransactionRequestDto.setFileKey(aorStartTransactionRequest.getFileKey());
        aorStartTransactionRequestDto.setDelegateTaxId(aorStartTransactionRequest.getDelegateTaxId());
        aorStartTransactionRequestDto.setVersionToken(aorStartTransactionRequest.getVersionToken());
        if (aorStartTransactionRequest.getRecipientType() != null) {
            aorStartTransactionRequestDto.setRecipientType(AorStartTransactionRequestDto.RecipientTypeEnum.fromValue(aorStartTransactionRequest.getRecipientType().getValue()));
        }
        aorStartTransactionRequestDto.setRecipientTaxId(aorStartTransactionRequest.getRecipientTaxId());
        aorStartTransactionRequestDto.setOperationId(aorStartTransactionRequest.getOperationId());
        if (aorStartTransactionRequest.getOperationDate() != null) {
            aorStartTransactionRequestDto.setOperationDate(aorStartTransactionRequest.getOperationDate().toInstant().atOffset(ZoneOffset.UTC));
        }

        return aorStartTransactionRequestDto;
    }
}
