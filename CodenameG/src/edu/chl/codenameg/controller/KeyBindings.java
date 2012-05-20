package edu.chl.codenameg.controller;

import org.newdawn.slick.Input;

import edu.chl.codenameg.model.Action;

/**
 * This binds different keys to "actions".
 * If you would like to change the controls of the game you only have
 * to change them here.
 * 
 * @author Mike Phoohad
 * 
 */
public class KeyBindings {

	/**
	 * 
	 * @param key
	 * @return an Action corresponding to the key
	 */
	public static Action getAction(int key) {
		switch (key) {
		case Input.KEY_ESCAPE:
			return Action.PAUSE_GAME;
		case Input.KEY_R:
			return Action.RESTART_GAME;
		case Input.KEY_ENTER:
			return Action.START_GAME;
		case Input.KEY_LEFT:
			return Action.PLAYER_1_MOVE_LEFT;
		case Input.KEY_RIGHT:
			return Action.PLAYER_1_MOVE_RIGHT;
		case Input.KEY_UP:
			return Action.PLAYER_1_JUMP;
		case Input.KEY_DOWN:
			return Action.PLAYER_1_TOGGLE_CROUCH;
		case Input.KEY_M:
			return Action.PLAYER_1_TOGGLE_CROUCH;
		case Input.KEY_A:
			return Action.PLAYER_2_MOVE_LEFT;
		case Input.KEY_L:
			return Action.PLAYER_1_TOGGLE_LIFT;
		case Input.KEY_D:
			return Action.PLAYER_2_MOVE_RIGHT;
		case Input.KEY_W:
			return Action.PLAYER_2_JUMP;
		case Input.KEY_S:
			return Action.PLAYER_2_TOGGLE_CROUCH;
		case Input.KEY_LSHIFT:
			return Action.PLAYER_2_TOGGLE_CROUCH;
		case Input.KEY_T:
			return Action.PLAYER_2_TOGGLE_LIFT;
		case Input.KEY_P:
			return Action.PAUSE_GAME;
		default:
			return Action.NO_ACTION;
		}
	}
}
