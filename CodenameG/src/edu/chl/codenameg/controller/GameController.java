package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.GameView;

public class GameController implements KeyListener, Runnable{
	
	private GameModel model;
	private GameView view;
	private List<PlayerCharacter> listOfPC;
	
	private boolean leftKeyPressed, rightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController() {
		this.model = new GameModel();
		this.view = new GameView(this.model, this);
		
		listOfPC = new ArrayList<PlayerCharacter>();		
		
		Thread gameThread = new Thread(this);
		
		gameThread.start();
		
		leftKeyPressed = false; rightKeyPressed = false;
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		model.performAction(KeyBindings.getAction(evt.getKeyCode()));
		
		
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
		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			leftKeyPressed = false;
			if(rightKeyPressed) {
				listOfPC.get(0).move(Direction.RIGHT);
			}
		}
		else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightKeyPressed = false;
			if(leftKeyPressed) {
				listOfPC.get(0).move(Direction.LEFT);
			}
		}
		
		if(!leftKeyPressed && !rightKeyPressed) {
			listOfPC.get(0).stopMove();
		}
		
		if(evt.getKeyCode() == KeyEvent.VK_UP) {
			listOfPC.get(0).stopJump();
		}
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
