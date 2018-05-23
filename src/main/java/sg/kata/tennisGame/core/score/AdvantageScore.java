package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.helper.PlayerHelper;
import sg.kata.tennisGame.model.Player;

/**
 * Represents Advantage Score
 * Define the Advantage Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class AdvantageScore extends AScore{
	
	/**
	 * AdvantageScore default constructor
	 */
    private AdvantageScore() {
        //expected for sonar
    	super(null, null);
    }

	/**
	 * AdvantageScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public AdvantageScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    /**
	 * Check if is advantage rule activated
	 * If the score is DEUCE , the player who  win the point take the ADVANTAGE
	 * @return true/false
	 */
    @Override
    public Boolean isAppliable() {
        return (player1.getGameScore() >= 4 && player1.getGameScore() == player2.getGameScore() + 1) ||
        		(player2.getGameScore() >= 4 && player2.getGameScore() == player1.getGameScore() + 1);
			
    }
    
    @Override
    public String toString() {
        return "Game score : ADV " + playerInAdvantage().getName();
    }

    /**
     * playerInAdvantage 
     * @return player in advantage
     */
    private Player playerInAdvantage() {
        return PlayerHelper.hasAdvantageOver(player1, player2) ? player1 : player2;
    }


}
