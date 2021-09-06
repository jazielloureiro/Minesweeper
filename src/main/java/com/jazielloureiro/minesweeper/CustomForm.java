package com.jazielloureiro.minesweeper;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomForm extends JFrame {
	public JButton okBtn = new JButton("Ok");
	private JTextField rowsField = new JTextField(3),
		colsField = new JTextField(3),
		bombsField = new JTextField(3);
	private int rows, cols, bombs;
	
	public CustomForm() {
		setLayout(new GridLayout(3, 1));
		setTitle("Minesweeper");
		addComponents();
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void addComponents() {
		add(new JLabel("Customize your game", SwingConstants.CENTER));
		
		JPanel inputPanel = new JPanel();
		inputPanel.add(new JLabel("Rows:"));
		inputPanel.add(rowsField);
		inputPanel.add(new JLabel("Columns:"));
		inputPanel.add(colsField);
		inputPanel.add(new JLabel("Bombs:"));
		inputPanel.add(bombsField);
		add(inputPanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(okBtn);
		add(btnPanel);
	}
	
	public void getInput() {
		rows = getIntFromField(rowsField);
		cols = getIntFromField(colsField);
		bombs = getIntFromField(bombsField);
		
		if(rows < 2 || cols < 2) {
			JOptionPane.showMessageDialog(
				null,
				"The board size must be at least 2 x 2.",
				"Minesweeper",
				JOptionPane.ERROR_MESSAGE
			);
		} else if(bombs < 1 || bombs >= rows * cols) {
			JOptionPane.showMessageDialog(
				null,
				"The quantity of bombs must be from 1 to " + (rows * cols - 1) + ".",
				"Minesweeper",
				JOptionPane.ERROR_MESSAGE
			);
		}
	}
	
	private int getIntFromField(JTextField field) {
		try {
			return Integer.parseInt(field.getText());
		} catch(NumberFormatException e) {
			return -1;
		}
	}
	
	public boolean isInputValid() {
		return rows >= 2 &&
			cols >= 2 &&
			bombs >= 1 &&
			bombs < rows * cols;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public int getBombs() {
		return bombs;
	}
}