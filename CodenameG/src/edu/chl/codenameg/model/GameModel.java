package edu.chl.codenameg.model;

public class GameModel {
	
	World world;
	
	public GameModel() {
		
	}
	
	public void startGame(World w) {
		this.world = w;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void update(int elapsedTime) {
		if(world != null) {
			world.update(elapsedTime);
		}
	}
	
}
