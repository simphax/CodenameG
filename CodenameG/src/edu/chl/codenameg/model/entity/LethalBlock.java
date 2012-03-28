package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;


public class LethalBlock extends Block{
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity() instanceof PlayerCharacter){
			PlayerCharacter deadPlayer = (PlayerCharacter)evt.getEntity();
			deadPlayer.die();
		}
	}
	public LethalBlock(Hitbox hb, Position ps){
		super(hb,ps);
	}
	
	public LethalBlock() {
		super();
	}
}
