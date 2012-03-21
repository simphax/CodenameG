package edu.chl.codenameg.model.entity;

import java.awt.Point;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;

public class PlayerCharacter implements Entity{
	private final Hitbox hitbox = new Hitbox(5,10);
	private boolean gameWon;
	private Point pt;
	private Vector2D v2d;
	private boolean colliding;
	
	public PlayerCharacter() {
		gameWon = false;
		this.setPosition(new Point(0,0));
	}
	
	public PlayerCharacter(Point position) {
		this();
		this.setPosition(position);
	}
	
	public void jump() {
		//TODO Complete this method
	}
	
/*	public void move(new Direction d) {
		this.v2d = d;
	}*/


	public void collide(Entity e) {
		System.out.println("PlayerCharacter collided with a "+e.getClass().getCanonicalName());
	}
	public void update(int elapsedTime) {
		this.setPosition(new Point(this.getPosition().x,this.getPosition().y+1));
	}
	public boolean winGame(){
		this.gameWon=true;
		return this.gameWon;
	}

	//getters & setters
	public void setPosition(Point p) {
		this.pt=p;
		
	}
	public Point getPosition() {
		return new Point(this.pt);
	}

	public Hitbox getHitbox() {
		return new Hitbox(hitbox);
	}
	public Vector2D getVector2D() {
		return new Vector2D(this.v2d);
	}
	public boolean isColliding() {
		boolean temp = this.colliding;
		return temp;
	}
	public boolean isGameWon(){
		boolean temp = this.gameWon;
		return temp;
	}
}