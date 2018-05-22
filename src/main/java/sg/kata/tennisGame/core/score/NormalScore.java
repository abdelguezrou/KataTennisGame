package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Normal Score
 * Define the Normal Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class NormalScore extends Score{

	/**
	 * NormalScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public NormalScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return player1.getGameScore() <= 3 && player2.getGameScore() <= 3;
    }


}
