package edu.chl.codenameg.model;

public class Vector2D {
	private double x;
	private double y;
	
	public Vector2D(double x,double y){
		this.setX(x);
		this.setY(y);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2D other = (Vector2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Vector2D(Vector2D v2d){
		this(v2d.getX(),v2d.getY());
	}

}
