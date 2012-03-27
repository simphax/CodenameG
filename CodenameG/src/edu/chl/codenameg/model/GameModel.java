package edu.chl.codenameg.model;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.model.entity.PlayerCharacter;

public class GameModel {

	private World world;
	private boolean running;
	private List<PlayerCharacter> listOfPC;

	public GameModel() {
		listOfPC = new ArrayList<PlayerCharacter>();
		World testWorld = this.createTestWorld();

		this.setWorld(testWorld);
	}

	private World createTestWorld() {
		World testWorld = new World();

		Block block = new Block();
		block.setPosition(new Position(100, 200));
		block.setHitbox(new Hitbox(200, 20));
		Block block2 = new Block();
		block2.setPosition(new Position(200, 140));
		block2.setHitbox(new Hitbox(20, 20));
		Block block3 = new Block();
		block3.setPosition(new Position(250, 180));
		block3.setHitbox(new Hitbox(20, 20));
		LethalBlock lblock = new LethalBlock();
		lblock.setPosition(new Position(250, 150));
		lblock.setHitbox(new Hitbox(20, 20));

		MovingBlock movingblock = new MovingBlock(new Hitbox(20, 20), new Position(50, 50), new Position(100, 100), 1000);
		MovingBlock movingblock2 = new MovingBlock(new Hitbox(20, 20), new Position(50, 100), new Position(50, 200), 1000);
		MovingBlock movingblock3 = new MovingBlock(new Hitbox(20, 20), new Position(100, 50), new Position(200, 50), 1000);
		MovingBlock movingblock4 = new MovingBlock(new Hitbox(20, 20), new Position(150, 180), new Position(225, 180), 1000);

		GoalBlock goalblock = new GoalBlock(new Hitbox(10, 25), new Position(130, 175));

		PlayerCharacter pc = new PlayerCharacter();
		pc.setPosition(new Position(200, 50));

		testWorld.add(block);
		testWorld.add(block2);
		testWorld.add(block3);
		testWorld.add(pc);
		testWorld.add(movingblock);
		testWorld.add(movingblock2);
		testWorld.add(movingblock3);
		testWorld.add(movingblock4);
		testWorld.add(goalblock);
		testWorld.add(lblock);
		listOfPC.add(pc);
		
		return testWorld;
	}

	public void setWorld(World w) {
		this.world = w;
	}

	public void startGame() {
		this.running = true;
	}

	public void restartGame() {
		// This should be done using the controller instead...
		this.endGame();
		//******************************
		World testWorld = this.createTestWorld();
		this.setWorld(testWorld);
	}

	public void pauseGame(World w) {
		this.running = false;
	}

	public World getWorld() {
		return world;
	}
	
	public void endGame() {
		if (world != null && running) {
			this.running = false;
			this.world = null;
		}
	}
	
	public void performAction(Action action) {
		switch (action) {
		case PLAYER_1_MOVE_LEFT:
			getPlayer(1).move(Direction.LEFT);
			break;
		case PLAYER_1_MOVE_RIGHT:
			getPlayer(1).move(Direction.RIGHT);
			break;
		case PLAYER_1_JUMP:
			getPlayer(1).jump();
			break;
		case START_GAME:
			this.startGame();
			break;
		}
	}
	
	private void listPlayerCharacters() {
		List<Entity> list = world.getEntities();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof PlayerCharacter) {
				listOfPC.add((PlayerCharacter) list.get(i));
			}
		}
	}
	
	public PlayerCharacter getPlayer(int num) {
		return listOfPC.get(num-1);
	}

	public void update(int elapsedTime) {
		if (world != null && running) {
			world.update(elapsedTime);
		}
		for (Entity entity : world.getEntities()) {
			if (entity instanceof PlayerCharacter) {
				PlayerCharacter pc = (PlayerCharacter)entity;
				if (!(pc.isAlive())) {
					this.restartGame(); // TODO Skriv klart
				}
			}
		}
	}
}
