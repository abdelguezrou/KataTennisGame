package sg.kata.tennisGame.core;

import sg.kata.tennisGame.helper.PlayerHelper;
import sg.kata.tennisGame.model.Player;


/**
 * Represents a Set {@link Set} entity.
 * extend Abstract class StateScore {@link AbstructStateScore}
 * @author gabdel
 * @since 22/05/2018
 */
public class Set extends AbstructStateScore {
	
	/**
	 * Constructor
	 * Creates a Set {@link Set} with specified players
	 * @param player1 first player {@link Player}
	 * @param player2 second player {@link Player}
	 */
	public Set(final Player player1, final Player player2) {
		super.player1 = player1;
		super.player2 = player2;
	}
	
	
	@Override
	public boolean hasWinner() {
		return ((player1.getSetScore() == 6 && player2.getSetScore() <= 4) || (player2.getSetScore() == 6  && player1.getSetScore() <= 4)
				|| player1.getSetScore() == 7 || player2.getSetScore() == 7) ? true : false;
	}
	
	@Override
	public Player playerWithHighestScore() {
		return (player1.getSetScore() > player2.getSetScore()) ? player1 : player2;
	}
	
	@Override
	public String getScore() {
		final String score;
		if(hasWinner()) {
			score = PlayerHelper.winsSet(playerWithHighestScore());
			player1.setSetScore(0);
			player2.setSetScore(0);
			return "Set score : " + score;
		}
		return "Set score : " + player1.getSetScore() + "/" + player2.getSetScore();
	}
}
