package edu.chl.codenameg.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.entity.PlayerCharacter;

public class CameraTest {

	public void testUpdate() {
		World w = new World();
		PlayerCharacter pc1 = new PlayerCharacter(w);
		PlayerCharacter pc2 = new PlayerCharacter(w);
		w.add(pc1);
		w.add(pc2);
		Camera c = new Camera(w);
		pc1.setPosition(new Position(0,50));
		pc2.setPosition(new Position(pc1.getHitbox().getWidth() +1, 50));
		while(pc2.getPosition().getX())
		pc2.addVector2D(new Vector2D(0,))
	}

}
