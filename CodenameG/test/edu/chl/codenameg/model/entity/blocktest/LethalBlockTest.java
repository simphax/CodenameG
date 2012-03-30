package edu.chl.codenameg.model.entity.blocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class LethalBlockTest {

	@Test
	public void testSetPosition() {
		LethalBlock block = new LethalBlock();
		Position Position = new Position(10,20);
		block.setPosition(Position);
		assertTrue(block.getPosition().equals(Position));
	}
	@Test
	public void testSetHitbox(){
		LethalBlock block = new LethalBlock();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox(hb);
		assertTrue(block.getHitbox().equals(hb));
	}
	@Test
	public void testGetVector2D(){
		LethalBlock block = new LethalBlock();
		Vector2D v2d= new Vector2D(0,0);
		assertTrue(block.getVector2D().equals(v2d));
	}
	
	@Test
	public void testPlayerCollide(){ // this is the distinction between other block implementations
		LethalBlock lb = new LethalBlock();
		PlayerCharacter pc = new PlayerCharacter();
		lb.collide(new CollisionEvent(pc,Direction.TOP));
		pc.collide(new CollisionEvent(lb,Direction.BOTTOM));
		assertTrue(lb.isColliding() && pc.isColliding() && !pc.isAlive());
	}	
}
