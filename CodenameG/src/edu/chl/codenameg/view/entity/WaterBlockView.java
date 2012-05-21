package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

/**
 * The water's view that sets the animations and graphics for the entity
 * **Basically empty since water is drawn in straight from Tiled
 */
public class WaterBlockView implements EntityView{

	public WaterBlockView() {} 
	
	@Override
	public void render(Entity ent, Graphics g) {}
}
