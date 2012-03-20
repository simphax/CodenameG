package edu.chl.codenameg.model.entity;

import java.awt.Point;
import java.util.Vector;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;


public class Block extends Entity{
	private Hitbox hb;
	private static final Vector v = new Vector(0,0);
	
	public void setHitbox(Hitbox hb){
		this.hb = hb;
	}
	
}
