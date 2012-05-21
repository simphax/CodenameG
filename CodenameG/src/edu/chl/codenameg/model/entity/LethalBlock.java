package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

/**
 * This is a block that kills a player if he touches it
 * @author ???
 *
 */
public class LethalBlock extends Block{
	
	/**
	 * Handles collision with this block
	 * 
	 * If a player touches it, he dies
	 */
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
