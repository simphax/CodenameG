package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;

public class FallingBlockView extends BasicEntityView{

private Image fallingBlock;
	
	public FallingBlockView(){
		fallingBlock = null;
		
		try {
			fallingBlock = new Image("res/fallingBlock.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Entity ent, Graphics g) {
		g.drawImage(fallingBlock, ent.getPosition().getX(), ent.getPosition().getY());
	}
	
}
