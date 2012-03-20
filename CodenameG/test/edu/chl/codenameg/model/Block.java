package edu.chl.codenameg.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Block {

	@Test
	public void testSetPosition() {
		Block block = new Block();
		Point point = new Point(10,20);
		block.setPosition(point);
		assertTrue(block.getPosition().equals(point));
	}

}
