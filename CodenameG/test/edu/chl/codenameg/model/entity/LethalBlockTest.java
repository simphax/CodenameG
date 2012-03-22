package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Vector2D;

public class LethalBlockTest {

	@Test
	public void testSetPosition() {
		LethalBlock block = new LethalBlock();
		Point point = new Point(10,20);
		block.setPosition(point);
		assertTrue(block.getPosition().equals(point));
	}
	@Test
	public void testSetHitbox(){
		LethalBlock block = new LethalBlock();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox(hb);
		assertTrue(block.getHitbox().equals(hb));
	}
	@Test
	public void testGetVector2D(){
		LethalBlock block = new LethalBlock();
		Vector2D v2d= new Vector2D(0,0);
		assertTrue(block.getVector2D().equals(v2d));
	}
	@Test
	public void testIsColliding(){
		LethalBlock block1 = new LethalBlock();
		LethalBlock block2 = new LethalBlock();
		Point p = new Point(10,20);
		block1.setPosition(p);
		block2.setPosition(p);
		block1.collide(block2);
		block2.collide(block1);
		assertTrue(block1.isColliding() && block2.isColliding());
	}
	
	@Test
	public void testPlayerDies(){
		Point pos = new Point(0,0);
		Hitbox hb = new Hitbox(5,5);
		LethalBlock block = new LethalBlock(hb, pos);
		PlayerCharacter pc = new PlayerCharacter(pos);
		block.collide(pc);
		pc.collide(block);
		assertTrue(!pc.isAlive());
	}
}