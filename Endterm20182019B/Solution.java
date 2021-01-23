package Endterm20182019B;

import java.util.*;

public class Solution {

    /**
     * Counts the number of nodes with an event number of children.
     *
     * @param tree
     *     The tree to count nodes with an even number of children in.
     * @return the number of nodes with an even number of children, or 0 if tree is null.
     */
    public static int countNodesEvenChildren(LibraryTree tree) {
        if(tree == null) return 0;
        int counter = 0;
        for(LibraryTree t : tree.getChildren())
            counter += countNodesEvenChildren(t);

        return (tree.getChildren().size() % 2 == 0 ? 1 : 0)
                + counter;
    }

    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using breadth first search.
     *
     * Returns 0 if the graph or vertex is null
     *
     * @param g
     *     The graph to count vertices in.
     * @param v
     *     The vertex to start counting at.
     * @return the number of vertices in the same connected component.
     */
    public static int countVertices(Graph g, Graph.Vertex v) {
        if(g == null || v == null) return 0;
        Queue<Graph.Vertex> queue = new LinkedList<>();
        Set<Graph.Vertex> known = new HashSet<>();
        queue.add(v);
        int counter = 0;

        while(!queue.isEmpty()) {
            Graph.Vertex current = queue.poll();
            if(known.contains(current)) continue;
            counter++;
            queue.addAll(g.getNeighbours(current));
            known.add(current);
        }

        return counter;
    }

    /**
     * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
     *
     * @param phoneNumbers
     *     The list of phone numbers to sort.
     * @return The sorted list of phone numbers.
     * @throws NullPointerException
     *     If `phoneNumbers` equals `null`.
     */
    public static List<String> radixSortLSD(List<String> phoneNumbers) {
        if(phoneNumbers == null) throw new NullPointerException();

        for(int i = 9; i >= 2; i--)
            phoneNumbers = radixSortLSDhelp(phoneNumbers, i);

        return phoneNumbers;
    }

    public static List<String> radixSortLSDhelp(List<String> list, int index) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<String>[] table = new List[10];

        for(String s : list) {
            int i = (int) s.charAt(index) - 48;
            if(table[i] == null) table[i] = new ArrayList<>();
            if(!pq.contains(i)) pq.add(i);
            table[i].add(s);
        }

        List<String> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.addAll(table[pq.poll()]);

        return res;
    }


}
