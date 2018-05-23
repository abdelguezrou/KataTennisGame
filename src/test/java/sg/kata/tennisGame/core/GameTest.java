package sg.kata.tennisGame.core;

import org.junit.Before;
import org.junit.Test;

import sg.kata.tennisGame.helper.PlayerHelper;
import sg.kata.tennisGame.model.Player;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Represents a game {@link Game} test.
 * @author gabdel
 * @since 22/05/2018
 */
public class GameTest {

    private Player p1;
    private Player p2;
    private Game game;

    @Before
    public void beforeGameTest() {
        p1 = new Player("player1");
        p2 = new Player("player2");
        game = new Game(p1, p2);
    }
    

    @Test
    public void zeroShouldBeDescriptionForScore0() {
    	assertEquals(0, p1.getGameScore());
        assertEquals(0, p2.getGameScore());
        
    }


    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        PlayerHelper.winsPoint(p1);
        PlayerHelper.winsPoint(p1);
        PlayerHelper.winsPoint(p2);
        assertEquals(2, p1.getGameScore());
        assertEquals(1, p2.getGameScore());
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p1);
        });
        assertEquals(3, p1.getGameScore());
        assertEquals(0, p2.getGameScore());
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveBeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p1);
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p2);
        });
        assertEquals(3, p1.getGameScore());
        assertEquals(4, p2.getGameScore());
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p1);
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p2);
        });
        assertEquals(3, p1.getGameScore());
        assertEquals(3, p2.getGameScore());
        assertEquals("Game score : DEUCE", game.getScore());
        PlayerHelper.winsPoint(p1);
        assertNotEquals("Game score : DEUCE", game.getScore());
        PlayerHelper.winsPoint(p2);
        assertEquals("Game score : DEUCE", game.getScore());
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p1);
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	PlayerHelper.winsPoint(p2);
        });
        
        assertNotEquals("Game score : player1 win the game", game.getScore());
        assertNotEquals("Game score : player1 win the game", game.getScore());
        PlayerHelper.winsPoint(p1);
        assertEquals("Game score : player1 win the game", game.getScore());
    }

}
