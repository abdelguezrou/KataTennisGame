package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Tie Score
 * Define the Tie Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class TieScore extends Score{

	/**
	 * TieScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public TieScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return (player1.getSetScore() == 6 && player2.getSetScore() == player1.getSetScore());
    }


}
