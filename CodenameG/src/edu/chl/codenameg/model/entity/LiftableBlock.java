package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;

public class LiftableBlock extends Block{

	public void collide(CollisionEvent evt){
		super.collide(evt);
	}

	public LiftableBlock(Hitbox hb, Position ps){
		super(hb,ps);
	}
	
	public LiftableBlock() {
		super();
	}
	
	public String getType() {
		return "LiftableBlock";
	}
	
	public void update() {
		this.update(10);
	}
	
	public void update(int elapsedTime) {
	
	}

	public void lift(PlayerCharacter pc) {
	System.out.println("Lyfter");
	}

	public void drop(PlayerCharacter pc) {
	//this.setPosition(new Position(3,6));
	System.out.println("Släpper");
	}
}
