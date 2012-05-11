package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.MenuView;
import edu.chl.codenameg.view.PauseMenuView;

public class PausedLevelState extends BasicGameState {
	
	PauseMenuView view;
	int selectedId = 0;
	LevelState levelState;
	
	public PausedLevelState(LevelState levelState) {
		this.view = new PauseMenuView();
		this.levelState = levelState;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		levelState.render(container, game, g);
		view.setSelected(selectedId);
		view.repaint(g);
		

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int elapsedTime)
			throws SlickException {
		
		levelState.update(container, game, elapsedTime);

		if(container.getInput().isKeyPressed(Input.KEY_UP)) {
			selectedId=(selectedId-1)%3;
		}
		if(container.getInput().isKeyPressed(Input.KEY_DOWN)) {
			selectedId=(selectedId+1)%3;
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_ENTER)){
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
		return 4;
	}

}
