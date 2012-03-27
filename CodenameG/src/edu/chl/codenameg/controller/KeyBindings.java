package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;

import edu.chl.codenameg.model.Action;

public class KeyBindings {
	
	public static Action getAction(int key) {
		switch (key) {
			case KeyEvent.VK_ENTER:
				return Action.START_GAME;
			case KeyEvent.VK_LEFT:
				return Action.PLAYER_1_MOVE_LEFT;
			case KeyEvent.VK_RIGHT:
				return Action.PLAYER_1_MOVE_RIGHT;
			case KeyEvent.VK_UP:
				return Action.PLAYER_1_JUMP;
			default:
				return null;
		}
	}
	
}
