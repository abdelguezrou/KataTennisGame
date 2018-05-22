package sg.kata.tennisGame.core;

import sg.kata.tennisGame.model.Player;


/**
 * Represents a Set {@link Set} entity.
 * extend Abstract class StateScore {@link StateScore}
 * @author gabdel
 * @since 22/05/2018
 */
public class Set extends StateScore {
	
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
		if ((player1.getSetScore() == 6 && player2.getSetScore() <= 4) || (player2.getSetScore() == 6  && player1.getSetScore() <= 4)
				|| player1.getSetScore() == 7 || player2.getSetScore() == 7)
			return true;
		return false;
	}
	
	@Override
	public Player playerWithHighestScore() {
		if(player1.getSetScore() > player2.getSetScore())
			return player1;
		return player2;
	}
	
	@Override
	public String getScore() {
		String score;
		if(hasWinner()) {
			score = playerWithHighestScore().winsSet();
			player1.setSetScore(0);
			player2.setSetScore(0);
			return "Set score : " + score;
		}
		return "Set score : " + player1.getSetScore() + "/" + player2.getSetScore();
	}
}
