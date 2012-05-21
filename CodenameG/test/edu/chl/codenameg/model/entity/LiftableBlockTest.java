package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.World;

public class LiftableBlockTest {

	@Test
	public void testCollide() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		LiftableBlock lb = new LiftableBlock();
		CollisionEvent evt = new CollisionEvent(pc,Direction.RIGHT);
		lb.collide(evt);
		assertTrue(pc.isColliding() && lb.isColliding());
	}

//	@Test
//	public void testUpdateInt() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testUpdate() {
		LiftableBlock lb = new LiftableBlock();
		lb.update();
		assertTrue(lb.getVector2D().getY() != 0);
	}

	@Test
	public void testLiftableBlockPosition() {
		LiftableBlock lb = new LiftableBlock();
		lb.setVector2D(new Vector2D(2f, 2f));
		assertTrue(!lb.getPosition().equals(new Position(0, 0)));
	}

//	@Test
//	public void testLiftableBlockPositionHitbox() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLiftableBlock() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testLift() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		LiftableBlock lb = new LiftableBlock(new Position(pc.getHitbox().getWidth(), 0));
		pc.toggleLift();
		assertTrue(lb.isLifted() && pc.isLifting());
	}

	@Test
	public void testDrop() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		LiftableBlock lb = new LiftableBlock(new Position(pc.getHitbox().getWidth(), 0));
		pc.toggleLift();
		pc.unToggleLift();
		lb.update();
		lb.update();
		
		Boolean temp;
		// Tests if the block is moving in the right direction when dropped
		if (pc.getDirection() == Direction.RIGHT) {
			temp = (lb.getVector2D().getX() > 0) ? true : false;
		} else {
			temp = (lb.getVector2D().getX() < 0) ? true : false;
		}
		assertTrue(!lb.isLifted() && !pc.isLifting() && temp);
	}

}
