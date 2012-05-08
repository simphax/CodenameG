package edu.chl.codenameg.model;
import java.util.ArrayList;

import edu.chl.codenameg.model.entity.PlayerCharacter;
/** Class that represents a camera and controls the camera position depending on a player character */
public class Camera {
	private int width = 500;
	private int height = 500;
	private float camerax = 0;
	private float Xmax,Ymax,Xmin,Ymin;
	private float cameray;
	private World world;
	private ArrayList<PlayerCharacter> players;

	public Camera(World world) {
		this.world = world;
		this.players = new ArrayList<PlayerCharacter>();
	}
	public float getX(){
		camerax = ((Xmax+Xmin)/2)-this.getWidth()/2;
		return camerax;
	}
	public float getY(){
		cameray = Math.abs(((Ymax+Ymin)/2)-this.getHeight()/2);
		return cameray;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void update() {
		this.update(10);
	}
	public void update(int elapsedTime) {
		for(PlayerCharacter c : world.getPlayers()){
			players.add(c);
		}
		for(int i = 0; i < world.getAmountOfPlayers();i++){
		Xmax = Math.max(Xmax, players.get(i).getPosition().getX());
		Xmin = Xmax;
		Xmin = Math.min(Xmin, players.get(i).getPosition().getX());
		Ymax = Math.max(Ymax, players.get(i).getPosition().getY()+ players.get(i).getHitbox().getHeight());
		Ymin = Ymax;
		Ymin = Math.min(Ymin, players.get(i).getPosition().getY()+ players.get(i).getHitbox().getHeight());
		}
}
}
