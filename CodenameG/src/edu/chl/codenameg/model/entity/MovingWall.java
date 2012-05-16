package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class MovingWall extends MovingBlock{
	private boolean lethal;
	private Position startPos;
	private int travelTime;
	
	public MovingWall(Position ps, Position endPos, int travelTime, boolean lethal){
		super(ps,endPos,travelTime);
		this.lethal = lethal;
		this.travelTime = travelTime;
	}
	public boolean isLethal(){
		return this.lethal;
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
}
