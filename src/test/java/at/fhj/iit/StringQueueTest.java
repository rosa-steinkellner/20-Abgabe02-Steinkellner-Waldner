
package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Test class which checks the functionality of every single method in the StringQueue class.
 * @author Rosa Steinkellner
 * @author Nina Waldner
 */
@DisplayName("Testing StringQueue Implementation")
class StringQueueTest {

    private static final String FIRST = "Hohoho";
    private static final String SECOND = "Antipasti";

    //Setting up the List needed to test functionality
    private StringQueue stringQueue;

    /**
     * Before each test, a StringQueue object is initialized with the max size of 5 and 2 elements are added to it.
     */
    @BeforeEach
    void setup() {
        stringQueue = new StringQueue(5);
        stringQueue.offer(FIRST);
        stringQueue.offer(SECOND);
    }

    /**
     * This methods returns a boolean, depending on its success. To test the "true" case, one element is added to the queue
     * which initially has 2 elements. To test the "false" case, 3 elements are added so the queue reaches its max
     * capacity before trying to add another.
     */
    @Test
    @DisplayName("Testing offer()")
    void testOffer() {
        assertTrue(stringQueue.offer("Mutzi"));
        stringQueue.offer("Sunny");
        stringQueue.offer("Cloudy");
        stringQueue.offer("Stormy");
        assertFalse(stringQueue.offer("Angry"));
    }

    /**
     * This method returns and removes the first element of the queue. This is tested by using assertEquals to check
     * if the element that is returned really is equal to the first element that gets added in the setup phase.
     */
    @Test
    @DisplayName("Testing poll()")
    void testPoll() {
        assertEquals(FIRST, stringQueue.poll());
    }

    /**
     * To test the remove functionality, peek is used after doing remove on the queue. Then assertEquals is used to verify
     * that the first element is now the one that was added second in the setup phase.
     */
    @Test
    @DisplayName("Testing remove()")
    void testRemove() {
        stringQueue.remove();
        assertEquals(SECOND, stringQueue.peek());
    }

    /**
     * To test if the Exception gets thrown in the remove method, first both elements are removed. Then remove() is called
     * one more time on the now empty queue. This should throw the NoSuchElementException.
     */
    @Test
    @DisplayName("Testing, if Exception gets thrown when removing")
    void testRemoveException() {
        stringQueue.remove();
        stringQueue.remove();
        assertThrows(NoSuchElementException.class, () -> stringQueue.remove());
    }

    /**
     * To test the element method, assertEquals is used to verify that the element that is returned is equal to the
     * first element added during the setup phase.
     */
    @Test
    @DisplayName("Testing element()")
    void testElement() {
        assertEquals(FIRST, stringQueue.element());
    }

    /**
     * To test if the Exception gets thrown in the element method, first both elements are removed. Then element() is called
     * one more time on the now empty queue. This should throw the NoSuchElementException.
     */
    @Test
    @DisplayName("Testing that an exception gets thrown when using element")
    void testElementException() {
        stringQueue.remove();
        stringQueue.remove();
        assertThrows(NoSuchElementException.class, () -> stringQueue.element());
    }
}