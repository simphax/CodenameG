package edu.chl.codenameg.model;

import java.awt.Dimension;
import java.awt.Point;

public class Camera {
	private Point position;
	private Dimension size;

	
	public Camera() {
		position = new Point(0,0);
		size = new Dimension(1024, 768);
	}
	
	public Camera(Dimension size) {
		this();
		this.size = size;
	}
	
//	public Camera(Point position) {
//		this();
//		this.position = position;
//	}
//	
//	public Camera(Point position, Dimension size) {
//		this();
//		this.position = position;
//		this.size = size;
//	}
	
	public Point getPosition() {
		return position;
	}
	
	public Dimension getSize() {
		return size;
	}
	
	public void update() {
		int x = this.position.x;
		int y = this.position.y;
		int newX = x+1;
		
		this.position.move(newX, y);
	}
	
}
