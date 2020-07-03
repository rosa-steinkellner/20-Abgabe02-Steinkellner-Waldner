package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericQueue <T> implements IQueue<T>{

    private final List<T> elements = new ArrayList<>();
    private final int maxSize;

    /**
     * This is the constructor which sets the max size to a final value.
     * @param maxSize
     */
    public GenericQueue(int maxSize) {
        this.maxSize = maxSize;
    }
    /**
     * Adds the element obj to the queue.
     * If the addition is successful, the method returns true else false.
     * @param obj
     * @return boolean depending on the success of the operation
     */
    @Override
    public boolean offer(T obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }
    /**
     * Returns the head (first) element and also deletes it. That is, we cannot get it again.
     * If no element exists (when queue is empty), the method returns null.
     * @return value of the first element
     */
    @Override
    public T poll() {
        T element = peek();

        if (elements.size() > 0) {
            elements.remove(0);
        }

        return element;
    }
    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     * @return value of the first element
     */
    @Override
    public T remove() {
        T element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }
    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     * @return value of the first element
     */
    @Override
    public T peek() {
        T element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }
    /**
     * It works similar to peek() but with a small difference (returns but does not delete the element).
     * It throws NoSuchElementException when the queue is empty.
     * @return value of the first element
     */
    @Override
    public T element() {
        T element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

}
