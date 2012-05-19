package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.CollisionEvent;
import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.World;

public class FallingBlockTest {

	@Test
	public void testCollide() {
		PlayerCharacter gnarp = new PlayerCharacter(new World());
		FallingBlock fb = new FallingBlock();
		CollisionEvent evt1 = new CollisionEvent(gnarp,Direction.BOTTOM);
		fb.collide(evt1);
		Vector2D v2d1 = new Vector2D(fb.getVector2D());
		CollisionEvent evt2 = new CollisionEvent(new MovableBlock(),Direction.TOP);
		fb.collide(evt2);
		Vector2D v2d2 = new Vector2D(fb.getVector2D());
		CollisionEvent evt3 = new CollisionEvent(gnarp,Direction.TOP);
		fb.collide(evt3);
		Vector2D v2d3 = new Vector2D(fb.getVector2D());
		assertTrue(v2d1.equals(new Vector2D(0,0)) && v2d2.equals(v2d1) && v2d3.equals(new Vector2D(0,2)));
		
		
	}



}
