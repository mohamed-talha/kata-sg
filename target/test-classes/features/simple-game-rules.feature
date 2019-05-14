Feature: Simple Game Rules

# First Simple Scenario : the winner is player 1
Scenario: game won by player 1
	Given a game with two players P1 and P2
	And the following services scores
	| Winner is the first player | Winner is the second player |
	| 1 | 0 |
	| 0 | 1 |
	| 1 | 0 |
	| 1 | 0 |
	| 1 | 0 |
	When the game is launched
	Then the winner will be player P1

# Second Simple Scenario : the winner is player 2
Scenario: game won by player 2
	Given a game with two players P1 and P2
	And the following services scores
	| Winner is the first player | Winner is the second player |
	| 1 | 0 |
	| 1 | 0 |
	| 0 | 1 |
	| 1 | 0 |
	| 0 | 1 |
	| 0 | 1 |
	| 0 | 1 |
	When the game is launched
	Then the winner will be player P2
	