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
