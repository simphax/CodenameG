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
		pc.collide(evt);
		assertTrue(pc.isColliding() && lb.isColliding());
	}

	@Test
	public void testUpdate() {
		LiftableBlock lb = new LiftableBlock();
		lb.update();
		assertTrue(lb.getVector2D().getY() != 0);
	}

	@Test
	public void testLiftableBlockPosition() {
		World world = new World();
		LiftableBlock lb = new LiftableBlock();
		world.add(lb);
		lb.setVector2D(new Vector2D(2f, 2f));
		lb.update();
		lb.update();
		assertTrue(!lb.getVector2D().equals(new Vector2D(0,0)));
	}

	@Test
	public void testLift() {
		World wrld = new World();
		PlayerCharacter pc = new PlayerCharacter(wrld);
		LiftableBlock lb = new LiftableBlock(new Position(pc.getHitbox().getWidth()+2, 5));
		wrld.add(pc);
		wrld.add(lb);
		pc.setDirection(Direction.RIGHT);
		pc.toggleLift();
		
		lb.update();
		pc.update();
		assertTrue(lb.isLifted() && pc.isLifting());
	}

	@Test
	public void testDrop() {
		World wrld = new World();
		PlayerCharacter pc = new PlayerCharacter(wrld);
		LiftableBlock lb = new LiftableBlock(new Position(pc.getHitbox().getWidth(), 0));
		wrld.add(pc);
		wrld.add(lb);
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
