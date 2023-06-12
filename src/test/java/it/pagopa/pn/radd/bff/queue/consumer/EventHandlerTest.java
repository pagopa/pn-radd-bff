package it.pagopa.pn.radd.bff.queue.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {EventHandler.class})
@ExtendWith(SpringExtension.class)
class EventHandlerTest {
    @Autowired
    private EventHandler eventHandler;

    /**
     * Method under test: {@link EventHandler#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new EventHandler()).canEqual("Other"));
    }

    /**
     * Method under test: {@link EventHandler#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        EventHandler eventHandler2 = new EventHandler();

        EventHandler eventHandler3 = new EventHandler();
        eventHandler3.setHandlerDocumentReady("Handler Document Ready");
        assertTrue(eventHandler2.canEqual(eventHandler3));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link EventHandler}
     *   <li>{@link EventHandler#setHandlerDocumentReady(String)}
     *   <li>{@link EventHandler#toString()}
     *   <li>{@link EventHandler#getHandlerDocumentReady()}
     * </ul>
     */
    @Test
    void testConstructor() {
        EventHandler actualEventHandler = new EventHandler();
        actualEventHandler.setHandlerDocumentReady("Handler Document Ready");
        String actualToStringResult = actualEventHandler.toString();
        assertEquals("Handler Document Ready", actualEventHandler.getHandlerDocumentReady());
        assertEquals("EventHandler(handlerDocumentReady=Handler Document Ready)", actualToStringResult);
    }

    /**
     * Method under test: {@link EventHandler#equals(Object)}
     */
    @Test
    void testEquals() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady("Handler Document Ready");
        assertNotEquals(null, eventHandler);
    }

    /**
     * Method under test: {@link EventHandler#equals(Object)}
     */
    @Test
    void testEquals2() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady("Handler Document Ready");
        assertNotEquals("Different type to EventHandler", eventHandler);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EventHandler#equals(Object)}
     *   <li>{@link EventHandler#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady("Handler Document Ready");
        assertEquals(eventHandler, eventHandler);
        int expectedHashCodeResult = eventHandler.hashCode();
        assertEquals(expectedHashCodeResult, eventHandler.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EventHandler#equals(Object)}
     *   <li>{@link EventHandler#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady("Handler Document Ready");

        EventHandler eventHandler2 = new EventHandler();
        eventHandler2.setHandlerDocumentReady("Handler Document Ready");
        assertEquals(eventHandler, eventHandler2);
        int expectedHashCodeResult = eventHandler.hashCode();
        assertEquals(expectedHashCodeResult, eventHandler2.hashCode());
    }

    /**
     * Method under test: {@link EventHandler#equals(Object)}
     */
    @Test
    void testEquals5() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady(null);

        EventHandler eventHandler2 = new EventHandler();
        eventHandler2.setHandlerDocumentReady("Handler Document Ready");
        assertNotEquals(eventHandler, eventHandler2);
    }

    /**
     * Method under test: {@link EventHandler#equals(Object)}
     */
    @Test
    void testEquals6() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady("it.pagopa.pn.radd.bff.queue.consumer.EventHandler");

        EventHandler eventHandler2 = new EventHandler();
        eventHandler2.setHandlerDocumentReady("Handler Document Ready");
        assertNotEquals(eventHandler, eventHandler2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EventHandler#equals(Object)}
     *   <li>{@link EventHandler#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.setHandlerDocumentReady(null);

        EventHandler eventHandler2 = new EventHandler();
        eventHandler2.setHandlerDocumentReady(null);
        assertEquals(eventHandler, eventHandler2);
        int expectedHashCodeResult = eventHandler.hashCode();
        assertEquals(expectedHashCodeResult, eventHandler2.hashCode());
    }
}

