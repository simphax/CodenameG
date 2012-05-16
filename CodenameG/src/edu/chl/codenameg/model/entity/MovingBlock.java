package edu.chl.codenameg.model.entity;

import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.equations.Quad;
import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

// Remove comments and unused variable
public class MovingBlock extends Block {
	private boolean moving;  // Remove unused?
	private int travelTime;
	private Position endPos;
	private Position startPos;
	private int currentTime;
	private TweenEquation easing;

	public MovingBlock(Position ps, Position endPos, int travelTime) {
		super(ps);
		this.moving = false;
		this.currentTime = 0;
		this.setStartPosition(ps);
		this.endPos = endPos;
		this.setTravelTime(travelTime);
		this.easing = Quad.INOUT;
	}

	public MovingBlock() {
		this(new Position(2.5f, 2.5f), new Position(7.5f,
				7.5f), 100);
	}

	@Override
	public void collide(CollisionEvent evt) {
		super.collide(evt);
	}
	
	public void setStartPosition(Position p){
		this.startPos = p;
	}
	
	public void setTravelTime(int tt){
		this.travelTime = tt;
	}

	public Vector2D calculateNextVector(Position pos, int currentTime, int steps) {
		int time = currentTime + 10;
		int rounds = 0;

		while (time > this.travelTime) {
			time -= this.travelTime;
			rounds++;
		}

		time = rounds % 2 == 0 ? time : this.travelTime - time;

		float x = this.easing.compute(time, this.startPos.getX(),
				this.endPos.getX() - this.startPos.getX(), this.travelTime);
		float y = this.easing.compute(time, this.startPos.getY(),
				this.endPos.getY() - this.startPos.getY(), this.travelTime);

		if (steps == 0) {
			return new Vector2D(x - pos.getX(), y - pos.getY());
		} else {
			Position temp = new Position(x, y);
			return calculateNextVector(temp, steps - 1, currentTime + 10);
		}
	}

	@Override
	public void update(int elapsedTime) {
		// manager.update(elapsedTime);
		this.setVector2D(this.calculateNextVector(this.getPosition(), this.currentTime, 0));
		currentTime += elapsedTime;
	}
}