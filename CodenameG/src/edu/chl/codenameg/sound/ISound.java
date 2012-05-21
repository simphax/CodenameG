package edu.chl.codenameg.sound;

/**
 * Interface for classes playing sound files.
 */
public interface ISound {

	public void play();
	public void stop();
	public void setLooping(boolean loop);
	public void setVolume(float volume);
}
