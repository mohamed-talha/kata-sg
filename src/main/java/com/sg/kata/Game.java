package com.sg.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * manage a game :
 * 		reset
 * 		play a service (a game is a set of services)
 * 		show the final score (must be improved)
 * 		set a winner (is public because of tests)
 * 		get the winner of the game
 * 		get players
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
public class Game implements GameInterface {
	private Player player1;
	private Player player2;	
	private int winner;
	private List<int[]> scores;
	
	/**
	 * Constructor
	 * 
	 * @param name1 The name of the first player
	 * @param name2 The name of the second player
	 */
	public Game(String name1, String name2) {
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.reset();
	}

	/**
	 * initialize or reset the game
	 */
	public void reset() {		
		this.player1.getScore().init();		
		this.player2.getScore().init();
		this.winner = 0;
		this.scores = new ArrayList<int[]>();
		int[] startScore = {0, 0};
		scores.add(startScore);		
	}

	/**
	 * play a service (a game is a set of services)
	 * @param serviceWinner The winner of the current service
	 */
	public void play(int serviceWinner) {
		// by default, the winner is 0. If the value winner is 1 or 2, the game is already over
		if (this.winner == 1 || this.winner == 2)
			throw new RuntimeException("Game is Over !");

		// check the regularity of the argument
		if (serviceWinner != 1 && serviceWinner != 2)
			throw new IllegalArgumentException("the value of the winner of this step must be 1 or 2");

		if (serviceWinner == 1) {// if the winner is the first player
			if (this.player1.getScore().getValue() == 40) {
				this.setWinner(1);
			} else {
				this.player1.getScore().increment();
			}
		} else if (serviceWinner == 2) {// if the winner is the second player
			if (this.player2.getScore().getValue() == 40) {
				this.setWinner(2);
			} else {
				this.player2.getScore().increment();
			}
		}
		
		// update the score of the game
		int[] serviceScore = {this.player1.getScore().getValue(), this.player2.getScore().getValue()};
		this.scores.add(serviceScore);
	}

	/**
	 * show the current score of the game (from the beginning)
	 * @return The current score of the game
	 */
	public String showScores() {
		StringBuilder gameScore = new StringBuilder();		
		for (int[] serviceScore : scores) {
			gameScore.append(this.player1.getName() + " : " + serviceScore[0] + "\t-\t" + this.player2.getName() + " : " + serviceScore[1] + "\n");
		}
		return gameScore.toString();
	}

	/**
	 * set the winner (only for tests)
	 * @param winner The winner (1 or 2)
	 */
	public void setWinner(int winner) {
		if (winner != 1 && winner != 2)
			throw new IllegalArgumentException("the value of winner must be 1 or 2");

		this.winner = winner;
	}

	/**
	 * @return The winner of the game (if 0, there is no winner yet)
	 */
	public int getWinner() {
		return this.winner;
	}

	/**
	 * @return the first player
	 */
	public Player getPlayer1() {
		return this.player1;
	}
	
	/**
	 * @return the second player
	 */
	public Player getPlayer2() {
		return this.player2;
	}	
}