package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class LethalMovingBlock extends MovingBlock{
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity() instanceof PlayerCharacter){
			PlayerCharacter deadPlayer = (PlayerCharacter)evt.getEntity();
			deadPlayer.die();
		}
	}
	public LethalMovingBlock(Hitbox hb, Position ps, Position endPos, int travelTime){
		super(hb,ps,endPos,travelTime);
	}
	
	public LethalMovingBlock() {
		super();
	}

}
