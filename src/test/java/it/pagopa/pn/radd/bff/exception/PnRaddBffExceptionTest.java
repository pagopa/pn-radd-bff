package it.pagopa.pn.radd.bff.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import it.pagopa.pn.common.rest.error.v1.dto.Problem;
import it.pagopa.pn.common.rest.error.v1.dto.ProblemError;

import java.util.List;

import org.junit.jupiter.api.Test;

class PnRaddBffExceptionTest {
    /**
     * Method under test: {@link PnRaddBffException#PnRaddBffException(String, String, int, String, String, String)}
     */
    @Test
    void testConstructor() {
        PnRaddBffException actualPnRaddBffException = new PnRaddBffException("An error occurred",
                "The characteristics of someone or something", 2, "An error occurred", "Element", "Detail");

        assertEquals(100, actualPnRaddBffException.getStatus());
        Problem problem = actualPnRaddBffException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("An error occurred", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("The characteristics of someone or something", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertEquals("Element", getResult.getElement());
        assertEquals("An error occurred", getResult.getCode());
        assertEquals("Detail", getResult.getDetail());
    }

    /**
     * Method under test: {@link PnRaddBffException#PnRaddBffException(String, String, int, String, String, String)}
     */
    @Test
    void testConstructor2() {
        PnRaddBffException actualPnRaddBffException = new PnRaddBffException("foo", "foo", 1, "foo", "foo", "foo");

        assertEquals(100, actualPnRaddBffException.getStatus());
        Problem problem = actualPnRaddBffException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("foo", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("foo", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertEquals("foo", getResult.getElement());
        assertEquals("foo", getResult.getCode());
        assertEquals("foo", getResult.getDetail());
    }

    /**
     * Method under test: {@link PnRaddBffException#PnRaddBffException(String, String, int, String, String, String)}
     */
    @Test
    void testConstructor3() {
        PnRaddBffException actualPnRaddBffException = new PnRaddBffException("",
                "The characteristics of someone or something", 2, "An error occurred", "Element", "Detail");

        assertEquals(100, actualPnRaddBffException.getStatus());
        Problem problem = actualPnRaddBffException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("Internal Server Error", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("The characteristics of someone or something", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertEquals("Element", getResult.getElement());
        assertEquals("An error occurred", getResult.getCode());
        assertEquals("Detail", getResult.getDetail());
    }

    /**
     * Method under test: {@link PnRaddBffException#PnRaddBffException(String, String, int, String, String, String)}
     */
    @Test
    void testConstructor4() {
        PnRaddBffException actualPnRaddBffException = new PnRaddBffException("An error occurred", "", 2,
                "An error occurred", "Element", "Detail");

        assertEquals(100, actualPnRaddBffException.getStatus());
        Problem problem = actualPnRaddBffException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("An error occurred", problem.getTitle());
        assertEquals(100, problem.getStatus().intValue());
        assertEquals("Internal Server Error", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertEquals("Element", getResult.getElement());
        assertEquals("An error occurred", getResult.getCode());
        assertEquals("Detail", getResult.getDetail());
    }

    /**
     * Method under test: {@link PnRaddBffException#PnRaddBffException(String, String, int, String, String, String)}
     */
    @Test
    void testConstructor5() {
        PnRaddBffException actualPnRaddBffException = new PnRaddBffException("An error occurred",
                "The characteristics of someone or something", 4096, "An error occurred", "Element", "Detail");

        assertEquals(600, actualPnRaddBffException.getStatus());
        Problem problem = actualPnRaddBffException.getProblem();
        assertNull(problem.getTraceId());
        assertEquals("An error occurred", problem.getTitle());
        assertEquals(600, problem.getStatus().intValue());
        assertEquals("The characteristics of someone or something", problem.getDetail());
        List<ProblemError> errors = problem.getErrors();
        assertEquals(1, errors.size());
        assertEquals("GENERIC_ERROR", problem.getType());
        ProblemError getResult = errors.get(0);
        assertEquals("Element", getResult.getElement());
        assertEquals("An error occurred", getResult.getCode());
        assertEquals("Detail", getResult.getDetail());
    }
}

