package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {ActTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementServiceTest {
    @Autowired
    private ActTransactionManagementService actTransactionManagementService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @MockBean
    private TransactionManagementConverter transactionManagementConverter;

    /**
     * Method under test: {@link ActTransactionManagementService#abortActTransaction(String, Mono)}
     */
    @Test
    void testAbortActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ActTransactionManagementService.pnRaddFsuClient
        //     ActTransactionManagementService.transactionManagementConverter

        actTransactionManagementService.abortActTransaction("1234", (Mono<AbortTransactionRequest>) mock(Mono.class));
    }

    /**
     * Method under test: {@link ActTransactionManagementService#completeActTransaction(String, Mono)}
     */
    @Test
    void testCompleteActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ActTransactionManagementService.pnRaddFsuClient
        //     ActTransactionManagementService.transactionManagementConverter

        actTransactionManagementService.completeActTransaction("1234",
                (Mono<CompleteTransactionRequest>) mock(Mono.class));
    }

    /**
     * Method under test: {@link ActTransactionManagementService#startActTransaction(String, Mono)}
     */
    @Test
    void testStartActTransaction2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ActTransactionManagementService.pnRaddFsuClient
        //     ActTransactionManagementService.transactionManagementConverter

        actTransactionManagementService.startActTransaction("1234", (Mono<ActStartTransactionRequest>) mock(Mono.class));
    }
}

