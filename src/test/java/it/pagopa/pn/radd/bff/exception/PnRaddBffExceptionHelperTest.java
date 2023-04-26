package it.pagopa.pn.radd.bff.exception;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {PnRaddBffExceptionHelper.class, String.class})
@ExtendWith(SpringExtension.class)
class PnRaddBffExceptionHelperTest {
    @MockBean
    private ObjectProvider objectProvider;

    @Autowired
    private PnRaddBffExceptionHelper pnRaddBffExceptionHelper;

    /**
     * Method under test: {@link PnRaddBffExceptionHelper#handleException(Throwable)}
     */
    @Test
    void testHandleException() {
        Problem actualHandleExceptionResult = pnRaddBffExceptionHelper.handleException(new Throwable());
        assertEquals("See logs for details in ", actualHandleExceptionResult.getDetail());
        assertEquals("GENERIC_ERROR", actualHandleExceptionResult.getType());
        assertEquals("Unexpected error", actualHandleExceptionResult.getTitle());
        assertEquals(500, actualHandleExceptionResult.getStatus().intValue());
        List<ProblemError> errors = actualHandleExceptionResult.getErrors();
        assertEquals(1, errors.size());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("none", getResult.getDetail());
        assertEquals("PN_GENERIC_ERROR", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddBffExceptionHelper#handleException(Throwable)}
     */
    @Test
    void testHandleException3() {
        Problem actualHandleExceptionResult = pnRaddBffExceptionHelper
                .handleException(new Throwable("Not all who wander are lost"));
        assertEquals("See logs for details in ", actualHandleExceptionResult.getDetail());
        assertEquals("GENERIC_ERROR", actualHandleExceptionResult.getType());
        assertEquals("Unexpected error", actualHandleExceptionResult.getTitle());
        assertEquals(500, actualHandleExceptionResult.getStatus().intValue());
        List<ProblemError> errors = actualHandleExceptionResult.getErrors();
        assertEquals(1, errors.size());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("none", getResult.getDetail());
        assertEquals("PN_GENERIC_ERROR", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddBffExceptionHelper#handleException(Throwable)}
     */
    @Test
    void testHandleException4() {
        Problem actualHandleExceptionResult = pnRaddBffExceptionHelper.handleException(new Throwable("recipientTaxId=U"));
        assertEquals("See logs for details in ", actualHandleExceptionResult.getDetail());
        assertEquals("GENERIC_ERROR", actualHandleExceptionResult.getType());
        assertEquals("Unexpected error", actualHandleExceptionResult.getTitle());
        assertEquals(500, actualHandleExceptionResult.getStatus().intValue());
        List<ProblemError> errors = actualHandleExceptionResult.getErrors();
        assertEquals(1, errors.size());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("none", getResult.getDetail());
        assertEquals("PN_GENERIC_ERROR", getResult.getCode());
    }
}

