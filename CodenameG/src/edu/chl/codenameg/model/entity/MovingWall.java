package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class MovingWall extends MovingBlock{
	private boolean lethal;
	private int travelTime;
	private Direction direction;
	
	
	public MovingWall(Position ps, Position endPos, int travelTime, boolean lethal){
		super(ps,endPos,travelTime);
		this.lethal = lethal;
		this.travelTime = travelTime;
		
		if(ps.getX()<endPos.getX()) {
			this.direction = Direction.RIGHT;
		} else if(ps.getX()>endPos.getX()) {
			this.direction = Direction.LEFT;
		} else if(ps.getY()<endPos.getY()) {
			this.direction = Direction.BOTTOM;
		} else if(ps.getY()>endPos.getY()) {
			this.direction = Direction.TOP;
		} else {
			this.direction = Direction.NONE;
		}

	}
	
	public MovingWall(){
		this(new Position(2.5f, 2.5f), new Position(7.5f,
				7.5f), 100,false);
	}
	
	public boolean isLethal(){
		return this.lethal;
	}
	
	public void toggleLethal(boolean l){
		this.lethal = l;
	}
	
	@Override
	public void collide(CollisionEvent evt){
		if(evt.getEntity().getType().equals("PlayerCharacter")){
			if(this.isLethal()){
				PlayerCharacter pc = (PlayerCharacter)evt.getEntity();
				pc.die();
			}else{
				super.collide(evt);
			}
		}
	}
	
	@Override
	public Vector2D calculateNextVector(Position pos, int currentTime, int steps) {
		return super.calculateNextVector(pos, currentTime, steps);
	}
	
	@Override
	public void update(int elapsedTime) {
		super.update(elapsedTime);
	}
	
	@Override
	public void setStartPosition(Position p){
		super.setStartPosition(p);
	}
	
	public int getTravelTime(){
		return this.travelTime;
	}
	public void setHitbox(Hitbox hb){
		super.setHitbox(hb);
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
