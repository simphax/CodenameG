package edu.chl.codenameg.view;

/**
 * Interface for playing sound files.
 */
public interface ISound {

	public void play();
	public void stop();
	public void setLooping(boolean loop);
	public void setVolume(float volume);
}
