package com.jazielloureiro.minesweeper;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Square extends JButton {
	private final boolean bomb;
	private final int row, col;
	private IconId id;

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

	public int getCol() {
		return col;
	}
	
	public void setIconById(IconId id) {
		this.id = id;
		setIcon(new ImageIcon(getClass().getResource(id.getFilename(id))));
	}
	
	private void setButtonConfigs() {
		setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
	}
}