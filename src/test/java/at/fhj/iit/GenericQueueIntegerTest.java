package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Test class which checks the functionality of every single method in the genericQueue class. For the purpose
 * of testing, the Queue object is specified to hold elements of the type Integer.
 *
 * @author Rosa Steinkellner
 * @author Nina Waldner
 */
@DisplayName("Testing GenericQueue Implementation")

public class GenericQueueIntegerTest {

    private static final Integer FIRST = 22;
    private static final Integer SECOND = 33;

    //Setting up the List needed to test functionality
    private GenericQueue<Integer> genericQueue;

    /**
     * Before each test, a genericQueue object is initialized with the max size of 5 and 2 elements are added to it.
     */
    @BeforeEach
    void setup() {
        genericQueue = new GenericQueue<>(5);
        genericQueue.offer(FIRST);
        genericQueue.offer(SECOND);
    }

    /**
     * This methods returns a boolean, depending on its success. To test the "true" case, one element is added to the queue
     * which initially has 2 elements. To test the "false" case, 3 elements are added so the queue reaches its max
     * capacity before trying to add another.
     */
    @Test
    @DisplayName("Testing offer()")
    void testOffer() {
        assertTrue(genericQueue.offer(22));
        genericQueue.offer(44);
        genericQueue.offer(55);
        genericQueue.offer(66);
        assertFalse(genericQueue.offer(77));
    }

    /**
     * This method returns and removes the first element of the queue. This is tested by using assertEquals to check
     * if the element that is returned really is equal to the first element that gets added in the setup phase.
     */
    @Test
    @DisplayName("Testing poll()")
    void testPoll() {
        assertEquals(FIRST, genericQueue.poll());
    }

    /**
     * To test the remove functionality, peek is used after doing remove on the queue. Then assertEquals is used to verify
     * that the first element is now the one that was added second in the setup phase.
     */
    @Test
    @DisplayName("Testing remove()")
    void testRemove() {
        genericQueue.remove();
        assertEquals(SECOND, genericQueue.peek());
    }

    /**
     * To test if the Exception gets thrown in the remove method, first both elements are removed. Then remove() is called
     * one more time on the now empty queue. This should throw the NoSuchElementException.
     */
    @Test
    @DisplayName("Testing, if Exception gets thrown when removing")
    void testRemoveException() {
        genericQueue.remove();
        genericQueue.remove();
        assertThrows(NoSuchElementException.class, () -> genericQueue.remove());
    }

    /**
     * To test the element method, assertEquals is used to verify that the element that is returned is equal to the
     * first element added during the setup phase.
     */
    @Test
    @DisplayName("Testing element()")
    void testElement() {
        assertEquals(FIRST, genericQueue.element());
    }

    /**
     * To test if the Exception gets thrown in the element method, first both elements are removed. Then element() is called
     * one more time on the now empty queue. This should throw the NoSuchElementException.
     */
    @Test
    @DisplayName("Testing that an exception gets thrown when using element")
    void testElementException() {
        genericQueue.remove();
        genericQueue.remove();
        assertThrows(NoSuchElementException.class, () -> genericQueue.element());
    }

}




