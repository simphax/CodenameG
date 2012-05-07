package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.levels.LevelFactory;
import edu.chl.codenameg.view.LevelView;

public class LevelState extends BasicGameState {
	
	private LevelView view;
	private GameModel model;
	private boolean player1LeftKeyPressed, player1RightKeyPressed, player2LeftKeyPressed, player2RightKeyPressed;
	private int lastLevel = 1;
	
	public LevelState() {
		player1LeftKeyPressed = false; player1RightKeyPressed = false;
		player2LeftKeyPressed = false; player2RightKeyPressed = false;
	}
	
	public void selectLevel(int level) {
		model.selectLevel(level);		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		int level = 1;
		if(model != null) {
			level = model.getSelectedLevel();
		}

		TiledMap tm = new TiledMap(LevelFactory.getInstance().getLevelFilePath(level));
		LevelFactory.getInstance().setTiledMap(tm);
		
		System.out.println(LevelFactory.getInstance().getLevelFilePath(level));
		
		if(model == null) {
			this.model = new GameModel();
		}
		
		this.view = new LevelView(model,tm);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		view.repaint(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int elapsedTime)
			throws SlickException {
		if(model.getSelectedLevel() != lastLevel) { //Slick can only init TiledMap on init()
			this.init(container, game);
			lastLevel=model.getSelectedLevel();
		}
		
		model.update(elapsedTime);
		
	}

	@Override
	public int getID() {
		return 3;
	}
	
	@Override
	public void keyPressed(int key, char c) {
		
		Action action = KeyBindings.getAction(key);
		switch (action) {
		case PLAYER_1_MOVE_LEFT:
			player1LeftKeyPressed = true;
			break;
		case PLAYER_1_MOVE_RIGHT:
			player1RightKeyPressed = true;
			break;
		case PLAYER_2_MOVE_LEFT:
			player2LeftKeyPressed = true;
			break;
		case PLAYER_2_MOVE_RIGHT:
			player2RightKeyPressed = true;
			break;
		default:
			break;
		}
		model.performAction(action);
		
	}

	@Override
	public void keyReleased(int key, char c) {
		Action action = KeyBindings.getAction(key);
		switch (action) {
		case PLAYER_1_MOVE_LEFT:
			player1LeftKeyPressed = false;
			if (player1RightKeyPressed) {
				model.performAction(Action.PLAYER_1_MOVE_RIGHT);
			} else {
				model.stopAction(action);
			}
			break;
		case PLAYER_1_MOVE_RIGHT:
			player1RightKeyPressed = false;
			if (player1LeftKeyPressed) {
				model.performAction(Action.PLAYER_1_MOVE_LEFT);
			}else {
				model.stopAction(action);
			}
			break;
		case PLAYER_2_MOVE_LEFT:
			player2LeftKeyPressed = false;
			if (player2RightKeyPressed) {
				model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}else {
				model.stopAction(action);
			}
			break;
		case PLAYER_2_MOVE_RIGHT:
			player2RightKeyPressed = false;
			if (player2RightKeyPressed) {
				model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}else {
				model.stopAction(action);
			}
			break;
		default:
			model.stopAction(action);
			break;
		}
		
		// Doesn't matter if I send both stopActions or not
		if (!player1LeftKeyPressed && !player1RightKeyPressed) {
			model.stopAction(Action.PLAYER_1_MOVE_LEFT);
		} else if (!player2LeftKeyPressed && !player2RightKeyPressed) {
			model.stopAction(Action.PLAYER_2_MOVE_LEFT);
		}
		
	}

}
