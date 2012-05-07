package edu.chl.codenameg.controller;


import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameController extends StateBasedGame {
	
	public GameController() {
		super("CodenameG");
	}
	
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new MainMenuState());
		this.addState(new LevelState());
		this.addState(new SelectLevelMenuState());

	}
}
