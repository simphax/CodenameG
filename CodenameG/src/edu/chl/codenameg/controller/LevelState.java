package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.LevelView;

/**
 * This is the GameState that is used to actually play the game.
 * 
 * @author ???
 */
public class LevelState extends BasicGameState {
	private LevelView 	view;
	private GameModel 	model;
	private boolean 	player1LeftKeyPressed;		// These booleans are used to correct a 
	private boolean 	player1RightKeyPressed;		// bug explained in the end of keyReleased
	private boolean 	player2LeftKeyPressed;		// |
	private boolean 	player2RightKeyPressed;		// v
	private int 		lastLevel;
	
	public LevelState() {
		lastLevel = 1;
		
		player1LeftKeyPressed 	= false; 
		player1RightKeyPressed 	= false;
		player2LeftKeyPressed 	= false; 
		player2RightKeyPressed 	= false;
	}
	
	public void selectLevel(int level) {
		model.selectLevel(level);
		model.startGame();
	}

	/**
	 * Initiates the game model and adds the view
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		if(model == null) {
			this.model = new GameModel();
		}
		
		this.view = new LevelView(model);
	}

	/**
	 * Repaints the view with the selected Graphics object
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		view.repaint(g);
	}

	/**
	 * This updates the model and also pauses the game
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int elapsedTime)
			throws SlickException {
		if(model.getSelectedLevel() != lastLevel) { // Slick can only init TiledMap on init()
			this.init(container, game);
			lastLevel=model.getSelectedLevel();
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			game.enterState(4);
		}
		
		model.update(elapsedTime);
	}

	/**
	 * Returns this state's ID
	 */
	@Override
	public int getID() {
		return 3;
	}
	
	/**
	 * If a key is pressed the corresponding action is sent to the model
	 */
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

	/**
	 * If a key is released the corresponding action is sent to the model
	 */
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
		
		// This fixes the player stopping if you for example pressed
		// down the left key before you release the right
		if (!player1LeftKeyPressed && !player1RightKeyPressed) {
			model.stopAction(Action.PLAYER_1_MOVE_LEFT);
		} else if (!player2LeftKeyPressed && !player2RightKeyPressed) {
			model.stopAction(Action.PLAYER_2_MOVE_LEFT);
		}
	}
}
