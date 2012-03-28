package edu.chl.codenameg.model.entity;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;


public class MovableBlock extends Block{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter movingPlayer = (PlayerCharacter)e;
			if((movingPlayer.getPosition().getX()+ movingPlayer.getHitbox().getWidth() == this.getPosition().getX())|| ((movingPlayer.getPosition().getX()== this.getPosition().getX()+ this.getHitbox().getWidth()))){
				this.setVector2D(new Vector2D(movingPlayer.getVector2D().getX(), 0.0f));
			}
			
		}
	}
	public MovableBlock(Hitbox hb, Position ps){
		super(hb,ps);
	}
	
	public MovableBlock() {
		super();
	}
	public void update() {
		this.update(10);
	}
	public void update(int elapsedTime) {
		this.setVector2D( new Vector2D(0, 0));
	}
}

