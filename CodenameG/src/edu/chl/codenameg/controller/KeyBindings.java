package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.Direction;

public class KeyBindings {
	
	public static Action getAction(int key) {
		switch (key) {
			case KeyEvent.VK_R:
				return Action.RESTART_GAME;
			case KeyEvent.VK_ENTER:
				return Action.START_GAME;
			case KeyEvent.VK_LEFT:
				return Action.PLAYER_1_MOVE_LEFT;
			case KeyEvent.VK_RIGHT:
				return Action.PLAYER_1_MOVE_RIGHT;
			case KeyEvent.VK_UP:
				return Action.PLAYER_1_JUMP;
			case KeyEvent.VK_M:
				return Action.PLAYER_1_TOGGLE_CROUCH;
			case KeyEvent.VK_A:
				return Action.PLAYER_2_MOVE_LEFT;
			case KeyEvent.VK_D:
				return Action.PLAYER_2_MOVE_RIGHT;
			case KeyEvent.VK_W:
				return Action.PLAYER_2_JUMP;
			case KeyEvent.VK_C:
				return Action.PLAYER_2_TOGGLE_CROUCH;
			case KeyEvent.VK_P:
				return Action.PAUSE_GAME;
			case KeyEvent.VK_L:
				return Action.PLAYER_1_TOGGLE_LIFT;
			default:
				return Action.NO_ACTION;
		}
	}	
}
