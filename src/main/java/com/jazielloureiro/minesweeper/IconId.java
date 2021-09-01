package com.jazielloureiro.minesweeper;

public enum IconId {
	NUMBER_0,
	NUMBER_1,
	NUMBER_2,
	NUMBER_3,
	NUMBER_4,
	NUMBER_5,
	NUMBER_6,
	NUMBER_7,
	NUMBER_8,
	BOMB,
	FLAG,
	UNOPENED;
	
	public String getFilename(IconId id) {
		switch(id) {
			case NUMBER_0:
				return "/0.png";
			case NUMBER_1:
				return "/1.png";
			case NUMBER_2:
				return "/2.png";
			case NUMBER_3:
				return "/3.png";
			case NUMBER_4:
				return "/4.png";
			case NUMBER_5:
				return "/5.png";
			case NUMBER_6:
				return "/6.png";
			case NUMBER_7:
				return "/7.png";
			case NUMBER_8:
				return "/8.png";
			case BOMB:
				return "/bomb.png";
			case FLAG:
				return "/flagged.png";
			case UNOPENED:
				return "/unopened.png";
			default:
				return null;
		}
	}
}