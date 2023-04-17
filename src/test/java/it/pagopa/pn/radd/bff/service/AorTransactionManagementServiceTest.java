package it.pagopa.pn.radd.bff.service;

import static org.mockito.Mockito.mock;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

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
    @Disabled("TODO: Complete this test")
    void testAbortAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "abortTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.AorTransactionManagementService.abortAorTransaction(AorTransactionManagementService.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementService.abortAorTransaction("1234", null);
    }

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
    @Disabled("TODO: Complete this test")
    void testCompleteAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "completeTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.AorTransactionManagementService.completeAorTransaction(AorTransactionManagementService.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementService.completeAorTransaction("1234", null);
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
    @Disabled("TODO: Complete this test")
    void testStartAorTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "aorStartTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.AorTransactionManagementService.startAorTransaction(AorTransactionManagementService.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        aorTransactionManagementService.startAorTransaction("1234", null);
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

