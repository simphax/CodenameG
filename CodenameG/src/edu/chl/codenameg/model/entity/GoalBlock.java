package edu.chl.codenameg.model.entity;


import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class GoalBlock extends Block{
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity() instanceof PlayerCharacter){
			PlayerCharacter skilledPlayer = (PlayerCharacter)evt.getEntity();
			skilledPlayer.winGame();
		}
	}
	public GoalBlock(Hitbox hb, Position pt){
		super(hb,pt);
	}
	
	public GoalBlock() {
		super();
	}
	
	@Override
	public String getType() {
		return "GoalBlock";
	}
}
