package it.pagopa.pn.radd.bff.service;

import static org.mockito.Mockito.mock;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {ActTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementControllerServiceTest {
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
    @Disabled("TODO: Complete this test")
    void testAbortActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "abortTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.ActTransactionManagementService.abortActTransaction(ActTransactionManagementService.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementService.abortActTransaction("1234", null);
    }

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
    @Disabled("TODO: Complete this test")
    void testCompleteActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "completeTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.ActTransactionManagementService.completeActTransaction(ActTransactionManagementService.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementService.completeActTransaction("1234", null);
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
    @Disabled("TODO: Complete this test")
    void testStartActTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "actStartTransactionRequest" is null
        //       at it.pagopa.pn.radd.bff.service.ActTransactionManagementService.startActTransaction(ActTransactionManagementService.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        actTransactionManagementService.startActTransaction("1234", null);
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

