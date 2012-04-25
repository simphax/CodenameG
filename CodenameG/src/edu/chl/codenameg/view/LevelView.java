package edu.chl.codenameg.view;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.*;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.LethalMovingBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.entity.BasicEntityView;
import edu.chl.codenameg.view.entity.BlockView;
import edu.chl.codenameg.view.entity.HitboxView;
import edu.chl.codenameg.view.entity.LethalBlockView;
import edu.chl.codenameg.view.entity.LethalMovingBlockView;
import edu.chl.codenameg.view.entity.PlayerCharacterView;

public class LevelView {

	private GameModel model;
	private Map<Entity, EntityView> entityMap;

	public LevelView(final GameModel model) {
		this.model = model;
		entityMap = new HashMap<Entity, EntityView>();
	}

	public void repaint(Graphics g) {

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
				} else if (e instanceof LethalBlock) {
					EntityView view = new LethalBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof Block) {
					EntityView view = new BlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else {
					EntityView view = new BasicEntityView();
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
