package edu.chl.codenameg.model;

import java.util.ArrayList;

import edu.chl.codenameg.model.entity.PlayerCharacter;

/** 
 * Class that represents a camera
 * with width, height and a position depending 
 * on the player character's position.
 * @author ???
 */
public class Camera {
	private int 						minWidth;
	private int 						minHeight;
	private int 						maxWidth;
	private int 						maxHeight;
	private int 						width;
	private int 						height;
	private float 						camerax;
	private float 						Xmax;
	private float 						Ymax;
	private float 						Xmin;
	private float 						Ymin;
	private float 						cameray;
	private World 						world;
	private ArrayList<PlayerCharacter> 	players;

	public Camera(World world) {
		this.minWidth 	= 500;
		this.minHeight 	= 500;
		this.maxWidth 	= 700;
		this.maxHeight 	= 700;
		this.camerax 	= 0;
		this.world 		= world;
		this.players 	= new ArrayList<PlayerCharacter>();
	}
	
	/**
	 * @return The X-value of the camera
	 */
	public float getX(){
		return camerax;
	}
	
	/**
	 * @return The Y-value of the camera
	 */
	public float getY(){
		return cameray;
	}
	
	/**
	 * @return The maximum width of the camera
	 */
	public float getMaxWidth(){
		return this.maxWidth;
	}
	
	/**
	 * @return The maximum height of the camera
	 */
	public float getMaxHeight(){
		return this.maxHeight;
	}
	
	/**
	 * @return The minimum width of the camera
	 */
	public float getMinWidth(){
		return this.minWidth;
	}
	
	/**
	 * @return The minimum height of the camera
	 */
	public float getMinHeight(){
		return this.maxHeight;
	}
	
	/**
	 * @return The width of the camera
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return The height of the camera
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Updates with a default value of 10 ms
	 */
	public void update() {
		this.update(10);
	}
	
	/**
	 * Updates the camera's position to match the two players' position
	 * or just one player of the other is dead
	 * @param The time since the last update
	 */
	public void update(int elapsedTime) {
		for(PlayerCharacter c : world.getPlayers()){
			players.add(c);
		}
		
		Xmax = players.get(0).getPosition().getX() + players.get(0).getHitbox().getWidth();
		Xmin = players.get(0).getPosition().getX();
		Ymax = players.get(0).getPosition().getY() + players.get(0).getHitbox().getHeight();
		Ymin = players.get(0).getPosition().getY() + players.get(0).getHitbox().getHeight();
		
		for(int i = 1; i < world.getAmountOfPlayers();i++){
		Xmax = Math.max(Xmax, players.get(i).getPosition().getX() + players.get(i).getHitbox().getWidth());
		Xmin = Math.min(Xmin, players.get(i).getPosition().getX());
		Ymax = Math.max(Ymax, players.get(i).getPosition().getY() + players.get(i).getHitbox().getHeight());
		Ymin = Math.min(Ymin, players.get(i).getPosition().getY())+ players.get(i).getHitbox().getHeight();
		}
		
		width = Math.min(Math.max((int)(Ymax - Ymin + minHeight),(int)(Xmax - Xmin + minWidth)),maxWidth);
		height = Math.min(Math.max((int)(Ymax - Ymin + minHeight),(int)(Xmax - Xmin + minWidth)),maxHeight);
		camerax =((Xmax+Xmin)/2)-this.getWidth()/2;
		cameray =((Ymax+Ymin)/2)-this.getHeight()/2;
		
		for(PlayerCharacter c : world.getPlayers()){
			players.remove(c);
		}
	}
}
