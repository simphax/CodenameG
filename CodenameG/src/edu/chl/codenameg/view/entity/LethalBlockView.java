package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.view.EntityView;

public class LethalBlockView implements EntityView{
	private SpriteSheet spriteSheet;
	private Animation 	spin;
	
	public LethalBlockView(){
		spriteSheet = null;
		spin 		= null;
		
		try {
			spriteSheet = new SpriteSheet("res/Muncher.png", 32, 32,Color.white);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		spin = new Animation();
		for (int i = 0; i < 3; i++) {
			spin.addFrame(spriteSheet.getSprite(i, 0), 200);
		}
	}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof LethalBlock) {
			LethalBlock lb = (LethalBlock) ent;
			spin.draw(lb.getPosition().getX(), lb.getPosition().getY());
		}
	}
}
