package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.World;

public class PlayerCharacterTest {
	/*
	 * no Time to complete this test, due to constant updates to Playercharacter
	 */

	@Test
	public void testToggleCrouch() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		pc.toggleCrouch();
		assertTrue(pc.isCrouching()
				&& pc.getHitbox().equals(new Hitbox(pc.getHitbox().getWidth(), pc.getHitbox().getHeight() - 25))
				&& pc.getPosition().equals(new Position(pc.getPosition().getX(),pc.getPosition().getY()+25)));

	}

	@Test
	public void testUnToggleCrouch() {
		PlayerCharacter hulk = new PlayerCharacter(new World());
		hulk.toggleCrouch();
		hulk.update();
		float h1 = hulk.getHitbox().getHeight();
		float p1 = hulk.getPosition().getY();
		hulk.unToggleCrouch();
		hulk.update();
		float h2 = hulk.getHitbox().getHeight();
		float p2 = hulk.getPosition().getY();
		assertTrue(h2 > h1 && p2 < p1);
	}


	@Test
	public void testStopJump() {
		World w = new World();
		PlayerCharacter pc = new PlayerCharacter(new World());
		w.add(pc);
		pc.jump();
		pc.update(10);
		boolean case1 = pc.isJumping();
		pc.stopJump();
		pc.update(10);
		boolean case2 = pc.isJumping();
		assertTrue(case1 && !case2);
	}
/*
	@Test
	public void testCollide() {
		fail("Not yet implemented");
	}*/



	@Test
	public void testUpdate() {
		// the main thing to test here is if update resets the booleans properly
		World w = new World();
		PlayerCharacter pc = new PlayerCharacter(w);
		w.add(pc);
		w.update(10);
		boolean case1 = pc.isOnGround();
		
		pc.move(Direction.LEFT);
		w.update(10);
		boolean case2 = pc.getVector2D().getX() !=0;
		
		boolean case3 = pc.isColliding();
		boolean case4 = pc.isInWater();
		
		assertTrue(!case1 && case2 && !case3 && !case4);
		
	}


}
