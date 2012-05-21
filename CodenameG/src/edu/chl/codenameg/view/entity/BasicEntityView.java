package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.view.EntityView;

/**
 * Draws rectangles around level entities for easier distinction
 * This is used mainly for testing the view
 */
public class BasicEntityView implements EntityView {
	
	@Override
	public void render(Entity ent, Graphics g) {
		
		if (ent instanceof LethalBlock){
			g.setColor(Color.red);
		}else if(ent instanceof MovingBlock){
			g.setColor(Color.darkGray);
		}else if(ent instanceof MovableBlock){
			g.setColor(Color.green);
		}else{
			g.setColor(Color.blue);
		}
		
		g.drawRect(ent.getPosition().getX(), ent.getPosition().getY(), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
	
}
