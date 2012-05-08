package edu.chl.codenameg.model;

public class Vector2D {
	private float x;
	private float y;
	
	public Vector2D(float x,float y){
		this.setX(x);
		this.setY(y);
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
	public void add(Vector2D v2d){
		this.setX(this.getX()+v2d.getX());
		this.setY(this.getY()+v2d.getY());
	}
	public void subtract(Vector2D v2d){
		this.x=this.getX()-v2d.getX();
		this.y=this.getY()-v2d.getY();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2D other = (Vector2D) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	public Vector2D(Vector2D v2d){
		this(v2d.getX(),v2d.getY());
	}

}
