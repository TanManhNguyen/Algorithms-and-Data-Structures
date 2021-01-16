package Dijkstra;

import java.util.*;

class Solution {

    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {
        if(a == b) return new ArrayList<>(Arrays.asList(a));

        Map<Vertex, Vertex> pred = new HashMap<>();

        int[] path = new int[g.getAllVertices().size()];
        AdaptablePQ pq = new AdaptablePQ();
        pq.insertOrReplace(a, 0);
        path[a.getId()] = 0;

        for(Vertex v : g.getAllVertices()) {
            if(v == a) continue;
            pq.insertOrReplace(v, Integer.MAX_VALUE);
            path[a.getId()] = Integer.MAX_VALUE;
        }

        Vertex current;

        while(!pq.isEmpty()) {
            current = pq.removeMin().getVertex();

            for(VertexNumPair v : current.getNeighbours()) {
                Vertex p = v.getVertex();
                int n = v.getNum();
                if(path[current.getId()] + n < path[p.getId()]) {
                    path[p.getId()] = path[current.getId()] + n;
                    pred.put(p, current);
                    pq.insertOrReplace(p, path[p.getId()]);
                }
            }
        }

        if(pred.get(b) == null) return null;
        List<Vertex> res = new ArrayList<>();
        current = b;

        while(current != a) {
            res.add(0, current);
            current = pred.get(current);
        }

        res.add(0, current);
        return res;
    }
}

