package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.SelectLevelMenuView;

/**
 * This is a MenuState that where you select the level
 * @author ???
 *
 */
public class SelectLevelMenuState extends BasicGameState {
	private SelectLevelMenuView view;
	private int selectedId = 0;
	
	public SelectLevelMenuState() {
		this.view = new SelectLevelMenuView();
	}

	/**
	 * Initializes nothing
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {}

	/**
	 * Repaints the view with the selected Graphics object
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		view.setSelected(selectedId);
		view.repaint(g);
	}

	/**
	 * Updates the menu to highlight the right choice and enters the correct state if chosen
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame game, int elapsedTime)
			throws SlickException {
		int amountOfLevels=3;

		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
		    game.enterState(1);
		}
		if(gc.getInput().isKeyPressed(Input.KEY_UP)) {
			// Enables the menu to continue scroll endlessly in both directions
			selectedId = (selectedId == 0) ? amountOfLevels-1 : (selectedId-1)%amountOfLevels;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			selectedId=(selectedId+1)%amountOfLevels;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			switch(selectedId) {
			case 0:
				this.selectLevel(game,1);
				game.enterState(3);
				break;
			case 1:
				this.selectLevel(game,2);
				game.enterState(3);
				break;
			case 2:
				this.selectLevel(game,3);
				game.enterState(3);
				break;
			}
		}
	}
	
	/**
	 * Selects the correct LevelState when the level is chosen
	 * @param game
	 * @param level
	 */
	public void selectLevel(StateBasedGame game, int level) {
		GameState gs = game.getState(3);
		if(gs instanceof LevelState) {
			LevelState ls = (LevelState)gs;
			ls.selectLevel(level);
		}
	}

	/**
	 * Returns this class's ID
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
