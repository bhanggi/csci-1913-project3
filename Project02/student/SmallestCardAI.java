// Baraka Hanggi
// Project02
// SmallestCardAI.java

package student;

public class SmallestCardAI extends AI {
     /**
     * Returns the card the AI chooses to play (Smallest Card the AI can play).
     * @param hand Cards in the AI's hand.
     * @param cardPile Object that represents the cards stacked between both players.
     * @return Returns the smallest Card the AI can play.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        String topCardSuit = cardPile.getTopCard().getSuitName();
        int topCardRank = cardPile.getTopCard().getRankNum();
        Card smallestCard = null;

        for (int i = 0; i < hand.getSize(); i++) {
            if (hand.get(i).getSuitName().equals(topCardSuit) || hand.get(i).getRankNum() >= topCardRank) {
                if (smallestCard == null) {
                    smallestCard = hand.get(i);
                } else if (smallestCard.getRankNum() > hand.get(i).getRankNum()) {
                    smallestCard = hand.get(i);
                }
            }
        }
        return smallestCard;
    }

    /**
     * @return The name of the AI being used.
     */
    public String toString() {
        return "Smallest Card AI";
    }
}
