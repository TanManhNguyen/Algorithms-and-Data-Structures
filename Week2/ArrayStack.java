package Week2;

import java.util.EmptyStackException;

class ArrayStack {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStack() {
        elements = new Object[1];
        size = 0;
        capacity = 1;
    }

    /**
     * @return The size of this ArrayStack.
     */
    public int size() {
        return size;
    }

    /**
     * @return `true` iff this ArrayStack is empty, `false` otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return `true` iff the size is equal to the capacity, `false` otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * @return the top element of the stack without removing it
     */
    public Object peek() throws EmptyStackException {
        if(size > 0) return elements[size - 1];
        throw new EmptyStackException();
    }

    /**
     * Adds `o` to the stack.
     * If capacity of stack was too small, capacity is doubled and `o` is added.
     *
     * @param o
     *     the element to add to the stack.
     */
    public void push(Object o) {
        if(size == capacity) resize(size*2);
        elements[size++] = o;
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException
     *     iff the stack is empty
     */
    public Object pop() throws EmptyStackException {
        if(size == 0) throw new EmptyStackException();

        if(size - 1 < capacity / 4 && capacity > 1) resize(capacity/2);

        Object temp = elements[--size];
        elements[size] = null;
        return temp;
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        String res = "<ArrayStack[";

        for(int i = 0; i < size; i++) {
            res += elements[i];
            if(i < size - 1) res += ",";
        }

        res += "]>(Size=" + size + ", Cap=" + capacity + ")";
        return res;
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }


    private void resize(int n) {
        Object[] temp = new Object[n];

        for(int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }

        elements = temp;
        capacity = n;
    }
}

