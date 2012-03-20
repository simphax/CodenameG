package edu.chl.codenameg.model;

import java.awt.Point;






public abstract class Entity {
	private Point pt;
	private Hitbox hb;
	private Vector v;
	
	//methods to be tested
	public void setPosition(Point p){
		this.pt =p;
	}
	public Point getPosition(){
		return this.pt;
	}
	public Hitbox getHitbox(){
		return new Hitbox(this.hb);
	}
	public Vector getVector(){
		return new 
	}
}
