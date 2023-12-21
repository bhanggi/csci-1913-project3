// Baraka Hanggi
// Project02
// AI.java

package student;

public class AI {
    /**
     * Returns the card the AI chooses to play.
     * @param hand        Cards in the AI's hand.
     * @param cardPile    Object that represents the cards stacked between both players.
     * @return Returns the first Card in the Hand that can be placed.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        String topCardSuit = cardPile.getTopCard().getSuitName();
        int topCardRank = cardPile.getTopCard().getRankNum();
        for (int i = 0; i < hand.getSize(); i++) {
            if (hand.get(i).getSuitName().equals(topCardSuit) || hand.get(i).getRankNum() >= topCardRank) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * @return the name of the AI being used.
     */
    public String toString() {
        return "Random Card AI";
    }
}
