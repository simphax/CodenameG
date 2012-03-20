package edu.chl.codenameg.model.entity;

import java.awt.Point;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;

public class PlayerCharacter extends Entity{
	private Hitbox hitbox;
	
	public PlayerCharacter() {
		hitbox = new Hitbox(5, 10);
	}
	
	public PlayerCharacter(Point position) {
		this();
		this.setPosition(position);
	}
	
	public void jump() {
		//TODO Complete this method
	}
	
	public void move() {
		//TODO Complete this method
	}

	@Override
	public Hitbox getHitbox() {
		return new Hitbox(hitbox);
	}

	@Override
	public Vector2D getVector2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isColliding() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void collide(Entity e) {
		// TODO Auto-generated method stub
		
	}
}