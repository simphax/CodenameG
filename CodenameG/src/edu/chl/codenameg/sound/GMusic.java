package edu.chl.codenameg.sound;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 * Controls the music in the game
 * 
 * *Can only play one track at the time*
 */
public class GMusic implements IMusic {
	
	private Music music;
	private boolean loop;
	private float volume;
	
	public GMusic(String path) {
		try {
			music = new Music(path);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setLooping(boolean loop) {
		this.loop = loop;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public void play(){
		if(loop) {
			music.loop(1.0f, volume);
		} else {
			music.play(1.0f, volume);
		}
	}
	
	public void resume(){
		System.out.println(music.getPosition());
		if(music.getPosition() > 0.1f) {
			music.resume();
		} else {
			this.play();
		}
	}
	public void stop(){
		music.stop();
	}
	
	public void pause(){
		music.pause();
	}
}
