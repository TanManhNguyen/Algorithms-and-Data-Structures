package Resit20182019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testBase() {
        BinarySearchTree tree = new BinarySearchTree(1, 42);
        assertEquals(1, Solution.higherEntry(tree, 0).key);
        assertNull(Solution.higherEntry(tree, 1));
        assertNull(Solution.higherEntry(tree, 2));
        assertNull(Solution.higherEntry(null, 42));
    }

    @Test
    public void testSmall() {
        BinarySearchTree tree = new BinarySearchTree(42, 42, new BinarySearchTree(21, 21, new BinarySearchTree(10, 10), new BinarySearchTree(30, 30)), new BinarySearchTree(84, 84, new BinarySearchTree(60, 60), new BinarySearchTree(100, 100)));
        assertEquals(10, Solution.higherEntry(tree, 2).key);
        assertEquals(60, Solution.higherEntry(tree, 42).key);
        assertEquals(100, Solution.higherEntry(tree, 88).key);
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(1, Solution.countVertices(g, v, 0));
        assertEquals(1, Solution.countVertices(g, v, 1));
        assertEquals(1, Solution.countVertices(g, v, 2));
    }

    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        assertEquals(1, Solution.countVertices(g, v, 0));
        assertEquals(2, Solution.countVertices(g, v, 1));
        assertEquals(2, Solution.countVertices(g, v, 2));
    }

    @Test
    public void testConstructor() {
        ArrayBasedStack stack = new ArrayBasedStack(3);
        assertEquals(3, stack.stack.length);
        assertEquals(0, stack.size);
        assertArrayEquals(new Object[3], stack.stack);
    }

    @Test
    public void testPush() {
        ArrayBasedStack stack = new ArrayBasedStack(2);
        assertEquals(5, stack.push(5));
        assertEquals(42, stack.push(42));
        assertNull(stack.push(512));
    }

    @Test
    public void testPop() {
        ArrayBasedStack stack = new ArrayBasedStack(4);
        assertNull(stack.pop());
        assertEquals(5, stack.push(5));
        assertEquals(5, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    public void testPeek() {
        ArrayBasedStack stack = new ArrayBasedStack(4);
        assertNull(stack.peek());
        assertEquals(5, stack.push(5));
        assertEquals(5, stack.peek());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testEmpty() {
        SLList input = new SLList();
        SLList output = new SLList();
        assertEquals(output, Solution.insertionSort(input));
    }

    @Test
    public void testNull() {
        assertNull(Solution.insertionSort(null));
    }

    @Test
    public void testExample() {
        SLList input = new SLList(3, 1, 2);
        SLList output = new SLList(1, 2, 3);
        assertEquals(output, Solution.insertionSort(input));
    }
}