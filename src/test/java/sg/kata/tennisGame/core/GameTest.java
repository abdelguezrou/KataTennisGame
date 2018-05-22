package sg.kata.tennisGame.core;

import org.junit.Before;
import org.junit.Test;

import sg.kata.tennisGame.model.Player;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        assertThat(p1, hasProperty("gameScore", is(0)));
        assertThat(p2, hasProperty("gameScore", is(0)));
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        p2.winsPoint();
        assertThat(p1, hasProperty("gameScore", is(0)));
        assertThat(p2, hasProperty("gameScore", is(1)));
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        p1.winsPoint();
        p1.winsPoint();
        p2.winsPoint();
        assertThat(p1, hasProperty("gameScore", is(2)));
        assertThat(p2, hasProperty("gameScore", is(1)));
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                p1.winsPoint();
        });
        assertThat(p1, hasProperty("gameScore", is(3)));
        assertThat(p2, hasProperty("gameScore", is(0)));
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveBeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p1.winsPoint();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            p2.winsPoint();
        });
        assertThat(p1, hasProperty("gameScore", is(3)));
        assertThat(p2, hasProperty("gameScore", is(4)));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p1.winsPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p2.winsPoint();
        });
        assertThat(p1, hasProperty("gameScore", is(3)));
        assertThat(p2, hasProperty("gameScore", is(3)));
        assertEquals("Game score : DEUCE", game.getScore());
        p1.winsPoint();
        assertNotEquals("Game score : DEUCE", game.getScore());
        p2.winsPoint();
        assertEquals("Game score : DEUCE", game.getScore());
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            p1.winsPoint();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p2.winsPoint();
        });
        
        assertNotEquals("Game score : player1 win the game", game.getScore());
        assertNotEquals("Game score : player1 win the game", game.getScore());
        p1.winsPoint();
        assertEquals("Game score : player1 win the game", game.getScore());
    }

}
