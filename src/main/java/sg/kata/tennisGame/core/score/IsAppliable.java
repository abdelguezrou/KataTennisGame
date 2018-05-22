package sg.kata.tennisGame.core.score;

import org.apache.commons.collections4.Predicate;

public class IsAppliable implements Predicate<Score> {

    public boolean evaluate(final Score score) {
        return score.isAppliable();
    }

}