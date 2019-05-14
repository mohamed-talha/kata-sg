package com.sg.kata;

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
public interface GameInterface {
	public void reset();
	public void play(int stepWinner);
	public String showScores();
	public void setWinner(int winner);
	public int getWinner();
	public Player getPlayer1();
	public Player getPlayer2();
}
