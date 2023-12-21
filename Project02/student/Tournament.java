// Baraka Hanggi
// Project02
// Tournament.java

package student;

public class Tournament {
    /**
     * Runs 1000 Games per AI Combination and returns statistics of the Tournament.
     * @param args
     */
    public static void main(String[] args) {
        AI randomAI = new AI();
        AI biggestAI = new BiggestCardAI();
        AI smallestAI = new SmallestCardAI();
        AI[] aiArray = {randomAI, smallestAI, biggestAI};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                UnoWarMatch game = new UnoWarMatch(aiArray[i], aiArray[j]);
                System.out.println(aiArray[i].toString() + " vs. " + aiArray[j].toString() + ": " + game.winRate(1000));
            }
        }
    }
}
