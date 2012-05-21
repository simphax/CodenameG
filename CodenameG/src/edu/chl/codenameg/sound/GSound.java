package edu.chl.codenameg.sound;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Plays sound files
 */
public class GSound implements ISound {
	private Sound 		sound;
	private boolean 	loop;
	private float 		volume;

	public GSound(String path) throws SlickException {
		sound = new Sound(path);
		loop = false;
		volume = 1.0f;
	}

	@Override
	public void play() {
		if (loop) {
			sound.loop(1.0f, volume);
		} else {
			sound.play(1.0f, volume);
		}
	}

	@Override
	public void setLooping(boolean loop) {
		this.loop = loop;
	}

	@Override
	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Override
	public void stop() {
		sound.stop();
	}
}
