package edu.chl.codenameg.view;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** 
 * Represents menu graphics that changes according to the selected option.
 */
public class MenuView {
	private int 	selectedId = 0;
	private Image 	background;
	private Image 	startGame;
	private Image 	selectLevel;
	private Image 	quit;
	private Image 	romijam;
	private Image 	startGameSelected;
	private Image 	selectLevelSelected;
	private Image 	quitSelected;
	
	public MenuView(){
		try {
			romijam = 				new Image("res/romijam.png");
			background = 			new Image("res/background.jpg");
			selectLevel = 			new Image("res/menu_select_level.png");
			startGame =				new Image("res/menu_start_game.png");
			quit = 					new Image("res/menu_quit.png");
			selectLevelSelected = 	new Image("res/menu_select_level_selected.png");
			startGameSelected = 	new Image("res/menu_start_game_selected.png");
			quitSelected = 			new Image("res/menu_quit_selected.png");
		} catch (SlickException e1) {
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
		
		g.drawImage(background, 0, 0);
		g.drawImage(romijam, 0, 20);
		Image img;
		img = selectedId==0?startGameSelected:startGame;
		g.drawImage(img, 150, 150);
		img = selectedId==1?selectLevelSelected:selectLevel;
		g.drawImage(img, 150, 270);
		img = selectedId==2?quitSelected:quit;
		g.drawImage(img, 150, 370);
	}
}
