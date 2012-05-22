package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;

public class WaterTest {

	@Test
	public void testCollide() {
		Water water = new Water();
		Block b = new Block();
		CollisionEvent ce = new CollisionEvent(b, Direction.TOP);
		water.collide(ce);
		assertTrue(water.isColliding());
	}

}
