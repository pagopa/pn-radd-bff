package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.NotificationInquiryConverter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationsActDetailsResponseDto;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.OperationsAorDetailsResponseDto;
import it.pagopa.pn.radd.bff.rest.v1.dto.FilterRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.OperationsActDetailsResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.OperationsAorDetailsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



@ExtendWith (SpringExtension.class)
class NotificationInquiryServiceTest {
	@Mock
	private NotificationInquiryConverter notificationInquiryConverter;

	@Mock
	private PnRaddFsuClient pnRaddFsuClient;

	@InjectMocks
	private NotificationInquiryService notificationInquiryService;



	@Test
	void testGetActPracticesByInternalId(){
		when(pnRaddFsuClient.getActPracticesByInternalId(any(),any()))
				.thenReturn((Mono<OperationsActDetailsResponseDto>) mock(Mono.class));
		OperationsActDetailsResponse operationsActDetailsResponse = mock(OperationsActDetailsResponse.class);
		when(notificationInquiryConverter.operationsActDetailsDtoToResponse(any()))
				.thenReturn(operationsActDetailsResponse);
		FilterRequest filterRequest = mock(FilterRequest.class);
		StepVerifier.create(notificationInquiryService.getActPracticesByInternalId("taxId",Mono.just(filterRequest)))
				.expectNext(operationsActDetailsResponse);
	}

	@Test
	void testGetAorPracticesByInternalId(){
		when(pnRaddFsuClient.getAorPracticesByInternalId(any(),any()))
				.thenReturn((Mono<OperationsAorDetailsResponseDto>) mock(Mono.class));
		OperationsAorDetailsResponse operationsAorDetailsResponse = mock(OperationsAorDetailsResponse.class);
		when(notificationInquiryConverter.operationsAorDetailsDtoToResponse(any()))
				.thenReturn(operationsAorDetailsResponse);
		FilterRequest filterRequest = mock(FilterRequest.class);
		StepVerifier.create(notificationInquiryService.getAorPracticesByInternalId("taxId",Mono.just(filterRequest)))
				.expectNext(operationsAorDetailsResponse);
	}

	/**
	 * Method under test: {@link NotificationInquiryService#getActPracticesByIun(String)}
	 */
	@Test
	void testGetActPracticesByIun () {
		when(pnRaddFsuClient.getActPracticesByIun(any()))
				.thenReturn(mock(Mono.class));
		StepVerifier.create(notificationInquiryService.getActPracticesByIun("Iun"));
	}

	/**
	 * Method under test: {@link NotificationInquiryService#getActTransactionByOperationId(String)}
	 */
	@Test
	void testGetActTransactionByOperationId () {
		// Arrange
		when(pnRaddFsuClient.getActTransactionByOperationId(any())).thenReturn(mock(Mono.class));

		// Act
		notificationInquiryService.getActTransactionByOperationId("42");

		// Assert
		verify(pnRaddFsuClient).getActTransactionByOperationId(any());
	}

	/**
	 * Method under test: {@link NotificationInquiryService#getAorPracticesByIun(String)}
	 */
	@Test
	void testGetAorPracticesByIun () {
		when(pnRaddFsuClient.getAorPracticesByIun(any()))
				.thenReturn(mock(Mono.class));
		StepVerifier.create(notificationInquiryService.getAorPracticesByIun("Iun"));
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
}

