package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

/**
 * An Entity that represents a basic block
 * (a rectangle-shaped object)
 */
public class Block implements Entity{
	private Hitbox 		hb;
	private Vector2D 	v2d;
	private boolean 	colliding;
	private Position 	ps;
	
	public Block(){
		this(new Position(0,0));
	}
	
	public Block(Position position){
		this(position,new Hitbox(32,32));
	}
	
	public Block(Position position, Hitbox hitbox){
		this.setHitbox(hitbox);
		this.setPosition(position);
		this.colliding = false;
		this.v2d = new Vector2D(0,0);
	}
	
	@Override
	public Hitbox getHitbox() {
			return new Hitbox(hb);
	}
	
	public void setHitbox(Hitbox hb) {
		this.hb = new Hitbox(hb);
	}

	@Override
	public Vector2D getVector2D() {
		return new Vector2D(this.v2d);
	}

	@Override
	public boolean isColliding() {
		return colliding;
	}

	@Override
	public void collide(CollisionEvent evt) {
		this.colliding = true;
	}

	@Override
	public Position getPosition() {
		return new Position(this.ps);
	}

	@Override
	public void update(int elapsedTime) {
		this.colliding = false;
	}

	@Override
	public void setPosition(Position p) {
		this.ps=p;
	}

	public void setVector2D(Vector2D v2d) {
		this.v2d=v2d;
	}

	@Override
	public List<String> getCollideTypes() {
		return new ArrayList<String>();
	}

	@Override
	public String getType() {
		return "Block";
	}

	/**
	 * Adds a two dimensional vector to this object's vector
	 * @param a Vector2D-object
	 */
	public void addVector2D(Vector2D v2d) {
		this.v2d.add(v2d);
	}
}
