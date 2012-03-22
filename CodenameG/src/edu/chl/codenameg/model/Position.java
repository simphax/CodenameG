package edu.chl.codenameg.model;

public class Position {
	private	float x;
	private float y;
	
	public Position(){
		this(0,0);
	}
	public Position(float x, float y){
		this.setX(x);
		this.setY(y);
	}
	public Position(Position ps){
		this.setX(ps.getX());
		this.setY(ps.getY());
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
	
}
