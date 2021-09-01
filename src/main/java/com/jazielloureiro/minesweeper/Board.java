package com.jazielloureiro.minesweeper;

public class Board {
	private Square[][] board;

	public Board(int rows, int cols) {
		board = new Square[rows][cols];
	}
}