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
		this.model.selectLevel(level);
		this.model.startGame();
	}

	/**
	 * Initiates the game model and adds the view
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		if(this.model == null) {
			this.model = new GameModel();
		}
		
		this.view = new LevelView(this.model);
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
		if(this.model.getSelectedLevel() != lastLevel) { // Slick can only init TiledMap on init()
			this.init(container, game);
			lastLevel=this.model.getSelectedLevel();
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			game.enterState(4);
		}
		
		this.model.update(elapsedTime);
		if(this.model.gameEnded()) {
		    game.enterState(2);
		}
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
		
		this.model.performAction(action);
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
				this.model.performAction(Action.PLAYER_1_MOVE_RIGHT);
			} else {
				this.model.stopAction(action);
			}
			break;
		case PLAYER_1_MOVE_RIGHT:
			player1RightKeyPressed = false;
			if (player1LeftKeyPressed) {
				this.model.performAction(Action.PLAYER_1_MOVE_LEFT);
			}else {
				this.model.stopAction(action);
			}
			break;
		case PLAYER_2_MOVE_LEFT:
			player2LeftKeyPressed = false;
			if (player2RightKeyPressed) {
				this.model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}else {
				this.model.stopAction(action);
			}
			break;
		case PLAYER_2_MOVE_RIGHT:
			player2RightKeyPressed = false;
			if (player2RightKeyPressed) {
				this.model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}else {
				this.model.stopAction(action);
			}
			break;
		default:
			this.model.stopAction(action);
			break;
		}
		
		// This fixes the player stopping if you for example pressed
		// down the left key before you release the right
		if (!player1LeftKeyPressed && !player1RightKeyPressed) {
			this.model.stopAction(Action.PLAYER_1_MOVE_LEFT);
		} else if (!player2LeftKeyPressed && !player2RightKeyPressed) {
			this.model.stopAction(Action.PLAYER_2_MOVE_LEFT);
		}
	}
}
