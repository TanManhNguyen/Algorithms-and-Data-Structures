package Week8Part2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static int numberOfConnectedComponents(Graph g) {
        Collection<Vertex> unexplored = g.getAllVertices();
        int counter = 0;

        while(unexplored.iterator().hasNext()) {
            counter++;
            GraphIterator iter = new GraphIterator(g, unexplored.iterator().next());
            while(iter.hasNext())
                unexplored.remove(iter.next());
        }

        return counter;
    }

    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g
     *     graph to search in.
     * @param v
     *     node to start from.
     * @param u
     *     node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        if(!checkIfReachable(g, v, u)) return new ArrayList<>();

        List<Vertex> res = new ArrayList<>();
        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        GraphIterator iter = new GraphIterator(g, v);
        Vertex current;

        while(iter.hasNext()) {
            current = iter.next();
            for(Vertex k : g.getNeighbours(current))
                if(!predecessors.containsKey(k)) predecessors.put(k, current);
        }

        current = u;

        while(current != v) {
            res.add(0, current);
            current = predecessors.get(current);
        }

        res.add(0, current);
        return res;
    }

    public static boolean checkIfReachable(Graph g, Vertex a, Vertex b) {
        Set<Vertex> known = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(a);
        Vertex current;

        while(!queue.isEmpty()) {
            current = queue.poll();
            if(known.contains(current)) continue;
            if(current == b) return true;
            queue.addAll(g.getNeighbours(current));
            known.add(current);
        }

        return false;
    }

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        List<Edge> res = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.size(); i++) {
            Edge current = pq.poll();
            if(uf.union(current.getFrom(), current.getTo())) res.add(current);
        }

        return res;
    }

    //Dijkstra is in Dijkstra package

}
