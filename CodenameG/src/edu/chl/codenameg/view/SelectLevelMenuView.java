package edu.chl.codenameg.view;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** 
 * Represents "Select level"-menu graphics that changes according to the selected option.
 */
public class SelectLevelMenuView {
	private Image 	romijam;
	private Image 	background;
	private int 	selectedId;
	private Image	onePlayer;
	private Image	onePlayerSelected;
	private Image	twoPlayers;
	private Image	twoPlayersSelected;
	private Image	demo;
	private Image	demoSelected;
	
	public SelectLevelMenuView(){
		this.selectedId = 0;
		try {
			background = new Image("res/background.jpg");
			romijam = new Image("res/romijam.png");
			onePlayer = new Image("res/menu_one_player.png");
			onePlayerSelected = new Image("res/menu_one_player_selected.png");
			twoPlayers = new Image("res/menu_two_players.png");
			twoPlayersSelected = new Image("res/menu_two_players_selected.png");
			demo = new Image("res/menu_demo.png");
			demoSelected = new Image("res/menu_demo_selected.png");
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
		g.drawImage(romijam, 0, 20);
		Image img;
		
		img = selectedId == 0 ? onePlayerSelected : onePlayer;
		g.drawImage(img, 150, 150);
		
		img = selectedId == 1 ? twoPlayersSelected : twoPlayers;
		g.drawImage(img, 150, 270);
		
		img = selectedId == 2 ? demoSelected : demo;
		g.drawImage(img, 150, 370);
	}
}
