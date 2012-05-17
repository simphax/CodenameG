package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.World;

public class GoalBlockTest {

	@Test
	public void testCollide() {
		PlayerCharacter pc = new PlayerCharacter(new World());
		GoalBlock gb = new GoalBlock();
		CollisionEvent evt = new CollisionEvent(pc,Direction.RIGHT);
		gb.collide(evt);
		assertTrue(pc.hasWonGame());
		
	}

}
