package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import edu.chl.codenameg.model.Hitbox;

public class PlayerCharacterTest {

	@Test
	public void testGetHitbox() {
		PlayerCharacter pc = new PlayerCharacter();
		Hitbox hb = pc.getHitBox();
		assertTrue(hb.equals(new Hitbox(5,10)));
	}
	
	@Test
	public void testGetPosition() {
		PlayerCharacter pc = new PlayerCharacter();
		Point pos = pc.getPosition();
		assertTrue(pos.equals(new Point(0,0)));
	}
	
	@Test
	public void testSpawnAtPosition() {
		PlayerCharacter pc = new PlayerCharacter(new Point(25,25));
		Point pos = pc.getPosition();
		assertTrue(pos.equals(new Point(25,25)));
	}
	
	@Test
	public void testStartMoving() {
		PlayerCharacter pc = new PlayerCharacter();
		Point pos = pc.getPosition();
		pc.startMoving();
		update();
		Point secondPos = pc.getPosition();
		assertTrue(!pos.equals(secondPos));
	}
	
	@Test
	public void testChangeDirection() {
		PlayerCharacter pc = new PlayerCharacter();
		Direction direction = pc.getDirection();
		pc.changeDirection();
		Direction secondDirection = pc.getDirection();
		assertTrue(!direction.equals(secondDirection));
	}
	
	public void testAcceleration() {
		PlayerCharacter pc = new PlayerCharacter();
		pc.move();
		pc.setAccelerating();
		Point[] pos = new Point[2];
		for (int i = 0; i<2; i++) {
			update();
			pos[i] = pc.getPosition();
		}
		assertTrue((pos[1].getX()-pos[0].getX()) < (pos[2].getX()-pos[1].getX()));
	}
	
	@Test
	public void testJump() {
		PlayerCharacter pc = new PlayerCharacter();
		Double posY = pc.getPosition().getY();
		pc.jump();
		update();
		Double secondPosY = pc.getPosition().getY();
		assertTrue(posY < secondPosY);
		
	}
	
	@Test
	public void testDeceleration() {
		//TODO incomplete test
	}
}
