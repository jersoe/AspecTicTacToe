package com.jersoe.aspectictactoe;
import java.util.Scanner;

public class View {
	private String playerChars[] = new String[] { " ", "X", "O" };

	public void showSplashScreen() {
		System.out.println("Welcome to AspecTicTacToe!");
	}

	public void showWinner(int winner) {
		if (winner == 0) {
			System.out.println("It's a draw!");
		} else {
			System.out.println("Player " + winner + " won!");
		}
	}

	public void drawBoard(int[] board) {
		System.out.println("    A   B   C");
		System.out.println("  *************");
		System.out.println(
				"1 * " + playerChars[board[0]] + " * " + playerChars[board[1]] + " * " + playerChars[board[2]] + " *");
		System.out.println("  *************");
		System.out.println(
				"2 * " + playerChars[board[3]] + " * " + playerChars[board[4]] + " * " + playerChars[board[5]] + " *");
		System.out.println("  *************");
		System.out.println(
				"3 * " + playerChars[board[6]] + " * " + playerChars[board[7]] + " * " + playerChars[board[8]] + " *");
		System.out.println("  *************");
	}

	public String getNextMove(int player) {
		System.out.println("It's player " + player + "'s turn. What is your next move (for example: B3) ?");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			return scanner.nextLine();
		}
	}

	public void showIncorrectMove() {
		System.out.println("That was not a valid move!");
	}
}
