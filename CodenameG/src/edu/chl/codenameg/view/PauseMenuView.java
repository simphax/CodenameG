package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class PauseMenuView {
	
	int selectedId = 0;
	
	public void setSelected(int id) {
		this.selectedId = id;
	}
	public int getSelected() {
		return this.selectedId;
	}
	
	public void repaint(Graphics g) {
		Color c;
		c = selectedId==0?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("START GAME", 200, 100);
		c = selectedId==1?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("SELECT LEVEL", 200, 150);
		c = selectedId==2?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("QUIT", 200, 200);
	}
}
