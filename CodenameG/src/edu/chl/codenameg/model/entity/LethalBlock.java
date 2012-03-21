package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;


public class LethalBlock extends Block{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter deadPlayer = (PlayerCharacter)e;
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
