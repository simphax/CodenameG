package edu.chl.codenameg.model;

import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class GameModel {
	
	private World world;
	private boolean running;
	
	public GameModel() {
		
		//TODO Default world?
		this.world = new World();
		
		Block block = new Block();
		block.setPosition(new Position(100,200));
		block.setHitbox(new Hitbox(200,20));
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setPosition(new Position(200,50));
		
		world.add(block);
		world.add(pc);
		
		this.setWorld(world);
		this.startGame();
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
