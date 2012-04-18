package edu.chl.codenameg.view;


import org.newdawn.slick.*;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class MainView {
	
	GameView currentView;
	MenuView mv;
	LevelMenuView lmv;
	PauseMenuView pmv;
	
	public MainView(final GameModel model) {
		currentView = new GameView(model);
	}
	
	public void repaint(Graphics g) {
		currentView.repaint(g);
		
	}
	
	
	
}
