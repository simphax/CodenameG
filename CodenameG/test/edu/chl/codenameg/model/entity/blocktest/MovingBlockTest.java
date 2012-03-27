package edu.chl.codenameg.model.entity.blocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class MovingBlockTest {

	@Test
	public void testGetVector2D() {
		MovingBlock mb = new MovingBlock();
		mb.setVector2D(new Vector2D(1,1));
		Vector2D v2d = new Vector2D(1,1);
		assertTrue(mb.getVector2D().equals(v2d));
	}

	@Test
	public void testCollide() {
		MovingBlock mb = new MovingBlock();
		PlayerCharacter pc = new PlayerCharacter();
		pc.setVector2D(new Vector2D(0,0));
		pc.collide(mb);
		mb.collide(pc);
		assertTrue(mb.isColliding() && pc.isColliding() && pc.getVector2D().equals(mb.getVector2D()));
	}
	@Test
	public void testMoving(){
		MovingBlock mb = new MovingBlock();
		Position p = mb.getPosition();
		System.out.println(""+p.getX()+ " "+p.getY()+"\n"+mb.getPosition().getX() + " " + mb.getPosition().getY());
		mb.update(100);
		System.out.println(""+mb.getPosition().getX() + " " + mb.getPosition().getY());
		assertTrue(p.equals(new Position(2.5f,2.5f)) && mb.getPosition().equals(new Position(7.5f,7.5f)));
	}
}
