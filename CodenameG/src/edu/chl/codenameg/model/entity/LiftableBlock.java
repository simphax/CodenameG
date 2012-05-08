package edu.chl.codenameg.model.entity;
import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class LiftableBlock extends MovableBlock{
	
	private PlayerCharacter pc;
	private Vector2D gravity;
	private Vector2D vector;
	private boolean onGround;
	private List<String> collideList = new ArrayList<String>();

	public void collide(CollisionEvent evt){
		super.collide(evt);

	}

	public LiftableBlock(Position ps){
		super(ps);
		this.collideList = new ArrayList<String>();
		this.collideList.add("Block");
		this.collideList.add("PlayerCharacter");
	}
	public LiftableBlock(Position ps, Hitbox hb){
		super(ps, hb);
		this.collideList = new ArrayList<String>();
		this.collideList.add("Block");
		this.collideList.add("PlayerCharacter");
	}
	
	public LiftableBlock() {
		super();
		this.collideList = new ArrayList<String>();
		this.collideList.add("Block");
		this.collideList.add("PlayerCharacter");
	}
	
	public String getType() {
		return "LiftableBlock";
	}
	
	public List<String> getCollideTypes() {
		List<String> list = new ArrayList<String>(this.collideList);
		return list;
	}
	
	public void update() {
		this.update(10);
	}
	
	@Override
	public void update(int elapsedTime) {
		if (pc != null){
			if (this.pc.getDirection()==Direction.RIGHT){
				this.setPosition(new Position((pc.getPosition().getX() + 5 + pc.getHitbox().getWidth()),(pc.getPosition().getY()+ pc.getHitbox().getHeight()-this.getHitbox().getHeight())));	
			}else{
				this.setPosition(new Position((pc.getPosition().getX() - 5 - this.getHitbox().getWidth()),(pc.getPosition().getY()+ pc.getHitbox().getHeight()-this.getHitbox().getHeight())));		
			}
			this.setVector2D(pc.getVector2D());
		}else{
			this.setVector2D( new Vector2D(0, 1));
		}
	}
	
	public void lift(PlayerCharacter pc) {
	this.pc = pc;
	this.collideList.remove("Block");
	this.collideList.remove("PlayerCharacter");
	}

	public void drop(PlayerCharacter pc) {
	this.pc = null;
	this.collideList.add("Block");
	this.collideList.add("PlayerCharacter");
	}
}
