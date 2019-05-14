package com.sg.kata;

import java.util.stream.IntStream;

/**
 * a score has a value that can be incremented or reset
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
public class Score implements ScoreInterface {
	private int value;
	
	/**
	 * Constructor
	 */
	public Score() {
		this.init();
	}
	
	/**
	 * initialize or reset the score
	 */
	public void init() {
        	this.value = 0;
    }
	
	/**
	 * increment the score
	 */
	public void increment() {		
		int[] expectedValues = {0, 15, 30, 40};
		if (!IntStream.of(expectedValues).anyMatch(x -> x == this.value)) {
			throw new RuntimeException("score value not supported");
		}
    	if (this.value == 0 || this.value == 15) {
    		this.value += 15;
    	} else if (this.value == 30) {
    		this.value = 40;
    	}		
	}

	/**
	 *	@return the score value
	 */
	public int getValue() {
		return this.value;
	}
}
