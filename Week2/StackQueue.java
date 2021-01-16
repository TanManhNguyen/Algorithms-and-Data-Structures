package Week2;

import java.util.*;

class StackQueue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    /**
     * @return true iff there are no elements left.
     */
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    /**
     * @return the number of elements in the queue.
     */
    public int size() {
        return s1.size();
    }

    /**
     * Adds an element to the queue.
     *
     * @param i
     *     element to enqueue.
     */
    public void enqueue(T i) {
        s1.push(i);
    }

    /**
     * Removes the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public T dequeue() throws NoSuchElementException {
        if(s1.size() > 0) {
            int size1 = s1.size();
            for(int i = 1; i < size1; i++) s2.push(s1.pop());

            T temp = s1.pop();
            for(int i = 0; i < size1 -1; i++) s1.push(s2.pop());

            return temp;
        }
        else throw new NoSuchElementException();

    }

    /**
     * Only returns (i.e. does not remove) the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public T first() throws NoSuchElementException {
        if(s1.size() > 0) {
            int size1 = s1.size();
            for(int i = 1; i < size1; i++) s2.push(s1.pop());

            T temp = s1.peek();
            int size2 = s2.size();
            for(int i = 0; i < size2; i++) s1.push(s2.pop());

            return temp;
        }
        else throw new NoSuchElementException();
    }
}