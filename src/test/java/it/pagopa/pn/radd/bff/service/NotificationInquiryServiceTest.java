package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.*;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



@ExtendWith (SpringExtension.class)
class NotificationInquiryServiceTest {
	@Mock
	private NotificationInquiryConverter notificationInquiryConverter;

	@Mock
	private PnRaddFsuClient pnRaddFsuClient;

	@Mock
	private DataVaultService dataVaultService;

	@InjectMocks
	private NotificationInquiryService notificationInquiryService;


	@Test
	void testGetActPracticesByInternalId(){
		OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
		operationsActDetailsResponseDto.setResult(true);
		operationsActDetailsResponseDto.setElements(new ArrayList<>());
		operationsActDetailsResponseDto.setStatus(null);

		FilterRequest filterRequest = new FilterRequest();
		filterRequest.setRecipientType(FilterRequest.RecipientTypeEnum.PF);

		OperationsActDetailsResponse operationsActDetailsResponse = new OperationsActDetailsResponse();
		operationsActDetailsResponse.setElements(new ArrayList<>());
		operationsActDetailsResponse.setResult(true);
		operationsActDetailsResponse.setStatus(null);

		when(dataVaultService.getAnonymousByTaxId(any(),any())).thenReturn(Mono.just("abc"));
		when(pnRaddFsuClient.getActPracticesByInternalId(any(),any())).thenReturn(Mono.just(operationsActDetailsResponseDto));
		when(notificationInquiryConverter.operationsActDetailsDtoToResponse(any())).thenReturn(operationsActDetailsResponse);

		StepVerifier.create(notificationInquiryService.getActPracticesByInternalId("taxId",Mono.just(filterRequest)))
				.expectNext(operationsActDetailsResponse).verifyComplete();
	}

	@Test
	void testGetAorPracticesByInternalId(){
		OperationsAorDetailsResponseDto operationsActDetailsResponseDto = new OperationsAorDetailsResponseDto();
		operationsActDetailsResponseDto.setResult(true);
		operationsActDetailsResponseDto.setElements(new ArrayList<>());
		operationsActDetailsResponseDto.setStatus(null);

		FilterRequest filterRequest = new FilterRequest();
		filterRequest.setRecipientType(FilterRequest.RecipientTypeEnum.PF);

		OperationsAorDetailsResponse operationsActDetailsResponse = new OperationsAorDetailsResponse();
		operationsActDetailsResponse.setElements(new ArrayList<>());
		operationsActDetailsResponse.setResult(true);
		operationsActDetailsResponse.setStatus(null);

		when(dataVaultService.getAnonymousByTaxId(any(),any())).thenReturn(Mono.just("abc"));
		when(pnRaddFsuClient.getAorPracticesByInternalId(any(),any())).thenReturn(Mono.just(operationsActDetailsResponseDto));
		when(notificationInquiryConverter.operationsAorDetailsDtoToResponse(any())).thenReturn(operationsActDetailsResponse);

		StepVerifier.create(notificationInquiryService.getAorPracticesByInternalId("taxId",Mono.just(filterRequest)))
				.expectNext(operationsActDetailsResponse).verifyComplete();
	}


	@Test
	void testGetAorPracticesByIun() {

		OperationsResponseDto operationsResponseDto = new OperationsResponseDto();
		operationsResponseDto.setOperationIds(List.of("42"));
		operationsResponseDto.setResult(true);

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsResponseDto.setStatus(operationResponseStatusDto);

		when(pnRaddFsuClient.getAorPracticesByIun(any())).thenReturn(Mono.just(operationsResponseDto));

		OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
		operationAorResponseDto.setStatus(operationResponseStatusDto);
		operationAorResponseDto.setResult(true);
		OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
		operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationId("42");
		operationAorDetailResponseDto.setOperationType("type");
		operationAorDetailResponseDto.setOperationStatus("status");
		operationAorDetailResponseDto.setFileKey("fileKey");
		operationAorDetailResponseDto.setIuns(List.of("42"));
		operationAorDetailResponseDto.setRecipientTaxId("taxId");
		operationAorDetailResponseDto.setDelegateTaxId("taxId");
		operationAorDetailResponseDto.setRecipientType("type");
		operationAorDetailResponseDto.setErrorReason("errorReason");
		operationAorDetailResponseDto.setUid("uid");
		operationAorDetailResponseDto.setQrCode("qrCode");

		operationAorResponseDto.setElement(operationAorDetailResponseDto);

		when(pnRaddFsuClient.getAorTransactionByOperationId(any())).thenReturn(Mono.just(operationAorResponseDto));

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationId("42");
		operationsDetailsResponse.setOperationType("type");
		operationsDetailsResponse.setOperationStatus("status");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setIuns(List.of("42"));
		operationsDetailsResponse.setRecipientTaxId("taxId");
		operationsDetailsResponse.setDelegateTaxId("taxId");
		operationsDetailsResponse.setRecipientType("type");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setQrCode("qrCode");
		when(notificationInquiryConverter.enrichAorData(any())).thenReturn(operationsDetailsResponse);

		Map map = Map.of("42", "42");
		when(dataVaultService.getRecipientDenominationByInternalId(any())).thenReturn(Mono.just(map));

		OperationsResponse operationsResponse = mock(OperationsResponse.class);
		when(notificationInquiryConverter.operationsDtoToResponse(any(), any(), any(), any())).thenReturn(operationsResponse);
		StepVerifier.create(notificationInquiryService.getAorPracticesByIun("iun"))
				.expectNext(operationsResponse)
				.verifyComplete();
	}

	@Test
	void testGetAorPracticesByIun2() {

		OperationsResponseDto operationsResponseDto = new OperationsResponseDto();
		operationsResponseDto.setOperationIds(List.of("42"));
		operationsResponseDto.setResult(true);

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsResponseDto.setStatus(null);

		when(pnRaddFsuClient.getAorPracticesByIun(any())).thenReturn(Mono.just(operationsResponseDto));

		OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
		operationAorResponseDto.setStatus(null);
		operationAorResponseDto.setResult(true);
		OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
		operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationId("42");
		operationAorDetailResponseDto.setOperationType("type");
		operationAorDetailResponseDto.setOperationStatus("status");
		operationAorDetailResponseDto.setFileKey("fileKey");
		operationAorDetailResponseDto.setIuns(List.of("42"));
		operationAorDetailResponseDto.setRecipientTaxId("taxId");
		operationAorDetailResponseDto.setDelegateTaxId("taxId");
		operationAorDetailResponseDto.setRecipientType("type");
		operationAorDetailResponseDto.setErrorReason("errorReason");
		operationAorDetailResponseDto.setUid("uid");
		operationAorDetailResponseDto.setQrCode("qrCode");

		operationAorResponseDto.setElement(operationAorDetailResponseDto);

		when(pnRaddFsuClient.getAorTransactionByOperationId(any())).thenReturn(Mono.just(operationAorResponseDto));

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationId("42");
		operationsDetailsResponse.setOperationType("type");
		operationsDetailsResponse.setOperationStatus("status");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setIuns(List.of("42"));
		operationsDetailsResponse.setRecipientTaxId("taxId");
		operationsDetailsResponse.setDelegateTaxId("taxId");
		operationsDetailsResponse.setRecipientType("type");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setQrCode("qrCode");
		when(notificationInquiryConverter.enrichAorData(any())).thenReturn(operationsDetailsResponse);

		Map map = Map.of("42", "42");
		when(dataVaultService.getRecipientDenominationByInternalId(any())).thenReturn(Mono.just(map));

		OperationsResponse operationsResponse = mock(OperationsResponse.class);
		when(notificationInquiryConverter.operationsDtoToResponse(any(), any(), any(), any())).thenReturn(operationsResponse);
		StepVerifier.create(notificationInquiryService.getAorPracticesByIun("iun"))
				.expectError()
				.verify();
	}
	@Test
	void testGetActPracticesByIun() {

		OperationsResponseDto operationsResponseDto = new OperationsResponseDto();
		operationsResponseDto.setOperationIds(List.of("42"));
		operationsResponseDto.setResult(true);

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsResponseDto.setStatus(operationResponseStatusDto);
		when(pnRaddFsuClient.getActPracticesByIun(any())).thenReturn(Mono.just(operationsResponseDto));

		OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
		operationActResponseDto.setStatus(operationResponseStatusDto);
		operationActResponseDto.setResult(true);
		OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
		operationActDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationId("42");
		operationActDetailResponseDto.setOperationType("type");
		operationActDetailResponseDto.setOperationStatus("status");
		operationActDetailResponseDto.setFileKey("fileKey");
		operationActDetailResponseDto.setIun("42");
		operationActDetailResponseDto.setRecipientTaxId("taxId");
		operationActDetailResponseDto.setDelegateTaxId("taxId");
		operationActDetailResponseDto.setRecipientType("type");
		operationActDetailResponseDto.setErrorReason("errorReason");
		operationActDetailResponseDto.setUid("uid");
		operationActDetailResponseDto.setQrCode("qrCode");

		operationActResponseDto.setElement(operationActDetailResponseDto);

		when(pnRaddFsuClient.getActTransactionByOperationId(any())).thenReturn(Mono.just(operationActResponseDto));

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationId("42");
		operationsDetailsResponse.setOperationType("type");
		operationsDetailsResponse.setOperationStatus("status");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setIuns(List.of("42"));
		operationsDetailsResponse.setRecipientTaxId("taxId");
		operationsDetailsResponse.setDelegateTaxId("taxId");
		operationsDetailsResponse.setRecipientType("type");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setQrCode("qrCode");
		when(notificationInquiryConverter.enrichActData(any())).thenReturn(operationsDetailsResponse);

		Map map = Map.of("42", "42");
		when(dataVaultService.getRecipientDenominationByInternalId(any())).thenReturn(Mono.just(map));

		OperationsResponse operationsResponse = mock(OperationsResponse.class);
		when(notificationInquiryConverter.operationsDtoToResponse(any(), any(), any(), any())).thenReturn(operationsResponse);
		StepVerifier.create(notificationInquiryService.getActPracticesByIun("iun"))
				.expectNext(operationsResponse)
				.verifyComplete();
	}

	@Test
	void testGetActPracticesByIun2() {

		OperationsResponseDto operationsResponseDto = new OperationsResponseDto();
		operationsResponseDto.setOperationIds(List.of("42"));
		operationsResponseDto.setResult(true);

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsResponseDto.setStatus(null);
		when(pnRaddFsuClient.getActPracticesByIun(any())).thenReturn(Mono.just(operationsResponseDto));

		OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
		operationActResponseDto.setStatus(operationResponseStatusDto);
		operationActResponseDto.setResult(true);
		OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
		operationActDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationId("42");
		operationActDetailResponseDto.setOperationType("type");
		operationActDetailResponseDto.setOperationStatus("status");
		operationActDetailResponseDto.setFileKey("fileKey");
		operationActDetailResponseDto.setIun("42");
		operationActDetailResponseDto.setRecipientTaxId("taxId");
		operationActDetailResponseDto.setDelegateTaxId("taxId");
		operationActDetailResponseDto.setRecipientType("type");
		operationActDetailResponseDto.setErrorReason("errorReason");
		operationActDetailResponseDto.setUid("uid");
		operationActDetailResponseDto.setQrCode("qrCode");

		operationActResponseDto.setElement(operationActDetailResponseDto);

		when(pnRaddFsuClient.getActTransactionByOperationId(any())).thenReturn(Mono.just(operationActResponseDto));

		OperationsDetailsResponse operationsDetailsResponse = new OperationsDetailsResponse();
		operationsDetailsResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationsDetailsResponse.setOperationId("42");
		operationsDetailsResponse.setOperationType("type");
		operationsDetailsResponse.setOperationStatus("status");
		operationsDetailsResponse.setFileKey("fileKey");
		operationsDetailsResponse.setIuns(List.of("42"));
		operationsDetailsResponse.setRecipientTaxId("taxId");
		operationsDetailsResponse.setDelegateTaxId("taxId");
		operationsDetailsResponse.setRecipientType("type");
		operationsDetailsResponse.setErrorReason("errorReason");
		operationsDetailsResponse.setUid("uid");
		operationsDetailsResponse.setQrCode("qrCode");
		when(notificationInquiryConverter.enrichActData(any())).thenReturn(operationsDetailsResponse);

		Map map = Map.of("42", "42");
		when(dataVaultService.getRecipientDenominationByInternalId(any())).thenReturn(Mono.just(map));

		OperationsResponse operationsResponse = mock(OperationsResponse.class);
		when(notificationInquiryConverter.operationsDtoToResponse(any(), any(), any(), any())).thenReturn(operationsResponse);
		StepVerifier.create(notificationInquiryService.getActPracticesByIun("iun"))
				.expectError().verify();
	}
	/**
	 * Method under test: {@link NotificationInquiryService#getActTransactionByOperationId(String)}
	 */
	@Test
	void testGetActTransactionByOperationId () {
		// Arrange
		OperationActResponseDto operationActResponseDto = new OperationActResponseDto();
		operationActResponseDto.setResult(true);
		OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
		operationActDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationActDetailResponseDto.setOperationId("42");
		operationActDetailResponseDto.setOperationType("type");
		operationActDetailResponseDto.setOperationStatus("status");
		operationActDetailResponseDto.setFileKey("fileKey");
		operationActDetailResponseDto.setIun("42");
		operationActDetailResponseDto.setRecipientTaxId("taxId");
		operationActDetailResponseDto.setDelegateTaxId("taxId");
		operationActDetailResponseDto.setRecipientType("type");
		operationActDetailResponseDto.setErrorReason("errorReason");
		operationActDetailResponseDto.setUid("uid");
		operationActDetailResponseDto.setQrCode("qrCode");
		operationActResponseDto.setElement(operationActDetailResponseDto);

		when(pnRaddFsuClient.getActTransactionByOperationId(any())).thenReturn(Mono.just(operationActResponseDto));

		Map<String, String> map = Map.of("42", "42");


		when(dataVaultService.getRecipientDenominationByInternalId(Map.of("taxId", "taxId"))).thenReturn(Mono.just(map));

		OperationActResponse operationActResponse = new OperationActResponse();
		operationActResponse.setResult(true);
		OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();
		operationActDetailResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationActDetailResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationActDetailResponse.setOperationId("42");
		operationActDetailResponse.setOperationType("type");
		operationActDetailResponse.setOperationStatus("status");
		operationActDetailResponse.setFileKey("fileKey");
		operationActDetailResponse.setIun("42");
		operationActDetailResponse.setRecipientTaxId("42");
		operationActDetailResponse.setDelegateTaxId("42");
		operationActDetailResponse.setRecipientType("type");
		operationActDetailResponse.setErrorReason("errorReason");
		operationActDetailResponse.setUid("uid");
		operationActDetailResponse.setQrCode("qrCode");
		operationActResponse.setElement(operationActDetailResponse);

		when(notificationInquiryConverter.operationActDtoToResponse(any(), any())).thenReturn(operationActResponse);

		StepVerifier.create(notificationInquiryService.getActTransactionByOperationId("42"))
				.expectNext(operationActResponse)
				.verifyComplete();
	}
	@Test
	void testGetAorTransactionByOperationId2 () {
		// Arrange
		OperationAorResponseDto operationAorResponseDto = new OperationAorResponseDto();
		operationAorResponseDto.setResult(true);
		OperationAorDetailResponseDto operationAorDetailResponseDto = new OperationAorDetailResponseDto();
		operationAorDetailResponseDto.setOperationEndDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationStartDate(OffsetDateTime.now());
		operationAorDetailResponseDto.setOperationId("42");
		operationAorDetailResponseDto.setOperationType("type");
		operationAorDetailResponseDto.setOperationStatus("status");
		operationAorDetailResponseDto.setFileKey("fileKey");
		operationAorDetailResponseDto.setIuns(List.of("42"));
		operationAorDetailResponseDto.setRecipientTaxId("taxId");
		operationAorDetailResponseDto.setDelegateTaxId("taxId");
		operationAorDetailResponseDto.setRecipientType("type");
		operationAorDetailResponseDto.setErrorReason("errorReason");
		operationAorDetailResponseDto.setUid("uid");
		operationAorDetailResponseDto.setQrCode("qrCode");
		operationAorResponseDto.setElement(operationAorDetailResponseDto);

		when(pnRaddFsuClient.getAorTransactionByOperationId(any())).thenReturn(Mono.just(operationAorResponseDto));

		Map<String, String> map = Map.of("42", "42");


		when(dataVaultService.getRecipientDenominationByInternalId(Map.of("taxId", "taxId"))).thenReturn(Mono.just(map));

		OperationAorResponse operationAorResponse = new OperationAorResponse();
		operationAorResponse.setResult(true);
		OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();
		operationAorDetailResponse.setOperationEndDate(Date.from(OffsetDateTime.now().toInstant()));
		operationAorDetailResponse.setOperationStartDate(Date.from(OffsetDateTime.now().toInstant()));
		operationAorDetailResponse.setOperationId("42");
		operationAorDetailResponse.setOperationType("type");
		operationAorDetailResponse.setOperationStatus("status");
		operationAorDetailResponse.setFileKey("fileKey");
		operationAorDetailResponse.setIuns(List.of("42"));
		operationAorDetailResponse.setRecipientTaxId("42");
		operationAorDetailResponse.setDelegateTaxId("42");
		operationAorDetailResponse.setRecipientType("type");
		operationAorDetailResponse.setErrorReason("errorReason");
		operationAorDetailResponse.setUid("uid");
		operationAorDetailResponse.setQrCode("qrCode");
		operationAorResponse.setElement(operationAorDetailResponse);

		when(notificationInquiryConverter.operationAorDtoToResponse(any(), any())).thenReturn(operationAorResponse);

		StepVerifier.create(notificationInquiryService.getAorTransactionByOperationId("42"))
				.expectNext(operationAorResponse)
				.verifyComplete();
	}


	/**
	 * Method under test: {@link NotificationInquiryService#getAorTransactionByOperationId(String)}
	 */
	@Test
	void testGetAorTransactionByOperationId () {

		when(pnRaddFsuClient.getAorTransactionByOperationId(any())).thenReturn(mock(Mono.class));

		notificationInquiryService.getAorTransactionByOperationId("42");

		verify(pnRaddFsuClient).getAorTransactionByOperationId(any());
	}

	@Test
	void testGetAorPracticesByInternalId2 () {

		FilterRequestDto filterRequestDto = new FilterRequestDto();
		OffsetDateTime from = OffsetDateTime.now();
		OffsetDateTime to = OffsetDateTime.now();
		filterRequestDto.setFrom(from);
		filterRequestDto.setTo(to);
		FilterRequest filterRequest = new FilterRequest();
		filterRequest.setFrom(Date.from(from.toInstant()));
		filterRequest.setTo(Date.from(to.toInstant()));

		when(notificationInquiryConverter.filterRequestToDto(any())).thenReturn(filterRequestDto);
		OperationAorDetailResponseDto operationAorDetailResponseDto = mock(OperationAorDetailResponseDto.class);

		OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = new OperationsAorDetailsResponseDto();
		operationsAorDetailsResponseDto.setResult(true);
		operationsAorDetailsResponseDto.setElements(List.of(operationAorDetailResponseDto));

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsAorDetailsResponseDto.setStatus(operationResponseStatusDto);

		when(pnRaddFsuClient.getAorPracticesByInternalId(any(), any())).thenReturn(Mono.just(operationsAorDetailsResponseDto));

		OperationAorDetailResponse operationAorDetailResponse = new OperationAorDetailResponse();
		operationAorDetailResponse.setOperationEndDate(Date.from(from.toInstant()));
		operationAorDetailResponse.setOperationStartDate(Date.from(to.toInstant()));
		operationAorDetailResponse.setOperationId("42");
		operationAorDetailResponse.setOperationType("type");
		operationAorDetailResponse.setOperationStatus("status");
		operationAorDetailResponse.setFileKey("fileKey");
		operationAorDetailResponse.setIuns(List.of("42"));
		operationAorDetailResponse.setRecipientTaxId("taxId");
		operationAorDetailResponse.setDelegateTaxId("taxId");
		operationAorDetailResponse.setRecipientType("type");
		operationAorDetailResponse.setErrorReason("errorReason");
		operationAorDetailResponse.setUid("uid");
		operationAorDetailResponse.setQrCode("qrCode");

		OperationsAorDetailsResponse operationsAorDetailsResponse = new OperationsAorDetailsResponse();
		operationsAorDetailsResponse.setResult(true);
		operationsAorDetailsResponse.setElements(List.of(operationAorDetailResponse));

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");
		operationsAorDetailsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryConverter.operationsAorDetailsDtoToResponse(any())).thenReturn(operationsAorDetailsResponse);
	}

	@Test
	void testGetActPracticesByInternalId2 () {

		FilterRequestDto filterRequestDto = new FilterRequestDto();
		OffsetDateTime from = OffsetDateTime.now();
		OffsetDateTime to = OffsetDateTime.now();
		filterRequestDto.setFrom(from);
		filterRequestDto.setTo(to);
		FilterRequest filterRequest = new FilterRequest();
		filterRequest.setFrom(Date.from(from.toInstant()));
		filterRequest.setTo(Date.from(to.toInstant()));

		when(notificationInquiryConverter.filterRequestToDto(any())).thenReturn(filterRequestDto);
		OperationActDetailResponseDto operationActDetailResponseDto = new OperationActDetailResponseDto();
		operationActDetailResponseDto.setOperationEndDate(from);
		operationActDetailResponseDto.setOperationStartDate(to);
		operationActDetailResponseDto.setOperationId("42");
		operationActDetailResponseDto.setOperationType("type");
		operationActDetailResponseDto.setOperationStatus("status");
		operationActDetailResponseDto.setFileKey("fileKey");
		operationActDetailResponseDto.setIun("42");
		operationActDetailResponseDto.setRecipientTaxId("taxId");
		operationActDetailResponseDto.setDelegateTaxId("taxId");
		operationActDetailResponseDto.setRecipientType("type");
		operationActDetailResponseDto.setErrorReason("errorReason");
		operationActDetailResponseDto.setUid("uid");
		operationActDetailResponseDto.setQrCode("qrCode");

		OperationsActDetailsResponseDto operationsActDetailsResponseDto = new OperationsActDetailsResponseDto();
		operationsActDetailsResponseDto.setResult(true);
		operationsActDetailsResponseDto.setElements(List.of(operationActDetailResponseDto));

		OperationResponseStatusDto operationResponseStatusDto = new OperationResponseStatusDto();
		operationResponseStatusDto.setCode(OperationResponseStatusDto.CodeEnum.NUMBER_0);
		operationResponseStatusDto.setMessage("message");
		operationsActDetailsResponseDto.setStatus(operationResponseStatusDto);

		when(pnRaddFsuClient.getActPracticesByInternalId(any(), any())).thenReturn(Mono.just(operationsActDetailsResponseDto));

		OperationActDetailResponse operationActDetailResponse = new OperationActDetailResponse();
		operationActDetailResponse.setOperationEndDate(Date.from(from.toInstant()));
		operationActDetailResponse.setOperationStartDate(Date.from(to.toInstant()));
		operationActDetailResponse.setOperationId("42");
		operationActDetailResponse.setOperationType("type");
		operationActDetailResponse.setOperationStatus("status");
		operationActDetailResponse.setFileKey("fileKey");
		operationActDetailResponse.setIun("42");
		operationActDetailResponse.setRecipientTaxId("taxId");
		operationActDetailResponse.setDelegateTaxId("taxId");
		operationActDetailResponse.setRecipientType("type");
		operationActDetailResponse.setErrorReason("errorReason");
		operationActDetailResponse.setUid("uid");
		operationActDetailResponse.setQrCode("qrCode");

		OperationsActDetailsResponse operationsActDetailsResponse = new OperationsActDetailsResponse();
		operationsActDetailsResponse.setResult(true);
		operationsActDetailsResponse.setElements(List.of(operationActDetailResponse));

		OperationResponseStatus operationResponseStatus = new OperationResponseStatus();
		operationResponseStatus.setCode(OperationResponseStatus.CodeEnum.NUMBER_0);
		operationResponseStatus.setMessage("message");
		operationsActDetailsResponse.setStatus(operationResponseStatus);

		when(notificationInquiryConverter.operationsActDetailsDtoToResponse(any())).thenReturn(operationsActDetailsResponse);

	}
}

