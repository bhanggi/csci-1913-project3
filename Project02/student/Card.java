// Baraka Hanggi
// Project02
// Card.java

package student;

public class Card {
    /** Rank of the Card (1 = Ace). */
    private int rank = 1;
    /** Suit of the Card (1 = Spades). */
    private int suit = 1;
    /** Names of each Rank. */
    private String[] rankName = {"Ace", "Two", "Three", "Four", "Five", "Six",
                                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    /** Names of each Suit. */
    private String[] suitName = {"Spades", "Hearts", "Clubs", "Diamonds"};

    /**
     * Instantiates the Card object.
     * @param rank The Rank of the Card (1 = Ace, 13 = King).
     * @param suit The Suit of the Card (1 = Spades, 4 = Diamonds).
     */
    public Card(int rank, int suit) {
        if (rank > 13 || rank < 1 || suit > 4 || suit < 1) {
            System.out.println("Invalid Card");
            return;
        }
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return Returns the rank of the card.
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * @return Returns the Name of the Rank of the Card.
     */
    public String getRankName() {
        return rankName[rank - 1];
    }

    /**
     * @return Returns the Suit of the Suit of the Card.
     */
    public String getSuitName() {
        return suitName[suit - 1];
    }

    /**
     * @return Returns the Name of the Card.
     */
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * Overrides the equals method, for it to work with Card objects and its instance variables.
     * @param obj Any valid object.
     * @return Boolean value, true if the object is a Card object with the same instance variable values.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Card) {
            Card card = (Card) obj;
            return this.rank == card.rank && this.suit == card.suit;
        }
        return false;
    }
}
