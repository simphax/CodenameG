package edu.chl.codenameg.model;

/**
 * This is an enum that lists all the actions that can be sent to the game's model
 * @author Mike Phoohad
 *
 */
public enum Action {
	START_GAME,
	RESTART_GAME,
	PLAYER_1_MOVE_LEFT,
	PLAYER_1_MOVE_RIGHT,
	PLAYER_1_JUMP,
	PLAYER_2_MOVE_RIGHT,
	PLAYER_2_MOVE_LEFT,
	PLAYER_2_JUMP,
	PLAYER_1_TOGGLE_CROUCH,
	PLAYER_2_TOGGLE_CROUCH,
	PLAYER_1_TOGGLE_LIFT,
	PLAYER_2_TOGGLE_LIFT,
	PAUSE_GAME,
	NO_ACTION,
}
