package Week3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * Creates a hard copy of the n-ary tree.
     * @param t - the tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding positions in t
     */
    public static Tree copy(Tree t) {
        if(t == null) return null;
        if(t.getChildren() == null) return new Tree(t.getValue());

        List<Tree> children = new ArrayList<>();
        for(Tree p : t.getChildren())
            children.add(copy(p));

        return new Tree(t.getValue(), children);
    }

    /**
     * @param arr integer array to be checked (root at index 0)
     * @param n the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     */
    public static boolean isHeap(int[] arr, int n) {
        if(arr == null) return false;
        for(int i = n - 1; i > 0; i--) {
            int index = getParent(arr, i);
            if(arr[i] > arr[index]) return false;
        }

        return true;
    }

    /**
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i index of node whose parent we're looking for (make no assumptions about it's validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have a parent
     */
    public static int getParent(int[] arr, int i) {
        if(arr == null) return -1;
        if(i <= 0 || i >= arr.length) return -1;
        return (i-1) / 2;
    }

 //no tests bc bc
    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTreeDiff tree) {
        if(tree == null) return true;
        if(!tree.hasLeft() && tree.hasRight()) return false;

        Queue<BinaryTreeDiff> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(tree);

        while(!queue.isEmpty()) {
            BinaryTreeDiff current = queue.poll();

            if(current.hasLeft()) {
                if(flag) return false;
                queue.add(current.getLeft());
            }
            else flag = true;

            if(current.hasRight()) {
                if(flag) return false;
                queue.add(current.getRight());
            }
            else flag = true;
        }

        return true;
    }

    /**
     * Sums the values of the nodes of two n-ary trees.
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return a new tree in which every node contains the sum of the values of the nodes at the corresponding positions in t1 and t2
     */
    public static Tree sum(Tree t1, Tree t2) {
        if(t1 == null) {
            return null;
        }
        if(t1.getChildren() == null) {
            return new Tree(t1.getValue() + t2.getValue());
        }

        List<Tree> children = new ArrayList<>();

        for(int i = 0; i < t1.getChildren().size(); i++) {
            children.add(sum(t1.getChildren().get(i), t2.getChildren().get(i)));
        }

        return new Tree(t1.getValue() + t2.getValue(), children);

    }

    /**
     * @param heap
     *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
     * @return the Node corresponding to the middle element in the last layer of the Heap, or null if the Heap is null.
     * In case the last layer contains an even number of elements, returns the element just left of the middle (see test).
     */
    public static Heap.Node findMiddleInLastLayer(Heap heap) {
        if(heap == null) return null;
        if(heap.size() == 1) return heap.getRoot();

        int h = (int) (Math.log(heap.size()) / Math.log(2));
        int bottom = (int) (heap.size() - (Math.pow(2, h) - 1));
        int index = bottom % 2 == 0 ? bottom / 2 - 1 : bottom / 2;
        int mask = 1 << (h-1);

        Heap.Node currentNode = heap.getRoot();

        for(int i = 0; i < h; i++) {
            if((mask & index) != 0) currentNode = heap.getRight(currentNode);
            else if((mask & index) == 0) currentNode = heap.getLeft(currentNode);

            mask = mask >>1;
        }

        return currentNode;
    }

}

