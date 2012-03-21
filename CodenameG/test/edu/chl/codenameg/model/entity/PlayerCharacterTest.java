package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;

public class PlayerCharacterTest {

	@Test
	public void testGetHitbox() {
		PlayerCharacter pc = new PlayerCharacter();
		Hitbox hb = pc.getHitbox();
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
	public void testMove() {
		PlayerCharacter pc = new PlayerCharacter();
		Point pos = pc.getPosition();
		pc.move();
		pc.update(10);
		Point newPos = pc.getPosition();
		assertTrue(pos.equals(newPos));
	}
		
	@Test
	public void testChangeDirection() {
		PlayerCharacter pc = new PlayerCharacter();
		Direction direction = pc.getDirection();
		pc.move();
		Direction secondDirection = pc.getDirection();
		assertTrue(!direction.equals(secondDirection));
	}
	
	public void testAcceleration() {
		PlayerCharacter pc = new PlayerCharacter();
		pc.move();
		pc.setAcceleration(5);
		Point[] pos = new Point[2];
		for (int i = 0; i<2; i++) {
			pc.update(10);
			pos[i] = pc.getPosition();
		}
		assertTrue((pos[1].getX()-pos[0].getX()) < (pos[2].getX()-pos[1].getX()));
	}
	
	@Test
	public void testJump() {
		PlayerCharacter pc = new PlayerCharacter();
		Double posY = pc.getPosition().getY();
		pc.jump();
		pc.update(10);
		Double secondPosY = pc.getPosition().getY();
		assertTrue(posY < secondPosY);
		
	}
	
	@Test
	public void testDeceleration() {
		//TODO incomplete test
	}
	
	@Test
	public void testWinGame(){
		PlayerCharacter anders = new PlayerCharacter();
		GoalBlock gb = new GoalBlock(new Hitbox(5,5),new Point(4,4));
		anders.collide(gb);
		gb.collide(anders);
		assertTrue(anders.hasWonGame());
	}
	
	@Test
	public void testDie(){
		PlayerCharacter berit = new PlayerCharacter();
		LethalBlock lb = new LethalBlock(new Hitbox(5,5),new Point(4,4));
		berit.collide(lb);
		lb.collide(berit);
		assertTrue(!berit.isAlive());
	}
}
