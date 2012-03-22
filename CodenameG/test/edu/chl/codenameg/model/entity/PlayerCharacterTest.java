package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

public class PlayerCharacterTest {

	@Test
	public void testGetHitbox() {
		PlayerCharacter pc = new PlayerCharacter();
		Hitbox hb = pc.getHitbox();
		assertTrue(hb.equals(new Hitbox(10,15)));
	}
	
	@Test
	public void testGetPosition() {
		PlayerCharacter pc = new PlayerCharacter();
		Position pos = pc.getPosition();
		assertTrue(pos.equals(new Position(0.0,0.0)));
	}
	
	@Test
	public void testSpawnAtPosition() {
		PlayerCharacter pc = new PlayerCharacter(new Position(25.0,25.0));
		Position pos = pc.getPosition();
		assertTrue(pos.equals(new Position(25.0,25.0)));
	}
	
	@Test
	public void testMove() {
		PlayerCharacter pc = new PlayerCharacter();
		Position pos = pc.getPosition();
		pc.move();
		pc.update(10);
		Position newPos = pc.getPosition();
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
	@Test
	public void testAcceleration() {
		PlayerCharacter pc = new PlayerCharacter();
		pc.move();
		pc.setAcceleration(5);
		Position[] pos = new Position[2];
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
		GoalBlock gb = new GoalBlock(new Hitbox(5,5),new Position(4.0,4.0));
		anders.collide(gb);
		gb.collide(anders);
		assertTrue(anders.hasWonGame());
	}
	
	@Test
	public void testDie(){
		PlayerCharacter berit = new PlayerCharacter();
		LethalBlock lb = new LethalBlock(new Hitbox(5,5),new Position(4.0,4.0));
		berit.collide(lb);
		lb.collide(berit);
		assertTrue(!berit.isAlive());
	}
	@Test
	public void testMovingBlock(){
		MovingBlock mb = new MovingBlock(new Hitbox(70,10), new Position(2.0,2.0));
		PlayerCharacter chewbaka = new PlayerCharacter();
		chewbaka.collide(mb);
		mb.collide(chewbaka);
		chewbaka.setVector2D(new Vector2D(1.0,1.0));
		assertTrue((chewbaka.getVector2D().equals(new Vector2D(2.0,0.0))));
	}
}
