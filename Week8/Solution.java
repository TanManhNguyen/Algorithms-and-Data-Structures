package Week8;

import java.util.*;

public class Solution {

    /**
     * Checks if vertex b is reachable from vertex a.
     * @param a Vertex to start from.
     * @param b Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean checkIfReachable(Vertex a, Vertex b) {
        Set<Vertex> known = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(a);
        Vertex current;

        while(!queue.isEmpty()) {
            current = queue.poll();
            if(known.contains(current)) continue;
            if(current == b) return true;
            queue.addAll(current.getNeighbours());
            known.add(current);
        }

        return false;
    }

    /**
     * Detects cycles in a connected component.
     *
     * @param s starting node in our connected component.
     * @param nodes the nodes that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static boolean detectCycle(Node s, List<Node> nodes) {
        Set<Node> known = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        known.add(s);
        stack.addAll(s.getOutgoingEdges());
        Node current;

        while(!stack.isEmpty()) {
            current = stack.pop();
            if(known.contains(current)) continue;
            if(detectCycleHelp(current)) return true;
            known.add(current);
            stack.addAll(current.getOutgoingEdges());
        }

        return false;
    }

    public static boolean detectCycleHelp(Node s) {
        Set<Node> known = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        known.add(s);
        Node current;
        queue.addAll(s.getOutgoingEdges());

        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current == s) return true;
            if(known.contains(current)) continue;
            queue.addAll(current.getOutgoingEdges());
            known.add(current);
        }

        return false;
    }

    //rest is in part 2 bc they constantly change the library implementations

}
