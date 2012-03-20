package edu.chl.codenameg.model;

import java.awt.Point;


public abstract class Entity {
	private Point pt;
	
	//methods to be tested
	public void setPosition(Point p){
		this.pt =p;
	}
	public Point getPosition(){
		return this.pt;
	}
	public abstract Hitbox getHitbox();
	
	public abstract Vector2D getVector2D();
	
	public abstract boolean isColliding();

	public abstract void collide(Entity e);
	
	public void update() {
		
	}
}

