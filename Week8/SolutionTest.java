package Week8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    /**
     * Tests the following graph
     * 0 - 1 - 2
     */
    @Test
    public void testLine() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        // Path from 0 to 1 is reachable
        assertTrue(Solution.checkIfReachable(g.getVertex(0), g.getVertex(1)));
        // Path from 1 to 2 is reachable
        assertTrue(Solution.checkIfReachable(g.getVertex(1), g.getVertex(2)));
        // Path from 0 to 2 is reachable
        assertTrue(Solution.checkIfReachable(g.getVertex(0), g.getVertex(2)));
        // Path from 2 to 0 is reachable
        assertTrue(Solution.checkIfReachable(g.getVertex(2), g.getVertex(0)));
    }

    /**
     * Tests the following graph:
     * 0 - 1 - 3
     * |    \  |
     * |     \ |
     * 2  ---  4    (5)
     */
    @Test
    public void testWeighted() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        // Path is 0-1-4
        assertTrue(Solution.checkIfReachable(g.getVertex(0), g.getVertex(4)));
        // Path is 0-1-4-3
        assertTrue(Solution.checkIfReachable(g.getVertex(0), g.getVertex(3)));
        // Path is 2-4
        assertTrue(Solution.checkIfReachable(g.getVertex(2), g.getVertex(4)));
        // Path is 2-4-1-0
        assertTrue(Solution.checkIfReachable(g.getVertex(2), g.getVertex(0)));
        // No path
        assertFalse(Solution.checkIfReachable(g.getVertex(0), g.getVertex(5)));
        assertFalse(Solution.checkIfReachable(g.getVertex(1), g.getVertex(5)));
        assertFalse(Solution.checkIfReachable(g.getVertex(2), g.getVertex(5)));
        assertFalse(Solution.checkIfReachable(g.getVertex(3), g.getVertex(5)));
        assertFalse(Solution.checkIfReachable(g.getVertex(4), g.getVertex(5)));
    }

    @Test
    public void testDoubleVertex() {
        Graph g = new Graph(2);
        Vertex v = new Vertex(0);
        Vertex w = new Vertex(1);
        g.addEdge(v, w);
        Iterator<Vertex> it = new GraphIterator(g, v);
        assertSame(v, it.next());
        assertTrue(it.hasNext());
        assertSame(w, it.next());
        assertFalse(it.hasNext());
    }

    /**
     * Graph: https://i.imgur.com/ty3flio.png
     */
    @Test
    public void testNoCycle() {
        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(i);
        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[1]);

        assertFalse(Solution.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }

    /**
     * Graph: https://i.imgur.com/IuPAZTV.png
     */
    @Test
    public void testCycle() {
        Node[] nodes = new Node[5];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(i);

        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[1].outgoingEdges.add(nodes[3]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[4]);
        nodes[4].outgoingEdges.add(nodes[2]);

        assertTrue(Solution.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }



}