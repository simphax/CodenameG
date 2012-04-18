package edu.chl.codenameg.controller;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

public class SlickGame extends BasicGame {
	
	GameController controller;

	public SlickGame(String title, GameController controller) {
		super(title);
		this.controller = controller;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		controller.render(g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int elapsedTime) throws SlickException {
		// TODO Auto-generated method stub
		controller.update(elapsedTime);
	}

}
