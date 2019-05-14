package com.sg.kata;

/**
 * a score has a value that can be incremented or reset
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
public interface ScoreInterface {
	public void init();
	public void increment();
	public int getValue();
}
