package edu.chl.codenameg.model.entity;

import java.awt.Point;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;

public class PlayerCharacter implements Entity{
	private final Hitbox hitbox = new Hitbox(10,15);
	private boolean gameWon;
	private Point pt;
	private Vector2D v2d;
	private boolean colliding;
	private boolean alive;
	private Direction direction;
	private boolean moving;
	private int acc;
	
	public PlayerCharacter() {
		this(new Point(0,0));
	}
	
	public PlayerCharacter(Point position) {
		gameWon = false;
		this.alive = true;
		this.setPosition(position);
		this.v2d = new Vector2D(0,0);
		this.direction = Direction.RIGHT;
	}
	
	public void jump() {
		//TODO Complete this method
	}
	
	public void move() {
		this.moving = true;
	}
	public void move(Direction d) {
		this.setDirection(d);
		this.move();
	}
	
	public void setDirection(Direction d) {
		this.direction = d;
	}
	
	public void stopMove() {
		this.moving = false;
	}
	
	public Direction getDirection() {
		Direction temp = this.direction;
		return temp;
	}

	public void collide(Entity e) {
		this.colliding = true;
	}
	
	public void update() {
		this.update(10);
	}
	
	public void update(int elapsedTime) {
		if(this.direction == Direction.RIGHT && this.moving == true) {
			this.v2d = new Vector2D(1,0);
		} else if(this.direction == Direction.LEFT && this.moving == true) {
			this.v2d = new Vector2D(1,0);
		}
		this.v2d.add(new Vector2D(0,1));
		
		//Not colliding now
		this.colliding = false;
	}
	
	public void die(){
		this.alive=false;
	}
	
	public void winGame(){
		this.gameWon=true;
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
	
	public boolean isAlive(){
		boolean temp = this.alive;
		return temp;
	}

	public void setAcceleration(int a) {
		this.acc = a;
	}
	
	public int getAcceleration(){
		int temp = this.acc;
		return temp;
	}
}