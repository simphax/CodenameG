package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class LethalMovingBlock extends MovingBlock{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter deadPlayer = (PlayerCharacter)e;
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
