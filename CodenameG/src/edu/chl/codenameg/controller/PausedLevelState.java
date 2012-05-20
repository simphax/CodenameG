package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.PauseMenuView;

/**
 * This state represents the paused game menu
 * @author ???
 *
 */
public class PausedLevelState extends BasicGameState {
	private PauseMenuView 	view;
	private int 			selectedId;
	private LevelState 		levelState;
	
	public PausedLevelState(LevelState levelState) {
		this.selectedId = 0;
		this.view = new PauseMenuView();
		this.levelState = levelState;
	}

	/**
	 * Initializes nothing
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {}

	/**
	 * Repaints the view with the selected Graphics object
	 * Also highlights the selected menu-choice
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		levelState.render(container, game, g);
		view.setSelected(selectedId);
		view.repaint(g);
	}

	/**
	 * Updates the menu to highlight the right choice and enters the correct state if chosen
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int elapsedTime)
			throws SlickException {
		levelState.update(container, game, elapsedTime);

		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
		    game.enterState(3);
		}
		if(container.getInput().isKeyPressed(Input.KEY_UP)) {
			// Enables the menu to continue scroll endlessly in both directions
			selectedId = (selectedId == 0) ? 2 : (selectedId-1)%3;  
		}
		if(container.getInput().isKeyPressed(Input.KEY_DOWN)) {
			selectedId = (selectedId+1)%3;
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
			    	game.enterState(1);
				break;
			}
		}
	}

	/**
	 * Returns this class's ID
	 */
	@Override
	public int getID() {
		return 4;
	}
}
