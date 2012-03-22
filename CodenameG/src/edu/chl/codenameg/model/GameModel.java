package edu.chl.codenameg.model;

public class GameModel {
	
	private World world;
	private boolean running;
	
	public GameModel() {
		this.world = new World();
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
