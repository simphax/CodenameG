package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;

public class MovingBlockView extends BasicEntityView{
	private Image movingBlock;
	
	public MovingBlockView(){
		movingBlock = null;
		
		try {
			movingBlock = new Image("res/th_marioblock.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Entity ent, Graphics g) {
		g.drawImage(movingBlock, ent.getPosition().getX(), ent.getPosition().getY());
	}
}
