package sg.kata.tennisGame.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sg.kata.tennisGame.model.Player;


/**
 * Match Unit Test
 * @author gabdel
 * @since 22/05/2018
 */
public class MatchUnitTest {

	private Player player1 = new Player("player1");
	private Player player2 = new Player("player2");
	private Match tennisMatch = new Match(player1, player2);
	
	@Test
	public void testHasSetWinner() {
		createMatchScore(6,4,0,0);
		assertEquals(true, tennisMatch.hasWinner());
		
		createMatchScore(5,5,4,5);
		assertEquals(false, tennisMatch.hasWinner());
	}
	
	@Test
	public void testPlayerWithHighestSetScore() {
		createMatchScore(5,6,7,8);
		assertEquals(player2, tennisMatch.playerWithHighestScore());
		
		createMatchScore(4,2,0,0);
		assertEquals(player1, tennisMatch.playerWithHighestScore());
	}
	
	@Test
	public void testMatchScore() {
		createMatchScore(4,5,0,3);
		assertEquals("Game score : 0/40" + "\n" + "Set score : 4/5", tennisMatch.getScore());
		
		createMatchScore(2,1,2,3);
		assertEquals("Game score : 30/40" + "\n" + "Set score : 2/1", tennisMatch.getScore());
		
		createMatchScore(3,5,0,2);
		assertEquals("Game score : 0/30" + "\n" + "Set score : 3/5", tennisMatch.getScore());
	}

	private void createMatchScore(int playerOneSetScore, int playerTwoSetScore, int playerOneGameScore, int playerTwoGameScore) {
		player1.setSetScore(playerOneSetScore);
		player2.setSetScore(playerTwoSetScore);
		player1.setGameScore(playerOneGameScore);
		player2.setGameScore(playerTwoGameScore);
	}
	
}
	
	
