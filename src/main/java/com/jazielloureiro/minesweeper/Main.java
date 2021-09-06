package com.jazielloureiro.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		loadMenu();
	}
	
	private static void loadMenu() {
		int option = JOptionPane.showOptionDialog(
			null,
			"Select difficulty",
			"Minesweeper",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			new String[]{"Easy", "Medium", "Hard", "Custom"},
			null
		);
		
		switch(option) {
			case 0:
				createGame(new Board(8, 8, 10));
				break;
			case 1:
				createGame(new Board(16, 16, 40));
				break;
			case 2:
				createGame(new Board(16, 30, 99));
				break;
			case 3:
				CustomForm custom = new CustomForm();
				custom.okBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						custom.getInput();
						
						if(custom.isInputValid()) {
							int rows = custom.getRows(),
								cols = custom.getCols(),
								bombs = custom.getBombs();
							
							custom.dispose();
							createGame(new Board(rows, cols, bombs));
						}
					}
				});
				break;
		}
	}
	
	private static void createGame(Board board) {
		Game game = new Game(board);
		game.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				loadMenu();
			}
		});
	}
}