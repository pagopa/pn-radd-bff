package it.pagopa.pn.radd.bff.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;

import java.util.List;

import org.junit.jupiter.api.Test;

class PnRaddFsuExceptionTest {
    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException("An error occurred", "Code", "Detail", 2,
                "Status Text", new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Status Text", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("An error occurred", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("Detail", getResult.getDetail());
        assertEquals("Code", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor2() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException(null, "foo", "foo", 100, "foo",
                new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("foo", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("Errore durante la chiamata a pn-radd-fsu", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("foo", getResult.getDetail());
        assertEquals("foo", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor3() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException("recipientTaxId=U", "Code", "Detail", 2,
                "Status Text", new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Status Text", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("recipientTaxId=*", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("Detail", getResult.getDetail());
        assertEquals("Code", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor4() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException("", "Code", "Detail", 2, "Status Text",
                new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Status Text", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("Internal Server Error", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("Detail", getResult.getDetail());
        assertEquals("Code", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor5() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException("An error occurred", "Code", "detail", 2,
                "Status Text", new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Status Text", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("An error occurred", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("detail", getResult.getDetail());
        assertEquals("Code", getResult.getCode());
    }

    /**
     * Method under test: {@link PnRaddFsuException#PnRaddFsuException(String, String, String, int, String, Throwable)}
     */
    @Test
    void testConstructor6() {
        PnRaddFsuException actualPnRaddFsuException = new PnRaddFsuException("An error occurred", "Code", "Detail", 2,
                "Internal Server Error", new Throwable());

        assertEquals(100, actualPnRaddFsuException.getStatus());
        Problem problem = actualPnRaddFsuException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Internal Server Error", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("An error occurred", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertNull(getResult.getElement());
        assertEquals("Detail", getResult.getDetail());
        assertEquals("Code", getResult.getCode());
    }
}

