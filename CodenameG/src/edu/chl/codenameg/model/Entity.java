package edu.chl.codenameg.model;

import java.util.List;

/**
 * This interface specifies constitutes what an 
 * entity should be able to do
 * @author ???
 *
 */
public interface Entity {
	
	public void setPosition(Position p);
	
	public Position getPosition();
	
	public Hitbox getHitbox();
	
	public Vector2D getVector2D();

	public List<String> getCollideTypes();
	
	public String getType();
	
	public boolean isColliding();

	public void collide(CollisionEvent evt);
	
	public void update(int elapsedTime);
}

