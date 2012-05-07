package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class SelectLevelMenuView {
	
	int selectedId = 0;
	
	public void setSelected(int id) {
		this.selectedId = id;
	}
	public int getSelected() {
		return this.selectedId;
	}
	
	public void repaint(Graphics g) {
		
		g.setColor(Color.green);
		g.drawString("SELECT LEVEL", 200, 100);
		Color c;
		c = selectedId==0?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("Level 1", 200, 150);
		c = selectedId==1?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("Level 2", 200, 200);
	}
}
