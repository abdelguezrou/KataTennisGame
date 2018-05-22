package sg.kata.tennisGame.core.score;


import sg.kata.tennisGame.model.Player;


/**
 * Represents Advantage Score
 * Define the Advantage Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class AdvantageScore extends Score{

	/**
	 * AdvantageScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public AdvantageScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return (player1.getGameScore() >= 4 && player1.getGameScore() == player2.getGameScore() + 1) ||
        		(player2.getGameScore() >= 4 && player2.getGameScore() == player1.getGameScore() + 1);
			
    }


}
