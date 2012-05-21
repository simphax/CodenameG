package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

/**
 * This is a block that falls when you walk on it
 */
public class FallingBlock extends Block{
	private boolean 		colliding;
	private List<String> 	list;
	
	public FallingBlock(){
		this(new Position(0,0));
	}
	
	public FallingBlock(Position position){
		this(position,new Hitbox(32,32));
	}
	public FallingBlock(Position position, Hitbox hitbox){
		super(position,hitbox);
		list = new ArrayList<String>();
		list.add("Block");
		list.add("LethalBlock");
		list.add("MovingBlock");
		list.add("LethalMovingBlock");
		list.add("LiftableBlock");
		list.add(this.getType());
	}
	
	/**
	 * Handles collision with this block
	 * 
	 * Sets the block to fall if a player walks on it
	 */
	public void collide(CollisionEvent evt) {
		this.colliding = true;
		if(evt.getEntity().getType().equals("PlayerCharacter") && evt.getDirection().equals(Direction.TOP)){
			this.addVector2D(new Vector2D(0,2));
		}
		if (this.getCollideTypes().contains(evt.getEntity().getType())
				&& (evt.getDirection().equals(Direction.BOTTOM))) {
		}
	}

	@Override
	public void setPosition(Position p) {
		super.setPosition(p);
		
	}

	public void setVector2D(Vector2D v2d) {
		super.setVector2D(v2d);
	}

	@Override
	public List<String> getCollideTypes() {
		return this.list;
	}

	@Override
	public String getType() {
		return "FallingBlock";
	}


	public void addVector2D(Vector2D v2d) {
		super.addVector2D(v2d);
	}
	@Override
	public boolean isColliding(){
		return this.colliding;
	}
}
