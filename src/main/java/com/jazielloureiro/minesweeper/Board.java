package com.jazielloureiro.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Square[][] board;
	private final int rows, cols, bombs;

	public Board(int rows, int cols, int bombs) {
		this.rows = rows;
		this.cols = cols;
		this.bombs = bombs;
		
		initBoard();
		
		setPanelConfigs();
	}
	
	private void initBoard() {
		board = new Square[rows][cols];
		boolean[][] bombPlaces = getBombPlaces();
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				board[i][j] = new Square(bombPlaces[i][j], i, j);
	}
	
	private boolean[][] getBombPlaces() {
		boolean[][] places = new boolean[rows][cols];
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				places[i][j] = false;
		
		Random random = new Random();
		for(int i = 0; i < bombs; ) {
			int row = random.nextInt(rows);
			int col = random.nextInt(cols);
			
			if(places[row][col] == false) {
				places[row][col] = true;
				i++;
			}
		}
		
		return places;
	}
	
	private void setPanelConfigs() {
		setLayout(new GridLayout(rows, cols));
		
		setPreferredSize(new Dimension(
			board[0][0].getIcon().getIconWidth() * rows,
			board[0][0].getIcon().getIconHeight() * cols
		));
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				add(board[i][j]);
	}
}