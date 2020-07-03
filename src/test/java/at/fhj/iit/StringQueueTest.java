package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing StringQueue Implementation")
class StringQueueTest {

    private static final String FIRST = "Hohoho";
    private static final String SECOND = "Antipasti";

    //Setting up the List needed to test functionality
    private StringQueue stringQueue;

    @BeforeEach
    void setup() {
        stringQueue = new StringQueue(5);
        stringQueue.offer(FIRST);
        stringQueue.offer(SECOND);
    }

    @Test
    @DisplayName("Testing offer()")
    void testOffer() {
        assertTrue(stringQueue.offer("Mutzi"));
        stringQueue.offer("Sunny");
        stringQueue.offer("Cloudy");
        stringQueue.offer("Stormy");
        assertFalse(stringQueue.offer("Angry"));
    }

    @Test
    @DisplayName("Testing poll()")
    void testPoll() {
        assertEquals(FIRST, stringQueue.poll());
    }

    @Test
    @DisplayName("Testing remove()")
    void testRemove() {
        stringQueue.remove();
        assertEquals(SECOND, stringQueue.peek());
    }

    @Test
    @DisplayName("Testing, if Exception gets thrown when removing")
    void testRemoveException() {
        stringQueue.remove();
        stringQueue.remove();
        assertThrows(NoSuchElementException.class, () -> stringQueue.remove());
    }

    @Test
    @DisplayName("Testing element()")
    void testElement() {
        assertEquals(FIRST, stringQueue.element());
    }

    @Test
    @DisplayName("Testing that an exception gets thrown when using element")
    void testElementException() {
        stringQueue.remove();
        stringQueue.remove();
        assertThrows(NoSuchElementException.class, () -> stringQueue.element());
    }
}