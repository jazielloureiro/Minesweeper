package com.jazielloureiro.minesweeper;

import javax.swing.JFrame;

public class Game extends JFrame {
	public Game(Board board) {
		add(board);
		pack();
		setTitle("Minesweeper");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}