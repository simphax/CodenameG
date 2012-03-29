package edu.chl.codenameg.model.entity.blocktest;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.PlayerCharacter;


public class BlockTest {

	@Test
	public void testSetPosition() {
		Block block = new Block();
		Position Position = new Position(10,20);
		block.setPosition(Position);
		assertTrue(block.getPosition().equals(Position));
	}
	@Test
	public void testSetHitbox(){
		Block block = new Block();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox(hb);
		assertTrue(block.getHitbox().equals(hb));
	}
	@Test
	public void testGetVector2D(){
		Block block = new Block();
		Vector2D v2d= new Vector2D(0,0);
		assertTrue(block.getVector2D().equals(v2d));
	}
	@Test
	public void testPlayerCollide(){ // this is the distinction between other block implementations
		Block b = new Block();
		PlayerCharacter pc = new PlayerCharacter();
		b.collide(new CollisionEvent(pc,Direction.TOP));
		pc.collide(new CollisionEvent(b,Direction.BOTTOM));
		assertTrue(b.isColliding() && pc.isColliding());
	}	
	//Blocks are meant to be static at this point, hence they will never collide due to fixed positions.
	/*@Test
	public void testIsColliding(){
		Block block1 = new Block();
		Block block2 = new Block();
		Position p = new Position(10,20);
		block1.setPosition(p);
		block2.setPosition(p);
		block1.collide(block2);
		block2.collide(block1);
		assertTrue(block1.isColliding() && block2.isColliding());*/
}
