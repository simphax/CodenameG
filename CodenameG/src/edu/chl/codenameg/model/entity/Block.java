package edu.chl.codenameg.model.entity;

import java.awt.Position;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;


public class Block implements Entity{
	private Hitbox hb;
	private final Vector2D v = new Vector2D(0,0);
	private boolean colliding;
	private Position ps;
	
	public Block(){
		this(new Hitbox(1,1), new Position(2,2));
	}
	
	public Block(Hitbox hb,Position position){
		this.setPosition(position);
		this.hb = hb;
		this.colliding = false;
		
	}
	
	public void setHitbox(Hitbox hb){
		this.hb = hb;
	}

	public Hitbox getHitbox() {
		if(hb == null)
			return new Hitbox(0,0);
		else {
			return new Hitbox(this.hb);
		}
	}

	public Vector2D getVector2D() {
		return v;
	}

	public boolean isColliding() {
		return colliding;
	}

	public void collide(Entity e) {
		this.colliding = true;
		
	}
	
	public void setPosition(Position p) {
		this.ps=p;
		
	}

	public Position getPosition() {
		return new Position(this.ps);
	}

	public void update(int elapsedTime) {
		// TODO Auto-generated method stub
		
	}
}
