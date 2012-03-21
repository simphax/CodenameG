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

			Point temp = e.getPosition();
			Vector2D vector = e.getVector2D();
			if (vector != null && (vector.getX() > 0 || vector.getY() > 0)) {
				e.setPosition(new Point((int) e.getPosition().getX() + e.getVector2D().getX(), (int) e.getPosition().getY() + e.getVector2D().getY()));
			}
			this.checkCollision(e);
			e.update(elapsedTime);
		}
	}

	private void checkCollision(Entity e) {
		for (Entity target : this.getEntities()) {
			if (target != e) {
				boolean collision = false;

				Rectangle thisRectangle = new Rectangle(e.getPosition(), new Dimension(e.getHitbox().getWidth(), e.getHitbox().getHeight()));
				Rectangle targetRectangle = new Rectangle(target.getPosition(), new Dimension(target.getHitbox().getWidth(), target.getHitbox().getHeight()));
				if (thisRectangle.intersects(targetRectangle)) {
					collision = true;

					Rectangle intersection = thisRectangle.intersection(targetRectangle);

					//Collision on bottom
					if (intersection.y == targetRectangle.y) {
						e.setPosition(new Point(e.getPosition().x, e.getPosition().y - intersection.height));
					}
					//Collision on top
					if (intersection.y + intersection.height == targetRectangle.y) {
						e.setPosition(new Point(e.getPosition().x, e.getPosition().y + intersection.height));
					}
					//Collision on right
					if (intersection.x == targetRectangle.x) {
						e.setPosition(new Point(e.getPosition().x - intersection.width, e.getPosition().y));
					}
					//Collision on left
					if (intersection.x + intersection.width == targetRectangle.x) {
						e.setPosition(new Point(e.getPosition().x + intersection.width, e.getPosition().y));
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
