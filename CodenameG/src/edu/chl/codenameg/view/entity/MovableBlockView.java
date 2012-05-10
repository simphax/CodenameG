package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;

public class MovableBlockView extends BasicEntityView{
	private Image movableBlock = null;
	public MovableBlockView(){
		try {
			movableBlock = new Image("res/MoveableBlock.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void render(Entity ent, Graphics g) {
		g.drawImage(movableBlock, ent.getPosition().getX(), ent.getPosition().getY());
	}
}
