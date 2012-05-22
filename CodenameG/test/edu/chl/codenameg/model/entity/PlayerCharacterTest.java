package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.World;

public class PlayerCharacterTest {

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
	public void testToggleLift() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnToggleLift() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopJump() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveDirection() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testCollide() {
		fail("Not yet implemented");
	}

	@Test
	public void testDie() {
		fail("Not yet implemented");
	}

	@Test
	public void testWinGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddVector2D() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInt() {
		fail("Not yet implemented");
	}

}
