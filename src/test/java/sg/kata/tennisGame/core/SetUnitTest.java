package sg.kata.tennisGame.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sg.kata.tennisGame.model.Player;

/**
 * Set Unit Test
 * @author gabdel
 * @since 22/05/2018
 */
public class SetUnitTest {

	private Player player1 = new Player("player1");
	private Player player2 = new Player("player2");
	private Set tennisSet = new Set(player1, player2);
	
	@Test
	public void testHasSetWinner() {
		createSetScore(6,4);
		assertEquals(true, tennisSet.hasWinner());
		
		createSetScore(5,5);
		assertEquals(false, tennisSet.hasWinner());
	}
	
	@Test
	public void testPlayerWithHighestSetScore() {
		createSetScore(5,6);
		assertEquals(player2, tennisSet.playerWithHighestScore());
		
		createSetScore(4,2);
		assertEquals(player1, tennisSet.playerWithHighestScore());
	}
	
	@Test
	public void testPlayersWinsGames() {
		createSetScore(1, 0);
		assertEquals("Set score : 1/0", tennisSet.getScore());
		
		createSetScore(0, 3);
		assertEquals("Set score : 0/3", tennisSet.getScore());
		
		createSetScore(5, 5);
		assertEquals("Set score : 5/5", tennisSet.getScore());
	}
	
	@Test
	public void testPlayerOneWinsTheSet() {
		createSetScore(6, 3);
		assertEquals("Set score : player1 win the set and the match", tennisSet.getScore());
	}
	
	@Test
	public void testPlayerTwoWinsTheSet() {
		createSetScore(5, 7);
		assertEquals("Set score : player2 win the set and the match", tennisSet.getScore());
	}
	
	@Test
	public void testPlayerTwoWinsTheSetAfterTieBreak() {
		createSetScore(6, 7);
		assertEquals("Set score : player2 win the set and the match", tennisSet.getScore());
	}

	private void createSetScore(int gamesWonByPlayerOne, int gamesWonByPlayerTwo) {
		player1.setSetScore(gamesWonByPlayerOne);
		player2.setSetScore(gamesWonByPlayerTwo);
	}

}
