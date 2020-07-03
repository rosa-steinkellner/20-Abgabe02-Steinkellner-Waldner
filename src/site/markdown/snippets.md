# 20-Abgabe02-Steinkellner-Waldner #

### Code Snippets ###

<b>Testing Method of GenericQueueStringTest</b>
``` java
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
```
<br/>
<b>GenericQueue class header displaying the Generic Implementation<b/>
``` java
/**
 * This class represents a Queue that contains objects of a Generic Class. It implements the IQueue interface and therefore has all its
 * methods.
 * @param <T> Generic Class
 */
public class GenericQueue <T> implements IQueue<T>{

    private final List<T> elements = new ArrayList<>();
    private final int maxSize;
```
<br/>
<b>Testing Method of StringQueueTest<b/>
``` java
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
```

