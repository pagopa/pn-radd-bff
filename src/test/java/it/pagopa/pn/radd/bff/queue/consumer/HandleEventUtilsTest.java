package it.pagopa.pn.radd.bff.queue.consumer;

import it.pagopa.pn.api.dto.events.StandardEventHeader;
import it.pagopa.pn.commons.exceptions.PnInternalException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.messaging.MessageHeaders;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HandleEventUtilsTest {
    /**
     * Method under test: {@link HandleEventUtils#handleException(MessageHeaders, Exception)}
     */
    @Test
    void testHandleException3() {
        MessageHeaders headers = mock(MessageHeaders.class);
        when(headers.get(Mockito.<Object>any())).thenReturn(null);
        HandleEventUtils.handleException(headers, new Exception());
        verify(headers, atLeast(1)).get(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link HandleEventUtils#handleException(MessageHeaders, Exception)}
     */
    @Test
    void testHandleException4() {
        MessageHeaders headers = mock(MessageHeaders.class);
        when(headers.get(Mockito.<Object>any())).thenThrow(new PnInternalException("An error occurred"));
        Exception exception = new Exception();
        assertThrows(PnInternalException.class, () -> HandleEventUtils.handleException(headers, exception));
        verify(headers).get(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link HandleEventUtils#mapStandardEventHeader(MessageHeaders)}
     */
    @Test
    void testMapStandardEventHeader() {
        assertThrows(PnInternalException.class, () -> HandleEventUtils.mapStandardEventHeader(null));
    }

    /**
     * Method under test: {@link HandleEventUtils#mapStandardEventHeader(MessageHeaders)}
     */
    @Test
    void testMapStandardEventHeader3() {
        MessageHeaders headers = mock(MessageHeaders.class);
        when(headers.get(Mockito.<Object>any())).thenReturn(null);
        StandardEventHeader actualMapStandardEventHeaderResult = HandleEventUtils.mapStandardEventHeader(headers);
        assertNull(actualMapStandardEventHeaderResult.getCreatedAt());
        assertNull(actualMapStandardEventHeaderResult.getPublisher());
        assertNull(actualMapStandardEventHeaderResult.getIun());
        assertNull(actualMapStandardEventHeaderResult.getEventType());
        assertNull(actualMapStandardEventHeaderResult.getEventId());
        verify(headers, atLeast(1)).get(Mockito.<Object>any());
    }

    /**
     * Method under test: {@link HandleEventUtils#mapStandardEventHeader(MessageHeaders)}
     */
    @Test
    void testMapStandardEventHeader4() {
        MessageHeaders headers = mock(MessageHeaders.class);
        when(headers.get(Mockito.<Object>any())).thenThrow(new PnInternalException("An error occurred"));
        assertThrows(PnInternalException.class, () -> HandleEventUtils.mapStandardEventHeader(headers));
        verify(headers).get(Mockito.<Object>any());
    }
}

