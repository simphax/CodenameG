package edu.chl.codenameg.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class World {

	@Test
	public void testSetMap() {
		World world = new World();
		BlockTest block = new BlockTest();
		world.add(block);
		assertTrue(world.getEntities().getLength() == 1);
	}
	
	@Test
	public void testEntityCollide() {
		World world = new World();
		BlockTest block = new BlockTest();
		world.add(block);
		assertTrue(world.getEntities().getLength() == 1);
	}	

}
