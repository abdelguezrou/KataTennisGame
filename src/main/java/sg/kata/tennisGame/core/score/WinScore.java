package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Win Score
 * Define the Win Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class WinScore extends Score{

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
        return player1.hasWonAgainst(player2) || player2.hasWonAgainst(player1);
			
    }


}
