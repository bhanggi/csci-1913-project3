// Baraka Hanggi
// Project 3

package student;

import provided.BinarySequence;

public class HuffmanCodeTree {
    /** Root Node of the Tree. */
    private HuffmanNode root;

    /**
     * Constructor for a tree built from a single root node.
     * @param root - Root Node of the Tree.
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * Constructor for a tree built from a codeBook.
     * @param codeBook codeBook map with characters mapped to BinarySequences.
     */
    public HuffmanCodeTree(HuffmanCodeBook codeBook) {
        root = new HuffmanNode(null);
        for (int i = 0; i < codeBook.getLength(); i++) {
            put(codeBook.getSequence(codeBook.getChar(i)), codeBook.getChar(i));
        }
    }

    /**
     * Checks if the tree is valid.
     * @return boolean value, True if valid, false otherwise.
     */
    public boolean isValid() {
        return root.isValidTree();
    }

    /**
     * Places the character in the appropriate leaf node.
     * @param seq - BinarySequence associated with the character.
     * @param letter - Character to be placed in the tree.
     */
    public void put(BinarySequence seq, char letter) {
        HuffmanNode currentNode = root;
        for (int i = 0; i < seq.size(); i++) {
            if (seq.get(i)) {
                if (currentNode.getOne() == null) {
                    currentNode.setOne(new HuffmanNode(null));
                }
                currentNode = currentNode.getOne();
            } else {
                if (currentNode.getZero() == null) {
                    currentNode.setZero(new HuffmanNode(null));
                }
                currentNode = currentNode.getZero();
            }
        }
        currentNode.setData(letter);
    }

    /**
     * Decodes a BinarySequence into a string.
     * @param s - BinarySequence to be decoded.
     * @return String, decoded message.
     */
    public String decode(BinarySequence s) {
        HuffmanNode node = root;
        String decodedString = "";
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i)) {
                node = node.getOne();
            } else {
                node = node.getZero();
            }
            if (node.isLeaf()) {
                decodedString += node.getData();
                node = root;
            }
        }
        return decodedString;
    }


}
