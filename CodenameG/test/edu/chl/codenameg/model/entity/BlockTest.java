package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import org.junit.Test;

import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;


public class BlockTest {

	@Test
	public void testSetPosition() {
		Block block = new Block();
		Point point = new Point(10,20);
		block.setPosition(point);
		assertTrue(block.getPosition().equals(point));
	}
	@Test
	public void testSetHitbox(){
		Block block = new Block();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox(hb);
		assertTrue(block.getHitbox().equals(hb));
	}
	@Test
	public void testGetVector2D(){
		Block block = new Block();
		Vector2D v2d= new Vector2D(0,0);
		assertTrue(block.getVector2D().equals(v2d));
	}
	@Test
	public void testIsColliding(){
		Block block1 = new Block();
		Block block2 = new Block();
		Point p = new Point(10,20);
		block1.setPosition(p);
		block2.setPosition(p);
		block1.collide(block2);
		block2.collide(block1);
		assertTrue(block1.isColliding() && block2.isColliding());
	}
}
