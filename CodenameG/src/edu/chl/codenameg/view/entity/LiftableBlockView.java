package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;

public class LiftableBlockView extends BasicEntityView{
	private Image liftableBlock;
	
	public LiftableBlockView(){
		liftableBlock = null;
		
		try {
			liftableBlock = new Image("res/liftableBlock.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void render(Entity ent, Graphics g) {
		g.drawImage(liftableBlock, ent.getPosition().getX(), ent.getPosition().getY());
	}
}
