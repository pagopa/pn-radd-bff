package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {AorTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class AorTransactionManagementServiceTest {
    @Autowired
    private AorTransactionManagementService aorTransactionManagementService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @MockBean
    private TransactionManagementConverter transactionManagementConverter;

    /**
     * Method under test: {@link AorTransactionManagementService#abortAorTransaction(String, Mono)}
     */
    @Test
    void testAbortAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AorTransactionManagementService.pnRaddFsuClient
        //     AorTransactionManagementService.transactionManagementConverter

        aorTransactionManagementService.abortAorTransaction("1234", (Mono<AbortTransactionRequest>) mock(Mono.class));
    }

    /**
     * Method under test: {@link AorTransactionManagementService#completeAorTransaction(String, Mono)}
     */
    @Test
    void testCompleteAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AorTransactionManagementService.pnRaddFsuClient
        //     AorTransactionManagementService.transactionManagementConverter

        aorTransactionManagementService.completeAorTransaction("1234",
                (Mono<CompleteTransactionRequest>) mock(Mono.class));
    }

    /**
     * Method under test: {@link AorTransactionManagementService#startAorTransaction(String, Mono)}
     */
    @Test
    void testStartAorTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AorTransactionManagementService.pnRaddFsuClient
        //     AorTransactionManagementService.transactionManagementConverter

        aorTransactionManagementService.startAorTransaction("1234", (Mono<AorStartTransactionRequest>) mock(Mono.class));
    }
}

