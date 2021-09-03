package com.jazielloureiro.minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setBoardToPanel();
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
			board[0][0].getIcon().getIconWidth() * cols,
			board[0][0].getIcon().getIconHeight() * rows
		));
	}
	
	private void setBoardToPanel() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				add(board[i][j]);
				
				board[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						click((Square) ae.getSource());
					}
				});
			}
		}
	}
	
	private void click(Square sqr) {
		if(sqr.getIconId() != IconId.UNOPENED)
			return;
		else if(sqr.hasBomb())
			showAllBombs();
		else {
			int bombsNearSquare = countBombsNearSquare(sqr);
			
			sqr.setIconById(IconId.valueOf("NUMBER_" + bombsNearSquare));
			
			if(bombsNearSquare == 0)
				for(int i = sqr.getPrevRow(); i <= sqr.getNextRow(rows); i++)
					for(int j = sqr.getPrevCol(); j <= sqr.getNextCol(cols); j++)
						click(board[i][j]);
		}
	}
	
	private void showAllBombs() {
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				if(board[i][j].hasBomb())
					board[i][j].setIconById(IconId.BOMB);
	}
	
	private int countBombsNearSquare(Square sqr) {
		int bombsNearSquare = 0;
		
		for(int i = sqr.getPrevRow(); i <= sqr.getNextRow(rows); i++)
			for(int j = sqr.getPrevCol(); j <= sqr.getNextCol(cols); j++)
				if(board[i][j].hasBomb())
					bombsNearSquare++;
		
		return bombsNearSquare;
	}
}