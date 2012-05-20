package edu.chl.codenameg.view;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** 
 * Class that represents a menu graphics
 * that changes according to selected options.
 */
public class PauseMenuView {
	private Image 	continueImg;
	private Image 	selectLevel;
	private Image 	mainMenu;
	private Image 	continueSelected;
	private Image 	selectLevelSelected;
	private Image 	mainMenuSelected;
	private int 	selectedId;
	
	public PauseMenuView(){
		this.selectedId = 0;
		
		try {
			selectLevel = new Image("res/menu_select_level.png");
			continueImg = new Image("res/menu_continue.png");
			mainMenu = new Image("res/menu_main_menu.png");
			selectLevelSelected = new Image("res/menu_select_level_selected.png");
			continueSelected = new Image("res/menu_continue_selected.png");
			mainMenuSelected = new Image("res/menu_main_menu_selected.png");
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
		Image img;
		img = selectedId==0?continueSelected:continueImg;
		g.drawImage(img, 150, 100);
		img = selectedId==1?selectLevelSelected:selectLevel;
		g.drawImage(img, 150, 170);
		img = selectedId==2?mainMenuSelected:mainMenu;
		g.drawImage(img, 150, 270);
	}
}
