package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class BasicEntity implements Entity {

	Position position;
	Hitbox hitbox;
	Vector2D vector;
	boolean colliding;
	
	public BasicEntity() {
		this(new Position(0,0),new Hitbox(32,32));
	}
	
	public BasicEntity(Position p, Hitbox hb) {
		this.position = p;
		this.hitbox = hb;
	}
	
	@Override
	public void setPosition(Position p) {
		// TODO Auto-generated method stub
		this.position = p;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return hitbox;
	}

	@Override
	public Vector2D getVector2D() {
		// TODO Auto-generated method stub
		return vector;
	}

	@Override
	public void setVector2D(Vector2D v2d) {
		this.vector = v2d;
	}

	@Override
	public void addVector2D(Vector2D v2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getCollideTypes() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("BasicEntity");
		list.add("Block");
		list.add("PlayerCharacter");
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "BasicEntity";
	}

	@Override
	public boolean isColliding() {
		// TODO Auto-generated method stub
		return colliding;
	}

	@Override
	public void collide(CollisionEvent evt) {
		// TODO Auto-generated method stub
		this.colliding = true;
	}

	@Override
	public void update(int elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
