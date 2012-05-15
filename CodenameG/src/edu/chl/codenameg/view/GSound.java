package edu.chl.codenameg.view;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Simple class to play sound files.
 */
public class GSound implements ISound {

	Sound sound;
	
	public GSound(String path) throws SlickException {
		sound = new Sound(path);
	}
	
	@Override
	public void play() {
		sound.play();
	}

}
