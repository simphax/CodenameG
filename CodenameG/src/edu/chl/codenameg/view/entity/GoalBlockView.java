package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.view.EntityView;

/**
 * The goal's view that sets the graphic for the entity
 */
public class GoalBlockView implements EntityView{
	private Animation 	spin;
	private SpriteSheet spriteSheet;
	
	public GoalBlockView(){
		this.spriteSheet = null;
		
		try {
			spriteSheet = new SpriteSheet("res/goal.png", 32, 32,Color.white);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		spin = new Animation();
		for (int i = 0; i < 6; i++) {
			spin.addFrame(spriteSheet.getSprite(0, i), 200);
		}
	}
	
	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof GoalBlock) {
			GoalBlock lb = (GoalBlock) ent;
			spin.draw(	lb.getPosition().getX(), 
						lb.getPosition().getY());
		}
	}
}
