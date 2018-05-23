/**
 * 
 */
package sg.kata.tennisGame.core;

import java.util.List;
import static java.util.Arrays.asList;
import static org.apache.commons.collections4.IterableUtils.find;

import sg.kata.tennisGame.core.score.AdvantageScore;
import sg.kata.tennisGame.core.score.DeuceScore;
import sg.kata.tennisGame.core.score.IsAppliable;
import sg.kata.tennisGame.core.score.NormalScore;
import sg.kata.tennisGame.core.score.NullScore;
import sg.kata.tennisGame.core.score.AScore;
import sg.kata.tennisGame.core.score.TieScore;
import sg.kata.tennisGame.core.score.WinScore;
import sg.kata.tennisGame.model.Player;

/**
 * Represents a game {@link Game} entity.
 * extend Abstract class StateScore {@link AStateScore}
 * @author gabdel
 * @since 22/05/2018
 */

public class Game extends AStateScore {
	
	
	/**
	 * Define possible Scores list
	 * 
	 * @return list of possible scores
	 */
	 private List<AScore> possibleScores() {
	        return asList(
	                new WinScore(player1, player2),
	                new TieScore(player1, player2),
	                new DeuceScore(player1, player2),
	                new AdvantageScore(player1, player2),
	                new NormalScore(player1, player2),
	                new NullScore(player1, player2)
	                );
	    }
	 

	/**
	 * Constructor
	 * Creates a game {@link Game} with specified players
	 * @param player1 first player {@link Player}
	 * @param player2 second player {@link Player}
	 */
    public Game(final Player player1, final Player player2) {
    	super.player1 = player1;
		super.player2 = player2;
    }
    
    
    @Override
	public boolean hasWinner() {
    	return player1.hasWonAgainst(player2) || player2.hasWonAgainst(player1);
	}
	
	@Override
	public Player playerWithHighestScore() {
		return (player1.getGameScore() > player2.getGameScore()) ? player1: player2;
	}

	
	
	@Override
	public String getScore() {
        return find(possibleScores(), new IsAppliable()).toString();
    }
    

    
}
