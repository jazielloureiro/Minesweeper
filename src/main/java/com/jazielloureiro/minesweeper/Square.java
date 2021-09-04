package com.jazielloureiro.minesweeper;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Square extends JButton {
	private final boolean bomb;
	private final int row, col;
	private IconId icon;

	public Square(boolean bomb, int row, int col) {
		this.bomb = bomb;
		this.row = row;
		this.col = col;
		
		setIconById(IconId.UNOPENED);
		
		setButtonConfigs();
	}

	public boolean hasBomb() {
		return bomb;
	}

	public int getRow() {
		return row;
	}

	public int getPrevRow() {
		return row == 0? 0 : row - 1;
	}

	public int getNextRow(int maxRow) {
		return row + 1 == maxRow? row : row + 1;
	}

	public int getCol() {
		return col;
	}

	public int getPrevCol() {
		return col == 0? 0 : col - 1;
	}

	public int getNextCol(int maxCol) {
		return col + 1 == maxCol? col : col + 1;
	}

	public IconId getIconId() {
		return icon;
	}
	
	public void setIconById(IconId id) {
		icon = id;
		setIcon(new ImageIcon(getClass().getResource(id.getFilename(id))));
	}
	
	private void setButtonConfigs() {
		setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
	}
}