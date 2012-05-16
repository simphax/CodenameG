package edu.chl.codenameg.model.entity;


import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class GoalBlock extends Block{
	
	@Override
	public void collide(CollisionEvent evt){
		super.collide(evt);
		if(evt.getEntity().getType().equals("PlayerCharacter")){
			PlayerCharacter skilledPlayer = (PlayerCharacter)evt.getEntity();
			skilledPlayer.winGame();
		}
	}
	public GoalBlock(Position pt){
		super(pt);
	}
	public GoalBlock(Position pt,Hitbox hb){
		super(pt,hb);
	}
	
	public GoalBlock() {
		super();
	}
	
	@Override
	public String getType() {
		return "GoalBlock";
	}
}
