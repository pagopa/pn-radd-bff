package it.pagopa.pn.radd.bff.queue.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import it.pagopa.pn.api.dto.events.StandardEventHeader;
import org.junit.jupiter.api.Test;

class PnRaddBffEventTest {
    /**
     * Method under test: {@link PnRaddBffEvent#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new PnRaddBffEvent()).canEqual("Other"));
    }

    /**
     * Method under test: {@link PnRaddBffEvent#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertTrue(pnRaddBffEvent.canEqual(pnRaddBffEvent2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PnRaddBffEvent}
     *   <li>{@link PnRaddBffEvent#setHeader(StandardEventHeader)}
     *   <li>{@link PnRaddBffEvent#setPayload(PnRaddBffEvent.Payload)}
     *   <li>{@link PnRaddBffEvent#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PnRaddBffEvent actualPnRaddBffEvent = new PnRaddBffEvent();
        actualPnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");
        actualPnRaddBffEvent.setPayload(payload);
        assertEquals(
                "PnRaddBffEvent(header=StandardEventHeader(iun=Iun), payload=PnRaddBffEvent.Payload(key=Key, versionId=42,"
                        + " documentType=Document Type, documentStatus=Document Status, contentType=text/plain, checksum=Checksum,"
                        + " retentionUntil=Retention Until, clientShortCode=Client Short Code))",
                actualPnRaddBffEvent.toString());
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);
        assertNotEquals(null, pnRaddBffEvent);
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals2() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);
        assertNotEquals("Different type to PnRaddBffEvent", pnRaddBffEvent);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PnRaddBffEvent#equals(Object)}
     *   <li>{@link PnRaddBffEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);
        assertEquals(pnRaddBffEvent, pnRaddBffEvent);
        int expectedHashCodeResult = pnRaddBffEvent.hashCode();
        assertEquals(expectedHashCodeResult, pnRaddBffEvent.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PnRaddBffEvent#equals(Object)}
     *   <li>{@link PnRaddBffEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertEquals(pnRaddBffEvent, pnRaddBffEvent2);
        int expectedHashCodeResult = pnRaddBffEvent.hashCode();
        assertEquals(expectedHashCodeResult, pnRaddBffEvent2.hashCode());
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals5() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Key"));
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertNotEquals(pnRaddBffEvent, pnRaddBffEvent2);
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals6() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(null);
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertNotEquals(pnRaddBffEvent, pnRaddBffEvent2);
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals7() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Checksum");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(mock(StandardEventHeader.class));
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertNotEquals(pnRaddBffEvent, pnRaddBffEvent2);
    }

    /**
     * Method under test: {@link PnRaddBffEvent#equals(Object)}
     */
    @Test
    void testEquals8() {
        PnRaddBffEvent.Payload payload = new PnRaddBffEvent.Payload();
        payload.setChecksum("Iun");
        payload.setClientShortCode("Client Short Code");
        payload.setContentType("text/plain");
        payload.setDocumentStatus("Document Status");
        payload.setDocumentType("Document Type");
        payload.setKey("Key");
        payload.setRetentionUntil("Retention Until");
        payload.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent = new PnRaddBffEvent();
        pnRaddBffEvent.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent.setPayload(payload);

        PnRaddBffEvent.Payload payload2 = new PnRaddBffEvent.Payload();
        payload2.setChecksum("Checksum");
        payload2.setClientShortCode("Client Short Code");
        payload2.setContentType("text/plain");
        payload2.setDocumentStatus("Document Status");
        payload2.setDocumentType("Document Type");
        payload2.setKey("Key");
        payload2.setRetentionUntil("Retention Until");
        payload2.setVersionId("42");

        PnRaddBffEvent pnRaddBffEvent2 = new PnRaddBffEvent();
        pnRaddBffEvent2.setHeader(new StandardEventHeader("Iun"));
        pnRaddBffEvent2.setPayload(payload2);
        assertNotEquals(pnRaddBffEvent, pnRaddBffEvent2);
    }

    /**
     * Method under test: {@link PnRaddBffEvent#getHeader()}
     */
    @Test
    void testGetHeader() {
        assertNull((new PnRaddBffEvent()).getHeader());
    }

    /**
     * Method under test: {@link PnRaddBffEvent#getPayload()}
     */
    @Test
    void testGetPayload() {
        assertNull((new PnRaddBffEvent()).getPayload());
    }
}

