package edu.chl.codenameg.view.entity;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.*;
import edu.chl.codenameg.view.EntityView;

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
		g.fillRect((int)(ent.getPosition().getX()+0.5), (int)(ent.getPosition().getY()+0.5), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
	
}
