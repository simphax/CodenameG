package edu.chl.codenameg.model;

import java.util.List;

public interface Entity {
	
	//methods to be tested
	public void setPosition(Position p);
	public Position getPosition();
	
	public Hitbox getHitbox();
	
	public Vector2D getVector2D();
	
	public void setVector2D(Vector2D v2d);

	public void addVector2D(Vector2D v2d);

	public List<String> getCollideTypes();
	
	public String getType();
	
	public boolean isColliding();

	public void collide(CollisionEvent evt);
	
	public void update(int elapsedTime);


	
}

