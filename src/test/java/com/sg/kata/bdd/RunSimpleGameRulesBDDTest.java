package com.sg.kata.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Functional test of the user story 1 of sprint 1
 * Test Runner
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/simple-game-rules.feature" })
public class RunSimpleGameRulesBDDTest {

}
