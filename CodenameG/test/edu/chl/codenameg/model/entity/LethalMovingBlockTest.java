package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.World;

public class LethalMovingBlockTest {

	@Test
	public void testCollide() {
		World pandora = new World();
		PlayerCharacter pc = new PlayerCharacter(pandora);
		LethalMovingBlock lb = new LethalMovingBlock();
		CollisionEvent evt = new CollisionEvent(pc,Direction.TOP);
		lb.collide(evt);
		assertTrue(pc.isAlive() == false);	
	}

}
