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
	
	public GameController() {
		super("CodenameG");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new MainMenuState());
		this.addState(new LevelState());
	}

}
