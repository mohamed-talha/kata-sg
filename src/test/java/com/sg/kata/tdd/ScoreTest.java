package com.sg.kata.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.sg.kata.Score;

/**
 * Unit tests for Score class
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
class ScoreTest {

	static Score score = new Score();
	
    @Before
    public void scoreInit() {
    	score.init();
    }

    @Test
    public void incrementTest() {
    	score.increment();
        assertEquals(15, score.getValue());
		score.increment();
		assertEquals(30, score.getValue());
		score.increment();
		assertEquals(40, score.getValue());
		score.increment();
		assertEquals(40, score.getValue());
    }  

}
