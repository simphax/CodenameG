package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.MenuView;

public class MainMenuState extends BasicGameState {
	private MenuView	view;
	private int 		selectedId;
	
	public MainMenuState() {
		this.selectedId = 0;
		this.view = new MenuView();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		view.setSelected(selectedId);
		view.repaint(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int elapsedTime)
			throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_UP)) {
			selectedId=(selectedId-1)%3;
		}
		if(gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			selectedId=(selectedId+1)%3;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			switch(selectedId) {
			case 0:
				game.enterState(3);
				break;
			case 1:
				game.enterState(2);
				break;
			case 2:
				System.exit(0);
				break;
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}
}
