package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;
import edu.chl.codenameg.view.TestView;

public class GameController implements KeyListener, Runnable{
	
	private GameModel model;
	private TestView view;
	
	private boolean player1LeftKeyPressed, player1RightKeyPressed;
	private boolean player2LeftKeyPressed, player2RightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController() {
		this.model = new GameModel();
		this.view = new TestView(this.model);
		this.view.addKeyListener(this);		
		
		Thread gameThread = new Thread(this);
		
		gameThread.start();
		
		player1LeftKeyPressed = false; player1RightKeyPressed = false;
		player2LeftKeyPressed = false; player2RightKeyPressed = false;
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		Action action = KeyBindings.getAction(evt.getKeyCode());
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
	public void keyReleased(KeyEvent evt) {
		Action action = KeyBindings.getAction(evt.getKeyCode());
		switch (action) {
		case PLAYER_1_MOVE_LEFT:
			player1LeftKeyPressed = false;
			if (player1RightKeyPressed) {
				model.performAction(Action.PLAYER_1_MOVE_RIGHT);
			}
			model.stopAction(action);
			break;
		case PLAYER_1_MOVE_RIGHT:
			player1RightKeyPressed = false;
			if (player1LeftKeyPressed) {
				model.performAction(Action.PLAYER_1_MOVE_LEFT);
			}
			model.stopAction(action);
			break;
		case PLAYER_2_MOVE_LEFT:
			player2LeftKeyPressed = false;
			if (player2RightKeyPressed) {
				model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}
			model.stopAction(action);
			break;
		case PLAYER_2_MOVE_RIGHT:
			player2RightKeyPressed = false;
			if (player2RightKeyPressed) {
				model.performAction(Action.PLAYER_2_MOVE_RIGHT);
			}
			model.stopAction(action);
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

	@Override
	public void keyTyped(KeyEvent evt) {}

	@Override
	public void run() {
		while (this.isRunning) {
				model.update(10);
				view.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// if we get this exception, we're asked to terminate ourselves
					this.isRunning = false;
				}
		}
	}
}
