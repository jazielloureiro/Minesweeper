package com.jazielloureiro.minesweeper;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

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
		
		setRightClickEvent();
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
		icon = id;
		setIcon(new ImageIcon(getClass().getResource(id.getFilename(id))));
	}
	
	private void setButtonConfigs() {
		setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
	}
	
	private void setRightClickEvent() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					if(icon == IconId.UNOPENED)
						setIconById(IconId.FLAG);
					else if(icon == IconId.FLAG)
						setIconById(IconId.UNOPENED);
				}
			}
		});
	}
}