package it.pagopa.pn.radd.bff.rest;

import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.StartTransactionResponse;
import it.pagopa.pn.radd.bff.service.ActTransactionManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ActTransactionManagementController.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementControllerTest {
    @Autowired
    private ActTransactionManagementController actTransactionManagementController;

    @MockBean
    private ActTransactionManagementService actTransactionManagementService;

    /**
     * Method under test: {@link ActTransactionManagementController#abortActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortActTransaction3() {
        when(actTransactionManagementService.abortActTransaction(any(), any()))
                .thenReturn((Mono<AbortTransactionResponse>) mock(Mono.class));
        actTransactionManagementController.abortActTransaction("1234", null, null);
        verify(actTransactionManagementService).abortActTransaction(any(),
                any());
    }

    /**
     * Method under test: {@link ActTransactionManagementController#completeActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteActTransaction3() {
        when(actTransactionManagementService.completeActTransaction(any(),
                any())).thenReturn((Mono<CompleteTransactionResponse>) mock(Mono.class));
        actTransactionManagementController.completeActTransaction("1234", null, null);
        verify(actTransactionManagementService).completeActTransaction(any(),
                any());
    }

    /**
     * Method under test: {@link ActTransactionManagementController#startActTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartActTransaction3() {
        when(
                actTransactionManagementService.startActTransaction(any(), any()))
                .thenReturn((Mono<StartTransactionResponse>) mock(Mono.class));
        actTransactionManagementController.startActTransaction("1234", null, null);
        verify(actTransactionManagementService).startActTransaction(any(),
                any());
    }
}

