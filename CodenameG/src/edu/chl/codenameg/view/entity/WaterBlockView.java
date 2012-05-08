package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class WaterBlockView implements EntityView{

	public WaterBlockView(){
		// DO NOTHING as the water is drawn seperately
	}
	@Override
	public void render(Entity ent, Graphics g) {
	}
}
