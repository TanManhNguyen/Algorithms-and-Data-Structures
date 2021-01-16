package Week3;

class BinaryTreeDiff {

    private int key;

    private BinaryTreeDiff left, right;

    /**
     * Simple constructor.
     *
     * @param key
     *     to set as key.
     */
    public BinaryTreeDiff(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key
     *     to set as key.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public BinaryTreeDiff(int key, BinaryTreeDiff left, BinaryTreeDiff right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    public int getKey() {
        return key;
    }

    /**
     * @return the left child.
     */
    public BinaryTreeDiff getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BinaryTreeDiff getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     to set
     */
    public void setLeft(BinaryTreeDiff left) {
        this.left = left;
    }

    /**
     * @param right
     *     to set
     */
    public void setRight(BinaryTreeDiff right) {
        this.right = right;
    }
}


