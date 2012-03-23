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
		Block block2 = new Block();
		block2.setPosition(new Position(200,140));
		block2.setHitbox(new Hitbox(20,20));
		Block block3 = new Block();
		block3.setPosition(new Position(250,180));
		block3.setHitbox(new Hitbox(20,20));
		
		MovingBlock movingblock = new MovingBlock(new Hitbox(20,20),new Position(50,50), new Position(100,100), 1000);
		MovingBlock movingblock2 = new MovingBlock(new Hitbox(20,20),new Position(50,100), new Position(50,200), 1000);
		MovingBlock movingblock3 = new MovingBlock(new Hitbox(20,20),new Position(100,50), new Position(200,50), 1000);
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setPosition(new Position(200,50));
		
		tempWorld.add(block);
		tempWorld.add(block2);
		tempWorld.add(block3);
		tempWorld.add(pc);
		tempWorld.add(movingblock);
		tempWorld.add(movingblock2);
		tempWorld.add(movingblock3);
		
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
