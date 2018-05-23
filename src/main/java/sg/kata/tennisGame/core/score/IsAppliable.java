package sg.kata.tennisGame.core.score;

import org.apache.commons.collections4.Predicate;

public class IsAppliable implements Predicate<AScore> {

	/**
	 * evaluate Score
	 * @return true if score is appliable or false if else
	 */
    public boolean evaluate(final AScore score) {
        return score.isAppliable();
    }

}