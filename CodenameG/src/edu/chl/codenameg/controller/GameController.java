package edu.chl.codenameg.controller;


import org.newdawn.slick.*;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;
import edu.chl.codenameg.view.MainView;
import edu.chl.codenameg.view.TestView;

public class GameController implements KeyListener{
	
	private GameModel model;
	private MainView view;
	private AppGameContainer agc;
	
	private boolean player1LeftKeyPressed, player1RightKeyPressed;
	private boolean player2LeftKeyPressed, player2RightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController() {
		this.model = new GameModel();
		this.view = new MainView(this.model);
		
		//Thread gameThread = new Thread(this);
		
		try {
			agc = new AppGameContainer(new SlickGame("CodenameG", this),800,600,false);
			agc.start();
			agc.getInput().addKeyListener(this);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//gameThread.start();
		
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
	
	public void render(Graphics g) {
		view.repaint(g);
	}
	
	public void update(int elapsedTime, Input inp) {
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
}
