package Endterm20192020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testEverythingOneItem() {
        MultiMap map = new MultiMap();
        map.put(1, 2);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList(2), map.get(1));
        assertFalse(map.remove(1, 3));
        assertTrue(map.remove(1, 2));
    }
    @Test
    public void testExample() {
        String[] arr = { "b", "c", "a" };
        int[] res = Solution.indexSort(arr);
        int[] expected = { 0, 2, 3, 1 };
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testNull() {
        String[] arr = null;
        int[] res = Solution.indexSort(arr);
        assertNull(res);
    }

    @Test
    public void testEmpty() {
        String[] arr = {};
        int[] res = Solution.indexSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testExadmple() {
        BinaryTree tree = new BinaryTree(4, false);
        assertTrue(Solution.isRedBlackTree(tree));
        tree.setLeft(new BinaryTree(2, false));
        tree.setRight(new BinaryTree(6, false));
        assertTrue(Solution.isRedBlackTree(tree));
        tree.getLeft().setLeft(new BinaryTree(1, false));
        tree.setRight(null);
        assertFalse(Solution.isRedBlackTree(tree));
    }

    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 3
     *     |   |
     *     2 - 4
     */
    @Test
    public void testUnweighted() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 4, 1);
        // Path from 0 to 4 should be 2
        assertEquals(2, Solution.shortestPath(g, g.getVertex(0), g.getVertex(4)));
        // Path from 1 to 2 should be 2
        assertEquals(2, Solution.shortestPath(g, g.getVertex(1), g.getVertex(2)));
        // Path from 3 to 4 should be 1
        assertEquals(1, Solution.shortestPath(g, g.getVertex(3), g.getVertex(4)));
        // Path from 3 to 1 should be 2
        assertEquals(2, Solution.shortestPath(g, g.getVertex(3), g.getVertex(1)));
    }

    /**
     * Tests the following graph:
     * 0 - 1 - 3
     * |    \  |
     * |     \ |
     * 2  ---  4
     *
     * The weights are as follows:
     * 0 - 1: 1
     * 1 - 3: 6
     * 3 - 4: 4
     * 1 - 4: 1
     * 0 - 2: 7
     * 2 - 4: 4
     */
    @Test
    public void testWeighted() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 3, 6);
        g.addEdge(3, 4, 4);
        g.addEdge(1, 4, 1);
        g.addEdge(0, 2, 7);
        g.addEdge(2, 4, 4);
        // Path is 0-1-4
        assertEquals(2, Solution.shortestPath(g, g.getVertex(0), g.getVertex(4)));
        // Path is 0-1-4-3
        assertEquals(6, Solution.shortestPath(g, g.getVertex(0), g.getVertex(3)));
        // Path is 2-4
        assertEquals(4, Solution.shortestPath(g, g.getVertex(2), g.getVertex(4)));
        // Path is 2-4-1-0
        assertEquals(6, Solution.shortestPath(g, g.getVertex(2), g.getVertex(0)));
    }
}
