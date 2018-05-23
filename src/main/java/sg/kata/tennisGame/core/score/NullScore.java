package sg.kata.tennisGame.core.score;

import sg.kata.tennisGame.model.Player;


/**
 * Represents Null Score
 * Define the Null Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public class NullScore extends AbstructScore{
	
	/**
	 * NullScore default constructor
	 */
    private NullScore() {
        //expected for sonar
    	super(null, null);
    }

	/**
	 * NullScore constructor
	 * @param player1 first player
	 * @param player2 second player
	 */
    public NullScore(final Player player1, final Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isAppliable() {
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
}
