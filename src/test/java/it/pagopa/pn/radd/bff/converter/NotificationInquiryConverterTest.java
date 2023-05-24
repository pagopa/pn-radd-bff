package it.pagopa.pn.radd.bff.converter;

import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import it.pagopa.pn.radd.bff.rest.v1.dto.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {NotificationInquiryConverter.class})
@ExtendWith(SpringExtension.class)
class NotificationInquiryConverterTest {
    @Autowired
    private NotificationInquiryConverter notificationInquiryConverter;

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    void testAbortTransactionRequestToDto2() {
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
    void testAbortTransactionRequestToDto4() {
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
    void testAbortTransactionDtoToResponse3() {
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
    void testAbortTransactionDtoToResponse4() {
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
    void testAbortTransactionDtoToResponse5() {
        TransactionResponseStatusDto status = mock(TransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        assertEquals("Not all who wander are lost", status2.getMessage());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    void testAbortTransactionDtoToResponse6() {
        TransactionResponseStatusDto status = mock(TransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_1);

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .abortTransactionDtoToResponse(abortTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status2.getCode());
        assertEquals("Not all who wander are lost", status2.getMessage());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionRequestToDto(CompleteTransactionRequest)}
     */
    @Test
    void testCompleteTransactionRequestToDto2() {
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
    void testCompleteTransactionRequestToDto4() {
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
    void testCompleteTransactionDtoToResponse3() {
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
    void testCompleteTransactionDtoToResponse4() {
        TransactionResponseStatusDto status = mock(TransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_0);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        assertEquals("Not all who wander are lost", status2.getMessage());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    void testCompleteTransactionDtoToResponse5() {
        TransactionResponseStatusDto status = mock(TransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(TransactionResponseStatusDto.CodeEnum.NUMBER_1);

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(status);
        TransactionResponseStatus status2 = notificationInquiryConverter
                .completeTransactionDtoToResponse(completeTransactionResponseDto)
                .getStatus();
        assertEquals(TransactionResponseStatus.CodeEnum.NUMBER_1, status2.getCode());
        assertEquals("Not all who wander are lost", status2.getMessage());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse3() {
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
    void testStartTransactionDtoToResponse4() {
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
    void testStartTransactionDtoToResponse5() {
        StartTransactionResponseStatusDto status = mock(StartTransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(StartTransactionResponseStatusDto.CodeEnum.NUMBER_0);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(status);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status2 = actualStartTransactionDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status2.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_0, status2.getCode());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    void testStartTransactionDtoToResponse6() {
        StartTransactionResponseStatusDto status = mock(StartTransactionResponseStatusDto.class);
        when(status.getMessage()).thenReturn("Not all who wander are lost");
        when(status.getCode()).thenReturn(StartTransactionResponseStatusDto.CodeEnum.NUMBER_99);

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(status);
        StartTransactionResponse actualStartTransactionDtoToResponseResult = notificationInquiryConverter
                .startTransactionDtoToResponse(startTransactionResponseDto);
        assertNull(actualStartTransactionDtoToResponseResult.getUrlList());
        StartTransactionResponseStatus status2 = actualStartTransactionDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status2.getMessage());
        assertEquals(StartTransactionResponseStatus.CodeEnum.NUMBER_99, status2.getCode());
        verify(status).getCode();
        verify(status).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    void testActStartTransactionRequestToDto5() {
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
    void testActStartTransactionRequestToDto6() {
        ActStartTransactionRequest actStartTransactionRequest = mock(ActStartTransactionRequest.class);
        when(actStartTransactionRequest.getOperationId()).thenReturn("42");
        when(actStartTransactionRequest.getOperationDate())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(actStartTransactionRequest.recipientType(Mockito.<ActStartTransactionRequest.RecipientTypeEnum>any()))
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
        verify(actStartTransactionRequest).recipientType(Mockito.<ActStartTransactionRequest.RecipientTypeEnum>any());
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
    void testAorStartTransactionRequestToDto5() {
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
    void testAorStartTransactionRequestToDto6() {
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
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse() {
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
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    void testFilterRequestToDto4() {
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
    void testFilterRequestToDto5() {
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
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse2() {
        // Arrange
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
        operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
        operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
        operationAorResponseDto.element(operationAorDetailResponseDto);
        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto);

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
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse4() {
        // Arrange
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        operationAorResponseDto.status(status);
        operationAorResponseDto.element(new OperationAorDetailResponseDto());

        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto);

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
        assertSame(status, operationAorResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse5() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.code(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.status(status);
        operationAorResponseDto.element(new OperationAorDetailResponseDto());

        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto);

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
        assertSame(status, operationAorResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse6() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.status(status);
        operationAorResponseDto.element(new OperationAorDetailResponseDto());

        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto);

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
        assertSame(status, operationAorResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse7() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.code(OperationResponseStatusDto.CodeEnum.NUMBER_1);

        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.status(status);
        operationAorResponseDto.element(new OperationAorDetailResponseDto());

        // Act
        OperationAorResponse actualOperationAorDtoToResponseResult = notificationInquiryConverter
                .operationAorDtoToResponse(operationAorResponseDto);

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
        assertSame(status, operationAorResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse2() {
        // Arrange
        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.element(new OperationActDetailResponseDto());
        OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
        operationActDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
        operationActDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
        operationActResponseDto.element(operationActDetailResponseDto);

        // Act
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto);

        // Assert
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertNull(operationActResponseDto.getStatus());
        assertNotNull(element.getOperationStartDate());
        assertNotNull(element.getOperationEndDate());

    }


    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse4() {
        // Arrange
        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        operationActResponseDto.status(status);
        operationActResponseDto.element(new OperationActDetailResponseDto());

        // Act
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto);

        // Assert
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertSame(status, operationActResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse5() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.code(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.status(status);
        operationActResponseDto.element(new OperationActDetailResponseDto());

        // Act
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto);

        // Assert
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertSame(status, operationActResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse6() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.status(status);
        operationActResponseDto.element(new OperationActDetailResponseDto());

        // Act
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto);

        // Assert
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertSame(status, operationActResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse7() {
        // Arrange
        OperationResponseStatusDto status = new OperationResponseStatusDto();
        status.code(OperationResponseStatusDto.CodeEnum.NUMBER_1);

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.status(status);
        operationActResponseDto.element(new OperationActDetailResponseDto());

        // Act
        OperationActResponse actualOperationActDtoToResponseResult = notificationInquiryConverter
                .operationActDtoToResponse(operationActResponseDto);

        // Assert
        assertNull(actualOperationActDtoToResponseResult.getResult());
        OperationActDetailResponse element = actualOperationActDtoToResponseResult.getElement();
        assertNull(element.getRecipientType());
        assertNull(element.getRecipientTaxId());
        assertNull(element.getQrCode());
        assertNull(element.getOperationType());
        assertNull(element.getOperationStatus());
        assertNull(element.getOperationId());
        assertNull(element.getIun());
        assertNull(element.getFileKey());
        assertNull(element.getErrorReason());
        assertNull(element.getDelegateTaxId());
        assertNull(element.getUid());
        assertSame(status, operationActResponseDto.getStatus());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse() {
        OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
        OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
        OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
        operationsActDetailsResponseDto.setResult(true);
        operationsActDetailsResponseDto.setStatus(operationResponseStatusDto);
        operationActDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
        operationActDetailResponseDto.setOperationEndDate(OffsetDateTime.now());

        operationsActDetailsResponseDto.setElements(List.of(operationActDetailResponseDto));

        operationResponseStatusDto.code(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        OperationsActDetailsResponse actualOperationsActDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsActDetailsDtoToResponse(operationsActDetailsResponseDto);
        assertTrue(actualOperationsActDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsActDetailsDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse() {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, true, new OperationResponseStatusDto());
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        assertNull(actualOperationsDtoToResponseResult.getStatus().getMessage());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse2() {
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(new ArrayList<>(), true, null);
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse3() {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, true, operationResponseStatusDto);
        assertTrue(actualOperationsDtoToResponseResult.getOperations().isEmpty());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse4() {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        operationsDetailsResponses.add(new OperationsDetailsResponse());
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, true, operationResponseStatusDto);
        assertEquals(1, actualOperationsDtoToResponseResult.getOperations().size());
        assertTrue(actualOperationsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsDtoToResponseResult.getStatus();
        assertEquals("Not all who wander are lost", status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationResponseStatusDto, atLeast(1)).getCode();
        verify(operationResponseStatusDto).getMessage();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsDtoToResponse(List, Boolean, OperationResponseStatusDto)}
     */
    @Test
    void testOperationsDtoToResponse5() {
        ArrayList<OperationsDetailsResponse> operationsDetailsResponses = new ArrayList<>();
        OperationResponseStatusDto operationResponseStatusDto = mock(OperationResponseStatusDto.class);
        when(operationResponseStatusDto.getCode()).thenReturn(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        when(operationResponseStatusDto.getMessage()).thenReturn("Not all who wander are lost");
        OperationsResponse actualOperationsDtoToResponseResult = notificationInquiryConverter
                .operationsDtoToResponse(operationsDetailsResponses, true, operationResponseStatusDto);
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
    void testEnrichAorData2() {
        OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
        operationAorResponseDto.element(new OperationAorDetailResponseDto());
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertNull(actualEnrichAorDataResult.getErrorReason());
        assertNull(actualEnrichAorDataResult.getUid());
        assertNull(actualEnrichAorDataResult.getRecipientType());
        assertNull(actualEnrichAorDataResult.getQrCode());
        assertNull(actualEnrichAorDataResult.getOperationType());
        assertNull(actualEnrichAorDataResult.getOperationStatus());
        assertNull(actualEnrichAorDataResult.getOperationId());
        assertNull(actualEnrichAorDataResult.getIuns());
        assertNull(actualEnrichAorDataResult.getFileKey());
    }


    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData4() {
        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);
        when(operationAorResponseDto.getElement()).thenReturn(new OperationAorDetailResponseDto());
        OperationsDetailsResponse actualEnrichAorDataResult = notificationInquiryConverter
                .enrichAorData(operationAorResponseDto);
        assertNull(actualEnrichAorDataResult.getErrorReason());
        assertNull(actualEnrichAorDataResult.getUid());
        assertNull(actualEnrichAorDataResult.getRecipientType());
        assertNull(actualEnrichAorDataResult.getQrCode());
        assertNull(actualEnrichAorDataResult.getOperationType());
        assertNull(actualEnrichAorDataResult.getOperationStatus());
        assertNull(actualEnrichAorDataResult.getOperationId());
        assertNull(actualEnrichAorDataResult.getIuns());
        assertNull(actualEnrichAorDataResult.getFileKey());
        verify(operationAorResponseDto).getElement();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichAorData(OperationAorResponseDto)}
     */
    @Test
    void testEnrichAorData5() {
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
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData3() {
        OperationActDetailResponseDto element = mock(OperationActDetailResponseDto.class);
        when(element.getErrorReason()).thenReturn("An error occurred");
        when(element.getQrCode()).thenReturn("Qr Code");
        when(element.getRecipientType()).thenReturn("Recipient Type");
        when(element.getUid()).thenReturn("1234");
        when(element.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(element.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(element.getFileKey()).thenReturn("File Key");
        when(element.getIun()).thenReturn("Iun");
        when(element.getOperationId()).thenReturn("42");
        when(element.getOperationStatus()).thenReturn("Operation Status");
        when(element.getOperationType()).thenReturn("Operation Type");

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.element(element);
        OperationsDetailsResponse actualEnrichActDataResult = notificationInquiryConverter
                .enrichActData(operationActResponseDto);
        assertEquals("An error occurred", actualEnrichActDataResult.getErrorReason());
        assertEquals("1234", actualEnrichActDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichActDataResult.getRecipientType());
        assertEquals("Qr Code", actualEnrichActDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichActDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichActDataResult.getOperationStatus());
        assertEquals("42", actualEnrichActDataResult.getOperationId());
        assertEquals(1, actualEnrichActDataResult.getIuns().size());
        assertEquals("File Key", actualEnrichActDataResult.getFileKey());
        verify(element).getErrorReason();
        verify(element).getFileKey();
        verify(element).getIun();
        verify(element).getOperationId();
        verify(element).getOperationStatus();
        verify(element).getOperationType();
        verify(element).getQrCode();
        verify(element).getRecipientType();
        verify(element).getUid();
        verify(element, atLeast(1)).getOperationEndDate();
        verify(element, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData4() {
        OperationActDetailResponseDto element = mock(OperationActDetailResponseDto.class);
        when(element.getErrorReason()).thenReturn("An error occurred");
        when(element.getQrCode()).thenReturn("Qr Code");
        when(element.getRecipientType()).thenReturn("Recipient Type");
        when(element.getUid()).thenReturn("1234");
        when(element.getOperationEndDate()).thenReturn(null);
        when(element.getOperationStartDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(element.getFileKey()).thenReturn("File Key");
        when(element.getIun()).thenReturn("Iun");
        when(element.getOperationId()).thenReturn("42");
        when(element.getOperationStatus()).thenReturn("Operation Status");
        when(element.getOperationType()).thenReturn("Operation Type");

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.element(element);
        OperationsDetailsResponse actualEnrichActDataResult = notificationInquiryConverter
                .enrichActData(operationActResponseDto);
        assertEquals("An error occurred", actualEnrichActDataResult.getErrorReason());
        assertEquals("1234", actualEnrichActDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichActDataResult.getRecipientType());
        assertEquals("Qr Code", actualEnrichActDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichActDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichActDataResult.getOperationStatus());
        assertEquals("42", actualEnrichActDataResult.getOperationId());
        assertEquals(1, actualEnrichActDataResult.getIuns().size());
        assertEquals("File Key", actualEnrichActDataResult.getFileKey());
        verify(element).getErrorReason();
        verify(element).getFileKey();
        verify(element).getIun();
        verify(element).getOperationId();
        verify(element).getOperationStatus();
        verify(element).getOperationType();
        verify(element).getQrCode();
        verify(element).getRecipientType();
        verify(element).getUid();
        verify(element).getOperationEndDate();
        verify(element, atLeast(1)).getOperationStartDate();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#enrichActData(OperationActResponseDto)}
     */
    @Test
    void testEnrichActData5() {
        OperationActDetailResponseDto element = mock(OperationActDetailResponseDto.class);
        when(element.getErrorReason()).thenReturn("An error occurred");
        when(element.getQrCode()).thenReturn("Qr Code");
        when(element.getRecipientType()).thenReturn("Recipient Type");
        when(element.getUid()).thenReturn("1234");
        when(element.getOperationEndDate())
                .thenReturn(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        when(element.getOperationStartDate()).thenReturn(null);
        when(element.getFileKey()).thenReturn("File Key");
        when(element.getIun()).thenReturn("Iun");
        when(element.getOperationId()).thenReturn("42");
        when(element.getOperationStatus()).thenReturn("Operation Status");
        when(element.getOperationType()).thenReturn("Operation Type");

        OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
        operationActResponseDto.element(element);
        OperationsDetailsResponse actualEnrichActDataResult = notificationInquiryConverter
                .enrichActData(operationActResponseDto);
        assertEquals("An error occurred", actualEnrichActDataResult.getErrorReason());
        assertEquals("1234", actualEnrichActDataResult.getUid());
        assertEquals("Recipient Type", actualEnrichActDataResult.getRecipientType());
        assertEquals("Qr Code", actualEnrichActDataResult.getQrCode());
        assertEquals("Operation Type", actualEnrichActDataResult.getOperationType());
        assertEquals("Operation Status", actualEnrichActDataResult.getOperationStatus());
        assertEquals("42", actualEnrichActDataResult.getOperationId());
        assertEquals(1, actualEnrichActDataResult.getIuns().size());
        assertEquals("File Key", actualEnrichActDataResult.getFileKey());
        verify(element).getErrorReason();
        verify(element).getFileKey();
        verify(element).getIun();
        verify(element).getOperationId();
        verify(element).getOperationStatus();
        verify(element).getOperationType();
        verify(element).getQrCode();
        verify(element).getRecipientType();
        verify(element).getUid();
        verify(element, atLeast(1)).getOperationEndDate();
        verify(element).getOperationStartDate();
    }
}

