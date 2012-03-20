package edu.chl.codenameg.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;

public class GameController implements KeyListener, Runnable{
	
	GameModel model;
	GameView view;
	
	boolean isRunning = true;
	
	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		
		Thread gameThread = new Thread(this);
		
		gameThread.start();
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
			model.startGame();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		
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
