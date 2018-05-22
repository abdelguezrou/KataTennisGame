package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Deuce Score
 * Define the Deuce Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class DeuceScore extends Score{

	/**
	 * DeuceScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public DeuceScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return (player1.getGameScore() >= 3 && player1.getGameScore() == player2.getGameScore());
			
    }


}