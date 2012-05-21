package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
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
	
	public LethalBlock(Position ps){
		super(ps);
	}
	
	public LethalBlock(Position ps, Hitbox hb){
		super(ps,hb);
	}
	
	public LethalBlock() {
		super();
	}
	
	@Override
	public String getType(){
		return "LethalBlock";
	}
}
