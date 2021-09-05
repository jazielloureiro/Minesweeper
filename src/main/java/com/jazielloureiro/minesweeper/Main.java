package com.jazielloureiro.minesweeper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
	private JButton easyBtn, mediumBtn, hardBtn;
	
	public Main() {
		setLayout(new GridLayout(3, 1));
		setButtons();
		setSize(200, 200);
		setTitle("Minesweeper");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setButtons() {
		easyBtn = new JButton("Easy");
		easyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				createGame(new Board(8, 8, 10));
			}
		});
		add(easyBtn);
		
		mediumBtn = new JButton("Medium");
		mediumBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				createGame(new Board(16, 16, 40));
			}
		});
		add(mediumBtn);
		
		hardBtn = new JButton("Hard");
		hardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				createGame(new Board(16, 30, 99));
			}
		});
		add(hardBtn);
	}
	
	private void createGame(Board board) {
		Game game = new Game(board);
		game.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setVisible(false);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		new Main();
	}
}