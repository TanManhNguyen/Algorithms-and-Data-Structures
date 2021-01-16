package Week7;

import java.util.*;

public class Solution {
    /**
     * Return all elements in the given BST in descending order.
     * @param tree The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        List<Integer> res = new ArrayList<>();
        if(!tree.hasRight() && !tree.hasLeft()) {
            res.add(tree.getKey());
            return res;
        }

        List<Integer> right = tree.hasRight() ? descendingOrder(tree.getRight()) : null;
        List<Integer> left = tree.hasLeft() ? descendingOrder(tree.getLeft()) : null;

        if(right != null) res.addAll(right);
        res.add(tree.getKey());
        if(left != null) res.addAll(left);

        return res;
    }

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree tree) {
        return isTreeBSTHelp(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isTreeBSTHelp(BinaryTree tree, int min, int max) {
        if (tree == null) return true;
        if (tree.getKey() < min || tree.getKey() > max) return false;

        return (isTreeBSTHelp(tree.getLeft(), min, tree.getKey()-1) &&
                isTreeBSTHelp(tree.getRight(), tree.getKey()+1, max));
    }

    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree
     *     the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static boolean isTreeBalanced(BinaryTree tree) {
        if(tree == null) return true;
        if(!tree.hasLeft() && !tree.hasRight()) return true;

        boolean left = isTreeBalanced(tree.getLeft());
        boolean right = isTreeBalanced(tree.getRight());

        if(!left || !right) return false;

        int lHeight = height(tree.getLeft());
        int rHeight = height(tree.getRight());

        return Math.abs(lHeight - rHeight) <= 1;
    }

    public static int height(BinaryTree tree) {
        if(tree == null) return -1;
        if(!tree.hasLeft() && !tree.hasRight()) return 0;

        int left = tree.hasLeft() ? height (tree.getLeft()) : 0;
        int right = tree.hasRight() ? height(tree.getRight()) : 0;

        return left > right ? left + 1 : right + 1;
    }

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        return isTreeBST(tree) && isTreeBalanced(tree);
    }

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     * @param tree BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static boolean isRedBlackTree(RedBlackBinaryTree tree) {
        if (tree == null) return true;
        if (tree.isRed()) return false;

        return blackHeight(tree) != -1 &&
                isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) &&
                noRedChildren(tree);
    }

    public static int blackHeight(RedBlackBinaryTree tree) {
        if (tree == null) return 0;

        int left = blackHeight(tree.getLeft());
        int right = blackHeight(tree.getRight());

        if (left == -1 || right == -1 || left != right) return -1;
        return left + (tree.isBlack() ? 1 : 0);
    }

    public static boolean isTreeBST(RedBlackBinaryTree tree, int min, int max) {
        if (tree == null) return true;
        if (tree.getValue() < min || tree.getValue() > max) return false;

        return (isTreeBST(tree.getLeft(), min, tree.getValue()-1) &&
                isTreeBST(tree.getRight(), tree.getValue()+1, max));
    }

    public static boolean noRedChildren(RedBlackBinaryTree tree) {
        if (tree == null) return true;

        return noRedChildren(tree.getLeft()) &&
                noRedChildren(tree.getRight()) &&
                (tree.isRed() ?
                        ((tree.getLeft() != null ? tree.getLeft().isBlack() : true) &&
                                (tree.getRight() != null ? tree.getRight().isBlack() : true)) : true);
    }

    /**
     * Checks whether the given MultiwaySearchTree satisfies all to conditions.
     * Our reference solution does not change this function in any way.
     *
     * @param tree
     *     MultiwaySearchTree to check.
     * @return True iff the given tree satisfies all conditions.
     */
    public static boolean isSpecialTree(MultiwaySearchTree tree) {
        return satisfiesCondition1(tree) && satisfiesCondition2(tree) && satisfiesCondition3(tree) && satisfiesCondition4(tree);
    }

    public static boolean satisfiesCondition1(MultiwaySearchTree tree) {
        if(tree == null) return true;
        if(tree.getChildren().length > 7) return false;

        for(MultiwaySearchTree t : tree.getChildren()) {
            if(tree == null) break;
            if(!satisfiesCondition1(t)) return false;
        }

        return true;
    }

    public static boolean satisfiesCondition2(MultiwaySearchTree tree) {
        if(tree == null) return true;

        Queue<MultiwaySearchTree> queue = new LinkedList<>(Arrays.asList(tree.getChildren()));
        MultiwaySearchTree current;

        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current == null) continue;
            if(Children(current.getChildren()) == 0) continue;
            if(Children(current.getChildren()) < 4) return false;
            queue.addAll(Arrays.asList(current.getChildren()));
        }

        return true;
    }

    public static boolean satisfiesCondition3(MultiwaySearchTree tree) {
        if(tree == null) return true;
        if(Children(tree.getChildren()) == 0) return true;

        return Children(tree.getChildren()) > 1;
    }

    public static boolean satisfiesCondition4(MultiwaySearchTree tree) {
        if(tree == null) return true;
        return isMultiWaySearchTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int Children(MultiwaySearchTree[] children) {
        int c = 0;
        for(int i = 0; i < children.length; i++) {
            if(children[i] != null) c++;
        }
        return c;
    }

    public static boolean isMultiWaySearchTree(MultiwaySearchTree tree, int min, int max) {
        if(tree == null) return true;

        for (int i = 0; i < tree.getKeys().length; i++) {
            if(tree.getKeys()[i] < min || tree.getKeys()[i] > max) return false;
            if(i > 0 ? tree.getKeys()[i] <= tree.getKeys()[i - 1] : false) return false;
        }

        if(Children(tree.getChildren()) != 0) {
            if (Children(tree.getChildren()) < 2) return false;
            if (Children(tree.getChildren()) - 1 != tree.getKeys().length) return false;
        }

        for (int i = 0; i < Children(tree.getChildren()); i++) {
            int newMin = i == 0 ? min : tree.getKeys()[i - 1] + 1;
            int newMax = i == Children(tree.getChildren()) - 1 ? max : tree.getKeys()[i] - 1;
            if(!isMultiWaySearchTree(tree.getChildren()[i], newMin, newMax)) return false;
        }

        return true;
    }





}
