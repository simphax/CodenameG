package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.World;

public class CheckPoint implements Entity{
	private Position 	pos;
	private Hitbox 		hb;
	private boolean 	colliding;
	private World 		world;
	private int 		elapsedTime;
	private boolean 	used;
	

	public CheckPoint(Position p , Hitbox hb, World world){
		this.pos = p;
		this.hb = hb;
		this.world = world;
		this.used = false;
	}
	@Override
	public void setPosition(Position p) {
		this.pos = p;
	}

	@Override
	public Position getPosition() {
		return this.pos;
	}

	@Override
	public Hitbox getHitbox() {
		return this.hb;
	}

	@Override
	public Vector2D getVector2D() {
		return new Vector2D(0,0);
	}


	@Override
	public String getType() {
		return "CheckPoint";
	}

	@Override
	public boolean isColliding() {
		return this.colliding;
	}

	@Override
	public void collide(CollisionEvent evt) {
		PlayerCharacter pc;
		MovingWall mw;
		Position mwSave;
		if(evt.getEntity().getType().equals("PlayerCharacter") && !this.used){
			pc = (PlayerCharacter)evt.getEntity();
			pc.setStartPosition(new Position(this.pos.getX(),this.pos.getY()-pc.getHitbox().getHeight()));
			
			for(int i = 0 ; i < this.world.getEntities().size();i++){
				if(this.world.getEntities().get(i).getType().equals("MovingWall")){
					mw = (MovingWall) this.world.getEntities().get(i);
					mwSave = mw.getPosition();
					mw.setStartPosition(mwSave);
					int tt = mw.getTravelTime() - this.elapsedTime;
					mw.setTravelTime(tt);					
				}
			}//end movingWall checkpoint-loop.
			this.used = true;
		}
		
		
	}

	@Override
	public void update(int elapsedTime){
		this.elapsedTime += elapsedTime;
	}
	
	@Override
	public List<String> getCollideTypes() {
		return new ArrayList<String>();
	}
	
}
