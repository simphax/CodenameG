package edu.chl.codenameg.view;

import java.awt.Dimension;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class LevelView {
	
	private GameModel model;
	
	public LevelView(final GameModel model) {
		this.model = model;
	}
	
	public void repaint(Graphics g) {
		for(Entity e : model.getWorld().getEntities()) {
			//g.setClip((int)e.getPosition().getX(), (int)e.getPosition().getY(), Integer.MAX_VALUE, Integer.MAX_VALUE);
			(new BasicEntityView()).render(e,g);
		}
		
		
	}
	
}
