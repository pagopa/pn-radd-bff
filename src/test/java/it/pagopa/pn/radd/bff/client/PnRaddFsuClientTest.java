package it.pagopa.pn.radd.bff.client;

import it.pagopa.pn.radd.bff.config.PnRaddBffConfig;
import it.pagopa.pn.radd.bff.generated.openapi.msclient.radd.fsu.v1.api.*;
import it.pagopa.pn.radd.bff.log.ResponseExchangeFilter;
import it.pagopa.pn.radd.bff.msclient.generated.radd.fsu.v1.dto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith (SpringExtension.class)
@TestPropertySource(properties = {
        "aws.region=${AWS_REGION}",
})
class PnRaddFsuClientTest {

    @Value("${AWS_REGION:eu-south-1}")

    private static final String AWS_REGION = "eu-south-1";
    private static PnRaddFsuClient pnRaddFsuClient;

    @Mock
    private DocumentUploadApi documentUploadApi;
    @Mock
    private ActDocumentInquiryApi actDocumentInquiryApi;

    @Mock
    private ActTransactionManagementApi actTransactionManagementApi;
    @Mock
    private NotificationInquiryApi notificationInquiryApi;
    @Mock
    private AorDocumentInquiryApi aorDocumentInquiryApi;

    @Mock
    private AorTransactionManagementApi aorTransactionManagementApi;

    @Mock
    private static PnRaddBffConfig pnRaddBffConfig;

    @Mock
    private static ResponseExchangeFilter responseExchangeFilter;

    @BeforeAll
    static void init () {
        pnRaddBffConfig = new PnRaddBffConfig();
        pnRaddBffConfig.setClientPnRaddFsuBasepath("http://localhost:8080");
        responseExchangeFilter = new ResponseExchangeFilter();
        pnRaddFsuClient = new PnRaddFsuClient(pnRaddBffConfig, responseExchangeFilter);
    }


    @Test
    void testActInquiry () {

        ActInquiryResponseDto actInquiryResponseDto = new ActInquiryResponseDto();

        ActInquiryResponseStatusDto actInquiryResponseStatusDto = new ActInquiryResponseStatusDto();
        actInquiryResponseStatusDto.setCode(ActInquiryResponseStatusDto.CodeEnum.NUMBER_0);
        actInquiryResponseStatusDto.setMessage("message");

        actInquiryResponseDto.setStatus(actInquiryResponseStatusDto);
        actInquiryResponseDto.setResult(true);

        when(actDocumentInquiryApi.actInquiry("uid", "recipientTaxId", "recipientType", "qrCode"))
                .thenReturn(Mono.just(actInquiryResponseDto));

        StepVerifier.create(pnRaddFsuClient.actInquiry("uid", "recipientTaxId", "recipientType", "qrCode"))
                .expectNext(actInquiryResponseDto);
    }
    @Test
    void testAorInquiry () {

        AORInquiryResponseDto aorInquiryResponseDto = new AORInquiryResponseDto();

        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.setCode(ResponseStatusDto.CodeEnum.NUMBER_0);
        responseStatusDto.setMessage("message");

        aorInquiryResponseDto.setStatus(responseStatusDto);
        aorInquiryResponseDto.setResult(true);

        when(aorDocumentInquiryApi.aorInquiry("uid", "recipientTaxId", "recipientType"))
                .thenReturn(Mono.just(aorInquiryResponseDto));

        StepVerifier.create(pnRaddFsuClient.aorInquiry("uid", "recipientTaxId", "recipientType"))
                .expectNext(aorInquiryResponseDto);
    }
    @Test
    void testDocumentUpload () {

        DocumentUploadRequestDto documentUploadRequestDto = new DocumentUploadRequestDto();

        documentUploadRequestDto.setBundleId("bundleId");
        documentUploadRequestDto.setChecksum("checksum");
        documentUploadRequestDto.setContentType("application/zip");

        DocumentUploadResponseDto documentUploadResponseDto = new DocumentUploadResponseDto();

        ResponseStatusDto responseStatusDto = new ResponseStatusDto();
        responseStatusDto.setCode(ResponseStatusDto.CodeEnum.NUMBER_0);
        responseStatusDto.setMessage("message");

        documentUploadResponseDto.setStatus(responseStatusDto);
        documentUploadResponseDto.setSecret("secret");
        documentUploadResponseDto.setFileKey("fileKey");
        documentUploadResponseDto.setUrl("url");

        when(documentUploadApi.documentUpload("uid", documentUploadRequestDto))
                .thenReturn(Mono.just(documentUploadResponseDto));

        StepVerifier.create(pnRaddFsuClient.documentUpload("uid", documentUploadRequestDto))
                .expectNext(documentUploadResponseDto);
    }

    @Test
    void testActAbortTransaction () {

        AbortTransactionRequestDto abortTransactionRequestDto = mock(AbortTransactionRequestDto.class);


        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);

        when(actTransactionManagementApi.abortActTransaction("uid", abortTransactionRequestDto))
                .thenReturn(Mono.just(abortTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.abortActTransaction("uid", abortTransactionRequestDto))
                .expectNext(abortTransactionResponseDto);
    }

    @Test
    void testActCompleteTransaction () {

        CompleteTransactionRequestDto completeTransactionRequestDto = mock(CompleteTransactionRequestDto.class);


        CompleteTransactionResponseDto completeTransactionResponseDto = mock(CompleteTransactionResponseDto.class);

        when(actTransactionManagementApi.completeActTransaction("uid", completeTransactionRequestDto))
                .thenReturn(Mono.just(completeTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.completeActTransaction("uid", completeTransactionRequestDto))
                .expectNext(completeTransactionResponseDto);
    }

    @Test
    void testActStartTransaction () {

        ActStartTransactionRequestDto actStartTransactionRequestDto = mock(ActStartTransactionRequestDto.class);


        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);

        when(actTransactionManagementApi.startActTransaction("uid", actStartTransactionRequestDto))
                .thenReturn(Mono.just(startTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.startActTransaction("uid", actStartTransactionRequestDto))
                .expectNext(startTransactionResponseDto);
    }

    @Test
    void testAORAbortTransaction () {

        AbortTransactionRequestDto abortTransactionRequestDto = mock(AbortTransactionRequestDto.class);


        AbortTransactionResponseDto abortTransactionResponseDto = mock(AbortTransactionResponseDto.class);

        when(aorTransactionManagementApi.abortAorTransaction("uid", abortTransactionRequestDto))
                .thenReturn(Mono.just(abortTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.abortAorTransaction("uid", abortTransactionRequestDto))
                .expectNext(abortTransactionResponseDto);
    }

    @Test
    void testAORCompleteTransaction () {

        CompleteTransactionRequestDto completeTransactionRequestDto = mock(CompleteTransactionRequestDto.class);


        CompleteTransactionResponseDto completeTransactionResponseDto = mock(CompleteTransactionResponseDto.class);

        when(aorTransactionManagementApi.completeAorTransaction("uid", completeTransactionRequestDto))
                .thenReturn(Mono.just(completeTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.completeAorTransaction("uid", completeTransactionRequestDto))
                .expectNext(completeTransactionResponseDto);
    }

    @Test
    void testAORStartTransaction () {

        AorStartTransactionRequestDto aorStartTransactionRequestDto = mock(AorStartTransactionRequestDto.class);


        StartTransactionResponseDto startTransactionResponseDto = mock(StartTransactionResponseDto.class);

        when(aorTransactionManagementApi.startAorTransaction("uid", aorStartTransactionRequestDto))
                .thenReturn(Mono.just(startTransactionResponseDto));

        StepVerifier.create(pnRaddFsuClient.startAorTransaction("uid", aorStartTransactionRequestDto))
                .expectNext(startTransactionResponseDto);
    }
    @Test
    void testGetActPracticesByInternalId () {

        FilterRequestDto filterRequestDto = mock(FilterRequestDto.class);

        OperationsActDetailsResponseDto operationsActDetailsResponseDto = mock(OperationsActDetailsResponseDto.class);

        when(notificationInquiryApi.getActPracticesByInternalId("internalID",filterRequestDto))
                .thenReturn(Mono.just(operationsActDetailsResponseDto));
        StepVerifier.create(pnRaddFsuClient.getActPracticesByInternalId("InternalId",filterRequestDto))
                .expectNext(operationsActDetailsResponseDto);
    }
    @Test
    void testGetActTransactionByOperationId () {

        OperationActResponseDto operationActResponseDto = mock(OperationActResponseDto.class);

        when(notificationInquiryApi.getActTransactionByOperationId("operationId"))
                .thenReturn(Mono.just(operationActResponseDto));
        StepVerifier.create(pnRaddFsuClient.getActTransactionByOperationId("operationId"))
                .expectNext(operationActResponseDto);
    }
    @Test
    void testGetActPracticesByIun() {
        OperationsResponseDto operationsResponseDto = mock(OperationsResponseDto.class);

        when(notificationInquiryApi.getActPracticesByIun("iun"))
                .thenReturn(Mono.just(operationsResponseDto));
        StepVerifier.create(pnRaddFsuClient.getActPracticesByIun("iun"))
                .expectNext(operationsResponseDto);
    }
    @Test
    void testGetAorPracticesByInternalId () {

        FilterRequestDto filterRequestDto = mock(FilterRequestDto.class);

        OperationsAorDetailsResponseDto operationsAorDetailsResponseDto = mock(OperationsAorDetailsResponseDto.class);

        when(notificationInquiryApi.getAorPracticesByInternalId("internalID",filterRequestDto))
                .thenReturn(Mono.just(operationsAorDetailsResponseDto));
        StepVerifier.create(pnRaddFsuClient.getAorPracticesByInternalId("InternalId",filterRequestDto))
                .expectNext(operationsAorDetailsResponseDto);
    }
    @Test
    void testGetAorPracticesByIun() {
        OperationsResponseDto operationsResponseDto = mock(OperationsResponseDto.class);

        when(notificationInquiryApi.getAorPracticesByIun("iun"))
                .thenReturn(Mono.just(operationsResponseDto));
        StepVerifier.create(pnRaddFsuClient.getAorPracticesByIun("iun"))
                .expectNext(operationsResponseDto);
    }
    @Test
    void testGetAorTransactionByOperationId () {

        OperationAorResponseDto operationAorResponseDto = mock(OperationAorResponseDto.class);

        when(notificationInquiryApi.getAorTransactionByOperationId("operationId"))
                .thenReturn(Mono.just(operationAorResponseDto));
        StepVerifier.create(pnRaddFsuClient.getAorTransactionByOperationId("operationId"))
                .expectNext(operationAorResponseDto);
    }
}

