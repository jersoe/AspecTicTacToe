package com.jersoe.aspectictactoe;
import java.util.Arrays;

public class Game {

	private int board[] = new int[9];
	private View v = new View();
	private int player = 1;
	private int winner;
	private boolean gameOver = false;

	public Game() {
		Arrays.fill(this.board, 0);
		this.v.showSplashScreen();
		this.run();
	}
	
	protected int[] getBoard() {
		return this.board;
	}
	
	protected void setGameOver(boolean gameOver) {
		this.gameOver=gameOver;
		this.v.drawBoard(board);
	}
	
	protected void setWinner(int winner) {
		this.winner=winner;
	}
	
	protected int getPlayer() {
		return this.player;
	}

	private void run() {
		while (!gameOver) {
			this.v.drawBoard(this.board);
			if (this.makeMove(this.v.getNextMove(player))) {
				if (this.player == 1) {
					this.player = 2;
				} else {
					this.player = 1;
				}
			} else {
				this.v.showIncorrectMove();
			}
		}
		this.v.showWinner(winner);
	}
	
	public void test() {
		System.out.println("test");
	}
	
	private boolean makeMove(String move) {

		int field = 0;

		switch (move.substring(0, 1).toUpperCase()) {
		case "A":
			break;
		case "B":
			field += 1;
			break;
		case "C":
			field += 2;
			break;
		default:
			return false;
		}

		try {
			switch (Integer.parseInt(move.substring(1, 2))) {
			case 1:
				break;
			case 2:
				field += 3;
				break;
			case 3:
				field += 6;
				break;
			default:
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}

		if (this.board[field] == 0) {
			this.board[field] = player;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
