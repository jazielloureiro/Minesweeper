package com.jazielloureiro.minesweeper;

public class Square {
	private final boolean bomb;
	private final int row, col;

	public Square(boolean bomb, int row, int col) {
		this.bomb = bomb;
		this.row = row;
		this.col = col;
	}

	public boolean hasBomb() {
		return bomb;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}