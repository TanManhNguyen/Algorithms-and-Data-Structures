package Week3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testExample1() {
        Tree t = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        assertEquals(t, Solution.copy(t));
    }

    @Test
    public void testExample2() {
        Tree t1 = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        Tree t2 = Solution.copy(t1);
        t1.getChildren().get(0).setValue(42);
        assertNotEquals(t1, t2);
    }
    @Test
    public void isHeapNull() {
        assertFalse(Solution.isHeap(null, 3), "A null heap should return false");
    }

    @Test
    public void isHeapSmall() {
        int[] heap = new int[] {99, 64, 5, 36, 8, 1};
        assertTrue(Solution.isHeap(heap, heap.length), "Valid heap returned false instead of true");
    }

    @Test
    public void getParentTest() {
        int[] heap = new int[] {99, 64, 5, 36, 8, 1};
        assertEquals(1, Solution.getParent(heap, 3));
    }

    @Test
    public void testOneLevel() {
        BTree<Integer> tree = new BinaryTree<>();
        tree.add(42, 42);
        tree.add(21, 21);
        tree.add(84, 84);
        Iterator<Integer> iterator = new BinaryTreeIterator<>(tree);
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(42), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(21), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(84), iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Test
    public void testEmptyTree() {
        assertTrue(Solution.isTreeComplete(null));
    }

    @Test
    public void testExample() {
        Tree t1 = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        Tree t2 = new Tree(5, Arrays.asList(new Tree(6), new Tree(7), new Tree(8)));
        Tree res = new Tree(6, Arrays.asList(new Tree(8), new Tree(10), new Tree(12)));
        assertEquals(res, Solution.sum(t1, t2));
    }

    @Test
    public void testNull() {
        assertNull(Solution.findMiddleInLastLayer(null));
    }

    @Test
    public void testTwoPositions() {
        Heap heap = new Heap(42);
        heap.setLeft(heap.getRoot(), 84);
        assertEquals(84, Solution.findMiddleInLastLayer(heap).getKey());
    }

    @Test
    public void testThreePositions() {
        Heap heap = new Heap(42);
        heap.setLeft(heap.getRoot(), 84);
        heap.setRight(heap.getRoot(), 99);
        assertEquals(84, Solution.findMiddleInLastLayer(heap).getKey());
    }


}