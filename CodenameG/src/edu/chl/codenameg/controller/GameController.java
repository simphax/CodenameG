package edu.chl.codenameg.controller;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameController extends StateBasedGame {
	
	public GameController() {
		super("CodenameG");
	}
	
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new MainMenuState());
		LevelState levelState = new LevelState();
		this.addState(levelState);
		this.addState(new PausedLevelState(levelState));
		this.addState(new SelectLevelMenuState());
	}
}
