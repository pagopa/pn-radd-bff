package it.pagopa.pn.radd.bff.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "AWS_REGION=eu-south-1",
        "PN_RADD_BFF_DYNAMODB_TABLENAME_PN_DOCUMENT=test"
})
class TemplateSampleApiControllerTest {

    @Test
    void getHttpHeadersMap() {
        Assertions.assertTrue(true, "Not yet Implemented");
    }
}
