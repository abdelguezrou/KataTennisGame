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
