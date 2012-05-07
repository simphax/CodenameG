package edu.chl.codenameg.view.entity;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.*;
import edu.chl.codenameg.view.EntityView;

public class BasicEntityView implements EntityView {
	
	@Override
	public void render(Entity ent, Graphics g) {
		
		if (ent instanceof LethalBlock){
			g.setColor(Color.red);
		}else if(ent instanceof MovingBlock){
			//System.out.println("width: "+ent.getHitbox().getWidth()+ " height: "+ent.getHitbox().getHeight());
			g.setColor(Color.darkGray);
		}else if(ent instanceof MovableBlock){
			g.setColor(Color.green);
		}else{
			g.setColor(Color.blue);
		}
		g.drawRect(ent.getPosition().getX(), ent.getPosition().getY(), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
	
}
