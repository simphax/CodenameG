package edu.chl.codenameg.model;

public interface Entity {
	
	//methods to be tested
	public void setPosition(Position p);
	public Position getPosition();
	
	public Hitbox getHitbox();
	
	public Vector2D getVector2D();
	
	public boolean isColliding();

	public void collide(Entity e);
	
	public void update(int elapsedTime);

	
}

