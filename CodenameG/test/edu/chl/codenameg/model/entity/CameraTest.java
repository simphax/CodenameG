package edu.chl.codenameg.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;


import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;
import edu.chl.codenameg.model.World;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class CameraTest {
	/*
	 * Since Camera can't work without it's world, we use the world update here. Have in mind that world calls for the camera
	 * to update itself in it's own update method.
	 */
	@Test
	public void testUpdate() {
		World w = new World();
		PlayerCharacter pc1 = new PlayerCharacter(w);
		PlayerCharacter pc2 = new PlayerCharacter(w);
		w.add(pc1);
		w.add(pc2);
		pc1.setPosition(new Position(0,50));
		pc2.setPosition(new Position(pc1.getHitbox().getWidth() +1, 50));
		while(pc2.getPosition().getX()<w.getCamera().getMaxWidth()-pc2.getHitbox().getWidth()-1){
			pc2.addVector2D(new Vector2D(1,0));
			w.update(10);

		}
		// pc2 should already be standing next to the wall, hence next addvector2D() shouldn't change pc2's position in X-direction
		pc2.addVector2D(new Vector2D(1,0));
		w.update(10);
		boolean case1 = pc2.getPosition().getX() ==w.getCamera().getMaxWidth()-pc2.getHitbox().getWidth()-1;
		boolean case2 = w.getCamera().getWidth() == 700;
		pc1.setPosition(new Position(0,50));
		w.remove(pc2);
		w.update(10);
		// Camera shouldn't be bigger than 700 pixels
		System.out.println(w.getCamera().getWidth());
		boolean case3 = w.getCamera().getWidth()-pc1.getHitbox().getWidth() == 500;
		assertTrue(case1 && case2 && case3);
		
		
	}

}
