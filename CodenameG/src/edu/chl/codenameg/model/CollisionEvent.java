package edu.chl.codenameg.model;

public class CollisionEvent {
	private Entity e;
	private Direction d;
	
	public CollisionEvent(Entity e, Direction d) {
		this.e = e;
		this.d = d;
	}
	
	public Entity getEntity() {
		return e;
	}
	
	public Direction getDirection() {
		return d;
	}
}
