package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MenuView {
	
	private int selectedId = 0;
	private Image background;
	public void setSelected(int id) {
		this.selectedId = id;
	}
	
	private void menuView(){
	
	}
	
	public int getSelected() {
		return this.selectedId;
	}
	
	public void repaint(Graphics g) {
		try {
			background = new Image("res/backimgherp.jpg");
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g.drawImage(background,0,0);

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
