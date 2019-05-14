package com.sg.kata;

/**
 * a player has a name and a score
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
public class Player implements PlayerInterface {
	private String name;
	private Score score;

	/**
	 * Constructor
	 * @param name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.score = new Score();
	}

	/**
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the current score of the player
	 */
	public Score getScore() {
		return this.score;
	}
}
