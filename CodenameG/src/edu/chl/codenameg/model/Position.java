package edu.chl.codenameg.model;

public class Position {
	private	double x;
	private double y;
	
	public Position(){
		this(0.0,0.0);
	}
	public Position(double x, double y){
		this.setX(x);
		this.setY(y);
	}
	public Position(Position ps){
		this.setX(ps.getX());
		this.setY(ps.getY());
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
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
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
	
	
}
