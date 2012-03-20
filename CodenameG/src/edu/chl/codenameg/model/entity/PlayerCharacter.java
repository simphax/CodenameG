package edu.chl.codenameg.model.entity;

import java.awt.Point;

import edu.chl.codenameg.model.Hitbox;

public class PlayerCharacter {
	private Point position;
	private Hitbox hitbox;
	
	public PlayerCharacter() {
		position = new Point(0,0);
		hitbox = new Hitbox(5, 10);
	}
	
	public Point getPosition() {
		return new Point(position);
	}
	
	public Hitbox getHitBox() {
		return new Hitbox(hitbox);
	}
}