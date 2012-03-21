package edu.chl.codenameg.view.entity;

import java.awt.Color;
import java.awt.Graphics;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class BasicEntityView implements EntityView {

	@Override
	public void render(Entity ent, Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(ent.getPosition().x, ent.getPosition().y, ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
	}
	
}