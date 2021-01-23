package Endterm20192020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     *
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        if(arr == null) return null;
        int[] res = new int[arr.length];
        sort(arr.clone(), res);
        return res;
    }

    public static void sort(String[] arr, int[] res) {
        for(int i = 0; i < res.length; i++)
            res[i] = i;

        for (int i = 1; i < arr.length; i++) {
            String a = arr[i].toLowerCase();
            int index = res[i];
            int b = i - 1;
            while(b >= 0 && arr[b].toLowerCase().compareTo(a) > 0) {
                res[b + 1] = res[b];
                arr[b + 1] = arr[b];
                b--;
            }
            res[b + 1] = index;
            arr[b + 1] = a;
        }
    }

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     * @param tree BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static boolean isRedBlackTree(BinaryTree tree) {
        if(tree == null) return true;
        if(tree.isRed()) return false;

        boolean bst = isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int height = blackHeight(tree);
        boolean children = noRedChildren(tree);

        return isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE)
                && blackHeight(tree) != -1
                && noRedChildren(tree);
    }

    public static boolean isTreeBST(BinaryTree tree, int min, int max) {
        if(tree == null) return true;
        if (tree.getValue() < min || tree.getValue() > max) return false;

        return isTreeBST(tree.getLeft(), min, tree.getValue() - 1)
                && isTreeBST(tree.getRight(), tree.getValue() + 1, max);
    }

    public static int blackHeight(BinaryTree tree) {
        if(tree == null) return 0;
        int left = blackHeight(tree.getLeft());
        int right = blackHeight(tree.getRight());

        if(left != right || left == -1 || right == -1) return -1;
        return left + (tree.isBlack() ? 1 : 0);
    }

    public static boolean noRedChildren(BinaryTree tree) {
        if(tree == null) return true;

        boolean flag = true;
        if(tree.isRed()) {
            if(tree.getLeft() != null && tree.getLeft().isRed()) flag = false;
            if(tree.getRight() != null && tree.getRight().isRed()) flag = false;
        }

        return noRedChildren(tree.getRight())
                && noRedChildren(tree.getLeft())
                && flag;
    }

    /**
     * Returns the length of the shortest path between vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The length of the shortest path between a and b, or -1 if no such path exists.
     */
    public static int shortestPath(Graph g, Vertex a, Vertex b) {
        if(a == b) return 0;
        AdaptablePQ pq = new AdaptablePQ();
        pq.insertOrReplace(a, 0);
        Integer[] path = new Integer[g.getAllVertices().size()];
        path[a.getId()] = 0;

        for(Vertex v : g.getAllVertices()) {
            if(v == a) continue;
            pq.insertOrReplace(v, Integer.MAX_VALUE);
            path[v.getId()] = Integer.MAX_VALUE;
        }

        while(!pq.isEmpty()) {
            Vertex current = pq.removeMin().getVertex();

            for(VertexNumPair v : current.getNeighbours()) {
                Vertex op = v.getVertex();
                int cost = v.getNum() + path[current.getId()];
                if(path[op.getId()] > cost ) {
                    path[op.getId()] = cost;
                    pq.insertOrReplace(op, cost);
                }
            }

        }

        return path[b.getId()] == Integer.MAX_VALUE ? -1 : path[b.getId()];
    }
}
