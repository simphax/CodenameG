package edu.chl.codenameg.model.entity;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.EntityTweenAccessor;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class MovingBlock extends Block {
	boolean moving = false;
	private int travelTime;
	private Position endPos;
	private Position startPos;
	private TweenManager manager = new TweenManager();

	@Override
	public void collide(CollisionEvent evt) {
		super.collide(evt);
		//TODO send friction to playercharacter
		if (evt.getEntity() instanceof PlayerCharacter) {
			PlayerCharacter landedPlayer = (PlayerCharacter) evt.getEntity();
			if(landedPlayer.getPosition().getY() + landedPlayer.getHitbox().getHeight() == this.getPosition().getY()) { //If player is on top.
				landedPlayer.addVector2D(new Vector2D(this.getVector2D().getX(),0));
			}
		}
	}

	public MovingBlock(Hitbox hb, Position ps, Position endPos, int travelTime) {
		super(hb, ps);
		this.startPos=ps;
		this.endPos = endPos;
		this.travelTime = travelTime;
		Tween.registerAccessor(MovingBlock.class, new EntityTweenAccessor());
		Tween.to(this, EntityTweenAccessor.POSITION_XY, this.travelTime)
				.target(endPos.getX(), endPos.getY()).repeat(-1, this.travelTime).start(manager);
		Tween.to(this, EntityTweenAccessor.POSITION_XY, this.travelTime)
		.target(ps.getX(), ps.getY()).repeat(-1, this.travelTime).delay(this.travelTime).start(manager);
		
	}

	public MovingBlock() {
		this(new Hitbox(20, 10), new Position(2.5f, 2.5f), new Position(7.5f,
				7.5f), 100);
	}

	public void update(int elapsedTime) {
		manager.update(elapsedTime);
	}

	// We can now create as many interpolations as we need !

}
