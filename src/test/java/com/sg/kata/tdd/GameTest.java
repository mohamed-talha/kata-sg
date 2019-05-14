package com.sg.kata.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sg.kata.Game;

/**
 * Unit tests for Game class
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
class GameTest {

	static Game game = new Game("Player 1", "Player 2");
	
    @Test
    public void setWinnerTestException() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> game.setWinner(4));
    }

    @Test
    public void setWinnerTest() {
    	game.setWinner(2);
    	assertEquals(2, game.getWinner());
}

    @Test
    public void playTestRuntimeException() {
    	game.setWinner(2);//game over (the winner is player 2)
    	Assertions.assertThrows(RuntimeException.class, () -> game.play(1));
    }

    @Test
    public void playTestIllegalArgumentException() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> game.play(0));
    }

    @Test
    public void playTestPlayer1() {
    	game.reset();
		game.play(1);
		assertEquals(15, game.getPlayer1().getScore().getValue());
		game.play(1);
		assertEquals(30, game.getPlayer1().getScore().getValue());
		game.play(1);
		assertEquals(40, game.getPlayer1().getScore().getValue());		
		assertEquals("Player 1 : 0	-	Player 2 : 0\nPlayer 1 : 15	-	Player 2 : 0\nPlayer 1 : 30	-	Player 2 : 0\nPlayer 1 : 40	-	Player 2 : 0\n", game.showScores());
    }

    @Test
    public void playTestPlayer2() {
    	game.reset();
		game.play(2);
		assertEquals(15, game.getPlayer2().getScore().getValue());
		game.play(2);
		assertEquals(30, game.getPlayer2().getScore().getValue());
		game.play(2);
		assertEquals(40, game.getPlayer2().getScore().getValue());
		assertEquals("Player 1 : 0	-	Player 2 : 0\nPlayer 1 : 0	-	Player 2 : 15\nPlayer 1 : 0	-	Player 2 : 30\nPlayer 1 : 0	-	Player 2 : 40\n", game.showScores());
    }

}
