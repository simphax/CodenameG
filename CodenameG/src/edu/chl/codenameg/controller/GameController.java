package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.GameView;

public class GameController implements KeyListener, Runnable{
	
	private GameModel model;
	private GameView view;
	private List<PlayerCharacter> listOfPC;
	
	private boolean player1LeftKeyPressed, player1RightKeyPressed;
	private boolean player2LeftKeyPressed, player2RightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController() {
		this.model = new GameModel();
		this.view = new GameView(this.model);
		this.view.addKeyListener(this);
		
		listOfPC = new ArrayList<PlayerCharacter>();		
		
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
		
		
//		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
//			model.startGame();
//		}
//		
//		if(evt.getKeyCode() == KeyEvent.VK_LEFT) {
//			listOfPC.get(0).move(Direction.LEFT);
//			leftKeyPressed = true;
//		}
//		
//		else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
//			listOfPC.get(0).move(Direction.RIGHT);
//			rightKeyPressed = true;
//		}
//		
//		if(evt.getKeyCode() == KeyEvent.VK_UP) {
//			listOfPC.get(0).jump();
//		}
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
		
		
//		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
//			leftKeyPressed = false;
//			if(rightKeyPressed) {
//				listOfPC.get(0).move(Direction.RIGHT);
//			}
//		}
//		else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
//			rightKeyPressed = false;
//			if(leftKeyPressed) {
//				listOfPC.get(0).move(Direction.LEFT);
//			}
//		}
//		
//		if(!leftKeyPressed && !rightKeyPressed) {
//			listOfPC.get(0).stopMove();
//		}
//		
//		if(evt.getKeyCode() == KeyEvent.VK_UP) {
//			listOfPC.get(0).stopJump();
//		}
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
