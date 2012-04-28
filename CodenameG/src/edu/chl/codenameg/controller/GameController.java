package edu.chl.codenameg.controller;


import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.model.Action;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;
import edu.chl.codenameg.view.LevelView;
import edu.chl.codenameg.view.MainView;
import edu.chl.codenameg.view.TestView;

public class GameController extends StateBasedGame {
	
	private GameModel model;
	private GameView view;
	private AppGameContainer agc;
	
	private boolean player1LeftKeyPressed, player1RightKeyPressed;
	private boolean player2LeftKeyPressed, player2RightKeyPressed;
	
	
	private boolean isRunning = true;
	
	public GameController() {
		super("CodenameG");
		
//		this.model = model;
		//this.view = view;
		
		this.addState(new MainMenuState());
		this.addState(new LevelState());
		
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void render(GameContainer gc, Graphics g) throws SlickException {
//		view.repaint(g);
//	}
//
//	@Override
//	public void init(GameContainer gc) throws SlickException {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void update(GameContainer gc, int elapsedTime) throws SlickException {
//		model.update(elapsedTime);
//		
//	}



}
