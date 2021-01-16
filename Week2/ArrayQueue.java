package Week2;


import java.util.EmptyStackException;

class ArrayQueue {

    private int[] arr;
    private int f;
    private int size;
    private int C;


    /**
     * Creates a new ArrayQueue with the given capacity.
     * @param capacity the capacity for this queue
     */
    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        f = 0;
        size = 0;
        this.C = capacity;
    }

    /**
     * Adds the given element to the queue.
     * @param e the element to add to the queue
     * @throws Exception if the queue is full
     */
    public void enqueue(int e) throws Exception {
        if(size != C) {
            int index = (f + size++) % C;
            arr[index] = e;
        }
        else throw new Exception(); //replaced bc lazy
    }

    /**
     * Removes an element from the queue and returns it.
     * @return the first element in the queue
     * @throws EmptyStackException if the queue is empty
     */
    public int dequeue() throws EmptyStackException {
        if(size-- > 0) {
            int temp = arr[f++];
            f %= C;
            return temp;
        }
        else throw new EmptyStackException(); //replaced bc lazy
    }
}


