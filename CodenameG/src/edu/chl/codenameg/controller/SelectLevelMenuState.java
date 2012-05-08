package edu.chl.codenameg.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.chl.codenameg.view.SelectLevelMenuView;

public class SelectLevelMenuState extends BasicGameState {
	
	SelectLevelMenuView view;
	int selectedId = 0;
	
	public SelectLevelMenuState() {
		this.view = new SelectLevelMenuView();
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
		int amountOfLevels=3;

		if(gc.getInput().isKeyPressed(Input.KEY_UP)) {
			selectedId=(selectedId-1)% amountOfLevels;
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
	
	public void selectLevel(StateBasedGame game,int level) {
		GameState gs = game.getState(3);
		if(gs instanceof LevelState) {
			LevelState ls = (LevelState)gs;
			ls.selectLevel(level);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
