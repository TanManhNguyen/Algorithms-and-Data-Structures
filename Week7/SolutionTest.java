package Week7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertEquals(Arrays.asList(84, 42, 21), Solution.descendingOrder(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertEquals(Arrays.asList(42, 21), Solution.descendingOrder(tree));
    }

    @Test
    public void testOneLevelTrue() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertTrue(Solution.isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalse() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertFalse(Solution.isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalseDuplicate() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(42), new BinaryTree(21));
        assertFalse(Solution.isTreeBST(tree));
    }

    @Test
    public void testOaneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isTreeBST(tree));
        tree = new BinaryTree(42, new BinaryTree(84), null);
        assertFalse(Solution.isTreeBST(tree));
    }

    @Test
    public void testEmptyTree() {
        assertTrue(Solution.isTreeBalanced(null));
    }

    @Test
    public void teastOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(Solution.isTreeBalanced(tree));
    }

    @Test
    public void testLinearTree() {
        assertFalse(Solution.isTreeBalanced(new BinaryTree(1, new BinaryTree(2, new BinaryTree(3), null), null)));
    }

    @Test
    public void testJustRoot() {
        BinaryTree tree = new BinaryTree(42);
        assertTrue(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLevealTrue() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertTrue(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLeveslFalse() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertFalse(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLewvelFalseDuplicate() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(42), new BinaryTree(21));
        assertFalse(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLefatChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isTreeAVL(tree));
        tree = new BinaryTree(42, new BinaryTree(84), null);
        assertFalse(Solution.isTreeAVL(tree));
    }

    /*
           42
          /
         36
        /  \
       21  39
     */
    @Test
    public void testTwoLevelsSkew2() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(39)), null);
        assertFalse(Solution.isTreeAVL(tree));
    }

    @Test
    public void testExample() {
        RedBlackBinaryTree tree = new RedBlackBinaryTree(4, false);
        assertTrue(Solution.isRedBlackTree(tree));
        tree.setLeft(new RedBlackBinaryTree(2, false));
        tree.setRight(new RedBlackBinaryTree(6, false));
        assertTrue(Solution.isRedBlackTree(tree));
        tree.getLeft().setLeft(new RedBlackBinaryTree(1, false));
        tree.setRight(null);
        assertFalse(Solution.isRedBlackTree(tree));
    }

    private MultiwaySearchTree makeLeafNode(int value) {
        int[] child2Value = new int[1];
        child2Value[0] = value;
        MultiwaySearchTree[] child2Children = new MultiwaySearchTree[2];
        return new MultiwaySearchTree(child2Value, child2Children);
    }

    @Test
    public void testExjuample() {
        int[] rootValue = new int[1];
        rootValue[0] = 4;
        MultiwaySearchTree[] rootChildren = new MultiwaySearchTree[2];
        MultiwaySearchTree tree = new MultiwaySearchTree(rootValue, rootChildren);
        assertTrue(Solution.isSpecialTree(tree));
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(6);
        assertTrue(Solution.isSpecialTree(tree));
    }

    @Test
    public void testExample2() {
        int[] rootValue = new int[1];
        rootValue[0] = 4;
        MultiwaySearchTree[] rootChildren = new MultiwaySearchTree[2];
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(3);
        MultiwaySearchTree tree = new MultiwaySearchTree(rootValue, rootChildren);
        assertFalse(Solution.isSpecialTree(tree));
        assertTrue(Solution.satisfiesCondition1(tree));
        assertTrue(Solution.satisfiesCondition2(tree));
        assertTrue(Solution.satisfiesCondition3(tree));
        assertFalse(Solution.satisfiesCondition4(tree));
    }
}