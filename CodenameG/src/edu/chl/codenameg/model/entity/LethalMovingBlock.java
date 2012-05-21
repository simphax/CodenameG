package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Position;

public class LethalMovingBlock extends MovingBlock{
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity().getType().equals("PlayerCharacter")){
			PlayerCharacter deadPlayer = (PlayerCharacter)evt.getEntity();
			deadPlayer.die();
		}
	}
	
	public LethalMovingBlock(Position ps, Position endPos, int travelTime){
		super(ps,endPos,travelTime);
	}
	
	public LethalMovingBlock() {
		super();
	}
	
	@Override
	public String getType(){
		return "LethalMovingBlock";
	}
}
