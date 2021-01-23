package Resit20182019;

import java.util.*;

public class Solution {
    /**
     * Given a Binary Search Tree and an Integer, returns the Entry in this tree
     * with the smallest key that is strictly larger than k.
     *
     * @param tree
     *     Binary search tree to search in.
     * @param k
     *     The key of the resulting entry should be strictly larger than this k.
     * @return The entry with smallest key, strictly larger than k.
     */
    static Entry higherEntry(BinarySearchTree tree, int k) {
        if(tree == null) return null;
        if(tree.getEntry().key <= k) return higherEntry(tree.getRight(), k);

        Entry left = higherEntry(tree.getLeft(), k);
        if(left == null) return tree.getEntry();
        return left;


    }

    /**
     * @param g
     *     The graph to search in.
     * @param v
     *     The vertex to start searching from.
     * @param n
     *     The number of edges n that can be traversed from v.
     * @return The number of vertices that are reachable from v (including v), using at most n edges.
     */
    static int countVertices(Graph g, Vertex v, int n) {
        Queue<Vertex> queue = new LinkedList(g.getNeighbours(v));
        Map<Vertex, Integer> edge = new HashMap<>();
        Map<Vertex, Vertex> pred = new HashMap<>();
        for(Vertex h : g.getNeighbours(v))
            pred.put(h, v);
        edge.put(v, 0);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            if(edge.containsKey(current)) continue;
            int edges = edge.get(pred.get(current));
            if(edges == n) continue;
            for(Vertex h : g.getNeighbours(current)) {
                if(pred.containsKey(h) || edge.containsKey(h)) continue;
                pred.put(h, current);
                queue.add(h);
            }
            edge.put(current, edges + 1);
        }

        return edge.size();
    }

    /**
     * @param list
     *     The singly linked list to sort.
     * @return A new singly linked list that contains the elements as the input list sorted in non-decreasing order.
     */
    static SLList insertionSort(SLList list) {
        if(list == null) return null;
        if(list.getFirst() == null) return new SLList();
        SLList res = new SLList();
        res.addFirst(list.removeFirst());

        while(list.getFirst() != null) {
            int val = list.removeFirst();
            SLList.Node current = res.getFirst();
            SLList.Node prev = null;

            while(current != null && current.getElement() < val) {
                prev = current;
                current = current.getNext();
            }

            if (prev != null) res.addAfter(prev, val);
            else res.addFirst(val);
        }

        return res;
    }
}
