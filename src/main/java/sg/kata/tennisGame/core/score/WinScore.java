package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.helper.PlayerHelper;
import sg.kata.tennisGame.model.Player;


/**
 * Represents Win Score
 * Define the Win Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class WinScore extends AScore{

	/**
	 * WinScore default constructor
	 */
    private WinScore() {
        //expected for sonar
    	super(null, null);
    }
	
	/**
	 * WinScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public WinScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return PlayerHelper.hasWonAgainst(player1, player2) || PlayerHelper.hasWonAgainst(player2, player1);
    }

    @Override
    public String toString() {
    	return "Game score : "+ playerWhoWon().getName()+" win the game";
    }

    /**
     * playerWhoWon
     * @return the won player
     */
    private Player playerWhoWon() {
        return PlayerHelper.hasWonAgainst(player1, player2) ? player1 : player2;
    }

}
