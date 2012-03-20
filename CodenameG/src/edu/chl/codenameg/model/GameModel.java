package edu.chl.codenameg.model;

public class GameModel {
	
	World world;
	boolean running;
	
	public GameModel() {
		
	}
	
	public void setWorld(World w) {
		this.world = w;
	}
	
	public void startGame() {
		this.running = true;
	}
	
	public void pauseGame(World w) {
		this.running = false;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void update(int elapsedTime) {
		if(world != null && running) {
			world.update(elapsedTime);
		}
	}
	
}
