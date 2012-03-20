package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;


public class BlockTest {

	@Test
	public void testSetPosition() {
		Block block = new Block();
		Point point = new Point(10,20);
		block.setPosition(point);
		assertTrue(block.getPosition().equals(point));
	}
	@Test
	public void testGetHitbox(){
		Block block = new Block();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox()
	}
}
