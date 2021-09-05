package com.jazielloureiro.minesweeper;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.add(new Board(8, 8, 10));
		test.pack();
		test.setTitle("Minesweeper");
		test.setLocationRelativeTo(null);
		test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		test.setVisible(true);
	}
}