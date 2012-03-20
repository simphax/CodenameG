package edu.chl.codenameg.model.entity;

import java.awt.Point;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;


public class Block extends Entity{
	private Hitbox hb;
	private final Vector2D v = new Vector2D(0,0);
	private boolean colliding;
	
	public void setHitbox(Hitbox hb){
		this.hb = hb;
	}

	@Override
	public Hitbox getHitbox() {
		return new Hitbox(this.hb);
	}

	@Override
	public Vector2D getVector2D() {
		return v;
	}

	@Override
	public boolean isColliding() {
		return colliding;
	}
	
}
