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
	private List<String> collideList = new ArrayList<String>();
	private boolean colliding;
	private boolean onGround;

	public LiftableBlock(Position ps){
		super(ps);
		this.collideList = new ArrayList<String>();
		addCompleteCollideList();
		this.colliding = false;
		this.onGround = false;
		
	}
	public LiftableBlock(Position ps, Hitbox hb){
		super(ps, hb);
		this.collideList = new ArrayList<String>();
		addCompleteCollideList();
		this.colliding = false;
		this.onGround = false;
	}
	
	public LiftableBlock() {
		super();
		this.collideList = new ArrayList<String>();
		addCompleteCollideList();
		this.colliding = false;
		this.onGround = false;
	}
	
	private void addCompleteCollideList() {
		this.collideList.add("MovableBlock");
		this.collideList.add("MovingBlock");
		this.collideList.add("Block");
		this.collideList.add("PlayerCharacter");
	}
	
	private void removeAllInCollideList() {
		for (int i = 0; this.collideList.size() > i; i++) {
			this.collideList.remove(0);
		}
	}
	
	public String getType() {
		return "LiftableBlock";
	}
	
	public List<String> getCollideTypes() {
		List<String> list = new ArrayList<String>(this.collideList);
		return list;
	}
	
	@Override
	public void collide(CollisionEvent evt) {
		this.colliding = true;
		if (this.getCollideTypes().contains(evt.getEntity().getType())
				&& (evt.getDirection().equals(Direction.BOTTOM))) {
			this.onGround = true;
		}
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
			this.addVector2D(new Vector2D(0, 0.1f));
		}
		
//		if (Math.abs(this.acceleration.getX()) < 0.1) {
//			this.acceleration.setX(0);
//		}

		if (this.onGround) {
			if (this.getVector2D().getX() < 0) {
//				DO SOMETHING WHEN LEFT
				this.addVector2D(new Vector2D(0.1f, 0));
			} else if (this.getVector2D().getX() > 0) {
//				DO SOMETHING WHEN RIGHT
				this.addVector2D(new Vector2D(-0.1f, 0));
			}
		}
		
		this.onGround = false;
		
	}
	
	public void lift(PlayerCharacter pc) {
	this.pc = pc;
	removeAllInCollideList();
	}

	public void drop(PlayerCharacter pc) {
	this.pc = null;
	addCompleteCollideList();
	}
}
