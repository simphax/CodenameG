package edu.chl.codenameg.model.entity;


import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class GoalBlock extends Block{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter skilledPlayer = (PlayerCharacter)e;
			skilledPlayer.winGame();
		}
	}
	public GoalBlock(Hitbox hb, Position pt){
		super(hb,pt);
	}
	
	public GoalBlock() {
		super();
	}
}
