// Baraka Hanggi
// Project 3

package student;

public class HuffmanNode {
    /** Left Child Huffman Node. */
    private HuffmanNode left;
    /** Right Child Huffman Node. */
    private HuffmanNode right;
    /** Character stored in the current Node. */
    private Character c;

    /**
     * Constructs an internal node.
     * @param zero - Left Child Node.
     * @param one - Right Child Node.
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        left = zero;
        right = one;
        c = null;
    }

    /**
     * Constructs a leaf node.
     * @param data Data stored in the leaf node.
     */
    public HuffmanNode(Character data) {
        left = null;
        right = null;
        c = data;
    }

    /**
     * @return Left Child Node of current Node.
     */
    public HuffmanNode getZero() {
        return left;
    }

    /**
     * Sets left Child node.
     * @param zero - Left Child Node.
     */
    public void setZero(HuffmanNode zero) {
        left = zero;
    }

    /**
     * @return Right Child Node of current Node.
     */
    public HuffmanNode getOne() {
        return right;
    }

    /**
     * Set right Child node.
     * @param one - Right Child Node.
     */
    public void setOne(HuffmanNode one) {
        right = one;
    }

    /**
     * @return data in current Node.
     */
    public Character getData() {
        return c;
    }

    /**
     * Sets data in the current Node.
     * @param data Data to be placed in the node.
     */
    public void setData(char data) {
        c = data;
    }

    /**
     * Checks if current node is a leaf.
     * @return True if the node is a leaf, false otherwise.
     */
    public boolean isLeaf() {
        if (left == null && right == null) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a node is valid or not.
     * @return True if valid, false otherwise.
     */
    public boolean isValidNode() {
        if (isLeaf() && c != null || left != null && right != null && c == null) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a tree if valid.
     * @return True if valid, false otherwise.
     */
    public boolean isValidTree() {
        if (isValidNode() && isLeaf()) {
            return true;
        } else if (isValidNode()) {
            return (left.isValidTree() && right.isValidTree());
        }
        return false;
    }
}
