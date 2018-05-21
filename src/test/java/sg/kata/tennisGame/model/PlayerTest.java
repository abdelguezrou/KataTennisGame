package sg.kata.tennisGame.model;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Player Unit Test
 * @author gabdel
 * @since 22/05/2018
 */
public class PlayerTest {

    @Test
    public void pointsCanBeAddedToEachPlayer() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player1.winsPoint();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            player2.winsPoint();
        });
        assertThat(player1, hasProperty("gameScore", is(3)));
        assertThat(player2, hasProperty("gameScore", is(4)));
    }
}
