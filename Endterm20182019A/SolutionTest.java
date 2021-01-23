package Endterm20182019A;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testSmall() {
        BinaryTree tree = new BinaryTree(0, new BinaryTree(1, new BinaryTree(3), new BinaryTree(4)), new BinaryTree(2, new BinaryTree(5), new BinaryTree(6)));
        assertEquals(1, Solution.countNodesAtLevel(tree, 0));
        assertEquals(2, Solution.countNodesAtLevel(tree, 1));
        assertEquals(4, Solution.countNodesAtLevel(tree, 2));
    }

    @Test
    public void testNull() {
        BinaryTree tree = null;
        assertEquals(0, Solution.countNodesAtLevel(tree, 0));
    }

    @Test
    public void testdNull() {
        Graph g = new Graph();
        Graph.Vertex v = null;
        assertEquals(0, Solution.countVertices(g, v));
        g = null;
        v = new Graph.Vertex(1);
        assertEquals(0, Solution.countVertices(g, v));
    }

    @Test
    public void testExample() {
        Graph g = new Graph();
        Graph.Vertex v = new Graph.Vertex(1);
        Graph.Vertex w = new Graph.Vertex(2);
        Graph.Vertex x = new Graph.Vertex(3);
        Graph.Vertex y = new Graph.Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        assertEquals(3, Solution.countVertices(g, v));
        assertEquals(3, Solution.countVertices(g, w));
        assertEquals(3, Solution.countVertices(g, y));
        assertEquals(1, Solution.countVertices(g, x));
    }
    @Test
    public void testOneElement() {
        SolutionHashTable tab = new SolutionHashTable(1);
        assertTrue(tab.put("apple", "juice"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testIllegalArgument() {
        try {
            new SolutionHashTable(0);
        } catch (IllegalArgumentException e1) {
            try {
                new SolutionHashTable(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        fail();
    }

    @Test
    public void testEmpty() {
        assertEquals(new ArrayList<>(), Solution.radixSortMSD(new ArrayList<>()));
    }

    @Test
    public void testReversed() {
        List<String> data = Arrays.asList("bherry", "bherry", "bherry", "bherry");
        List<String> data2 = Arrays.asList("apple", "banana", "bherry", "donut");
        assertEquals(data2, Solution.radixSortMSD(data));
    }
}