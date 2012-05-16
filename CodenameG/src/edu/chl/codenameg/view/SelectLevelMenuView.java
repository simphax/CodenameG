package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
/** 
 * Class that represents a menue graphics
 * that changes according to selected options.
 */ 
public class SelectLevelMenuView {
	private Image 	selectLevel;
	private Image 	background;
	private int 	selectedId = 0;
	
	public SelectLevelMenuView(){
		try {
			background = new Image("res/background.jpg");
			selectLevel = new Image("res/select_level.png");
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public void setSelected(int id) {
		this.selectedId = id;
	}
	public int getSelected() {
		return this.selectedId;
	}
	
	public void repaint(Graphics g) {

		g.drawImage(background, 0,0);
		g.drawImage(selectLevel, 150, 50);
		Color c;
		c = selectedId==0?new Color(255,138,0):new Color(255,240,0);
		g.setColor(c);
		g.drawString("Level 1", 200, 200);
		c = selectedId==1?new Color(255,138,0):new Color(255,240,0);
		g.setColor(c);
		g.drawString("Level 2", 200, 250);
		c = selectedId==2?new Color(255,138,0):new Color(255,240,0);
		g.setColor(c);
		g.drawString("Level 3", 200, 300);
	}
}
