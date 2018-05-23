package sg.kata.tennisGame.helper;

import org.junit.Test;

import sg.kata.tennisGame.model.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;


/**
 * Player Unit Test
 * @author gabdel
 * @since 22/05/2018
 */
public class PlayerHelperTest {
	
	/**
	 * winsPoint test
	 */
    @Test
    public void pointsCanBeAddedToEachPlayer() {
    	final Player player1 = new Player("Player 1");
        final Player player2 = new Player("Player 2");
        
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            PlayerHelper.winsPoint(player1);
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	PlayerHelper.winsPoint(player2);
        });
        assertEquals(3, player1.getGameScore());
        assertEquals(4, player2.getGameScore());
    }
    
    @Test
    public void winsGameTest() {
    	final Player player1 = new Player("Player 1");
        assertEquals("Player 1 win the game", player1.getName() + " win the game");
        assertEquals(player1.getName() + " win the game", PlayerHelper.winsGame(player1));
    }
    
    @Test
    public void winsSetTest() {
    	final Player player1 = new Player("Player 1");
        assertEquals("Player 1 win the set and the match", player1.getName() + " win the set and the match");
        assertEquals(player1.getName() + " win the set and the match", PlayerHelper.winsSet(player1));
	}
    
    @Test
    public void hasWonAgainstTest() {
    	final Player player1 = new Player("Player 1");
        final Player player2 = new Player("Player 2");
        
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            PlayerHelper.winsPoint(player1);
        });
        
        assertTrue(PlayerHelper.hasWonAgainst(player1, player2));
        assertFalse(PlayerHelper.hasWonAgainst(player2, player1));
        
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            PlayerHelper.winsPoint(player2);
        });

        assertFalse(PlayerHelper.hasWonAgainst(player1, player2));
        
     }
    
    @Test
    public void hasAdvantageOverTest() {
    	final Player player1 = new Player("Player 1");
        final Player player2 = new Player("Player 2");
        
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            PlayerHelper.winsPoint(player1);
        });
        
        assertFalse(PlayerHelper.hasAdvantageOver(player1, player2));
        
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            PlayerHelper.winsPoint(player2);
        });

        assertTrue(PlayerHelper.hasAdvantageOver(player1, player2));
        
     }
}
