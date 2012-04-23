package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class BlockView implements EntityView{
	private Image standardBlock = null;
	public BlockView(){
		try {
			standardBlock = new Image("res/th_marioblock.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void render(Entity ent, Graphics g) {
		g.drawImage(standardBlock, ent.getPosition().getX(), ent.getPosition().getY());
	}


	
}
