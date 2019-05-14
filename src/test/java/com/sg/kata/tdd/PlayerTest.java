package com.sg.kata.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sg.kata.Player;

/**
 * Unit tests for Player class
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
class PlayerTest {
	
	static Player player = new Player("Player 1");

    @Test
    public void getNameTest() {
        assertEquals("Player 1", player.getName());        
    }

    @Test
    public void getScoreTest() {
        assertEquals(0, player.getScore().getValue());        
    }
    
}
