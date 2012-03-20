package edu.chl.codenameg.controller;

import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.GameView;

public class GameController {
	
	GameModel model;
	GameView view;
	
	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}
	
	

}
