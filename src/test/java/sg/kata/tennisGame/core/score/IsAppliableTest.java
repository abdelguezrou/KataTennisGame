package sg.kata.tennisGame.core.score;


import org.junit.Test;

import sg.kata.tennisGame.core.score.IsAppliable;
import sg.kata.tennisGame.core.score.NormalScore;
import sg.kata.tennisGame.core.score.NullScore;
import sg.kata.tennisGame.core.score.Score;
import sg.kata.tennisGame.model.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.collections4.IterableUtils.find;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Represents a predicates IsAppliable {@link IsAppliable} test.
 * @author gabdel
 * @since 22/05/2018
 */
public class IsAppliableTest {

   
    @Test
    public void shouldBeNull() {
        assertNull(find(null, new IsAppliable()));
    }
    
    @Test
    public void shouldBeNullIfNotInitialized() {
        assertNull(find(new ArrayList<Score>(), new IsAppliable()));
    }
    
    @Test
    public void shouldBeNotNull() {
        assertNotNull(find(testScores(), new IsAppliable()).toString());
    }

   /**
    * test score list
    * @return test list 
    */
    private List<Score> testScores() {
        Player player1 = null;
		Player player2 = null;
		return asList(
                new NullScore(player1, player2),
                new NormalScore(player1, player2)
                );
    }

}
