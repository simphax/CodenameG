package edu.chl.codenameg.model;

import java.awt.Point;


public interface Entity {
	
	//methods to be tested
	public void setPosition(Point p);
	public Point getPosition();
	
	public Hitbox getHitbox();
	
	public Vector2D getVector2D();
	
	public boolean isColliding();

	public void collide(Entity e);
	
	public void update(int elapsedTime);
	
}

