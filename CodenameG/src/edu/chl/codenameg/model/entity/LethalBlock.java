package edu.chl.codenameg.model.entity;

import java.awt.Point;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;


public class LethalBlock extends Block{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter deadPlayer = (PlayerCharacter)e;
			deadPlayer.die();
		}
	}
}
