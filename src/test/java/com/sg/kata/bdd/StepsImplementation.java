package com.sg.kata.bdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import com.sg.kata.Game;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

/**
 * Functional test of the user story 1 of sprint 1
 * Setting up scenarios
 * 
 * @author Mohamed TALHA
 * @version 1.0
 *
 */
public class StepsImplementation implements En {
	
	private static Game game;
	private static String player1Name;
	private static String player2Name;
	private static String winner;
	private static List<Map<String, Integer>> scores;
	
	/**
	 * Constructor
	 */
	public StepsImplementation() {
		Given("^a game with two players (.*) and (.*)$", (String arg1, String arg2) -> {
			player1Name = arg1;
			player2Name = arg2;
			game = new Game(player1Name, player2Name);
			System.out.println(player1Name + " vs " + player2Name);
		});
		
		Given("^the following services scores$", (DataTable arg1) -> {
			scores = arg1.asMaps(String.class, Integer.class);
		});
		
		When("^the game is launched$", () -> {
			game.reset();
			for(int i=0; i<scores.size(); i++) {
				if (scores.get(i).get("Winner is the first player") == 1)
					game.play(1);
				else if (scores.get(i).get("Winner is the second player") == 1)
					game.play(2);
				System.out.println(scores.get(i).get("Winner is the first player") + " - " + scores.get(i).get("Winner is the second player"));
			}
			
			if (game.getWinner() == 1)
				winner = player1Name;
			else if (game.getWinner() == 2)
				winner = player2Name;			
		});

		Then("^the winner will be player (.*)$", (String arg1) -> {			
			assertThat(winner).isEqualTo(arg1);
		});		
	}
}
