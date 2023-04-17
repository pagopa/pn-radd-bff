package it.pagopa.pn.radd.bff.rest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HealthCheckApiController.class})
@ExtendWith(SpringExtension.class)
class HealthCheckApiControllerTest {
    @Autowired
    private HealthCheckApiController healthCheckApiController;

}

