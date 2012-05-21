package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.World;

public class MovableBlockTest {

	@Test
	public void testCollide() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		MovableBlock mb = new MovableBlock();
		CollisionEvent evt = new CollisionEvent(pc,Direction.RIGHT);
		mb.collide(evt);
		pc.collide(evt);
		assertTrue(pc.isColliding() && mb.isColliding());
	}

	@Test
	public void testUpdate() {
		MovableBlock mb = new MovableBlock();
		mb.update();
		assertTrue(mb.getVector2D().getY() != 0);
	}

}
