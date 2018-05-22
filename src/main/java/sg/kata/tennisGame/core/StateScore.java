package sg.kata.tennisGame.core;

import sg.kata.tennisGame.model.Player;

/**
 * Represents an abstract class StateScore {@link StateScore}
 * Define the State Score of tennis entities
 * @author gabdel
 * @since 22/05/2018
 */
public abstract class StateScore {
	
	protected Player player1;
	protected Player player2;
	
	/**
	 * Check if the entity has a winner
	 * @return true/false
	 */
	public abstract boolean hasWinner();
	
	/**
	 * Get the player with the highest score
	 * @return the player {@link Player} with highest score
	 */
	public abstract Player playerWithHighestScore();

	/**
	 * Get Score
	 * @return the entity score
	 */
	public abstract String getScore();
	

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(final Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(final Player player2) {
		this.player2 = player2;
	}
	
	
}
