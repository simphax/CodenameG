package edu.chl.codenameg.model.entity;

import java.awt.Point;





public abstract class Entity {
	private Point pt;
	
	//methods to be tested
	public void setPosition(Point p){
		this.pt =p;
	}
	public Point getPosition(){
		return this.pt;
	}
}
