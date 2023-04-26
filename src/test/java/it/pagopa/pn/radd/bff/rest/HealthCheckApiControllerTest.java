package it.pagopa.pn.radd.bff.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {HealthCheckApiController.class})
@ExtendWith(SpringExtension.class)
class HealthCheckApiControllerTest {

    @Autowired
    private HealthCheckApiController healthCheckApiController;

    @Mock
    ServerWebExchange serverWebExchange;

    @Test
    void testStatus() {
        StepVerifier.create(healthCheckApiController.status(serverWebExchange))
                .expectNext(ResponseEntity.ok().body("OK"));
    }

}

