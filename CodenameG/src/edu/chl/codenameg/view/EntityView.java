package edu.chl.codenameg.view;

import org.newdawn.slick.Graphics;

import edu.chl.codenameg.model.Entity;

/**
 * The interface for entities views
 */
public interface EntityView {
	public void render(Entity ent, Graphics g);
}
