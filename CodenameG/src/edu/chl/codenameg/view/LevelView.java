package edu.chl.codenameg.view;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.FallingBlock;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalMovingBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.model.entity.MovingWall;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.model.entity.Water;
import edu.chl.codenameg.model.levels.LevelFactory;
import edu.chl.codenameg.sound.GMusic;
import edu.chl.codenameg.view.entity.FallingBlockView;
import edu.chl.codenameg.view.entity.GoalBlockView;
import edu.chl.codenameg.view.entity.LethalMovingBlockView;
import edu.chl.codenameg.view.entity.MovableBlockView;
import edu.chl.codenameg.view.entity.MovingBlockView;
import edu.chl.codenameg.view.entity.MovingWallView;
import edu.chl.codenameg.view.entity.PlayerCharacterView;
import edu.chl.codenameg.view.entity.WaterBlockView;

/**
 * This is the highest abstracted view which 
 * adds all the views for entities in the game
 * 
 * Basically is what you see in the level
 */
public class LevelView {
	private float		scaleX;
	private float		scaleY;
	private GameModel 	model;
	private Map<Entity, EntityView> entityMap;
	private TiledMap	tm;
	private Image		background;
	private GMusic		music;
	private boolean		musicStopped;
	
	public LevelView(final GameModel model) throws SlickException {
		this.model = model;
		entityMap = new HashMap<Entity, EntityView>();
		this.tm = new TiledMap(LevelFactory.getInstance().getLevelFilePath(model.getSelectedLevel()));
		this.music = new GMusic("res/sounds/music.wav");
		music.setLooping(true);
		music.setVolume(0.5f);
		musicStopped = true;
	}

	public void repaint(Graphics g) {
		
		if(!model.isRunning()) {
			musicStopped = true;
			music.pause();
		} else if(musicStopped) {
			musicStopped=false;
			music.resume();
		}
		
		try {
			background = new Image("res/backimg.jpg");
		} catch (SlickException e1) {
			e1.printStackTrace();
		}
		
		g.drawImage(background, 
				-200 -model.getWorld().getCamera().getX()/2,
				-200 -model.getWorld().getCamera().getY()/2);
		
		scaleY = 500f/model.getWorld().getCamera().getHeight();
		scaleX = 500f/model.getWorld().getCamera().getWidth();
		g.scale(scaleX,scaleY);
		g.translate(-model.getWorld().getCamera().getX(), 
					-model.getWorld().getCamera().getY());
		tm.render(0, 0);
		
		for (Entity e : model.getWorld().getEntities()) {
			if (entityMap.containsKey(e)) {
				entityMap.get(e).render(e, g);
			} else {
				if (e instanceof PlayerCharacter) {
				    	EntityView view = null;
				    	if(model.getWorld().getAmountOfPlayers() > 1 && e.equals(model.getPlayer(2))) {
				    	    view = new PlayerCharacterView(PlayerCharacterView.GREEN);
				    	} else {
				    	    view = new PlayerCharacterView(PlayerCharacterView.DEFAULT);
				    	}
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof MovingWall) {
					EntityView view = new MovingWallView();
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
				} else if (e instanceof MovingBlock) {
					EntityView view = new MovingBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof MovableBlock) {
					EntityView view = new MovableBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof FallingBlock) {
					EntityView view = new FallingBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				} else if (e instanceof Water) {
					EntityView view = new WaterBlockView();
					view.render(e, g);
					entityMap.put(e, view);
				}
			}
			
			//if debug
//			(new BasicEntityView()).render(e, g);
		}
		
		for (int i = 1; tm.getLayerCount() > i; i++) {
			tm.render(0, 0, i);
		}
		
		g.translate(model.getWorld().getCamera().getX(), model.getWorld().getCamera().getY());
		g.scale(1/scaleX, 1/scaleY);
	}
	// TODO Possible memory leak? Clear all unused mappings.
}
