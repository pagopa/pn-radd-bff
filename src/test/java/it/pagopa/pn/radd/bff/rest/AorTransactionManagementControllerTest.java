package it.pagopa.pn.radd.bff.rest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.AbortTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.AorStartTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionRequest;
import it.pagopa.pn.radd.bff.rest.v1.dto.CompleteTransactionResponse;
import it.pagopa.pn.radd.bff.rest.v1.dto.StartTransactionResponse;
import it.pagopa.pn.radd.bff.service.AorTransactionManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {AorTransactionManagementController.class})
@ExtendWith(SpringExtension.class)
class AorTransactionManagementControllerTest {
    @Autowired
    private AorTransactionManagementController aorTransactionManagementController;

    @MockBean
    private AorTransactionManagementService aorTransactionManagementService;

    /**
     * Method under test: {@link AorTransactionManagementController#abortAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testAbortAorTransaction3() {
        when(aorTransactionManagementService.abortAorTransaction(any(), any()))
                .thenReturn((Mono<AbortTransactionResponse>) mock(Mono.class));
        aorTransactionManagementController.abortAorTransaction("1234", null, null);
        verify(aorTransactionManagementService).abortAorTransaction(any(),
                any());
    }

    /**
     * Method under test: {@link AorTransactionManagementController#completeAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testCompleteAorTransaction3() {
        when(aorTransactionManagementService.completeAorTransaction(any(),
                any())).thenReturn((Mono<CompleteTransactionResponse>) mock(Mono.class));
        aorTransactionManagementController.completeAorTransaction("1234", null, null);
        verify(aorTransactionManagementService).completeAorTransaction(any(),
                any());
    }

    /**
     * Method under test: {@link AorTransactionManagementController#startAorTransaction(String, Mono, ServerWebExchange)}
     */
    @Test
    void testStartAorTransaction3() {
        when(
                aorTransactionManagementService.startAorTransaction(any(), any()))
                .thenReturn((Mono<StartTransactionResponse>) mock(Mono.class));
        aorTransactionManagementController.startAorTransaction("1234", null, null);
        verify(aorTransactionManagementService).startAorTransaction(any(),
                any());
    }
}

