package com.jersoe.aspectictactoe;

public aspect Referee {
	after(): execution (* *.makeMove(String)) {
		Game game = (Game) thisJoinPoint.getThis();

		// Check if there is a winner
		int[][] winningLines = 
			{ 		{ 0, 1, 2 }, 
					{ 3, 4, 5 }, 
					{ 6, 7, 8 }, 
					{ 0, 3, 6 },
					{ 1, 4, 7 }, 
					{ 2, 5, 8 }, 
					{ 0, 4, 8 },
					{ 2, 4, 6 } };

		boolean winningLineFound = false;
		for (int i = 0; i < winningLines.length; i++) {
			if (game.getBoard()[winningLines[i][0]] != 0
					&& game.getBoard()[winningLines[i][0]] == game.getBoard()[winningLines[i][1]]
					&& game.getBoard()[winningLines[i][1]] == game.getBoard()[winningLines[i][2]]) {
				winningLineFound = true;
			}
		}

		if (winningLineFound) {
			game.setWinner(game.getPlayer()); // The game was won after the player made a move.
			game.setGameOver(true);
		} else {

			// Check for no more moves
			boolean movesLeft = false;
			for (int x : game.getBoard()) {
				if (x == 0) {
					movesLeft = true;
					break;
				}
			}

			if (!movesLeft) {
				game.setWinner(0);
				game.setGameOver(true);
			}
		}

	}
}
