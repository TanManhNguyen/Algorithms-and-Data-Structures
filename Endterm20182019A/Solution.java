package Endterm20182019A;

import java.util.*;

public class Solution {

    /**
     * Counts the number of nodes in the tree at a certain level.
     *
     * @param tree
     *     The binary tree to count nodes in.
     * @param level
     *     The specified level to count nodes in.
     * @return the number of nodes at that level, or 0 if tree is null.
     */
    public static int countNodesAtLevel(BinaryTree tree, int level) {
        if(tree == null) return 0;
        if(level == 0) return 1;
        return countNodesAtLevel(tree.getLeft(), --level)
                + countNodesAtLevel(tree.getRight(), level);

    }
    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using depth first search.
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
        Stack<Graph.Vertex> stack = new Stack<>();
        Set<Graph.Vertex> known = new HashSet<>();
        stack.push(v);
        int counter = 0;

        while(!stack.isEmpty()) {
            Graph.Vertex current = stack.pop();
            if(known.contains(current)) continue;
            counter++;
            stack.addAll(g.getNeighbours(current));
            known.add(current);
        }

        return counter;
    }
    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words
     *     The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException
     *     If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        if(words == null) throw new NullPointerException();
        return radixSortMSDhelp(words, 0);

    }

    //I would say this adheres to the requirements if you disagree send me a message

    static List<String> radixSortMSDhelp(List<String> words, int index) {
        if(words.size() <= 1 || checkAllSame(words)) return words;

        PriorityQueue<Integer> known = new PriorityQueue<>();
        List<String>[] table = new List[27];

        for(String s : words) {
            int i = s.length() < index + 1 ? 0 : s.charAt(index) % 32;

            if(table[i] == null) table[i] = new ArrayList<>();
            table[i].add(s);
            if(!known.contains(i)) known.add(i);
        }

        List<String> res = new ArrayList<>();
        while(!known.isEmpty())
            res.addAll(radixSortMSDhelp(table[known.poll()], index + 1));

        return res;
    }

    public static boolean checkAllSame(List<String> words) {
        String i = words.get(0);
        for (int j = 1; j < words.size(); j++)
            if(!words.get(j).equals(i)) return false;

        return true;
    }




}
