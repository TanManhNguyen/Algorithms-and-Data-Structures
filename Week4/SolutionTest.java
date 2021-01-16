package Week4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormal() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        Solution.insertionSort(data);
        assertArrayEquals(data2, data);
    }

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormadl() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        Solution.selectionSort(data);
        assertArrayEquals(data2, data);
    }

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormaal() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        int[] result = Solution.mergeSort(data);
        assertArrayEquals(data2, result);
    }

    @Test
    public void testSmall() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(4);
        queue1.enqueue(2);
        queue1.enqueue(1);

        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(6);
        queue2.enqueue(5);
        queue2.enqueue(3);
        queue2.enqueue(2);

        MyQueue<Integer> solution = Solution.merge(queue1, queue2);

        assertEquals(Integer.valueOf(6), solution.dequeue());
        assertEquals(Integer.valueOf(5), solution.dequeue());
        assertEquals(Integer.valueOf(4), solution.dequeue());
        assertEquals(Integer.valueOf(3), solution.dequeue());
        assertEquals(Integer.valueOf(2), solution.dequeue());
        assertEquals(Integer.valueOf(2), solution.dequeue());
        assertEquals(Integer.valueOf(1), solution.dequeue());
        assertTrue(solution.isEmpty());

        assertEquals(Integer.valueOf(4), queue1.dequeue());
        assertEquals(Integer.valueOf(2), queue1.dequeue());
        assertEquals(Integer.valueOf(1), queue1.dequeue());
        assertTrue(queue1.isEmpty());

        assertEquals(Integer.valueOf(6), queue2.dequeue());
        assertEquals(Integer.valueOf(5), queue2.dequeue());
        assertEquals(Integer.valueOf(3), queue2.dequeue());
        assertEquals(Integer.valueOf(2), queue2.dequeue());
        assertTrue(queue2.isEmpty());
    }

    @Test
    public void testExample() {
        Lawyer one = new Lawyer(1, 2, 3, 4, 5);
        Lawyer two = new Lawyer(2, 3, 4, 5, 6);
        MyQueue<Lawyer> input = new MyQueue<>();
        input.enqueue(one);
        input.enqueue(two);
        MyQueue<Lawyer> solution = Solution.sortingSomeLawyer(input);
        assertEquals(two, solution.dequeue());
        assertEquals(one, solution.dequeue());
        assertTrue(solution.isEmpty());
    }

    @Test
    public void testExampleEmptyQueue() {
        MyQueue<Lawyer> input = new MyQueue<>();
        MyQueue<Lawyer> solution = Solution.sortingSomeLawyer(input);
        assertTrue(solution.isEmpty());
    }

    @Test
    public void testExameple() {
        List<Integer> input = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> res = Solution.pqSort(input);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), res);
    }

    @Test
    public void testNull() {
        List<Integer> input = null;
        List<Integer> res = Solution.pqSort(input);
        assertEquals(null, res);
    }

    @Test
    public void testEmpty() {
        List<Integer> input = new ArrayList<>();
        List<Integer> res = Solution.pqSort(input);
        assertEquals(new ArrayList<Integer>(), res);
    }

    @Test
    public void testHeap() {
        LibraryPQ queue = new SolutionPQ();
        queue.insert(15);
        queue.insert(6);
        queue.insert(72);
        queue.insert(13);
        assertTrue(queue.heapEquals(Arrays.asList(72, 13, 15, 6)));
    }

    @Test
    public void testExaample() {
        int[] tasks = { 3, 7, 5 };
        assertEquals(8, Solution.completeTasks(tasks, 2));
    }
    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormaasl() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        Solution.quickSort(data);
        assertArrayEquals(data2, data);
    }
}