package edu.chl.codenameg.model.entity;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
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
		assertTrue(pos.equals(new Position(0,0)));
	}
	
	@Test
	public void testSpawnAtPosition() {
		PlayerCharacter pc = new PlayerCharacter(new Position(25,25));
		Position pos = pc.getPosition();
		assertTrue(pos.equals(new Position(25,25)));
	}
	
	@Test
	public void testMove() {
		PlayerCharacter pc = new PlayerCharacter();
		Vector2D v2d1 = pc.getVector2D();
		pc.move(Direction.LEFT);
		pc.update(10);
		Vector2D v2d2 = pc.getVector2D();
		assertTrue(!v2d1.equals(v2d2));
	}
		
	@Test
	public void testChangeDirection() {
		PlayerCharacter pc = new PlayerCharacter();
		Direction direction = pc.getDirection();
		pc.setDirection(Direction.LEFT);
		Direction secondDirection = pc.getDirection();
		assertTrue(!direction.equals(secondDirection));
	}
	
	@Test
	public void testJump() {
		PlayerCharacter pc = new PlayerCharacter();
		pc.setVector2D(new Vector2D(0,0));
		pc.jump();
		pc.update();
		assertTrue(pc.getVector2D().getY() < 0 );
	}
	@Test
	public void testStopJump(){
		PlayerCharacter pc = new PlayerCharacter();
		pc.jump();
		pc.update();
		boolean jumped = pc.isJumping();
		pc.stopJump();
		pc.update();
		assertTrue(!jumped && pc.isJumping());
	}
	
	@Test
	public void testWinGame(){
		PlayerCharacter anders = new PlayerCharacter();
		GoalBlock gb = new GoalBlock(new Hitbox(5,5),new Position(4,4));
		anders.collide(new CollisionEvent(gb,Direction.BOTTOM));
		gb.collide(new CollisionEvent(anders,Direction.TOP));
		assertTrue(anders.hasWonGame());
	}
	@Test
	public void testToggleCrouch(){
		PlayerCharacter gimli = new PlayerCharacter();
		float h1 = gimli.getHitbox().getHeight();
		float p1 = gimli.getPosition().getY();
		gimli.toggleCrouch();
		gimli.update();
		float h2 = gimli.getHitbox().getHeight();
		float p2 = gimli.getPosition().getY();
		assertTrue(h1 > h2 && p1 < p2);
	}
	@Test
	public void testUnToggleCrouch(){
		PlayerCharacter hulk = new PlayerCharacter();
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
	public void testDie(){
		PlayerCharacter berit = new PlayerCharacter();
		LethalBlock lb = new LethalBlock(new Hitbox(5,5),new Position(4,4));
		berit.collide(new CollisionEvent(lb,Direction.LEFT));
		lb.collide(new CollisionEvent(berit,Direction.RIGHT));
		assertTrue(!berit.isAlive());
	}
	@Test
	public void testMoveAlongMovingBlock(){
		MovingBlock mb = new MovingBlock(new Hitbox(70,10), new Position(2,2),new Position(10,2),2000);
		PlayerCharacter chewbaka = new PlayerCharacter();
		chewbaka.setVector2D(new Vector2D(1,1));
		chewbaka.collide(new CollisionEvent(mb,Direction.BOTTOM));
		mb.collide(new CollisionEvent(chewbaka,Direction.TOP));
		mb.update(1500);
		chewbaka.update();
		chewbaka.update();
		float cx = chewbaka.getVector2D().getX() + mb.getVector2D().getX();
		float cy = chewbaka.getVector2D().getY() + mb.getVector2D().getY();
		
		System.out.println(chewbaka.getVector2D().getX() + "    " + chewbaka.getVector2D().getY());
		assertTrue((chewbaka.getVector2D().equals(new Vector2D(cx,cy))));
	}
	@Test
	public void testDieOnTwoCollides(){
		PlayerCharacter rocky = new PlayerCharacter();
		rocky.collide(new CollisionEvent(new Block(), Direction.LEFT));
		rocky.collide(new CollisionEvent(new Block(), Direction.RIGHT));
		rocky.update(10);
		assertTrue(!rocky.isAlive());
	}
}
