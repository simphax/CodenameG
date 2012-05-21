package edu.chl.codenameg.sound;


/**
 * Interface for playing music
 */
public interface IMusic {
	
	public void setLooping(boolean loop);
	
	public void setVolume(float volume);
	
	public void play();
	
	public void resume();
	
	public void stop();
	
	public void pause();
}
