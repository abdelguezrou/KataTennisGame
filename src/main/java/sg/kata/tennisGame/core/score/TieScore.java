package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Tie Score
 * Define the Tie Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class TieScore extends AScore{
	
	/**
	 * TieScore default constructor
	 */
    private TieScore() {
        //expected for sonar
    	super(null, null);
    }

	/**
	 * TieScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public TieScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    /**
	 * Check if is TieBreak activated
	 * If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
	 * @return true/false
	 */
    @Override
    public Boolean isAppliable() {
         return (player1.getSetScore() == 6 && player2.getSetScore() == player1.getSetScore());
    }
    
    @Override
    public String toString() {
    	return "Tie Break score : " + Integer.valueOf(player1.getGameScore()).toString() + "/" + Integer.valueOf(player2.getGameScore()).toString();
    }

    


}
