// Baraka Hanggi
// Project02
// Hand.java

package student;

public class Hand {
    /** A Card Array containing the cards in the Hand. */
    private Card[] currentHand;
    /** Deck object containing all the cards in the Deck. */
    private Deck currentDeck;

    /**
     * Creates a hand of cards for a player/AI.
     * @param deck Deck object to grab cards from.
     * @param size Amount of cards to be held in the hand.
     */
    public Hand(Deck deck, int size) {
        currentHand = new Card[size];
        currentDeck = deck;
        for (int i = 0; i < currentHand.length; i++) {
            currentHand[i] = currentDeck.draw();
        }
    }

    /**
     * @return the size of the hand.
     */
    public int getSize() {
        return currentHand.length;
    }

    /**
     * Grabs a particular card in the hand.
     * @param i Index of the card to be grabbed.
     * @return Returns the card object held in the hand at index i.
     */
    public Card get(int i) {
        if (i > getSize() - 1 || i < 0) {
            System.out.println("Invalid hand index!");
            i = 0;
        }
        return currentHand[i];
    }

    /**
     * Searches for a card in the hand and removes/replaces it.
     * @param card The card to be removed.
     * @return boolean value, true if card was removed, false if the card cannot be removed.
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }
        for (int i = 0; i < currentHand.length; i++) {
            if (currentHand[i].equals(card)) {
                currentHand[i] = currentDeck.draw();
                return true;
            }
        }
        return false;
    }
}
