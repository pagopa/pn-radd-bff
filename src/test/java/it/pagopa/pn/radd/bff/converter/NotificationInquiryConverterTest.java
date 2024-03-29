package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration (classes = {NotificationInquiryConverter.class})
@ExtendWith (SpringExtension.class)
class NotificationInquiryConverterTest {
    @Autowired
    private NotificationInquiryConverter notificationInquiryConverter;


    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    void testAbortTransactionRequestToDto2 () {
        AbortTransactionRequest abortTransactionRequest = new AbortTransactionRequest();
        abortTransactionRequest
                .operationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        AbortTransactionRequestDto actualAbortTransactionRequestToDtoResult = notificationInquiryConverter
                .abortTransactionRequestToDto(abortTransactionRequest);
        assertEquals("abort", actualAbortTransactionRequestToDtoResult.getReason());
        assertNull(actualAbortTransactionRequestToDtoResult.getOperationId());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    void testAbortTransactionRequestToDto4 () {
        AbortTransactionRequest abortTransactionRequest = mock(AbortTransactionRequest.class);
        when(abortTransactionRequest.getOperationId()).thenReturn("42");
        when(abortTransactionRequest.getReason()).thenReturn("Just cause");
        when(abortTransactionRequest.getOperationDate())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        AbortTransactionRequestDto actualAbortTransactionRequestToDtoResult = notificationInquiryConverter
                .abortTransactionRequestToDto(abortTransactionRequest);
        assertEquals("Just cause", actualAbortTransactionRequestToDtoResult.getReason());
        assertEquals("42", actualAbortTransactionRequestToDtoResult.getOperationId());
        verify(abortTransactionRequest).getOperationId();
        verify(abortTransactionRequest).getReason();
        verify(abortTransactionRequest).getOperationDate();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse3 () {
        TransactionResponseStatusDto status = new TransactionResponseStatusDto();
        status.code(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        assertNull(status2.getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse4 () {
        TransactionResponseStatusDto status = new TransactionResponseStatusDto();
        status.setCode(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        assertNull(status2.getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse5 () {
        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);
        when(abortTransactionResponseDto.getStatus()).thenReturn(new TransactionResponseStatusDto());
        assertNull(notificationInquiryConverter.abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus()
                .getMessage());
        verify(abortTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse6 () {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);
        when(abortTransactionResponseDto.getStatus()).thenReturn(transactionResponseStatusDto);
        TransactionResponseStatus status = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(abortTransactionResponseDto).getStatus();
        verify(transactionResponseStatusDto, atLeast(1)).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse7 () {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.code(TransactionResponseStatusDto.CodeEnum.NUMBER_0);
        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);
        when(abortTransactionResponseDto.getStatus()).thenReturn(transactionResponseStatusDto);
        TransactionResponseStatus status = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertNull(status.getMessage());
        verify(abortTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse8 () {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.code(TransactionResponseStatusDto.CodeEnum.NUMBER_1);
        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);
        when(abortTransactionResponseDto.getStatus()).thenReturn(transactionResponseStatusDto);
        TransactionResponseStatus status = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        assertNull(status.getMessage());
        verify(abortTransactionResponseDto).getStatus();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionRequestToDto(CompleteTransactionRequest)}
     */
    @Test
    void testCompleteTransactionRequestToDto2 () {
        CompleteTransactionRequest completeTransactionRequest = new CompleteTransactionRequest();
        completeTransactionRequest
                .operationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertNull(
                notificationInquiryConverter.completeTransactionRequestToDto(completeTransactionRequest).getOperationId());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionRequestToDto(CompleteTransactionRequest)}
     */
    @Test
    void testCompleteTransactionRequestToDto4 () {
        CompleteTransactionRequest completeTransactionRequest = mock(CompleteTransactionRequest.class);
        when(completeTransactionRequest.getOperationId()).thenReturn("42");
        when(completeTransactionRequest.getOperationDate())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertEquals("42",
                notificationInquiryConverter.completeTransactionRequestToDto(completeTransactionRequest).getOperationId());
        verify(completeTransactionRequest).getOperationId();
        verify(completeTransactionRequest).getOperationDate();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse3 () {
        TransactionResponseStatusDto status = new TransactionResponseStatusDto();
        status.code(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        assertNull(status2.getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse4 () {
        CompleteTransactionResponseDto completeTransactionResponseDto = mock(CompleteTransactionResponseDto.class);
        when(completeTransactionResponseDto.getStatus()).thenReturn(new TransactionResponseStatusDto());
        assertNull(notificationInquiryConverter.completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus()
                .getMessage());
        verify(completeTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse5 () {
        TransactionResponseStatusDto transactionResponseStatusDto = mock(TransactionResponseStatusDto.class);
        when(transactionResponseStatusDto.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);
        when(transactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        CompleteTransactionResponseDto completeTransactionResponseDto = mock(CompleteTransactionResponseDto.class);
        when(completeTransactionResponseDto.getStatus()).thenReturn(transactionResponseStatusDto);
        TransactionResponseStatus status = notificationInquiryConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        assertEquals("Not all who wander are lost", status.getMessage());
        verify(completeTransactionResponseDto).getStatus();
        verify(transactionResponseStatusDto, atLeast(1)).getCode();
        verify(transactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse6 () {
        TransactionResponseStatusDto transactionResponseStatusDto = new TransactionResponseStatusDto();
        transactionResponseStatusDto.code(TransactionResponseStatusDto.CodeEnum.NUMBER_1);
        CompleteTransactionResponseDto completeTransactionResponseDto = mock(CompleteTransactionResponseDto.class);
        when(completeTransactionResponseDto.getStatus()).thenReturn(transactionResponseStatusDto);
        TransactionResponseStatus status = notificationInquiryConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        assertNull(status.getMessage());
        verify(completeTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse () {
        assertNull(
                notificationInquiryConverter.startTransactionDtoToResponse(new StartTransactionResponseDto()).getUrlList());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse3 () {
        StartTransactionResponseStatusDto status = new StartTransactionResponseStatusDto();
        status.code(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(status);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status2 = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status2.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse4 () {
        StartTransactionResponseStatusDto status = new StartTransactionResponseStatusDto();
        status.setCode(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(status);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status2 = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status2.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse5 () {
        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);
        when(startTransactionResponseDto.getStatus()).thenReturn(new StartTransactionResponseStatusDto());
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        assertNull(actualStartTransactionDtoToResponseResult.getStatus().getMessage());
        verify(startTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse6 () {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = mock(
                StartTransactionResponseStatusDto.class);
        when(startTransactionResponseStatusDto.getCode()).thenReturn(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);
        when(startTransactionResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);
        when(startTransactionResponseDto.getStatus()).thenReturn(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(startTransactionResponseDto).getStatus();
        verify(startTransactionResponseStatusDto, atLeast(1)).getCode();
        verify(startTransactionResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse7 () {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = new StartTransactionResponseStatusDto();
        startTransactionResponseStatusDto.code(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);
        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);
        when(startTransactionResponseDto.getStatus()).thenReturn(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(startTransactionResponseDto).getStatus();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse8 () {
        StartTransactionResponseStatusDto startTransactionResponseStatusDto = new StartTransactionResponseStatusDto();
        startTransactionResponseStatusDto.code(StartTransactionResponseStatusDto.CodeEnum.NUMBER_99);
        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);
        when(startTransactionResponseDto.getStatus()).thenReturn(startTransactionResponseStatusDto);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status = actualStartTransactionDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_99, status.getCode());
        verify(startTransactionResponseDto).getStatus();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    void testActStartTransactionRequestToDto5 () {
        ActStartTransactionRequest actStartTransactionRequest = new ActStartTransactionRequest();
        actStartTransactionRequest
                .operationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PG);
        ActStartTransactionRequestDto actualActStartTransactionRequestToDtoResult = notificationInquiryConverter
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
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    void testActStartTransactionRequestToDto6 () {
        ActStartTransactionRequest actStartTransactionRequest = mock(ActStartTransactionRequest.class);
        when(actStartTransactionRequest.getOperationId()).thenReturn("42");
        when(actStartTransactionRequest.getOperationDate())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(actStartTransactionRequest.recipientType(Mockito.any()))
                .thenReturn(new ActStartTransactionRequest());
        when(actStartTransactionRequest.getRecipientType()).thenReturn(ActStartTransactionRequest.RecipientTypeEnum.PF);
        when(actStartTransactionRequest.getChecksum()).thenReturn("Checksum");
        when(actStartTransactionRequest.getDelegateTaxId()).thenReturn("42");
        when(actStartTransactionRequest.getFileKey()).thenReturn("File Key");
        when(actStartTransactionRequest.getQrCode()).thenReturn("Qr Code");
        when(actStartTransactionRequest.getRecipientTaxId()).thenReturn("42");
        when(actStartTransactionRequest.getVersionToken()).thenReturn("ABC123");
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PG);
        ActStartTransactionRequestDto actualActStartTransactionRequestToDtoResult = notificationInquiryConverter
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
        verify(actStartTransactionRequest).recipientType(Mockito.any());
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

    /**
     * Method under test: {@link NotificationInquiryConverter#aorStartTransactionRequestToDto(AorStartTransactionRequest)}
     */
    @Test
    void testAorStartTransactionRequestToDto5 () {
        AorStartTransactionRequest aorStartTransactionRequest = new AorStartTransactionRequest();
        aorStartTransactionRequest
                .operationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        aorStartTransactionRequest.recipientType(AorStartTransactionRequest.RecipientTypeEnum.PG);
        AorStartTransactionRequestDto actualAorStartTransactionRequestToDtoResult = notificationInquiryConverter
                .aorStartTransactionRequestToDto(aorStartTransactionRequest);
        assertNull(actualAorStartTransactionRequestToDtoResult.getChecksum());
        assertNull(actualAorStartTransactionRequestToDtoResult.getVersionToken());
        assertEquals(AorStartTransactionRequestDto.RecipientTypeEnum.PG,
                actualAorStartTransactionRequestToDtoResult.getRecipientType());
        assertNull(actualAorStartTransactionRequestToDtoResult.getRecipientTaxId());
        assertNull(actualAorStartTransactionRequestToDtoResult.getOperationId());
        assertNull(actualAorStartTransactionRequestToDtoResult.getFileKey());
        assertNull(actualAorStartTransactionRequestToDtoResult.getDelegateTaxId());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#aorStartTransactionRequestToDto(AorStartTransactionRequest)}
     */
    @Test
    void testAorStartTransactionRequestToDto6 () {
        AorStartTransactionRequest aorStartTransactionRequest = mock(AorStartTransactionRequest.class);
        when(aorStartTransactionRequest.getOperationId()).thenReturn("42");
        when(aorStartTransactionRequest.getRecipientTaxId()).thenReturn("42");
        when(aorStartTransactionRequest.getOperationDate())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(aorStartTransactionRequest.recipientType(Mockito.<AorStartTransactionRequest.RecipientTypeEnum>any()))
                .thenReturn(new AorStartTransactionRequest());
        when(aorStartTransactionRequest.getRecipientType()).thenReturn(AorStartTransactionRequest.RecipientTypeEnum.PF);
        when(aorStartTransactionRequest.getChecksum()).thenReturn("Checksum");
        when(aorStartTransactionRequest.getDelegateTaxId()).thenReturn("42");
        when(aorStartTransactionRequest.getFileKey()).thenReturn("File Key");
        when(aorStartTransactionRequest.getVersionToken()).thenReturn("ABC123");
        aorStartTransactionRequest.recipientType(AorStartTransactionRequest.RecipientTypeEnum.PG);
        AorStartTransactionRequestDto actualAorStartTransactionRequestToDtoResult = notificationInquiryConverter
                .aorStartTransactionRequestToDto(aorStartTransactionRequest);
        assertEquals("Checksum", actualAorStartTransactionRequestToDtoResult.getChecksum());
        assertEquals("ABC123", actualAorStartTransactionRequestToDtoResult.getVersionToken());
        assertEquals(AorStartTransactionRequestDto.RecipientTypeEnum.PF,
                actualAorStartTransactionRequestToDtoResult.getRecipientType());
        assertEquals("42", actualAorStartTransactionRequestToDtoResult.getRecipientTaxId());
        assertEquals("42", actualAorStartTransactionRequestToDtoResult.getOperationId());
        assertEquals("File Key", actualAorStartTransactionRequestToDtoResult.getFileKey());
        assertEquals("42", actualAorStartTransactionRequestToDtoResult.getDelegateTaxId());
        verify(aorStartTransactionRequest).recipientType(Mockito.<AorStartTransactionRequest.RecipientTypeEnum>any());
        verify(aorStartTransactionRequest).getRecipientType();
        verify(aorStartTransactionRequest).getChecksum();
        verify(aorStartTransactionRequest).getDelegateTaxId();
        verify(aorStartTransactionRequest).getFileKey();
        verify(aorStartTransactionRequest).getOperationId();
        verify(aorStartTransactionRequest).getRecipientTaxId();
        verify(aorStartTransactionRequest).getVersionToken();
        verify(aorStartTransactionRequest).getOperationDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse () {
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
        OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
        OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
        operationsAorDetailsResponseDto.setResult(true);
        operationsAorDetailsResponseDto.setStatus(operationResponseStatusDto);
        operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
        operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());

        operationsAorDetailsResponseDto.setElements(List.of(operationAorDetailResponseDto));

        operationResponseStatusDto.code(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse2 () {
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(new OperationsAorDetailsResponseDto(), "taxId", Map.of("", ""));
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getElements().isEmpty());
        assertNull(actualOperationsAorDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse3 () {
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
        operationsAorDetailsResponseDto.addElementsItem(new OperationAorDetailResponseDto());
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, null, Map.of("", ""));
        assertEquals(1, actualOperationsAorDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsAorDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse4 () {
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
        ArrayList<OperationAorDetailResponseDto> elements = new ArrayList<>();
        operationsAorDetailsResponseDto.elements(elements);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(elements, actualOperationsAorDetailsDtoToResponseResult.getElements());
        assertNull(actualOperationsAorDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse6 () {
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(operationAorDetailResponseDtoList, actualOperationsAorDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        assertNull(actualOperationsAorDetailsDtoToResponseResult.getStatus().getMessage());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto, atLeast(1)).getElements();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse7 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(operationAorDetailResponseDtoList, actualOperationsAorDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse8 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");

        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        operationAorDetailResponseDtoList.add(new OperationAorDetailResponseDto());
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(1, actualOperationsAorDetailsDtoToResponseResult.getElements().size());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }
    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse11 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());

        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        operationAorDetailResponseDtoList.add(operationAorDetailResponseDto);
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(1, actualOperationsAorDetailsDtoToResponseResult.getElements().size());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
        verify(operationAorDetailResponseDto, times(2)).getDelegateTaxId();
        verify(operationAorDetailResponseDto).getErrorReason();
        verify(operationAorDetailResponseDto).getFileKey();
        verify(operationAorDetailResponseDto).getOperationId();
        verify(operationAorDetailResponseDto).getOperationStatus();
        verify(operationAorDetailResponseDto).getOperationType();
        verify(operationAorDetailResponseDto).getQrCode();
        verify(operationAorDetailResponseDto).getRecipientType();
        verify(operationAorDetailResponseDto).getUid();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationStartDate();
        verify(operationAorDetailResponseDto).getIuns();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    void testFilterRequestToDto3 () {
        FilterRequest filterRequest = mock(FilterRequest.class);
        when(filterRequest.getTo())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(filterRequest.from(Mockito.any())).thenReturn(new FilterRequest());
        when(filterRequest.to(Mockito.any())).thenReturn(new FilterRequest());
        when(filterRequest.getFrom())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        FilterRequestDto actualFilterRequestToDtoResult = notificationInquiryConverter.filterRequestToDto(filterRequest);
        OffsetDateTime expectedTo = actualFilterRequestToDtoResult.getFrom();
        assertEquals(expectedTo, actualFilterRequestToDtoResult.getTo());
        verify(filterRequest, atLeast(1)).getFrom();
        verify(filterRequest, atLeast(1)).getTo();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    void testFilterRequestToDto4 () {
        java.sql.Date from = mock(java.sql.Date.class);
        when(from.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        FilterRequest filterRequest = new FilterRequest();
        filterRequest.to(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        filterRequest.from(from);
        FilterRequestDto actualFilterRequestToDtoResult = notificationInquiryConverter.filterRequestToDto(filterRequest);
        OffsetDateTime expectedTo = actualFilterRequestToDtoResult.getFrom();
        assertEquals(expectedTo, actualFilterRequestToDtoResult.getTo());
        verify(from).toInstant();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    void testFilterRequestToDto5 () {
        // Arrange
        java.sql.Date from = mock(java.sql.Date.class);
        when(from.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        FilterRequest filterRequest = new FilterRequest();
        filterRequest.to(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        filterRequest.from(from);

        // Act
        FilterRequestDto actualFilterRequestToDtoResult = notificationInquiryConverter.filterRequestToDto(filterRequest);

        // Assert
        OffsetDateTime expectedTo = actualFilterRequestToDtoResult.getFrom();
        assertEquals(expectedTo, actualFilterRequestToDtoResult.getTo());
        verify(from).toInstant();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse () {
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        assertNull(
                notificationInquiryConverter.operationAorDtoToResponse(operationAorResponseDto, new HashMap<>()).getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse2 () {
        // Arrange
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
        operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
        operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
        operationAorResponseDto.element(operationAorDetailResponseDto);
        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>(0));

        // Assert
        assertNull(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIuns());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertNull(operationAorResponseDto.getStatus());
        assertNotNull(element.getOperationStartDate());
        assertNotNull(element.getOperationEndDate());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse3 () {
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.element(new OperationAorDetailResponseDto());
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertNull(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIuns());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        assertNull(operationAorResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse5 () {
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationAorResponseDto.getElement()).thenReturn(new OperationAorDetailResponseDto());
        when(operationAorResponseDto.getResult()).thenReturn(true);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        assertNull(actualOperationAorDtoToResponseResult.getStatus().getMessage());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getIuns());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse6 () {
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(null);
        when(operationAorResponseDto.getElement()).thenReturn(new OperationAorDetailResponseDto());
        when(operationAorResponseDto.getResult()).thenReturn(true);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getIuns());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse7 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getResult()).thenReturn(true);
        doNothing().when(operationAorResponseDto).setStatus(Mockito.any());
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse8 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getResult()).thenReturn(true);
        doNothing().when(operationAorResponseDto).setStatus(Mockito.any());
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);

        HashMap<String, String> denominations = new HashMap<>();
        denominations.put("42", "Value");
        denominations.put("Key", "42");
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, denominations);
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse9 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getElement()).thenReturn(new OperationAorDetailResponseDto());
        when(operationAorResponseDto.getResult()).thenReturn(true);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationAorDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getIuns());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse10 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getResult()).thenReturn(false);
        doNothing().when(operationAorResponseDto).setStatus(Mockito.any());
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertFalse(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();

        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse11 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getResult()).thenReturn(false);
        doNothing().when(operationAorResponseDto).setStatus(Mockito.any());
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);

        HashMap<String, String> denominations = new HashMap<>();
        denominations.put("42", "Value");
        denominations.put("Key", "42");
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, denominations);
        assertFalse(actualOperationAorDtoToResponseResult.getResult());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse12 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        when(operationAorResponseDto.getResult()).thenReturn(true);
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, new HashMap<>());
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationAorDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertEquals("Recipient Type", element.getRecipientType());
        assertEquals("Qr Code", element.getQrCode());
        assertEquals("Operation Type", element.getOperationType());
        verify(operationAorDetailResponseDto).getUid();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationStartDate();
        verify(operationAorDetailResponseDto).getIuns();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto, Map)}
     */
    @Test
    void testOperationAorDtoToResponse13 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        when(operationAorResponseDto.getResult()).thenReturn(true);

        HashMap<String, String> denominations = new HashMap<>();
        denominations.put("42", "Value");
        denominations.put("Key", "42");
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto, denominations);
        assertTrue(actualOperationAorDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationAorDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationAorDetailResponse element = actualOperationAorDtoToResponseResult.getElement();
        assertEquals("Recipient Type", element.getRecipientType());
        assertEquals("File Key", element.getFileKey());
        assertEquals("An error occurred", element.getErrorReason());
        assertEquals("Value", element.getDelegateTaxId());
        assertEquals("1234", element.getUid());
        verify(operationAorResponseDto).getElement();
        verify(operationAorResponseDto).getStatus();
        verify(operationAorDetailResponseDto).getOperationType();
        verify(operationAorDetailResponseDto).getQrCode();
        verify(operationAorDetailResponseDto, atLeast(1)).getRecipientTaxId();
        verify(operationAorDetailResponseDto).getRecipientType();
        verify(operationAorDetailResponseDto).getUid();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationStartDate();
        verify(operationAorDetailResponseDto).getIuns();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse () {
        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        assertNull(
                notificationInquiryConverter.operationActDtoToResponse(operationActResponseDto, new HashMap<>()).getResult());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse2 () {
        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.element(new OperationActDetailResponseDto());
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        assertNull(operationActResponseDto.getStatus());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse4 () {
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationActResponseDto.getResult()).thenReturn(true);
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse5 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getResult()).thenReturn(true);
        doNothing().when(operationActResponseDto).setStatus(Mockito.any());
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse6 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getResult()).thenReturn(false);
        doNothing().when(operationActResponseDto).setStatus(Mockito.any());
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertFalse(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse7 () {
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getResult()).thenReturn(false);
        doNothing().when(operationActResponseDto).setStatus(Mockito.any());
        when(operationActResponseDto.getElement()).thenReturn(operationActDetailResponseDto);
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertFalse(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse8 () {
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getResult()).thenReturn(false);
        doNothing().when(operationActResponseDto).setStatus(Mockito.any());
        when(operationActResponseDto.getElement()).thenReturn(operationActDetailResponseDto);

        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        deanonymizedTaxIds.put("42", "Value");
        deanonymizedTaxIds.put("Key", "42");
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, deanonymizedTaxIds);
        assertFalse(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse9 () {
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        when(operationActResponseDto.getResult()).thenReturn(true);
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        assertNull(actualOperationActDtoToResponseResult.getStatus().getMessage());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse10 () {
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(null);
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        when(operationActResponseDto.getResult()).thenReturn(true);
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse11 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        when(operationActResponseDto.getResult()).thenReturn(true);
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationActDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getUid());
        verify(operationActResponseDto).getElement();
        verify(operationActResponseDto).getStatus();
        verify(operationActResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse12 () {
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getElement()).thenReturn(operationActDetailResponseDto);
        when(operationActResponseDto.getResult()).thenReturn(true);
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, new HashMap<>());
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationActDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertEquals("Recipient Type", element.getRecipientType());
        verify(operationActDetailResponseDto).getRecipientType();
        verify(operationActDetailResponseDto).getUid();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto, Map)}
     */
    @Test
    void testOperationActDtoToResponse13 () {
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationActResponseDto.getElement()).thenReturn(operationActDetailResponseDto);
        when(operationActResponseDto.getResult()).thenReturn(true);

        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        deanonymizedTaxIds.put("42", "Value");
        deanonymizedTaxIds.put("Key", "42");
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto, deanonymizedTaxIds);
        assertTrue(actualOperationActDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationActDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertEquals("Recipient Type", element.getRecipientType());
        assertEquals("Value", element.getRecipientTaxId());
        verify(operationActDetailResponseDto).getRecipientType();
        verify(operationActDetailResponseDto).getUid();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse () {
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(new OperationsActDetailsResponseDto(), "taxId", Map.of("", ""));
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getElements().isEmpty());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse2 () {
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.addElementsItem(new OperationActDetailResponseDto());
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse3 () {
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        ArrayList<OperationActDetailResponseDto> elements = new ArrayList<>();
        operationsActDetailsResponseDto.elements(elements);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(elements, actualOperationsActDetailsDtoToResponseResult.getElements());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse4 () {
        // Arrange
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getElements().isEmpty());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse5 () {
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = mock(OperationsActDetailsResponseDto.class);
        when(operationsActDetailsResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationsActDetailsResponseDto.getResult()).thenReturn(true);
        ArrayList<OperationActDetailResponseDto> operationActDetailResponseDtoList = new ArrayList<>();
        when(operationsActDetailsResponseDto.getElements()).thenReturn(operationActDetailResponseDtoList);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(operationActDetailResponseDtoList, actualOperationsActDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getResult());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getStatus().getMessage());
        verify(operationsActDetailsResponseDto).getStatus();
        verify(operationsActDetailsResponseDto).getResult();
        verify(operationsActDetailsResponseDto, atLeast(1)).getElements();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse6 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = mock(OperationsActDetailsResponseDto.class);
        when(operationsActDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsActDetailsResponseDto.getResult()).thenReturn(true);
        ArrayList<OperationActDetailResponseDto> operationActDetailResponseDtoList = new ArrayList<>();
        when(operationsActDetailsResponseDto.getElements()).thenReturn(operationActDetailResponseDtoList);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(operationActDetailResponseDtoList, actualOperationsActDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsActDetailsResponseDto).getStatus();
        verify(operationsActDetailsResponseDto).getResult();
        verify(operationsActDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse7 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");

        ArrayList<OperationActDetailResponseDto> operationActDetailResponseDtoList = new ArrayList<>();
        operationActDetailResponseDtoList.add(new OperationActDetailResponseDto());
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = mock(OperationsActDetailsResponseDto.class);
        when(operationsActDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsActDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsActDetailsResponseDto.getElements()).thenReturn(operationActDetailResponseDtoList);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsActDetailsResponseDto).getStatus();
        verify(operationsActDetailsResponseDto).getResult();
        verify(operationsActDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }
    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse10 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));

        ArrayList<OperationActDetailResponseDto> operationActDetailResponseDtoList = new ArrayList<>();
        operationActDetailResponseDtoList.add(operationActDetailResponseDto);
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = mock(OperationsActDetailsResponseDto.class);
        when(operationsActDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsActDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsActDetailsResponseDto.getElements()).thenReturn(operationActDetailResponseDtoList);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "taxId", Map.of("", ""));
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsActDetailsResponseDto).getStatus();
        verify(operationsActDetailsResponseDto).getResult();
        verify(operationsActDetailsResponseDto, atLeast(1)).getElements();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
        verify(operationActDetailResponseDto, times(2)).getDelegateTaxId();
        verify(operationActDetailResponseDto).getErrorReason();
        verify(operationActDetailResponseDto).getFileKey();
        verify(operationActDetailResponseDto).getIun();
        verify(operationActDetailResponseDto).getOperationId();
        verify(operationActDetailResponseDto).getOperationStatus();
        verify(operationActDetailResponseDto).getOperationType();
        verify(operationActDetailResponseDto).getQrCode();
        verify(operationActDetailResponseDto).getRecipientType();
        verify(operationActDetailResponseDto).getUid();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse11 () {
        // Arrange
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.addElementsItem(new OperationActDetailResponseDto());

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse13 () {
        // Arrange
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.status(new OperationResponseStatusDto());
        operationsActDetailsResponseDto.addElementsItem(new OperationActDetailResponseDto());

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getStatus().getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse14 () {
        // Arrange
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        ArrayList<OperationActDetailResponseDto> elements = new ArrayList<>();
        operationsActDetailsResponseDto.elements(elements);

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(elements, actualOperationsActDetailsDtoToResponseResult.getElements());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }
    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse16 () {
        // Arrange
        OperationActDetailResponseDto elementsItem = new OperationActDetailResponseDto();
        elementsItem.delegateTaxId("42");

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.addElementsItem(elementsItem);

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse17 () {
        // Arrange
        OperationActDetailResponseDto elementsItem = new OperationActDetailResponseDto();
        elementsItem.operationStartDate(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.addElementsItem(elementsItem);

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse18 () {
        // Arrange
        OperationActDetailResponseDto elementsItem = new OperationActDetailResponseDto();
        elementsItem.operationEndDate(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.addElementsItem(elementsItem);

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse19 () {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.code(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.status(status);
        operationsActDetailsResponseDto.addElementsItem(new OperationActDetailResponseDto());

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status2 = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertNull(status2.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto, String, Map)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse20 () {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        operationsActDetailsResponseDto.status(status);
        operationsActDetailsResponseDto.addElementsItem(new OperationActDetailResponseDto());

        // Act
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto, "42", new HashMap<>());

        // Assert
        assertEquals(1, actualOperationsActDetailsDtoToResponseResult.getElements().size());
        assertNull(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status2 = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertNull(status2.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Map, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse () {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter.operationsDtoToResponse(
                operationsDetailsResponses, deanonymizedTaxIds, true, new OperationResponseStatusDto());
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        assertNull(actualOperationsDtoToResponseResult.getStatus().getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Map, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse2 () {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        operationsDetailsResponses.add(new OperationsDetailsResponse());
        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter.operationsDtoToResponse(
                operationsDetailsResponses, deanonymizedTaxIds, true, new OperationResponseStatusDto());
        assertEquals(1, actualOperationsDtoToResponseResult.getOperations().size());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        assertNull(actualOperationsDtoToResponseResult.getStatus().getMessage());
    }
    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Map, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse4 () {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, new HashMap<>(), true, null);
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Map, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse5 () {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, deanonymizedTaxIds, true, operationResponseStatusDto);
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Map, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse6 () {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        HashMap<String, String> deanonymizedTaxIds = new HashMap<>();
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, deanonymizedTaxIds, true, operationResponseStatusDto);
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData () {
        assertNull(notificationInquiryConverter.enrichAorData(new OperationAorResponseDto()).getIuns());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData2 () {
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.element(new OperationAorDetailResponseDto());
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertNull(actualEnrichAorDataResult.getDelegateTaxId());
        assertNull(actualEnrichAorDataResult.getUid());
        assertNull(actualEnrichAorDataResult.getRecipientType());
        assertNull(actualEnrichAorDataResult.getRecipientTaxId());
        assertNull(actualEnrichAorDataResult.getQrCode());
        assertNull(actualEnrichAorDataResult.getOperationType());
        assertNull(actualEnrichAorDataResult.getOperationStatus());
        assertNull(actualEnrichAorDataResult.getOperationId());
        assertNull(actualEnrichAorDataResult.getIuns());
        assertNull(actualEnrichAorDataResult.getFileKey());
        assertNull(actualEnrichAorDataResult.getErrorReason());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData4 () {
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getElement()).thenReturn(new OperationAorDetailResponseDto());
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertNull(actualEnrichAorDataResult.getDelegateTaxId());
        assertNull(actualEnrichAorDataResult.getUid());
        assertNull(actualEnrichAorDataResult.getRecipientType());
        assertNull(actualEnrichAorDataResult.getRecipientTaxId());
        assertNull(actualEnrichAorDataResult.getQrCode());
        assertNull(actualEnrichAorDataResult.getOperationType());
        assertNull(actualEnrichAorDataResult.getOperationStatus());
        assertNull(actualEnrichAorDataResult.getOperationId());
        assertNull(actualEnrichAorDataResult.getIuns());
        assertNull(actualEnrichAorDataResult.getFileKey());
        assertNull(actualEnrichAorDataResult.getErrorReason());
        verify(operationAorResponseDto).getElement();
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData5 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertEquals("An error occurred", actualEnrichAorDataResult.getErrorReason());
        assertEquals("1234", actualEnrichAorDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichAorDataResult.getRecipientType());
        assertEquals("Qr Code", actualEnrichAorDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichAorDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichAorDataResult.getOperationStatus());
        assertEquals("42", actualEnrichAorDataResult.getOperationId());
        assertTrue(actualEnrichAorDataResult.getIuns().isEmpty());
        assertEquals("File Key", actualEnrichAorDataResult.getFileKey());
        verify(operationAorResponseDto).getElement();
        verify(operationAorDetailResponseDto).getErrorReason();
        verify(operationAorDetailResponseDto).getFileKey();
        verify(operationAorDetailResponseDto).getOperationId();
        verify(operationAorDetailResponseDto).getOperationStatus();
        verify(operationAorDetailResponseDto).getOperationType();
        verify(operationAorDetailResponseDto).getQrCode();
        verify(operationAorDetailResponseDto).getRecipientType();
        verify(operationAorDetailResponseDto).getUid();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationStartDate();
        verify(operationAorDetailResponseDto).getIuns();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData6 () {
        OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);
        when(operationAorDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationAorDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationAorDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationAorDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationAorDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationAorDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationAorDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationAorDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationAorDetailResponseDto.getUid()).thenReturn("1234");
        when(operationAorDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationAorDetailResponseDto.getIuns()).thenReturn(new ArrayList<>());
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getElement()).thenReturn(operationAorDetailResponseDto);
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertEquals("42", actualEnrichAorDataResult.getDelegateTaxId());
        assertEquals("1234", actualEnrichAorDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichAorDataResult.getRecipientType());
        assertEquals("42", actualEnrichAorDataResult.getRecipientTaxId());
        assertEquals("Qr Code", actualEnrichAorDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichAorDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichAorDataResult.getOperationStatus());
        assertEquals("42", actualEnrichAorDataResult.getOperationId());
        assertTrue(actualEnrichAorDataResult.getIuns().isEmpty());
        assertEquals("File Key", actualEnrichAorDataResult.getFileKey());
        assertEquals("An error occurred", actualEnrichAorDataResult.getErrorReason());
        verify(operationAorResponseDto).getElement();
        verify(operationAorDetailResponseDto).getDelegateTaxId();
        verify(operationAorDetailResponseDto).getErrorReason();
        verify(operationAorDetailResponseDto).getFileKey();
        verify(operationAorDetailResponseDto).getOperationId();
        verify(operationAorDetailResponseDto).getOperationStatus();
        verify(operationAorDetailResponseDto).getOperationType();
        verify(operationAorDetailResponseDto).getQrCode();
        verify(operationAorDetailResponseDto).getRecipientTaxId();
        verify(operationAorDetailResponseDto).getRecipientType();
        verify(operationAorDetailResponseDto).getUid();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationAorDetailResponseDto, atLeast(1)).getOperationStartDate();
        verify(operationAorDetailResponseDto).getIuns();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData () {
        assertNull(notificationInquiryConverter.enrichActData(new OperationActResponseDto()).getIuns());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData3 () {
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getElement()).thenReturn(new OperationActDetailResponseDto());
        OperationsDetailsResponse actualEnrichActDataResult = notificationInquiryConverter
                .enrichActData(operationActResponseDto);
        assertNull(actualEnrichActDataResult.getDelegateTaxId());
        assertNull(actualEnrichActDataResult.getUid());
        assertNull(actualEnrichActDataResult.getRecipientType());
        assertNull(actualEnrichActDataResult.getRecipientTaxId());
        assertNull(actualEnrichActDataResult.getQrCode());
        assertNull(actualEnrichActDataResult.getOperationType());
        assertNull(actualEnrichActDataResult.getOperationStatus());
        assertNull(actualEnrichActDataResult.getOperationId());
        assertNull(actualEnrichActDataResult.getIuns());
        assertNull(actualEnrichActDataResult.getFileKey());
        assertNull(actualEnrichActDataResult.getErrorReason());
        verify(operationActResponseDto).getElement();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData4 () {
        OperationActDetailResponseDto operationActDetailResponseDto = mock(OperationActDetailResponseDto.class);
        when(operationActDetailResponseDto.getDelegateTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getErrorReason()).thenReturn("An error occurred");
        when(operationActDetailResponseDto.getFileKey()).thenReturn("File Key");
        when(operationActDetailResponseDto.getIun()).thenReturn("Iun");
        when(operationActDetailResponseDto.getOperationId()).thenReturn("42");
        when(operationActDetailResponseDto.getOperationStatus()).thenReturn("Operation Status");
        when(operationActDetailResponseDto.getOperationType()).thenReturn("Operation Type");
        when(operationActDetailResponseDto.getQrCode()).thenReturn("Qr Code");
        when(operationActDetailResponseDto.getRecipientTaxId()).thenReturn("42");
        when(operationActDetailResponseDto.getRecipientType()).thenReturn("Recipient Type");
        when(operationActDetailResponseDto.getUid()).thenReturn("1234");
        when(operationActDetailResponseDto.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(operationActDetailResponseDto.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);
        when(operationActResponseDto.getElement()).thenReturn(operationActDetailResponseDto);
        OperationsDetailsResponse actualEnrichActDataResult = notificationInquiryConverter
                .enrichActData(operationActResponseDto);
        assertEquals("42", actualEnrichActDataResult.getDelegateTaxId());
        assertEquals("1234", actualEnrichActDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichActDataResult.getRecipientType());
        assertEquals("42", actualEnrichActDataResult.getRecipientTaxId());
        assertEquals("Qr Code", actualEnrichActDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichActDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichActDataResult.getOperationStatus());
        assertEquals("42", actualEnrichActDataResult.getOperationId());
        assertEquals(1, actualEnrichActDataResult.getIuns().size());
        assertEquals("File Key", actualEnrichActDataResult.getFileKey());
        assertEquals("An error occurred", actualEnrichActDataResult.getErrorReason());
        verify(operationActResponseDto).getElement();
        verify(operationActDetailResponseDto).getDelegateTaxId();
        verify(operationActDetailResponseDto).getErrorReason();
        verify(operationActDetailResponseDto).getFileKey();
        verify(operationActDetailResponseDto, atLeast(1)).getIun();
        verify(operationActDetailResponseDto).getOperationId();
        verify(operationActDetailResponseDto).getOperationStatus();
        verify(operationActDetailResponseDto).getOperationType();
        verify(operationActDetailResponseDto).getQrCode();
        verify(operationActDetailResponseDto).getRecipientTaxId();
        verify(operationActDetailResponseDto).getRecipientType();
        verify(operationActDetailResponseDto).getUid();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationEndDate();
        verify(operationActDetailResponseDto, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#noAssociatedOperationFoundResponse(OperationsResponseDto)}
     */
    @Test
    void testNoAssociatedOperationFoundResponse () {
        OperationsResponse actualNoAssociatedOperationFoundResponseResult = notificationInquiryConverter
                .noAssociatedOperationFoundResponse(new OperationsResponseDto());
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getOperations().isEmpty());
        assertNull(actualNoAssociatedOperationFoundResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#noAssociatedOperationFoundResponse(OperationsResponseDto)}
     */
    @Test
    public void testNoAssociatedOperationFoundResponse3 () {
        OperationsResponseDto operationsResponseDto = mock(OperationsResponseDto.class);
        when(operationsResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationsResponseDto.getResult()).thenReturn(true);
        OperationsResponse actualNoAssociatedOperationFoundResponseResult = notificationInquiryConverter
                .noAssociatedOperationFoundResponse(operationsResponseDto);
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getOperations().isEmpty());
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getResult());
        verify(operationsResponseDto, atLeast(1)).getStatus();
        verify(operationsResponseDto).getResult();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#noAssociatedOperationFoundResponse(OperationsResponseDto)}
     */
    @Test
    public void testNoAssociatedOperationFoundResponse4 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        OperationsResponseDto operationsResponseDto = mock(OperationsResponseDto.class);
        when(operationsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsResponseDto.getResult()).thenReturn(true);
        OperationsResponse actualNoAssociatedOperationFoundResponseResult = notificationInquiryConverter
                .noAssociatedOperationFoundResponse(operationsResponseDto);
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getOperations().isEmpty());
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getResult());
        OperationResponseStatus status = actualNoAssociatedOperationFoundResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsResponseDto, atLeast(1)).getStatus();
        verify(operationsResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#noAssociatedOperationFoundResponse(OperationsResponseDto)}
     */
    @Test
    public void testNoAssociatedOperationFoundResponse5 () {
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        OperationsResponseDto operationsResponseDto = mock(OperationsResponseDto.class);
        when(operationsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsResponseDto.getResult()).thenReturn(true);
        OperationsResponse actualNoAssociatedOperationFoundResponseResult = notificationInquiryConverter
                .noAssociatedOperationFoundResponse(operationsResponseDto);
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getOperations().isEmpty());
        assertTrue(actualNoAssociatedOperationFoundResponseResult.getResult());
        OperationResponseStatus status = actualNoAssociatedOperationFoundResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        verify(operationsResponseDto, atLeast(1)).getStatus();
        verify(operationsResponseDto).getResult();
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }
}

