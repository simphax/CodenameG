package edu.chl.codenameg.view;


import org.newdawn.slick.*;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class MainView {
	
	GameView gv;
	MenuView mv;
	LevelMenuView lmv;
	PauseMenuView pmv;
	
	public MainView(final GameModel model) {
		
		
		/*
		jf = new JFrame();
		jf.setSize(new Dimension(400,400));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.add(new Gameview(model));
		*/
	}
	
	public void repaint(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(100, 100, 100, 100);
		
		
	}
	
	
	
}
