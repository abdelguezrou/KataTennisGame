package sg.kata.tennisGame.core.score;

import sg.kata.tennisGame.model.Player;


/**
 * Represents an abstract class Score {@link Score}
 * Define the Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public abstract class Score {

    protected Player player1;
    protected Player player2;

    /**
     * Score Constructor 
     * @param player1 first player
     * @param player2 second player
     */
    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Check if score is appliable
     * @return true/false
     */
    public abstract Boolean isAppliable();

}
