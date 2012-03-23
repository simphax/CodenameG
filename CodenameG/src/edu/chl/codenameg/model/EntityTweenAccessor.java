package edu.chl.codenameg.model;

import aurelienribon.tweenengine.TweenAccessor;

public class EntityTweenAccessor implements TweenAccessor<Entity> {

	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION_XY = 3;

	@Override
	public int getValues(Entity target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case POSITION_X:
			returnValues[0] = target.getPosition().getX();
			return 1;
		case POSITION_Y:
			returnValues[0] = target.getPosition().getY();
			return 1;
		case POSITION_XY:
			returnValues[0] = target.getPosition().getX();
			returnValues[1] = target.getPosition().getY();
			return 2;
		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(Entity target, int tweenType, float[] newValues) {
		switch (tweenType) {
		case POSITION_X:
			target.setPosition(new Position(newValues[0], target.getPosition()
					.getY()));
			break;
		case POSITION_Y:
			target.setPosition(new Position(target.getPosition().getX(),
					newValues[0]));
			break;
		case POSITION_XY:
			target.setVector2D(new Vector2D(newValues[0]
					- target.getPosition().getX(), newValues[1]
					- target.getPosition().getY()));
			break;
		default:
			assert false;
			break;
		}
	}
}