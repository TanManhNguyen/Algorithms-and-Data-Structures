package Endterm20182019B;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testNull() {
        LibraryTree tree = null;
        assertEquals(0, Solution.countNodesEvenChildren(tree));
    }

    @Test
    public void testRoot() {
        LibraryTree tree = new LibraryTree(0);
        assertEquals(1, Solution.countNodesEvenChildren(tree));
    }

    @Test
    public void testSmall() {
        LibraryTree tree = new LibraryTree(0, Arrays.asList(new LibraryTree(1), new LibraryTree(2)));
        assertEquals(3, Solution.countNodesEvenChildren(tree));
    }

    @Test
    public void testNaull() {
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
    public void testEmpty() {
        assertEquals(new ArrayList<>(), Solution.radixSortLSD(new ArrayList<>()));
    }

    @Test
    public void testReversed() {
        List<String> data = Arrays.asList("0687654321", "0612301345", "0612300123", "0612345678");
        List<String> data2 = Arrays.asList("0612300123", "0612301345", "0612345678", "0687654321");
        assertEquals(data2, Solution.radixSortLSD(data));
    }

    @Test
    public void testdExample() {
        SolutionHashTable tab = new SolutionHashTable(2);
        assertTrue(tab.put("apple", "juice"));
        assertTrue(tab.put("sf", "juice"));
        assertTrue(tab.put("ae", "juice"));
        assertTrue(tab.put("apple", "jue"));

        assertFalse(tab.put("ad", "cider"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.table[0].getKey());
        assertEquals(null, tab.table[0].getValue());
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
    public void testExaasmple() {
        SolutionHashTable tab = new SolutionHashTable(2);
        assertTrue(tab.put("AaAaAa", "juice"));
        assertTrue(tab.put("AaAaBB", "lol"));
        assertEquals("lol", tab.get("AaAaBB"));
        assertFalse(tab.put("a", "lol"));
        assertEquals("juice", tab.get("AaAaAa"));
        assertEquals(true, tab.remove("AaAaBB"));
    }
}