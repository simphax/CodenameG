package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SelectLevelMenuView {
	private Image selectLevel;
	private Image background;
	int selectedId = 0;
	
	public void setSelected(int id) {
		this.selectedId = id;
	}
	public int getSelected() {
		return this.selectedId;
	}
	
	public void repaint(Graphics g) {
		try {
			background = new Image("res/backgroundherpderp.jpg");
			selectLevel = new Image("res/select_level.png");
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g.drawImage(background, 0,0);
		g.setColor(Color.green);
		g.drawImage(selectLevel, 150, 50);
		Color c;
		c = selectedId==0?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("Level 1", 200, 200);
		c = selectedId==1?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("Level 2", 200, 250);
		c = selectedId==2?Color.red:Color.blue;
		g.setColor(c);
		g.drawString("Level 3", 200, 300);
	}
}
