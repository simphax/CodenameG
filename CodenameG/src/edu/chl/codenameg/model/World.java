package edu.chl.codenameg.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.geom.Rectangle;

import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.model.levels.Level;

/**
 * World model object Contains all entities and the camera for a level in the
 * game. On update: moves all entities according to its vectors and collide
 * types.
 */
public class World {

	private boolean gameOver;
	private boolean hasWonGame;
	private Camera camera;
	private List<Entity> entities;
	private ArrayList<PlayerCharacter> players;
	private int amountOfPlayers;

	public World() {
		this(new ArrayList<Entity>()); // Defaults to an empty world
	}

	public World(Level copy) {
		this(copy.getListOfEntities());
	}

	public World(World copy) {
		this(copy.getEntities());
		this.players = copy.getPlayers();
	}

	public World(List<Entity> list) {
		this.entities = new ArrayList<Entity>();
		this.players = new ArrayList<PlayerCharacter>();
		this.camera = new Camera(this);
		this.gameOver = false;
		this.hasWonGame = false;
		for (Entity e : list) {
			this.add(e);
		}
	}

	/**
	 * Add an entity to this World
	 * 
	 * @param an
	 *            Entity
	 */
	public void add(Entity e) {
		if (e instanceof PlayerCharacter) {
			entities.add(e);
			players.add((PlayerCharacter) e);
			this.amountOfPlayers++;
		} else {
			entities.add(e);
		}
	}

	/**
	 * Remove an entity from this World
	 * 
	 * @param an
	 *            Entity
	 */
	public void remove(Entity e) {
		if (e instanceof PlayerCharacter) {
			entities.remove(e);
			players.remove(e);
			this.amountOfPlayers--;
		} else {
			entities.remove(e);
		}
	}

	/**
	 * @return a list containing all the entities in this world
	 */
	public List<Entity> getEntities() {
		return new ArrayList<Entity>(this.entities);
	}

	public ArrayList<PlayerCharacter> getPlayers() {
		return new ArrayList<PlayerCharacter>(this.players);
	}

	public Camera getCamera() {
		return camera;
	}

	/**
	 * Moves all entities according to their vectors and collision
	 * 
	 * @param int, time since last update
	 */
	public void update(int elapsedTime) {
		Map<Entity, List<Entity>> collidedEntities = new HashMap<Entity, List<Entity>>();

		for (Entity e : this.getEntities()) {
			collidedEntities.put(e, new ArrayList<Entity>());
		}

		camera.update(elapsedTime);

		for (Entity e : this.getEntities()) {
			if (e instanceof PlayerCharacter) {
				PlayerCharacter pc = (PlayerCharacter) e;
				if (pc.hasWonGame()) {
					this.hasWonGame = true;
					this.setGameOver();
				} else if (!pc.isAlive() && this.getAmountOfPlayers() < 2) {
					this.setGameOver();
				}
				if (!pc.isAlive() && this.getAmountOfPlayers() == 2) {
					this.remove(pc);
				}
			}

			e.update(elapsedTime);
			move(e, collidedEntities);
			checkCollision(e, collidedEntities);
		}
	}

	private void move(Entity e, Map<Entity, List<Entity>> collidedEntities) {
		Vector2D vector = e.getVector2D();
		stepPositionX(e, vector.getX(), collidedEntities);
		stepPositionY(e, vector.getY(), collidedEntities);
	}

	public void setGameOver() {
		this.gameOver = true;
	}

	public boolean isGameOver() {
		return this.gameOver;
	}

	public boolean isGameWon() {
		return this.hasWonGame;
	}

	public int getAmountOfPlayers() {
		return this.amountOfPlayers;
	}

	/**
	 * Checks if it's able to move an entity in the X-plane Used to check for
	 * collision in movement
	 * 
	 * @param Entity
	 * @param float, amount of movement
	 * @param Map
	 *            of collidedEntities
	 * @return True if able to move, else false
	 */
	private boolean stepPositionX(Entity e, float movex,
			Map<Entity, List<Entity>> collidedEntities) {
		// TODO float->int conversion!!!
		// This can be done to make the game more accurate
		// Right now it only checks every integer so there is a loss of accuracy
		// E.g. you can be 0.6 from a wall and still collide with it, which is a
		// quite noticable distance
		int preferredx = Math.round(movex);
		List<Entity> collided = collidedEntities.get(e);
		int addx = Math.signum(preferredx) > 0 ? 1 : -1;

		for (int x = 0; x < Math.abs(preferredx); x++) {
			for (Entity colliding : this.getEntitiesAt(new Rectangle((e
					.getPosition().getX() + (x * Math.signum(preferredx)))
					+ addx, (e.getPosition().getY()), e.getHitbox().getWidth(),
					e.getHitbox().getHeight()))) {
				if (colliding != e) {

					Direction d1 = Math.signum(preferredx) > 0 ? Direction.LEFT
							: Direction.RIGHT;
					Direction d2 = Math.signum(preferredx) > 0 ? Direction.RIGHT
							: Direction.LEFT;

					if (!collided.contains(colliding)) {
						colliding.collide(new CollisionEvent(e, d1));
						e.collide(new CollisionEvent(colliding, d2));
						collided.add(colliding);
					}

					// If the entity is set to collide with this entity, check
					// if the other has this in its list, in that case try to
					// move that
					// away and continue.
					if (e.getCollideTypes().contains(colliding.getType())) {
						if (colliding.getCollideTypes().contains(e.getType())) {
							if (!stepPositionX(colliding,
									Math.signum(preferredx), collidedEntities)) {
								return false;
							}
						} else {
							return false;
						}
					}

					// Else if the collided entity has this entity in his list,
					// move it out of the way
					else if (colliding.getCollideTypes().contains(e.getType())) {
						if (!stepPositionX(colliding, Math.signum(preferredx),
								collidedEntities)) {
							return false;
						}
					}

					// Otherwise just pass through the entity
				}
			}

			// Do not go outside camera, if camera is in collidetypes
			Rectangle cameraRectangle = new Rectangle(camera.getX()
					+ e.getHitbox().getWidth(), camera.getY(),
					camera.getWidth() - e.getHitbox().getWidth() * 2,
					camera.getHeight());

			Rectangle eRectangle = new Rectangle(e.getPosition().getX()
					+ Math.signum(preferredx), e.getPosition().getY(), e
					.getHitbox().getWidth(), e.getHitbox().getHeight());

			if (!cameraRectangle.intersects(eRectangle)
					&& e.getCollideTypes().contains("Camera")) {
				// camera.setX(camera.getX()+Math.signum(preferredx));
			} else {
				e.setPosition(new Position(e.getPosition().getX()
						+ Math.signum(preferredx), e.getPosition().getY()));
			}

			// Send friction to objects on top
			for (Entity colliding : this.getEntitiesAt(new Rectangle((e
					.getPosition().getX()), (e.getPosition().getY()) - 1, e
					.getHitbox().getWidth(), 1))) {
				if (colliding != e) {
					if (colliding.getCollideTypes().contains(e.getType())) {
						this.stepPositionX(colliding, Math.signum(preferredx),
								collidedEntities);
					}
				}
			}
		}
		return true;
	}

	/**
	 * Checks if it's able to move an entity in the Y-plane Used to check for
	 * collision in movement
	 * 
	 * @param Entity
	 * @param float, amount of movement
	 * @param Map
	 *            of collidedEntities
	 * @return True if able to move, else false
	 */
	private boolean stepPositionY(Entity e, float movey,
			Map<Entity, List<Entity>> collidedEntities) {
		// TODO float->int conversion!!!
		// This can be done to make the game more accurate
		// Right now it only checks every integer so there is a loss of accuracy
		// E.g. you can be 0.6 from a wall and still collide with it, which is a
		// quite noticable distance
		int preferredy = Math.round(movey);
		List<Entity> collided = collidedEntities.get(e);
		int addy = Math.signum(preferredy) > 0 ? 1 : -1;

		for (int y = 0; y < Math.abs(preferredy); y++) {
			for (Entity colliding : this.getEntitiesAt(new Rectangle((e
					.getPosition().getX()), (e.getPosition().getY() + (y * Math
					.signum(preferredy))) + addy, e.getHitbox().getWidth(), e
					.getHitbox().getHeight()))) {
				if (colliding != e) {

					Direction d1 = Math.signum(preferredy) > 0 ? Direction.TOP
							: Direction.BOTTOM;
					Direction d2 = Math.signum(preferredy) > 0 ? Direction.BOTTOM
							: Direction.TOP;

					if (!collided.contains(colliding)) {
						colliding.collide(new CollisionEvent(e, d1));
						e.collide(new CollisionEvent(colliding, d2));
						collided.add(colliding);
					}

					if (e.getCollideTypes().contains(colliding.getType())) {
						if (colliding.getCollideTypes().contains(e.getType())) {
							if (!stepPositionY(colliding,
									Math.signum(preferredy), collidedEntities)) {
								return false;
							}
						} else {
							return false;
						}
					} else if (colliding.getCollideTypes()
							.contains(e.getType())) {
						stepPositionY(colliding, Math.signum(preferredy),
								collidedEntities);
					}
				}
			}

			// Do not go outside camera, if camera is in collidetypes
			Rectangle cameraRectangle = new Rectangle(camera.getX()
					+ e.getHitbox().getWidth(), camera.getY()
					+ e.getHitbox().getHeight(), camera.getWidth()
					- e.getHitbox().getWidth() * 2, camera.getHeight()
					- e.getHitbox().getHeight() * 2);

			Rectangle eRectangle = new Rectangle(e.getPosition().getX(), e
					.getPosition().getY() + Math.signum(preferredy), e
					.getHitbox().getWidth(), e.getHitbox().getHeight());

			if (!cameraRectangle.intersects(eRectangle)
					&& e.getCollideTypes().contains("Camera")) {
				e.collide(new CollisionEvent(new Block(), Direction.TOP));
			} else {
				e.setPosition(new Position(e.getPosition().getX(), e
						.getPosition().getY() + Math.signum(preferredy)));
			}
		}
		return true;
	}

	/*
	 * If a collision was not detected on move() (The entity did not move at
	 * all) This sends collide() events to overlapping entities.
	 */
	private void checkCollision(Entity e,
			Map<Entity, List<Entity>> collidedEntities) {
		Rectangle rect = new Rectangle(e.getPosition().getX(), e.getPosition()
				.getY(), e.getHitbox().getWidth(), e.getHitbox().getHeight());
		List<Entity> collided = collidedEntities.get(e);

		for (Entity colliding : getEntitiesAt(rect)) {
			if (!collided.contains(colliding)) {
				colliding.collide(new CollisionEvent(e, Direction.NONE));
				e.collide(new CollisionEvent(colliding, Direction.NONE));
				collided.add(colliding);
			}
		}
	}

	/**
	 * 
	 * @param target
	 *            Rectangle of the check
	 * @return a list of all the entities that are inside the target Rectangle
	 */
	public List<Entity> getEntitiesAt(Rectangle target) {
		List<Entity> list = new ArrayList<Entity>();

		for (Entity e : this.getEntities()) {
			Rectangle rect = new Rectangle((e.getPosition().getX()),
					(e.getPosition().getY()), e.getHitbox().getWidth(), e
							.getHitbox().getHeight());
			if (target.intersects(rect) || target.contains(rect)
					|| rect.contains(target)) {
				list.add(e);
			}
		}
		return list;
	}
}
