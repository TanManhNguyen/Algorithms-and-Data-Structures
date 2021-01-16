package Week8Part2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(1, Solution.numberOfConnectedComponents(g));
    }

    @Test
    public void testNotPossibleGraph() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex z = new VertexImpl(3);
        g.addVertex(v);
        g.addVertex(z);
        assertEquals(2, Solution.numberOfConnectedComponents(g));
    }

    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        List<Vertex> list = Solution.shortestPath(g, v, w);
        assertEquals(2, Solution.shortestPath(g, v, w).size());
        Vertex[] va = {v, w};
        assertArrayEquals(va, Solution.shortestPath(g, v, w).toArray());
    }

    @Test
    public void testSingleLoopingfVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(1, Solution.shortestPath(g, v, v).size());
    }


    /**
     * Tests if solution works for the given input.
     * Important because there might be different possible MST's for the same graph.
     *
     * @param mst_cost the real cost of a MST on that graph
     * @param edges the edges that comprise of the graph whose MST we are creating
     * @param n the amount of nodes in the graph that the MST should reach
     */
    void assertMST(int mst_cost, List<Edge> edges, int n) {
        // Run solution (& verify that input was not modified)
        List<Edge> original_edges = new ArrayList<>(edges);
        List<Edge> solution = Solution.buildMST(n, edges);
        assertEquals(original_edges, edges);

        // Test if it even is a spanning tree
        UnionFind uf = new UnionFind(n);
        // Do we have n - 1 edges?
        assertEquals(n - 1, solution.size());
        // Are they all useful? (Do they connect different clusters?)
        for (Edge e : solution)
            assertTrue(uf.union(e.getFrom(), e.getTo()));

        // Test if it is a minimum spanning tree
        int result_cost = solution.stream().mapToInt(Edge::getCost).sum();
        assertEquals(mst_cost, result_cost);
    }

    List<Edge> buildEdges(int[] info, int m) {
        List<Edge> solution = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int start = i * 3;
            solution.add(new Edge(info[start], info[start + 1], info[start + 2]));
        }

        return solution;
    }

    @Test
    public void emptyGraphTest() {
        List<Edge> solution = Solution.buildMST(0, new ArrayList<>());
        assertTrue(solution.isEmpty());
    }

    /**
     * Makes sure they don't just add the smallest cost edge.
     * Makes sure they don't skip necessary edges (most costly edge is necessary)
     *
     * Graph: https://i.imgur.com/BdvaXpV.png
     * MST: https://i.imgur.com/RS9poLa.png
     */
    @Test
    public void completeGraphTest() {
        int[] info = new int[] {
                0, 1, 1,
                0, 2, 1,
                1, 2, 2,
                1, 3, 3,
                3, 4, 2,
                3, 5, 1,
                4, 5, 1
        };

        List<Edge> input = buildEdges(info, 7);

        assertMST(7, input, 6);
    }
}