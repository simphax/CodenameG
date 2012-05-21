package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.World;

public class MovingWallTest {

	@Test
	public void testCollide() {
		MovingWall mw = new MovingWall();
		PlayerCharacter pc1 = new PlayerCharacter(new World());
		PlayerCharacter pc2 = new PlayerCharacter(new World());
		mw.setLethal(true);
		CollisionEvent evt1 = new CollisionEvent(pc1,Direction.LEFT);
		CollisionEvent evt2 = new CollisionEvent(pc2,Direction.LEFT);
		mw.collide(evt1);
		mw.setLethal(false);
		mw.collide(evt2);
		assertTrue(!pc1.isAlive() && pc2.isAlive());
	}
}
