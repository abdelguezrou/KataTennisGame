/**
 * 
 */
package sg.kata.tennisGame.core;

import sg.kata.tennisGame.model.Player;

/**
 * Represents a game {@link Game} entity.
 * extend Abstract class StateScore {@link StateScore}
 * @author gabdel
 * @since 22/05/2018
 */

public class Game extends StateScore {

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
		if(isTieBreakActivated()) {
			if(player1.getGameScore() >= 7 && player1.getGameScore() >= player2.getGameScore() + 2 
					|| player2.getGameScore() >= 7 && player2.getGameScore() >= player1.getGameScore() + 2)
				return true;
			return false;
		}
		else {
			if(player1.getGameScore() > 3 && player1.getGameScore() >= player2.getGameScore() + 2) {
				return true;
			}
			if(player2.getGameScore() > 3 && player2.getGameScore() >= player1.getGameScore() + 2) {
				return true;
			}
			return false;
		}
	}
	
	@Override
	public Player playerWithHighestScore() {
		if(player1.getGameScore() > player2.getGameScore()) {
			return player1;
		}
		else
			return player2;
	}

	@Override
	public String getScore() {
		String score;
		if(hasWinner()) {
			score = playerWithHighestScore().winsGame();
			player1.setGameScore(0);
			player2.setGameScore(0);
			return "Game score : " + score;
		}
		if(isTieBreakActivated())
			return "Tie Break score : " + Integer.valueOf(player1.getGameScore()).toString() + "/" + Integer.valueOf(player2.getGameScore()).toString();
		if(isDeuceActivated())
			return "Game score : DEUCE";
		if(hasAdvantage())
			return "Game score : ADV " + playerWithHighestScore().getName();
		return "Game score : " + tennisScore(player1.getGameScore()) + "/" + tennisScore(player2.getGameScore());
	}
    
	
	
    /**
     * Get tennis Score 
     * @param score : index score input
     * @return score value : possible value 0;15;30;40
     */
	public String tennisScore(final int score) {
		switch(score) {
		case 0: return "0";
		case 1: return "15";
		case 2: return "30";
		case 3: return "40";
		default: return "0";
		}
	}
	
	/**
	 * Check if is TieBreak activated
	 * If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
	 * @return true/false
	 */
	public boolean isTieBreakActivated() {
		if(player1.getSetScore() == 6 && player2.getSetScore() == player1.getSetScore())
			return true;
		return false;
	}
	
	/**
	 * Check if is Deuce activated
	 * If the 2 players reach the score 40, the DEUCE rule is activated
	 * @return true/false
	 */
	public boolean isDeuceActivated() {
		if(player1.getGameScore() >= 3 && player1.getGameScore() == player2.getGameScore())
			return true;
		return false;
	}
	
	/**
	 * Check if is advantage rule activated
	 * If the score is DEUCE , the player who  win the point take the ADVANTAGE
	 * @return true/false
	 */
	public boolean hasAdvantage() {
		if(player1.getGameScore() >= 4 && player1.getGameScore() == player2.getGameScore() + 1)
			return true;
		if(player2.getGameScore() >= 4 && player2.getGameScore() == player1.getGameScore() + 1)
			return true;
		return false;
	}

    
}
