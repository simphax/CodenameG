package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.MenuView;

public class MainMenuState extends BasicGameState {
	
	MenuView view;
	int selectedId = 0;
	
	public MainMenuState() {
		this.view = new MenuView();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		view.setSelected(selectedId);
		view.repaint(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int elapsedTime)
			throws SlickException {
		// TODO Auto-generated method stub

		if(gc.getInput().isKeyPressed(Input.KEY_UP)) {
			selectedId=(selectedId-1)%3;
		}
		if(gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			selectedId=(selectedId+1)%3;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && selectedId==0){
			game.enterState(2);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
