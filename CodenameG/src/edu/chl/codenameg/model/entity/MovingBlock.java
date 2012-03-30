package edu.chl.codenameg.model.entity;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;
import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
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
	private int currentTime = 0;
	private TweenEquation easing;

	public MovingBlock(Hitbox hb, Position ps, Position endPos, int travelTime) {
		super(hb, ps);
		this.startPos = ps;
		this.endPos = endPos;
		this.travelTime = travelTime;
		this.easing = Quad.INOUT;
		// Tween.registerAccessor(MovingBlock.class, new EntityTweenAccessor());
		// Tween.to(this, EntityTweenAccessor.POSITION_XY, this.travelTime)
		// .target(endPos.getX(), endPos.getY()).repeat(-1,
		// this.travelTime).start(manager);
		// Tween.to(this, EntityTweenAccessor.POSITION_XY, this.travelTime)
		// .target(ps.getX(), ps.getY()).repeat(-1,
		// this.travelTime).delay(this.travelTime).start(manager);

	}

	public MovingBlock() {
		this(new Hitbox(20, 10), new Position(2.5f, 2.5f), new Position(7.5f,
				7.5f), 100);
	}

	@Override
	public void collide(CollisionEvent evt) {
		super.collide(evt);
		// TODO send friction to playercharacter
		if (evt.getEntity() instanceof PlayerCharacter) {
			PlayerCharacter landedPlayer = (PlayerCharacter) evt.getEntity();
			if (evt.getDirection() == Direction.TOP) { // If player is on top.
				landedPlayer.addVector2D(new Vector2D(this.calculateNextVector(10).getX(), 0));				
			}
		}
	}

	public Vector2D calculateNextVector(int elapsedTime) {

		int time = this.currentTime + elapsedTime;
		int rounds = 0;

		while (time > this.travelTime) {
			time -= this.travelTime;
			rounds++;
		}
		
		time = rounds % 2 == 0 ? time : this.travelTime-time;

		float x = this.easing.compute(time, this.startPos.getX(),
				this.endPos.getX() - this.startPos.getX(), this.travelTime);
		float y = this.easing.compute(time, this.startPos.getY(),
				this.endPos.getY() - this.startPos.getY(), this.travelTime);
		return new Vector2D(x - this.getPosition().getX(), y
				- this.getPosition().getY());
	}

	public void update(int elapsedTime) {
		// manager.update(elapsedTime);
		this.setVector2D(this.calculateNextVector(elapsedTime));
		currentTime += elapsedTime;
	}

}