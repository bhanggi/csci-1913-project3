// Baraka Hanggi
// Project02
// CardPile.java

package student;

public class CardPile {
    /** Card at the Top of the CardPile. */
    private Card topCard;
    /** Size of the CardPile. */
    private int stackSize;

    /**
     * Instantiates the CardPile, placing the starting card.
     * @param topCard the starting card in the pile.
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        stackSize = 1;
    }

    /**
     * Checks if a card can be placed.
     * @param card Card that the player/AI is attempting to place.
     * @return returns a boolean value if the card is valid to be placed.
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }
        if (card.getRankNum() >= topCard.getRankNum() || card.getSuitName().equals(topCard.getSuitName())) {
            return true;
        }
        return false;
    }

    /**
     * Places the card into the cardPile (Only if Valid).
     * @param card The card that the AI/Player is attempting to place.
     */
    public void play(Card card) {
        if (!canPlay(card)) {
            System.out.println("Illegal move detected!");
            return;
        }
        topCard = card;
        stackSize += 1;
    }

    /**
     * @return Returns the amount of cards in the CardPile.
     */
    public int getNumCards() {
        return stackSize;
    }

    /**
     * @return Card at the top of the CardPile.
     */
    public Card getTopCard() {
        return topCard;
    }
}
