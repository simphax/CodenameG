package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;


public class Block implements Entity{
	private Hitbox hb;
	private Vector2D v2d;
	private boolean colliding;
	private Position ps;
	
	public Block(){
		this(new Hitbox(1,1), new Position(2,2));
	}
	
	public Block(Hitbox hb,Position position){
		this.setPosition(position);
		this.hb = hb;
		this.colliding = false;
		this.v2d = new Vector2D(0,0);
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
		return new Vector2D(this.v2d);
	}

	public boolean isColliding() {
		return colliding;
	}

	public void collide(Entity e) {
		this.colliding = true;
		
	}
	

	public Position getPosition() {
		return new Position(this.ps);
	}

	public void update(int elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(Position p) {
		this.ps=p;
		
	}

	@Override
	public void setVector2D(Vector2D v2d) {
		this.v2d=v2d;
	}
}
