package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.*;
import it.pagopa.pn.radd.bff.service.NotificationInquiryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith (SpringExtension.class)
class NotificationInquiryControllerTest {
	@InjectMocks
	private NotificationInquiryController notificationInquiryController;

	@Mock
	private NotificationInquiryService notificationInquiryService;

	@Mock
	ServerWebExchange serverWebExchange;

	@Mock
	private Scheduler scheduler;

	/**
	 * Method under test: {@link NotificationInquiryController#getActPracticesByInternalId(String, Mono, ServerWebExchange)}
	 */
	@Test
	void testGetActPracticesByInternalId () {
		Mono<FilterRequest> filterRequest = mock(Mono.class);

		OperationsActDetailsResponse operationsActDetailsResponse = mock(OperationsActDetailsResponse.class);
		OperationActDetailResponse operationActDetailResponse = mock(OperationActDetailResponse.class);
		operationsActDetailsResponse.setElements(List.of(operationActDetailResponse));
		operationsActDetailsResponse.setResult(true);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationsActDetailsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getActPracticesByInternalId("taxId",filterRequest))
				.thenReturn(Mono.just(operationsActDetailsResponse));

		StepVerifier.create(notificationInquiryController.getActPracticesByInternalId("taxId",filterRequest ,serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationsActDetailsResponse));
	}
	@Test
	void testGetAorPracticesByInternalId () {
		Mono<FilterRequest> filterRequest = mock(Mono.class);

		OperationsAorDetailsResponse operationsAorDetailsResponse = mock(OperationsAorDetailsResponse.class);
		OperationAorDetailResponse operationAorDetailResponse = mock(OperationAorDetailResponse.class);
		operationsAorDetailsResponse.setElements(List.of(operationAorDetailResponse));
		operationsAorDetailsResponse.setResult(true);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationsAorDetailsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getAorPracticesByInternalId("taxId",filterRequest))
				.thenReturn(Mono.just(operationsAorDetailsResponse));

		StepVerifier.create(notificationInquiryController.getAorPracticesByInternalId("taxId",filterRequest ,serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationsAorDetailsResponse));
	}
	@Test
	void testGetActPracticesByIun () {
		OperationsResponse operationsResponse = new OperationsResponse();

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationId("operationId");
		operationsDetailsResponse.setOperationStatus("operationStatus");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setOperationType("operationType");
		operationsDetailsResponse.setQrCode("qrCode");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setRecipientType("recipientType");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setOperationEndDate(new Date(System.currentTimeMillis() + 1000000L));
		operationsDetailsResponse.setOperationStartDate(new Date(System.currentTimeMillis()));
		operationsDetailsResponse.setIuns(List.of("iun"));

		operationsResponse.setOperations(List.of(operationsDetailsResponse));
		operationsResponse.setResult(true);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getActPracticesByIun("iun"))
				.thenReturn(Mono.just(operationsResponse));

		StepVerifier.create(notificationInquiryController.getActPracticesByIun("iun", serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationsResponse));
	}
	@Test
	void testGetActTransactionByOperationId () {
		OperationActResponse operationActResponse = new OperationActResponse();

		OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();

		operationActDetailResponse.setOperationId("operationId");
		operationActDetailResponse.setOperationStatus("operationStatus");
		operationActDetailResponse.setOperationType("operationType");
		operationActDetailResponse.setIun("Iun");
		operationActDetailResponse.setFileKey("fileKey");
		operationActDetailResponse.setQrCode("qrCode");
		operationActDetailResponse.setRecipientTaxId("recipientTaxId");
		operationActDetailResponse.setErrorReason("errorReason");
		operationActDetailResponse.setRecipientType("recipientType");
		operationActDetailResponse.setUid("uid");
		operationActDetailResponse.setOperationEndDate(new Date(System.currentTimeMillis() + 1000000L));
		operationActDetailResponse.setOperationStartDate(new Date(System.currentTimeMillis()));

		operationActResponse.setElement(operationActDetailResponse);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationActResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getActTransactionByOperationId("operationId"))
				.thenReturn(Mono.just(operationActResponse));

		StepVerifier.create(notificationInquiryController.getActTransactionByOperationId("operationId", serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationActResponse));
	}
	@Test
	void testGetAorTransactionByOperationId () {
		OperationAorResponse operationAorResponse = new OperationAorResponse();

		OperationAorDetailResponse operationAorDetailResponse = mock(OperationAorDetailResponse.class);

		operationAorResponse.setElement(operationAorDetailResponse);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationAorResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getAorTransactionByOperationId("operationId"))
				.thenReturn(Mono.just(operationAorResponse));

		StepVerifier.create(notificationInquiryController.getAorTransactionByOperationId("operationId", serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationAorResponse));
	}
	@Test
	void testGetAorPracticesByIun () {
		OperationsResponse operationsResponse = new OperationsResponse();

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationId("operationId");
		operationsDetailsResponse.setOperationStatus("operationStatus");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setOperationType("operationType");
		operationsDetailsResponse.setQrCode("qrCode");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setRecipientType("recipientType");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setOperationEndDate(new Date(System.currentTimeMillis() + 1000000L));
		operationsDetailsResponse.setOperationStartDate(new Date(System.currentTimeMillis()));
		operationsDetailsResponse.setIuns(List.of("iun"));

		operationsResponse.setOperations(List.of(operationsDetailsResponse));
		operationsResponse.setResult(true);

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");

		operationsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryService.getAorPracticesByIun("iun"))
				.thenReturn(Mono.just(operationsResponse));

		StepVerifier.create(notificationInquiryController.getAorPracticesByIun("iun", serverWebExchange))
				.expectNext(ResponseEntity.ok().body(operationsResponse));
	}

}

