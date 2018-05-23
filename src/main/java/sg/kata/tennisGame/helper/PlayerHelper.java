/**
 * 
 */
package sg.kata.tennisGame.helper;

import sg.kata.tennisGame.model.Player;

/**
 * Represents a PlayerHelper {@link PlayerHelper} entity
 * @author gabdel
 * @since 22/05/2018
 */
public final class PlayerHelper {
	
    /**
     * If a player wins point increments the game score value
     * @param player : player
     */
	public static void winsPoint(final Player player) {
		int gameScore = player.getGameScore();
		player.setGameScore(++gameScore);
	}
	
	/**
	 * Wining game declaration
     * If a player wins a game increments the game score value
     * @param player : player
     * @return the declaration of game wining
     */
	public static String winsGame(final Player player) {
		int setScore = player.getGameScore();
		player.setSetScore(setScore++);
		return player.getName() + " win the game";
	}

	/**
	 * Wining set declaration
	 * @param player : player 
     * @return the declaration of set wining
	 */
	public static String winsSet(final Player player) {
		return player.getName() + " win the set and the match";
	}
	/**
	 * has Won Against
	 * @param player player
	 * @param otherPlayer otherPlayer
	 * @return true if player is the winner or false if not
	 */
	public static Boolean hasWonAgainst(final Player player, final Player otherPlayer) {
        final Integer advantageOverOtherPlayer = player.getGameScore() - otherPlayer.getGameScore();
        return player.getGameScore() >= 4 && advantageOverOtherPlayer >= 2;
    }

	
	/**
	 * Check if the player is in advantage
	 * @param player player
	 * @param otherPlayer otherPlayer
	 * @return true if player is advantage else return false
	 */
    public static Boolean hasAdvantageOver(final Player player,final Player otherPlayer) {
        final Integer advantageOverOtherPlayer = player.getGameScore() - otherPlayer.getGameScore();
        return player.getGameScore() >= 4 && advantageOverOtherPlayer.equals(1);
    }
	
}
