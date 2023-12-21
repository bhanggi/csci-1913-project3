// Baraka Hanggi
// Project02
// BiggestCardAI.java

package student;

public class BiggestCardAI extends AI {
    /**
     * Returns the card the AI chooses to play (Largest Card the AI can play).
     * @param hand Cards in the AI's hand.
     * @param cardPile Object that represents the cards stacked between both players.
     * @return Card object, returns the largest Card the AI can play.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        String topCardSuit = cardPile.getTopCard().getSuitName();
        int topCardRank = cardPile.getTopCard().getRankNum();
        Card biggestCard = null;
        for (int i = 0; i < hand.getSize(); i++) {
            if (hand.get(i).getSuitName().equals(topCardSuit) || hand.get(i).getRankNum() >= topCardRank) {
                if (biggestCard == null) {
                    biggestCard = hand.get(i);
                } else if (biggestCard.getRankNum() < hand.get(i).getRankNum()) {
                    biggestCard = hand.get(i);
                }
            }
        }
        return biggestCard;
    }

    /**
     * @return the name of the AI being used.
     */
    public String toString() {
        return "Biggest Card AI";
    }
}
