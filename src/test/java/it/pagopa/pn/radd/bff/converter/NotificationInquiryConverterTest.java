package it.pagopa.pn.radd.bff.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AbortTransactionRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AbortTransactionResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.ActStartTransactionRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.AorStartTransactionRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.CompleteTransactionResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.FilterRequestDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationActResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationAorDetailResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationAorResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationResponseStatusDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationsActDetailsResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationsAorDetailsResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseStatusDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.FilterRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.OperationResponseStatus;
import it.pagopa.pn.radd.bff.rest.v1.dto.OperationsAorDetailsResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.StartTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.StartTransactionResponseStatus;
import it.pagopa.pn.radd.bff.rest.v1.dto.TransactionResponseStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;

@ContextConfiguration(classes = {NotificationInquiryConverter.class})
@ExtendWith(SpringExtension.class)
class NotificationInquiryConverterTest {
    @Autowired
    private NotificationInquiryConverter notificationInquiryConverter;

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionRequestToDto(AbortTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortTransactionRequestToDto() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.abortTransactionRequestToDto(NotificationInquiryConverter.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.abortTransactionRequestToDto(new AbortTransactionRequest());
    }

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
    @Disabled("TODO: Complete this test")
    void testAbortTransactionRequestToDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest.getOperationId()" because "abortTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.abortTransactionRequestToDto(NotificationInquiryConverter.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.abortTransactionRequestToDto(null);
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
    @Disabled("TODO: Complete this test")
    void testAbortTransactionDtoToResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto.getCode()" because "transactionResponseStatusDto" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.abortTransactionDtoToResponse(NotificationInquiryConverter.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.abortTransactionDtoToResponse(new AbortTransactionResponseDto());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#abortTransactionDtoToResponse(AbortTransactionResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortTransactionDtoToResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto$CodeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto.getCode()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.abortTransactionDtoToResponse(NotificationInquiryConverter.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        AbortTransactionResponseDto abortTransactionResponseDto = new AbortTransactionResponseDto();
        abortTransactionResponseDto.status(new TransactionResponseStatusDto());
        notificationInquiryConverter.abortTransactionDtoToResponse(abortTransactionResponseDto);
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
    @Disabled("TODO: Complete this test")
    void testCompleteTransactionRequestToDto() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.completeTransactionRequestToDto(NotificationInquiryConverter.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.completeTransactionRequestToDto(new CompleteTransactionRequest());
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
    @Disabled("TODO: Complete this test")
    void testCompleteTransactionRequestToDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest.getOperationId()" because "completeTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.completeTransactionRequestToDto(NotificationInquiryConverter.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.completeTransactionRequestToDto(null);
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
    @Disabled("TODO: Complete this test")
    void testCompleteTransactionDtoToResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto.getCode()" because "transactionResponseStatusDto" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.completeTransactionDtoToResponse(NotificationInquiryConverter.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.completeTransactionDtoToResponse(new CompleteTransactionResponseDto());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#completeTransactionDtoToResponse(CompleteTransactionResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompleteTransactionDtoToResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto$CodeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.TransactionResponseStatusDto.getCode()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.completeTransactionDtoToResponse(NotificationInquiryConverter.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        CompleteTransactionResponseDto completeTransactionResponseDto = new CompleteTransactionResponseDto();
        completeTransactionResponseDto.status(new TransactionResponseStatusDto());
        notificationInquiryConverter.completeTransactionDtoToResponse(completeTransactionResponseDto);
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
    @Disabled("TODO: Complete this test")
    void testStartTransactionDtoToResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseStatusDto.getCode()" because "startTransactionResponseStatusDto" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.startTransactionDtoToResponse(NotificationInquiryConverter.java:70)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.startTransactionDtoToResponse(new StartTransactionResponseDto());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#startTransactionDtoToResponse(StartTransactionResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStartTransactionDtoToResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseStatusDto$CodeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.StartTransactionResponseStatusDto.getCode()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.startTransactionDtoToResponse(NotificationInquiryConverter.java:70)
        //   See https://diff.blue/R013 to resolve this issue.

        StartTransactionResponseDto startTransactionResponseDto = new StartTransactionResponseDto();
        startTransactionResponseDto.status(new StartTransactionResponseStatusDto());
        notificationInquiryConverter.startTransactionDtoToResponse(startTransactionResponseDto);
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
    @Disabled("TODO: Complete this test")
    void testActStartTransactionRequestToDto() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest$RecipientTypeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest.getRecipientType()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.actStartTransactionRequestToDto(NotificationInquiryConverter.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.actStartTransactionRequestToDto(new ActStartTransactionRequest());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActStartTransactionRequestToDto2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.actStartTransactionRequestToDto(NotificationInquiryConverter.java:89)
        //   See https://diff.blue/R013 to resolve this issue.

        ActStartTransactionRequest actStartTransactionRequest = new ActStartTransactionRequest();
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PF);
        notificationInquiryConverter.actStartTransactionRequestToDto(actStartTransactionRequest);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActStartTransactionRequestToDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.actStartTransactionRequestToDto(NotificationInquiryConverter.java:89)
        //   See https://diff.blue/R013 to resolve this issue.

        ActStartTransactionRequest actStartTransactionRequest = new ActStartTransactionRequest();
        actStartTransactionRequest.setRecipientType(ActStartTransactionRequest.RecipientTypeEnum.PF);
        notificationInquiryConverter.actStartTransactionRequestToDto(actStartTransactionRequest);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#actStartTransactionRequestToDto(ActStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActStartTransactionRequestToDto4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.actStartTransactionRequestToDto(NotificationInquiryConverter.java:89)
        //   See https://diff.blue/R013 to resolve this issue.

        ActStartTransactionRequest actStartTransactionRequest = new ActStartTransactionRequest();
        actStartTransactionRequest.recipientType(ActStartTransactionRequest.RecipientTypeEnum.PG);
        notificationInquiryConverter.actStartTransactionRequestToDto(actStartTransactionRequest);
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
    @Disabled("TODO: Complete this test")
    void testAorStartTransactionRequestToDto() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest$RecipientTypeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest.getRecipientType()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.aorStartTransactionRequestToDto(NotificationInquiryConverter.java:101)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.aorStartTransactionRequestToDto(new AorStartTransactionRequest());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#aorStartTransactionRequestToDto(AorStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAorStartTransactionRequestToDto2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.aorStartTransactionRequestToDto(NotificationInquiryConverter.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        AorStartTransactionRequest aorStartTransactionRequest = new AorStartTransactionRequest();
        aorStartTransactionRequest.recipientType(AorStartTransactionRequest.RecipientTypeEnum.PF);
        notificationInquiryConverter.aorStartTransactionRequestToDto(aorStartTransactionRequest);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#aorStartTransactionRequestToDto(AorStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAorStartTransactionRequestToDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.aorStartTransactionRequestToDto(NotificationInquiryConverter.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        AorStartTransactionRequest aorStartTransactionRequest = new AorStartTransactionRequest();
        aorStartTransactionRequest.setRecipientType(AorStartTransactionRequest.RecipientTypeEnum.PF);
        notificationInquiryConverter.aorStartTransactionRequestToDto(aorStartTransactionRequest);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#aorStartTransactionRequestToDto(AorStartTransactionRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAorStartTransactionRequestToDto4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest.getOperationDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.aorStartTransactionRequestToDto(NotificationInquiryConverter.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        AorStartTransactionRequest aorStartTransactionRequest = new AorStartTransactionRequest();
        aorStartTransactionRequest.recipientType(AorStartTransactionRequest.RecipientTypeEnum.PG);
        notificationInquiryConverter.aorStartTransactionRequestToDto(aorStartTransactionRequest);
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
    @Disabled("TODO: Complete this test")
    void testOperationsAorDetailsDtoToResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.operationsAorDetailsDtoToResponse(NotificationInquiryConverter.java:114)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.operationsAorDetailsDtoToResponse(new OperationsAorDetailsResponseDto());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOperationsAorDetailsDtoToResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.OffsetDateTime.toInstant()" because the return value of "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationAorDetailResponseDto.getOperationEndDate()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.lambda$operationsAorDetailsDtoToResponse$0(NotificationInquiryConverter.java:127)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.operationsAorDetailsDtoToResponse(NotificationInquiryConverter.java:114)
        //   See https://diff.blue/R013 to resolve this issue.

        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
        operationsAorDetailsResponseDto.addElementsItem(new OperationAorDetailResponseDto());
        notificationInquiryConverter.operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOperationsAorDetailsDtoToResponse3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationResponseStatusDto.getCode()" because "operationResponseStatusDto" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.operationsAorDetailsDtoToResponse(NotificationInquiryConverter.java:139)
        //   See https://diff.blue/R013 to resolve this issue.

        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
        operationsAorDetailsResponseDto.elements(new ArrayList<>());
        notificationInquiryConverter.operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOperationsAorDetailsDtoToResponse4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationResponseStatusDto$CodeEnum.getValue()" because the return value of "it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationResponseStatusDto.getCode()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.operationsAorDetailsDtoToResponse(NotificationInquiryConverter.java:139)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<OperationAorDetailResponseDto> elements = new ArrayList<>();
        elements.add(new OperationAorDetailResponseDto());
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(new OperationResponseStatusDto());
        when(operationsAorDetailsResponseDto.elements(Mockito.<List<OperationAorDetailResponseDto>>any()))
                .thenReturn(new OperationsAorDetailsResponseDto());
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(new ArrayList<>());
        operationsAorDetailsResponseDto.elements(elements);
        notificationInquiryConverter.operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse5() {
        ArrayList<OperationAorDetailResponseDto> elements = new ArrayList<>();
        elements.add(new OperationAorDetailResponseDto());

        OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
        operationResponseStatusDto.code(OperationResponseStatusDto.CodeEnum.NUMBER_0);
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsAorDetailsResponseDto.elements(Mockito.<List<OperationAorDetailResponseDto>>any()))
                .thenReturn(new OperationsAorDetailsResponseDto());
        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        operationsAorDetailsResponseDto.elements(elements);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
        assertEquals(operationAorDetailResponseDtoList, actualOperationsAorDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_0, status.getCode());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).elements(Mockito.<List<OperationAorDetailResponseDto>>any());
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto).getElements();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDetailsDtoToResponse(OperationsAorDetailsResponseDto)}
     */
    @Test
    void testOperationsAorDetailsDtoToResponse6() {
        ArrayList<OperationAorDetailResponseDto> elements = new ArrayList<>();
        elements.add(new OperationAorDetailResponseDto());

        OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
        operationResponseStatusDto.code(OperationResponseStatusDto.CodeEnum.NUMBER_1);
        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);
        when(operationsAorDetailsResponseDto.getResult()).thenReturn(true);
        when(operationsAorDetailsResponseDto.getStatus()).thenReturn(operationResponseStatusDto);
        when(operationsAorDetailsResponseDto.elements(Mockito.<List<OperationAorDetailResponseDto>>any()))
                .thenReturn(new OperationsAorDetailsResponseDto());
        ArrayList<OperationAorDetailResponseDto> operationAorDetailResponseDtoList = new ArrayList<>();
        when(operationsAorDetailsResponseDto.getElements()).thenReturn(operationAorDetailResponseDtoList);
        operationsAorDetailsResponseDto.elements(elements);
        OperationsAorDetailsResponse actualOperationsAorDetailsDtoToResponseResult = notificationInquiryConverter
                .operationsAorDetailsDtoToResponse(operationsAorDetailsResponseDto);
        assertEquals(operationAorDetailResponseDtoList, actualOperationsAorDetailsDtoToResponseResult.getElements());
        assertTrue(actualOperationsAorDetailsDtoToResponseResult.getResult());
        OperationResponseStatus status = actualOperationsAorDetailsDtoToResponseResult.getStatus();
        assertNull(status.getMessage());
        assertEquals(OperationResponseStatus.CodeEnum.NUMBER_1, status.getCode());
        verify(operationsAorDetailsResponseDto).getStatus();
        verify(operationsAorDetailsResponseDto).elements(Mockito.<List<OperationAorDetailResponseDto>>any());
        verify(operationsAorDetailsResponseDto).getResult();
        verify(operationsAorDetailsResponseDto).getElements();
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilterRequestToDto() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.FilterRequest.getFrom()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.filterRequestToDto(NotificationInquiryConverter.java:151)
        //   See https://diff.blue/R013 to resolve this issue.

        notificationInquiryConverter.filterRequestToDto(new FilterRequest());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilterRequestToDto2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.FilterRequest.getTo()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.filterRequestToDto(NotificationInquiryConverter.java:152)
        //   See https://diff.blue/R013 to resolve this issue.

        FilterRequest filterRequest = new FilterRequest();
        filterRequest.from(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        notificationInquiryConverter.filterRequestToDto(filterRequest);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#filterRequestToDto(FilterRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilterRequestToDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "it.pagopa.pn.radd.bff.rest.v1.dto.FilterRequest.getTo()" is null
        //       at it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter.filterRequestToDto(NotificationInquiryConverter.java:152)
        //   See https://diff.blue/R013 to resolve this issue.

        java.sql.Date from = mock(java.sql.Date.class);
        when(from.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        FilterRequest filterRequest = new FilterRequest();
        filterRequest.from(from);
        notificationInquiryConverter.filterRequestToDto(filterRequest);
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
     * Method under test: {@link NotificationInquiryConverter#operationsActDtoToResponse(Flux)}
     */
    @Test
    void testOperationsActDtoToResponse() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        notificationInquiryConverter.operationsActDtoToResponse(DirectProcessor.create());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDtoToResponse(Flux)}
     */
    @Test
    void testOperationsActDtoToResponse2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        notificationInquiryConverter.operationsActDtoToResponse(null);
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDtoToResponse(Flux)}
     */
    @Test
    void testOperationsActDtoToResponse3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        notificationInquiryConverter.operationsActDtoToResponse(mock(Flux.class));
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDtoToResponse(Flux)}
     */
    @Test
    void testOperationsAorDtoToResponse() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        notificationInquiryConverter.operationsAorDtoToResponse(DirectProcessor.create());
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsAorDtoToResponse(Flux)}
     */
    @Test
    void testOperationsAorDtoToResponse2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        notificationInquiryConverter.operationsAorDtoToResponse(mock(Flux.class));
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationAorDtoToResponse(OperationAorResponseDto)}
     */
    @Test
    void testOperationAorDtoToResponse() {
        assertNull(notificationInquiryConverter.operationAorDtoToResponse(new OperationAorResponseDto()));
        assertNull(notificationInquiryConverter.operationAorDtoToResponse(mock(OperationAorResponseDto.class)));
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationActDtoToResponse(OperationActResponseDto)}
     */
    @Test
    void testOperationActDtoToResponse() {
        assertNull(notificationInquiryConverter.operationActDtoToResponse(new OperationActResponseDto()));
        assertNull(notificationInquiryConverter.operationActDtoToResponse(mock(OperationActResponseDto.class)));
    }

    /**
     * Method under test: {@link NotificationInquiryConverter#operationsActDetailsDtoToResponse(OperationsActDetailsResponseDto)}
     */
    @Test
    void testOperationsActDetailsDtoToResponse() {
        assertNull(notificationInquiryConverter.operationsActDetailsDtoToResponse(new OperationsActDetailsResponseDto()));
        assertNull(notificationInquiryConverter
                .operationsActDetailsDtoToResponse(mock(OperationsActDetailsResponseDto.class)));
    }
}

