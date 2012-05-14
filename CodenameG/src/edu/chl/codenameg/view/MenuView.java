package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MenuView {
	
	private int selectedId = 0;
	private Image background;
	private Image startGame;
	private Image selectLevel;
	private Image quit;
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
			startGame = new Image("res/start_game.png");
			quit = new Image("res/quit.png");
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g.drawImage(background,0,0);

		Color c;
		c = selectedId==0?Color.red:Color.blue;
		g.setColor(c);
		g.drawImage(startGame, 150, 100);
		c = selectedId==1?Color.red:Color.blue;
		g.setColor(c);
		g.drawImage(selectLevel, 150, 200);
		c = selectedId==2?Color.red:Color.blue;
		g.setColor(c);
		g.drawImage(quit, 150, 300);
	}
}
