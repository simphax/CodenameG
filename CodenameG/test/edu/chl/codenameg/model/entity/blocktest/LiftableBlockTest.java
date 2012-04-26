package edu.chl.codenameg.model.entity.blocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.entity.*;

public class LiftableBlockTest {

	@Test
	public void testLift() {
		PlayerCharacter pc = new PlayerCharacter();
		LiftableBlock lb = new LiftableBlock();
		lb.lift(pc);
		Vector2D v2d1 = new Vector2D(pc.getVector2D());
	
		
	}

	@Test
	public void testDrop() {
		fail("Not yet implemented");
	}

}
