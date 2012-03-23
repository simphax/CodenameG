package edu.chl.codenameg.model;

import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class GameModel {
	
	private World world;
	private boolean running;
	
	public GameModel() {
		
		//TODO Default world?
		World tempWorld = new World();
		
		Block block = new Block();
		block.setPosition(new Position(100,200));
		block.setHitbox(new Hitbox(200,20));
		
		MovingBlock movingblock = new MovingBlock(new Hitbox(20,20),new Position(50,50), new Position(100,100), 1000);
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setPosition(new Position(200,50));
		
		tempWorld.add(block);
		tempWorld.add(pc);
		tempWorld.add(movingblock);
		
		this.setWorld(tempWorld);
	}
	
	public void setWorld(World w) {
		this.world = w;
	}
	
	public void startGame() {
		this.running = true;
	}
	
	public void restartGame() {
		//TODO restart game
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
