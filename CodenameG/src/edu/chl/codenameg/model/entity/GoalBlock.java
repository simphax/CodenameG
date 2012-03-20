package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;

public class GoalBlock extends Block{
	private Hitbox hb;
	private final Vector2D v = new Vector2D(0,0);
	private boolean colliding;
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			
		}
	}
}
