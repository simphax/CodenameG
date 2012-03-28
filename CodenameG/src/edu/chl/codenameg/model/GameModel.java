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
		PlayerCharacter pc2 = new PlayerCharacter();
		PlayerCharacter pc1 = new PlayerCharacter();
		pc1.setPosition(new Position(200, 50));
		pc2.setPosition(new Position(180,50));

		testWorld.add(block);
		testWorld.add(block2);
		testWorld.add(block3);
		testWorld.add(pc1);
		testWorld.add(pc2);
		testWorld.add(movingblock);
		testWorld.add(movingblock2);
		testWorld.add(movingblock3);
		testWorld.add(movingblock4);
		testWorld.add(goalblock);
		testWorld.add(lblock);
		listOfPC.removeAll(listOfPC);
		listOfPC.add(pc1);
		
		listOfPC.add(pc2);
		
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
		case START_GAME:
			this.startGame();
			break;
		case PAUSE_GAME:
			this.pauseGame(this.getWorld());
			break;
		case RESTART_GAME:
			this.restartGame();
			break;
		case PLAYER_1_MOVE_LEFT:
			getPlayer(1).move(Direction.LEFT);
			break;
		case PLAYER_1_MOVE_RIGHT:
			getPlayer(1).move(Direction.RIGHT);
			break;
		case PLAYER_1_JUMP:
			getPlayer(1).jump();
			break;
		case PLAYER_1_TOGGLE_CROUCH:
			getPlayer(1).toggleCrouch();
			break;
		case PLAYER_2_MOVE_LEFT:
			getPlayer(2).move(Direction.LEFT);
			break;
		case PLAYER_2_MOVE_RIGHT:
			getPlayer(2).move(Direction.RIGHT);
			break;
		case PLAYER_2_JUMP:
			getPlayer(2).jump();
			break;
		case PLAYER_2_TOGGLE_CROUCH:
			getPlayer(2).toggleCrouch();
			break;
		default:
			break;
		}
	}
	
	public void stopAction(Action action) {
		switch (action) {
		case PLAYER_1_MOVE_LEFT:
			getPlayer(1).stopMove();
			break;
		case PLAYER_1_MOVE_RIGHT:
			getPlayer(1).stopMove();
			break;
		case PLAYER_1_JUMP:
			getPlayer(1).stopJump();
			break;
		case START_GAME:
			this.startGame();
			break;
		case PLAYER_1_TOGGLE_CROUCH:
			getPlayer(1).toggleCrouch();
			break;
		case PLAYER_2_MOVE_LEFT:
			getPlayer(2).stopMove();
			break;
		case PLAYER_2_MOVE_RIGHT:
			getPlayer(2).stopMove();
			break;
		case PLAYER_2_JUMP:
			getPlayer(2).stopJump();
			break;
		case PLAYER_2_TOGGLE_CROUCH:
			getPlayer(2).toggleCrouch();
			break;
		default:
			break;
		}
	}
	
	public PlayerCharacter getPlayer(int num) {
		return listOfPC.get(num-1);
	}

	public void update(int elapsedTime) {
		if (world != null && running) {
			world.update(elapsedTime);
		}
		if (world.isGameOver()) {
			if (world.isGameWon()) {
				System.out.println("Congratulations!");
			}
			this.restartGame();
		}
//		for (Entity entity : world.getEntities()) {
//			if (entity instanceof PlayerCharacter) {
//				PlayerCharacter pc = (PlayerCharacter)entity;
//				if (pc.hasWonGame()) {
//					this.restartGame();
//					System.out.println("Congratulations for winning the game!");
//				} else if (!(pc.isAlive())) {
//					this.restartGame(); // TODO Skriv klart
//				}
//			}
//		}
	}
}
