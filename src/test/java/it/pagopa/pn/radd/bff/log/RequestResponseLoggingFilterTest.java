package it.pagopa.pn.radd.bff.log;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RequestResponseLoggingFilter.class})
@ExtendWith(SpringExtension.class)
class RequestResponseLoggingFilterTest {
    @Autowired
    private RequestResponseLoggingFilter requestResponseLoggingFilter;

}

