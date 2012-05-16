package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class HitboxView implements EntityView {
	
	@Override
	public void render(Entity ent, Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int)(ent.getPosition().getX()+0.5), (int)(ent.getPosition().getY()+0.5), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
}
