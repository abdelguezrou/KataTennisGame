/**
 * 
 */
package sg.kata.tennisGame.model;

/**
 * Represents a Player {@link Player} entity
 * @author gabdel
 * @since 22/05/2018
 */
public class Player {
	
	private String name;
    private int gameScore;
    private int setScore;
    
    /**
	 * Default Constructor : for sonar
	 */
    public Player() {
		//expected
	}
    
    /**
	 * Constructor
	 * Creates a Player {@link Player} with specified name
	 * @param name : player name 
	 * initialize game score and set score values to 0
	 */
    public Player(final String name) {
		this.name = name;
		this.gameScore = 0;
		this.setScore = 0;
	}
	
	
    /**
     * If a player wins point increments the game score value
     */
	public void winsPoint() {
		gameScore++;
	}
	
	/**
	 * Wining game declaration
     * If a player wins a game increments the game score value
     * @return the declaration of game wining
     */
	public String winsGame() {
		setScore++;
		return name + " win the game";
	}

	/**
	 * Wining set declaration 
     * @return the declaration of set wining
	 */
	public String winsSet() {
		return name + " win the set and the match";
	}
	/**
	 * has Won Against
	 * @param otherPlayer player
	 * @return true if player is the winner or false if not
	 */
	public Boolean hasWonAgainst(final Player otherPlayer) {
        final Integer advantageOverOtherPlayer = gameScore - otherPlayer.getGameScore();
        return gameScore >= 4 && advantageOverOtherPlayer >= 2;
    }

	
	/**
	 * Check if the player is in advantage
	 * @param otherPlayer player
	 * @return true if player is advantage else return false
	 */
    public Boolean hasAdvantageOver(final Player otherPlayer) {
        final Integer advantageOverOtherPlayer = gameScore - otherPlayer.getGameScore();
        return gameScore >= 4 && advantageOverOtherPlayer.equals(1);
    }
	
	
	public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(final int gameScore) {
		this.gameScore = gameScore;
	}
	
}
