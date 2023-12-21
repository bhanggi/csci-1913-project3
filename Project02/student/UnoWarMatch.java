// Baraka Hanggi
// Project02
// UnoWarMatch.java

package student;

public class UnoWarMatch {

    /** First AI in the Match. */
    private AI ai1;
    /** Second AI in the Match. */
    private AI ai2;
    /**
     * Instantiates the UnoWarMatch, assigns AI to the game.
     * @param ai1 AI object to be added to the game.
     * @param ai2 Second AI object to be added to the game.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * Handles all game logic. First to 10 rounds wins.
     * @return Boolean value, True if ai1 wins, false if ai2 wins.
     */
    public boolean playGame() {
        int ai1Wins = 0;
        int ai2Wins = 0;
        //Boolean Variable, Checks the current Turn (True = AI1 Turn, False = AI2 Turn).
        boolean ai1Turn = true;

        //Main Loop, Will Run until one AI has 10 round wins.
        while (ai1Wins < 10 && ai2Wins < 10) {
            Deck gameDeck = new Deck();
            Hand ai1Hand = new Hand(gameDeck, 5);
            Hand ai2Hand = new Hand(gameDeck, 5);
            CardPile gamePile = new CardPile(gameDeck.draw());

            //Second Loop, Will Run Until an AI wins a round. Contains all turns.
            while (true) {
                if (ai1Turn) {
                    Card ai1Play = ai1.getPlay(ai1Hand, gamePile);
                    if (ai1Play == null) {
                        ai1Turn = false;
                        ai2Wins += 1;
                        break;
                    }
                    gamePile.play(ai1Play);
                    ai1Hand.remove(ai1Play);
                    ai1Turn = false;
                }
                if (!ai1Turn) {
                    Card ai2Play = ai2.getPlay(ai2Hand, gamePile);
                    if (ai2Play == null) {
                        ai1Turn = true;
                        ai1Wins += 1;
                        break;
                    }
                    gamePile.play(ai2Play);
                    ai2Hand.remove(ai2Play);
                    ai1Turn = true;
                }
            }
        //Returns True if ai1 wins, else returns false.
        }
        if (ai1Wins == 10) {
            return true;
        }
        return false;
    }

    /**
     * Used to calculated the amount of games ai1 wins.
     * @param nTrails Amount of games to be played.
     * @return Float value (from 0 to 1) of the percentage of games ai1 won.
     */
    public double winRate(int nTrails) {
        double ai1Wins = 0;
        for (int i = 0; i < nTrails; i++) {
            if (playGame()) {
                ai1Wins += 1;
            }
        }
        return ai1Wins / nTrails;
    }
}
