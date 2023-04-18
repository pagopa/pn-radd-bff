package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {TransactionManagementConverter.class})
@ExtendWith(SpringExtension.class)
class TransactionManagementConverterTest {
    @Autowired
    private TransactionManagementConverter transactionManagementConverter;

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    void testAbortTransactionRequestToDto2() {
        AbortTransactionRequest abortTransactionRequest = new AbortTransactionRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        abortTransactionRequest.operationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        AbortTransactionRequestDto actualAbortTransactionRequestToDtoResult = transactionManagementConverter
                .abortTransactionRequestToDto(abortTransactionRequest);
        assertEquals("abort", actualAbortTransactionRequestToDtoResult.getReason());
        assertNull(actualAbortTransactionRequestToDtoResult.getOperationId());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    void testAbortTransactionRequestToDto4() {
        AbortTransactionRequest abortTransactionRequest = mock(AbortTransactionRequest.class);
        when(abortTransactionRequest.getOperationId()).thenReturn("42");
        when(abortTransactionRequest.getReason()).thenReturn("Just cause");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(abortTransactionRequest.getOperationDate())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        AbortTransactionRequestDto actualAbortTransactionRequestToDtoResult = transactionManagementConverter
                .abortTransactionRequestToDto(abortTransactionRequest);
        assertEquals("Just cause", actualAbortTransactionRequestToDtoResult.getReason());
        assertEquals("42", actualAbortTransactionRequestToDtoResult.getOperationId());
        verify(abortTransactionRequest).getOperationId();
        verify(abortTransactionRequest).getReason();
        verify(abortTransactionRequest).getOperationDate();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse3() {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.code(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse4() {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.setCode(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse5() {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(transactionResponseStatusDto).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse6() {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_1);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(transactionResponseStatusDto).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#completeTransactionRequestToDto(CompleteTransactionRequest)}
     */
    @Test
    void testCompleteTransactionRequestToDto2() {
        CompleteTransactionRequest completeTransactionRequest = new CompleteTransactionRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        completeTransactionRequest.operationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNull(
                transactionManagementConverter.completeTransactionRequestToDto(completeTransactionRequest).getOperationId());
    }


    /**
     * Method under test: {@link TransactionManagementConverter#completeTransactionRequestToDto(CompleteTransactionRequest)}
     */
    @Test
    void testCompleteTransactionRequestToDto4() {
        CompleteTransactionRequest completeTransactionRequest = mock(CompleteTransactionRequest.class);
        when(completeTransactionRequest.getOperationId()).thenReturn("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(completeTransactionRequest.getOperationDate())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertEquals("42",
                transactionManagementConverter.completeTransactionRequestToDto(completeTransactionRequest).getOperationId());
        verify(completeTransactionRequest).getOperationId();
        verify(completeTransactionRequest).getOperationDate();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse3() {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.code(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse4() {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(transactionResponseStatusDto).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse5() {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_1);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(transactionResponseStatusDto);
        TransactionResponseStatus status = transactionManagementConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(transactionResponseStatusDto).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse3() {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = new StartTransactionResponseStatusDto();
        startTransactionResponseStatusDto.code(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = transactionManagementConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse4() {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = new StartTransactionResponseStatusDto();
        startTransactionResponseStatusDto.setCode(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = transactionManagementConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse5() {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = mock(
                StartTransactionResponseStatusDto.class);
        when(startTransactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(startTransactionResponseStatusDto.getCode()).thenReturn(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = transactionManagementConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(startTransactionResponseStatusDto).getCode();
        verify(startTransactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse6() {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = mock(
                StartTransactionResponseStatusDto.class);
        when(startTransactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(startTransactionResponseStatusDto.getCode())
                .thenReturn(StartTransactionResponseStatusDto.CodeEnum.NUMBER_99);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = transactionManagementConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_99, status.getCode());
        verify(startTransactionResponseStatusDto).getCode();
        verify(startTransactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link TransactionManagementConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    void testActStartTransactionRequestToDto5() {
        ActStartTransactionRequest actStartTransactionRequest = new ActStartTransactionRequest();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        actStartTransactionRequest.operationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PG);
        ActStartTransactionRequestDto actualActStartTransactionRequestToDtoResult = transactionManagementConverter
                .actStartTransactionRequestToDto(actStartTransactionRequest);
        assertNull(actualActStartTransactionRequestToDtoResult.getChecksum());
        assertNull(actualActStartTransactionRequestToDtoResult.getVersionToken());
        assertEquals(ActStartTransactionRequestDto.RecipientTypeEnum.PG,
                actualActStartTransactionRequestToDtoResult.getRecipientType());
        assertNull(actualActStartTransactionRequestToDtoResult.getRecipientTaxId());
        assertNull(actualActStartTransactionRequestToDtoResult.getQrCode());
        assertNull(actualActStartTransactionRequestToDtoResult.getOperationId());
        assertNull(actualActStartTransactionRequestToDtoResult.getFileKey());
        assertNull(actualActStartTransactionRequestToDtoResult.getDelegateTaxId());
    }

    /**
     * Method under test: {@link TransactionManagementConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    void testActStartTransactionRequestToDto6() {
        ActStartTransactionRequest actStartTransactionRequest = mock(ActStartTransactionRequest.class);
        when(actStartTransactionRequest.getOperationId()).thenReturn("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(actStartTransactionRequest.getOperationDate())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        when(actStartTransactionRequest.recipientType(any()))
                .thenReturn(new ActStartTransactionRequest());
        when(actStartTransactionRequest.getRecipientType()).thenReturn(ActStartTransactionRequest.RecipientTypeEnum.PF);
        when(actStartTransactionRequest.getChecksum()).thenReturn("Checksum");
        when(actStartTransactionRequest.getDelegateTaxId()).thenReturn("42");
        when(actStartTransactionRequest.getFileKey()).thenReturn("File Key");
        when(actStartTransactionRequest.getQrCode()).thenReturn("Qr Code");
        when(actStartTransactionRequest.getRecipientTaxId()).thenReturn("42");
        when(actStartTransactionRequest.getVersionToken()).thenReturn("ABC123");
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PG);
        ActStartTransactionRequestDto actualActStartTransactionRequestToDtoResult = transactionManagementConverter
                .actStartTransactionRequestToDto(actStartTransactionRequest);
        assertEquals("Checksum", actualActStartTransactionRequestToDtoResult.getChecksum());
        assertEquals("ABC123", actualActStartTransactionRequestToDtoResult.getVersionToken());
        assertEquals(ActStartTransactionRequestDto.RecipientTypeEnum.PF,
                actualActStartTransactionRequestToDtoResult.getRecipientType());
        assertEquals("42", actualActStartTransactionRequestToDtoResult.getRecipientTaxId());
        assertEquals("Qr Code", actualActStartTransactionRequestToDtoResult.getQrCode());
        assertEquals("42", actualActStartTransactionRequestToDtoResult.getOperationId());
        assertEquals("File Key", actualActStartTransactionRequestToDtoResult.getFileKey());
        assertEquals("42", actualActStartTransactionRequestToDtoResult.getDelegateTaxId());
        verify(actStartTransactionRequest).recipientType(any());
        verify(actStartTransactionRequest).getRecipientType();
        verify(actStartTransactionRequest).getChecksum();
        verify(actStartTransactionRequest).getDelegateTaxId();
        verify(actStartTransactionRequest).getFileKey();
        verify(actStartTransactionRequest).getOperationId();
        verify(actStartTransactionRequest).getQrCode();
        verify(actStartTransactionRequest).getRecipientTaxId();
        verify(actStartTransactionRequest).getVersionToken();
        verify(actStartTransactionRequest).getOperationDate();
    }
}

