package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class SuperItemBlock extends Block {
	int random;
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity() instanceof PlayerCharacter){
			PlayerCharacter superPlayer = (PlayerCharacter)evt.getEntity();
			random = (int)(Math.random()*5);
			switch(random){
			case 1:
				superPlayer.jump();
				break;
			case 2:
				superPlayer.stopJump();
				break;
			}
		}
	}
	public SuperItemBlock(Position ps){
		super(ps);
	}
	
	public SuperItemBlock() {
		super();
		
	}
}
	
