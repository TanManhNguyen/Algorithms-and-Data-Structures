package Week2;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * @return true iff the queue contains no elements.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element
     *     to add.
     */
    public void enqueue(T element) {
        list.add(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the dequeue
     * @throws EmptyStackException
     *     iff the queue is empty
     */
    public T dequeue() throws EmptyStackException {
        if(!isEmpty()) return list.poll();
        else throw new EmptyStackException(); //replaced the exception bc im lazy
    }

    public int size() {
        return list.size();
    }


    //Method from the main matter
    /**
     * Reverses the queue itself. NB: This method should be recursive.
     */
    public void reverse() {
        if(this.size() == 0) return;
        if(this.size() == 1) return;

        T temp = this.dequeue();
        reverse();
        enqueue(temp);
    }
}
