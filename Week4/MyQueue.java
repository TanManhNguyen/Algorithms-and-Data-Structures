package Week4;

import java.util.*;

class MyQueue<T> {

    private LinkedList<T> q;

    public MyQueue() {
        this.q = new LinkedList<>();
    }

    public void enqueue(T e) {
        q.add(e);
    }

    public T dequeue() {
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T front() {
        return q.peek();
    }
}
