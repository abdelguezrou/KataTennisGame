package sg.kata.tennisGame.core;

import sg.kata.tennisGame.model.Player;

/**
 * Represents a Match {@link Match} entity.
 * extend Abstract class StateScore {@link AStateScore}
 * @author gabdel
 * @since 22/05/2018
 */
public class Match extends AStateScore {
	
	private Game game;
	private Set set;
	
	/**
	 * Constructor
	 * Creates a Match {@link Match} with specified players
	 * @param player1 first player {@link Player}
	 * @param player2 second player {@link Player}
	 * initialize game and set attribute
	 */
	public Match(final Player player1, final Player player2) {
		super.player1 = player1;
		super.player2 = player2;
		game = new Game(player1, player2);
		set = new Set(player1, player2);
	}


	@Override
	public boolean hasWinner() {
		return set.hasWinner() ? true : false;
	}

	@Override
	public Player playerWithHighestScore() {
		return (player1.getSetScore() == player2.getSetScore()) ? game.playerWithHighestScore() : set.playerWithHighestScore();
	}
	
	@Override
	public String getScore() {
		return game.getScore() + "\n" + set.getScore();
	}

	
	public Game getGame() {
		return game;
	}

	public void setGame(final Game game) {
		this.game = game;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(final Set set) {
		this.set = set;
	}

}
