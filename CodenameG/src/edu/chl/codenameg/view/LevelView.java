package edu.chl.codenameg.view;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.LethalMovingBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.model.levels.LevelFactory;
import edu.chl.codenameg.view.entity.BasicEntityView;
import edu.chl.codenameg.view.entity.BlockView;
import edu.chl.codenameg.view.entity.GoalBlockView;
import edu.chl.codenameg.view.entity.HitboxView;
import edu.chl.codenameg.view.entity.LethalBlockView;
import edu.chl.codenameg.view.entity.LethalMovingBlockView;
import edu.chl.codenameg.view.entity.PlayerCharacterView;

public class LevelView {
	private GameModel model;
	private Map<Entity, EntityView> entityMap;
	private TiledMap tm;


	public LevelView(final GameModel model, TiledMap tm) {
		this.model = model;
		entityMap = new HashMap<Entity, EntityView>();
		this.tm = tm;
//		try {
//			tm = new TiledMap("levels/testlevel.tmx", "levels");
//		} catch (SlickException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void repaint(Graphics g) {
		g.setBackground(Color.white);
		g.setClip(0,0, model.getWorld().getCamera().getWidth(), model.getWorld().getCamera().getHeight());
		g.translate(-model.getWorld().getCamera().getX(), -model.getWorld().getCamera().getY());
		tm.render(0, 0);
		
		for (Entity e : model.getWorld().getEntities()) {
			if (entityMap.containsKey(e)) {
				entityMap.get(e).render(e, g);
			} else {

				if (e instanceof PlayerCharacter) {
					EntityView view = new PlayerCharacterView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof LethalMovingBlock) {
					EntityView view = new LethalMovingBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof GoalBlock) {
					EntityView view = new GoalBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} 
			}
			
			//if debug
			(new BasicEntityView()).render(e, g);

		}
	}
	// TODO Possible memory leak? Clear all unused mappings.

}
