package edu.chl.codenameg.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	List<Entity> entities;

	public World() {
		this.entities = new ArrayList<Entity>();
	}
	
	public World(World copy) {
		this.entities = copy.getEntities();
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public List<Entity> getEntities() {
		// return new ArrayList<Entity>(this.entities);
		return this.entities;
	}

	public Camera getCamera() {
		return new Camera();
	}

	public void update(int elapsedTime) {
		for (Entity e : this.getEntities()) {

			Position temp = e.getPosition();
			Vector2D vector = e.getVector2D();
			if (vector != null && (vector.getX() > 0 || vector.getY() > 0)) {
				e.setPosition(new Position(e.getPosition().getX()
						+ e.getVector2D().getX(), e.getPosition().getY()
						+ e.getVector2D().getY()));
			}
			this.checkCollision(e);
			e.update(elapsedTime);
		}
	}

	private void checkCollision(Entity e) {
		for (Entity target : this.getEntities()) {
			if (target != e) {
				boolean collision = false;

				// TODO Collision detection without using rounded doubles!!

				Rectangle thisRectangle = new Rectangle(new Point((int) (e
						.getPosition().getX() + 0.5), (int) (e.getPosition()
						.getY() + 0.5)), new Dimension(
						e.getHitbox().getWidth(), e.getHitbox().getHeight()));
				
				Rectangle targetRectangle = new Rectangle(new Point(
						(int) (target.getPosition().getX() + 0.5),
						(int) (target.getPosition().getY() + 0.5)),
						new Dimension(target.getHitbox().getWidth(), target
								.getHitbox().getHeight()));
				
				if (thisRectangle.intersects(targetRectangle)) {
					collision = true;

					Rectangle intersection = thisRectangle
							.intersection(targetRectangle);

					// Collision on bottom
					if (intersection.y == targetRectangle.y) {
						e.setPosition(new Position(e.getPosition().getX(), e
								.getPosition().getY() - intersection.height));
					}
					// Collision on top
					if (intersection.y + intersection.height == targetRectangle.y) {
						e.setPosition(new Position(e.getPosition().getX(), e
								.getPosition().getY() + intersection.height));
					}
					// Collision on right
					if (intersection.x == targetRectangle.x) {
						e.setPosition(new Position(e.getPosition().getX()
								- intersection.width, e.getPosition().getY()));
					}
					// Collision on left
					if (intersection.x + intersection.width == targetRectangle.x) {
						e.setPosition(new Position(e.getPosition().getX()
								+ intersection.width, e.getPosition().getY()));
					}
				}
				if (collision) {
					e.collide(target);
					target.collide(e);
				}
			}

		}
	}

}
