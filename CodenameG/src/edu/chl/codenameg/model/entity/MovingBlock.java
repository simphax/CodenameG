package edu.chl.codenameg.model.entity;


import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class MovingBlock extends Block{
	private Vector2D v2d= new Vector2D(0,0);
	boolean moving = false;
	private int traveltime;
	private Position endPos;
	private Position startPos;
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter landedPlayer = (PlayerCharacter)e;
			landedPlayer.getVector2D().add(this.v2d);
		}
	}
	public MovingBlock(Hitbox hb,Position ps){
		super(hb,ps);
	}
	public Vector2D getVector2D(){
		return new Vector2D(this.v2d);
	}
}
