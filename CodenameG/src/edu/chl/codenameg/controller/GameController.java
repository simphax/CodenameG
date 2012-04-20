package edu.chl.codenameg.controller;


import org.newdawn.slick.*;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;
import edu.chl.codenameg.view.LevelView;
import edu.chl.codenameg.view.MainView;
import edu.chl.codenameg.view.TestView;

public class GameController implements Game, KeyListener, InputListener{
	
	private GameModel model;
	private GameView view;
	private AppGameContainer agc;
	
	private boolean player1LeftKeyPressed, player1RightKeyPressed;
	private boolean player2LeftKeyPressed, player2RightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController( GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		
		player1LeftKeyPressed = false; player1RightKeyPressed = false;
		player2LeftKeyPressed = false; player2RightKeyPressed = false;
	}

	@Override
	public void keyPressed(int key, char c) {
		
		System.out.println(key);
		
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
	public void render(GameContainer gc, Graphics g) throws SlickException {
		view.repaint(g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(GameContainer gc, int elapsedTime) throws SlickException {
		model.update(elapsedTime);
		
	}
/*
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
	}*/

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		System.out.println("setInput");
	}

	@Override
	public boolean closeRequested() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getTitle() {
		return "CodenameG";
	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}


}
