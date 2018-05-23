package sg.kata.tennisGame.core.score;


import java.util.HashMap;
import java.util.Map;

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
    
    @Override
    public String toString() {
    	return "Game score : " + nameFor(player1.getGameScore()) + "/" + nameFor(player2.getGameScore());
    }

    /**
     * Get tennis Score 
     * @param score : index score input
     * @return score value : possible value 0;15;30;40
     */
    private String nameFor(final Integer score) {
        return scoreNames().get(score);
    }

    
    /**
     * scoreNames : list of scores
     */
    private static final Map<Integer, String> scoreNames() {
        return new HashMap<Integer, String>() {
            private static final long serialVersionUID = 1L;
            {
                put(0, "0");
                put(1, "15");
                put(2, "30");
                put(3, "40");
            }
        };
    }


}
