package edu.chl.codenameg.model.entity.blocktest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class GoalBlockTest1 {

	@Test
	public void testSetPosition() {
		GoalBlock block = new GoalBlock();
		Position position = new Position(10,20);
		block.setPosition(position);
		assertTrue(block.getPosition().equals(position));
	}
	@Test
	public void testSetHitbox(){
		GoalBlock block = new GoalBlock();
		Hitbox hb = new Hitbox(1,1);
		block.setHitbox(hb);
		assertTrue(block.getHitbox().equals(hb));
	}
	@Test
	public void testGetVector2D(){
		GoalBlock block = new GoalBlock();
		Vector2D v2d= new Vector2D(0,0);
		assertTrue(block.getVector2D().equals(v2d));
	}
	@Test
	public void testPlayerCollide(){ // this is the distinction between other block implementations
		GoalBlock gb = new GoalBlock();
		PlayerCharacter pc = new PlayerCharacter();
		gb.collide(new CollisionEvent(pc,Direction.TOP));
		pc.collide(new CollisionEvent(gb,Direction.BOTTOM));
		assertTrue(gb.isColliding() && pc.isColliding() && pc.hasWonGame());
	}	
}
