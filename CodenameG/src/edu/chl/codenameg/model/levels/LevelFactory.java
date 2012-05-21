package edu.chl.codenameg.model.levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.FallingBlock;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.LethalMovingBlock;
import edu.chl.codenameg.model.entity.LiftableBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;
import edu.chl.codenameg.model.entity.MovingWall;
import edu.chl.codenameg.model.entity.Water;

/**
 * Generates Level objects from tmx files created using Tiled
 */
public class LevelFactory {
	private static LevelFactory instance;

	private LevelFactory() {
	}

	public static LevelFactory getInstance() {
		if (instance == null) {
			instance = new LevelFactory();
		}
		return instance;
	}

	public Level getLevel(int i) throws IllegalArgumentException {
		Level l = loadLevelFromFile(getLevelFilePath(i));

		if (l != null) {
			return l;
		} else {
			throw new IllegalArgumentException("The level does not exist");
		}
	}

	public Level loadLevelFromFile(String path) {
		List<Entity> entities = new ArrayList<Entity>();
		Map<Integer, Position> spawnPositions = new HashMap<Integer, Position>();
		TiledMap tiledmap;
		int numberOfPlayers = 1;

		try {
			tiledmap = new TiledMap(path);

			for (int groupID = 0; groupID < tiledmap.getObjectGroupCount(); groupID++) {

				for (int objectID = 0; objectID < tiledmap
						.getObjectCount(groupID); objectID++) {
					String name = tiledmap.getObjectName(groupID, objectID);

					if (name.equals("Water")) {
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity water = new Water(position, hitbox);
						entities.add(water);
					}
					if (name.equals("Block")) {
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity block = new Block(position, hitbox);
						entities.add(block);
					}
					if (name.equals("LethalBlock")) {
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity lethalblock = new LethalBlock(position, hitbox);
						entities.add(lethalblock);
					}
					if (name.equals("MovableBlock")) {
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity movableblock = new MovableBlock(position, hitbox);
						entities.add(movableblock);
					}
					if (name.equals("LiftableBlock")){
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity liftableblock = new LiftableBlock(position, hitbox);
						entities.add(liftableblock);
					}
					if (name.equals("MovingBlock")
							|| name.equals("LethalMovingBlock")
							|| name.equals("MovingWall")) {
						String direction = tiledmap.getObjectProperty(groupID,
								objectID, "Direction", "down");
						Position endPosition = new Position(0, 0);
						Position startPosition = new Position(0, 0);
						Entity movingblock;
						String lethality = tiledmap.getObjectProperty(groupID,
								objectID, "lethality", "false");
						int traveltime = Integer.parseInt(tiledmap
								.getObjectProperty(groupID, objectID,
										"traveltime", "1000"));
						if (name.equals(("MovingBlock"))) {
							movingblock = new MovingBlock();
						} else if (name.equals("LethalMovingBlock")) {
							movingblock = new LethalMovingBlock();
						} else {
							movingblock = new MovingWall();
						}
						if (direction.equals("up")) {
							endPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID));
							startPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID)
											+ tiledmap.getObjectHeight(groupID,
													objectID)
													- movingblock.getHitbox().getHeight());
						} else if (direction.equals("down")) {
							startPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID));
							endPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID)
											+ tiledmap.getObjectHeight(groupID,
													objectID)
													- movingblock.getHitbox().getHeight());
						} else if (direction.equals("right")) {
							startPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID));
							endPosition = new Position(
									tiledmap.getObjectX(groupID, objectID)
									+ tiledmap.getObjectWidth(groupID,
											objectID)
											- movingblock.getHitbox()
											.getWidth(),
											tiledmap.getObjectY(groupID, objectID));
						} else if (direction.equals("left")) {
							endPosition = new Position(tiledmap.getObjectX(
									groupID, objectID), tiledmap.getObjectY(
											groupID, objectID));

							startPosition = new Position(
									tiledmap.getObjectX(groupID, objectID)
									+ tiledmap.getObjectWidth(groupID,
											objectID)
											- movingblock.getHitbox()
											.getWidth(),
											tiledmap.getObjectY(groupID, objectID));
						}
						if (name.equals(("MovingBlock"))) {
							movingblock = new MovingBlock(startPosition,
									endPosition, traveltime);
						} else if (name.equals("LethalMovingBlock")) {
							movingblock = new LethalMovingBlock(startPosition,
									endPosition, traveltime);
						} else { // MovingWall
							movingblock = new MovingWall(startPosition,
									endPosition, traveltime,
									lethality.equals("true"));
							if (direction.equals("up")) {
								((MovingWall) movingblock)
								.setHitbox(new Hitbox((int) tiledmap
										.getObjectWidth(groupID,
												objectID), 32));
							} else {
								((MovingWall) movingblock)
								.setHitbox(new Hitbox(32, (int) tiledmap
										.getObjectWidth(groupID,
												objectID)));

							}
						}

						entities.add(movingblock);
					}
					if (name.equals("GoalBlock")) {
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity goalblock = new GoalBlock(position, hitbox);

						entities.add(goalblock);
					}
					if (name.equals("FallingBlock")){
						Hitbox hitbox = new Hitbox(tiledmap.getObjectWidth(
								groupID, objectID) - 1,
								tiledmap.getObjectHeight(groupID, objectID) - 1);
						Position position = new Position(tiledmap.getObjectX(
								groupID, objectID), tiledmap.getObjectY(
										groupID, objectID));
						Entity fallingblock = new FallingBlock(position, hitbox);

						entities.add(fallingblock);
					}
					if (name.equals("SpawnPC1")) {
						spawnPositions.put(
								1,
								new Position(tiledmap.getObjectX(groupID,
										objectID), tiledmap.getObjectY(groupID,
												objectID)));
					}
					if (name.equals("SpawnPC2")) {
						spawnPositions.put(
								2,
								new Position(tiledmap.getObjectX(groupID,
										objectID), tiledmap.getObjectY(groupID,
												objectID)));
					}
				}
			}

			numberOfPlayers = Integer.parseInt(tiledmap.getMapProperty(
					"numberOfPlayers", "1"));
		} catch (SlickException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Level level = new GeneratedLevel(entities, spawnPositions,
				numberOfPlayers);

		return level;

	}

	public String getLevelFilePath(int i) {
		return "levels/level" + i + ".tmx";
	}

	private class GeneratedLevel implements Level {
		private List<Entity> entities;
		private Map<Integer, Position> spawnPositions;
		private int numberPlayers;

		public GeneratedLevel(List<Entity> entities,
				Map<Integer, Position> spawnPositions, int numberPlayers) {
			this.entities = entities;
			this.spawnPositions = spawnPositions;
			this.numberPlayers = numberPlayers;
		}

		@Override
		public List<Entity> getListOfEntities() {
			return entities;
		}

		@Override
		public Position getPlayerSpawnPosition(int playerno) {
			if (spawnPositions.get(playerno) != null) {
				return spawnPositions.get(playerno);
			} else {
				return new Position(0, 0);
			}
		}

		@Override
		public int getAmountOfPlayers() {
			return numberPlayers;
		}
	}
}
