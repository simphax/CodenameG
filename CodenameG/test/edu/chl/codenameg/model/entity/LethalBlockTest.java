package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.World;

public class LethalBlockTest {

	@Test
	public void testCollide() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		LethalBlock lb = new LethalBlock();
		CollisionEvent evt = new CollisionEvent(pc,Direction.RIGHT);
		lb.collide(evt);
		assertTrue(!pc.isAlive());
	}

	
}
