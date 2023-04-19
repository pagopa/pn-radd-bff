package it.pagopa.pn.radd.bff.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;

import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    @Disabled("TODO: Complete this test")
    void testHandleException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Throwable.getMessage()" because "throwable" is null
        //       at it.pagopa.pn.radd.bff.exception.PnRaddBffExceptionHelper.handleException(PnRaddBffExceptionHelper.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        pnRaddBffExceptionHelper.handleException(null);
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

