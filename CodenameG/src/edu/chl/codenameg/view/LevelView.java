package edu.chl.codenameg.view;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.entity.BasicEntityView;
import edu.chl.codenameg.view.entity.PlayerCharacterView;

public class LevelView {
	
	private GameModel model;
	private Map<Entity,EntityView> entityMap;
	
	public LevelView(final GameModel model) {
		this.model = model;
		entityMap = new HashMap<Entity,EntityView>();
	}
	
	public void repaint(Graphics g) {
		
		for(Entity e : model.getWorld().getEntities()) {
			
			if(entityMap.containsKey(e)) {
				entityMap.get(e).render(e, g);
			} else {
				
				if(e instanceof PlayerCharacter) {
					EntityView view = new PlayerCharacterView();
					view.render(e, g);
					entityMap.put(e, view);
				} else {
					EntityView view = new BasicEntityView();
					view.render(e, g);
					entityMap.put(e, view);
				}
			}
			
		}
		
		//TODO Possible memory leak? Clear all unused mappings.
		
		
	}
	
}
