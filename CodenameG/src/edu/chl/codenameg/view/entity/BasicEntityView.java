package edu.chl.codenameg.view.entity;

import java.awt.Color;
import java.awt.Graphics;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class BasicEntityView implements EntityView {

	@Override
	public void render(Entity ent, Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)(ent.getPosition().getX()+0.5), (int)(ent.getPosition().getY()+0.5), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
	
}
