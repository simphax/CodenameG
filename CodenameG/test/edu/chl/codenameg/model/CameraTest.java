package edu.chl.codenameg.model;

import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.Test;

public class CameraTest {

	@Test
	public void testGetSize() {
		Camera camera = new Camera();
		Dimension cameraSize = camera.getSize();
		assertTrue(cameraSize != null);
	}
	
	@Test
	public void testGetPosition () {
		Camera camera = new Camera();
		Point pos = camera.getPosition();
		assertTrue(pos.equals(new Point(0,0)));
	}

}
