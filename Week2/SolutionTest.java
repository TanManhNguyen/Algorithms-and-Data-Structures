package Week2;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Stack;

import static java.util.Arrays.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testRemoveArray_Empty() {
        int[] array = new int[0];
        assertEquals(0, Solution.removeLastOccurrence(5, array).length);
    }

    @Test
    public void testFirstSimple() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(result, Solution.removeLastOccurrence(1, input));
    }

    @Test
    public void testLastSimple() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(result, Solution.removeLastOccurrence(10, input));
    }

    @Test
    public void testMultipleLast() {
        ArrayList<Integer> input = new ArrayList<>(asList(1, 1, 3, 5, 7, 1, 5, 9, 1));
        ArrayList<Integer> result = new ArrayList<>(asList(1, 1, 3, 5, 7, 1, 5, 9));
        Solution.removeLastOccurrence(1, input);
        assertEquals(result, input);
    }

    @Test
    public void example() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(42);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void cloneEmpty() {
        double[][] empty = new double[0][0];
        double[][] clone = Solution.clone(empty);
        assertEquals(empty.length, clone.length);
    }

    @Test
    public void cloneSingle() {
        double[][] array = {{1.5}};
        double[][] clone = Solution.clone(array);
        assertEquals(array.length, clone.length);
        assertEquals(array[0].length, clone[0].length);
        assertEquals(array[0][0], clone[0][0], 0);
    }

    @Test
    public void cloneLonger() {
        double[][] array = {{1.5, -10.3, 0}, {-2.5, 8, 1.3}};
        double[][] clone = Solution.clone(array);
        assertEquals(array.length, clone.length);
        assertEquals(array[0].length, clone[0].length);
        assertEquals(array[0][0], clone[0][0], 0);
        assertEquals(array[0][1], clone[0][1], 0);
        assertEquals(array[0][2], clone[0][2], 0);
        assertEquals(array[1][0], clone[1][0], 0);
        assertEquals(array[1][1], clone[1][1], 0);
        assertEquals(array[1][2], clone[1][2], 0);
    }
    @Test
    public void testConstructor() {
        ArrayStack tmp = new ArrayStack();
        assertArrayEquals(tmp.getElements(), new Object[1]);
    }

    @Test
    public void testToStringTwo() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    }

    @Test
    public void testGrowShrink() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        assertEquals(4, s.getElements().length);
        s.pop();
        s.pop();
        s.pop();
        assertEquals(2, s.getElements().length);
    }

    @Test
    public void testFirstEmptyQueue() {
        try {
            new StackQueue<Integer>().first();
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testOndeElement() {
        StackQueue<Integer> q = new StackQueue<Integer>();
        q.enqueue(42);
        assertEquals(1, q.size());
        assertEquals(new Integer(42), q.dequeue());
    }

    @Test
    public void testFirstEmpatyQueue() {
        try {
            new StackQueue<Integer>().first();
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testOneElement() {
        StackQueue<Integer> q = new StackQueue<>();
        q.enqueue(42);
        assertEquals(1, q.size());
        assertEquals(new Integer(42), q.dequeue());
    }

    @Test
    public void testDLListConstructor() {
        DLList list = new DLList();
        assertEquals(0, list.size());
    }

    @Test
    public void testaOneElement() {
        DLList list = new DLList();
        list.addFirst(42);
        assertEquals(42, list.getHead());
        assertEquals(42, list.getTail());
        assertEquals(1, list.size());
    }

    @Test
    public void testAddAtPosition() {
        DLList list = new DLList();
        list.addFirst(3);
        list.addLast(2);
        list.addAtPosition(1, 5);
        assertEquals(3, list.size());
        assertNull(list.removeFromPosition(10));
        assertEquals(3, list.size());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(2, list.removeFirst());
    }

    @Test
    public void testExample() throws Exception {
        ArrayQueue q = new ArrayQueue(20);
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, q.dequeue());
        }
    }




}