package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class FallingBlock extends Block{
	private Hitbox hb;
	private Vector2D v2d;
	private boolean colliding;
	private Position ps;
	private boolean onGround;
	
	public FallingBlock(){
		super(new Position(0,0));
	}
	
	public FallingBlock(Position position){
		super(position,new Hitbox(32,32));
	}
	public FallingBlock(Position position, Hitbox hitbox){
		this.setHitbox(hitbox);
		this.setPosition(position);
		this.colliding = false;
		this.v2d = new Vector2D(0,0);
	}


	public void collide(CollisionEvent evt) {
		this.colliding = true;
		if(evt.getEntity().getType().equals("PlayerCharacter") && evt.getDirection().equals(Direction.TOP)){
			this.addVector2D(new Vector2D(0,2));
		}	
		if (this.getCollideTypes().contains(evt.getEntity().getType())
				&& (evt.getDirection().equals(Direction.BOTTOM))) {
			this.onGround = true;
		}
		
	}

	@Override
	public void setPosition(Position p) {
		this.ps=p;
		
	}

	public void setVector2D(Vector2D v2d) {
		this.v2d=v2d;
	}

	@Override
	public List<String> getCollideTypes() {
		List<String> list= new ArrayList<String>();
		list.add("Block");
		list.add("PlayerCharacter");
		return list;
	}

	@Override
	public String getType() {
		return "FallingBlock";
	}


	public void addVector2D(Vector2D v2d) {
		this.v2d.add(v2d);
	}

}
