// Baraka Hanggi
// Project02
// Deck.java

package student;
import java.util.Random;

public class Deck {
    /** Instantiate Deck of 52 Cards (Array of Cards). */
    private Card[] currentDeck = new Card[52];
    /** Current Card Index Position of the Deck. */
    private int currentDraw = 0;
    /**
     * Creates a deck (Each deck as exactly one unique card).
     */
    public Deck() {
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j < 5; j++) {
                currentDeck[(i - 1) * 4 + (j - 1)] = new Card(i, j);
            }
        }
        shuffle();
    }

    /**
     * Shuffles the deck of cards (Random order).
     */
    public void shuffle() {
        for (int i = currentDeck.length - 1; i >= 1; i--) {
            Random rnd = new Random();
            int j = rnd.nextInt(i);
            Card temp = currentDeck[i];

            currentDeck[i] = currentDeck[j];
            currentDeck[j] = temp;
        }
        currentDraw = 0;
    }

    /**
     * Draws a top card in deck.
     * @return The top card drawed.
     */
    public Card draw() {
        if (isEmpty()) {
            shuffle();
        }
        Card drawedCard = currentDeck[currentDraw];
        currentDraw += 1;
        return drawedCard;
    }

    /**
     * @return Returns the amount of cards remaining in the Deck.
     */
    public int cardsRemaining() {
        return 52 - currentDraw;
    }

    /**
     * @return if the deck is empty or not.
     */
    public boolean isEmpty() {
        return cardsRemaining() == 0;
    }
}
