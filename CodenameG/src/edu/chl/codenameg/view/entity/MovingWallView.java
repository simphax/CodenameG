package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.MovingWall;
import edu.chl.codenameg.view.EntityView;

/**
 * The moving wall's view that sets the graphic for the entity
 */
public class MovingWallView implements EntityView {
    Animation fireRightAni;
    Animation fireUpAni;

    public MovingWallView() {
	SpriteSheet fireUpSS = null;
	SpriteSheet fireRightSS = null;
	try {
	    fireRightSS = new SpriteSheet("/res/fire_r.png", 200, 200);
	    fireUpSS = new SpriteSheet("/res/fire.png", 200, 200);
	} catch (SlickException e) {
	    e.printStackTrace();
	}

	fireUpAni = new Animation();
	for (int x = 0; x < 4; x++) {
	    for (int y = 0; y < 4; y++) {
		fireUpAni.addFrame(fireUpSS.getSprite(x, y), 40);
	    }
	}
	fireRightAni = new Animation();
	for (int x = 0; x < 4; x++) {
	    for (int y = 0; y < 4; y++) {
		fireRightAni.addFrame(fireRightSS.getSprite(x, y), 40);
	    }
	}
    }

    @Override
    public void render(Entity ent, Graphics g) {
	if (ent instanceof MovingWall) {
	    MovingWall wall = (MovingWall) ent;

	    if (wall.isLethal()) {
		if (wall.getDirection().equals(Direction.RIGHT)) {
		    for (int i = 0; i < Math.round(ent.getHitbox().getHeight()) - 50; i = i + 100) {
			fireRightAni.draw(ent.getPosition().getX() - 50, ent
				.getPosition().getY() - 50 + i);
		    }
		} else if (wall.getDirection().equals(Direction.TOP)) {
		    for (int i = 0; i < Math.round(ent.getHitbox().getWidth()) - 50; i = i + 100) {
			fireUpAni.draw(ent.getPosition().getX() - 50 + i, ent
				.getPosition().getY() - 100);
		    }
		}
	    } else {
		g.setColor(Color.black);
		if (wall.getDirection().equals(Direction.RIGHT)) {
		    g.fillRect(-1000, -1000, 1000+ent.getPosition().getX()+ent.getHitbox().getWidth(), 1000+ent.getPosition().getY()+ent.getHitbox().getHeight());
		} else if (wall.getDirection().equals(Direction.TOP)) {
		    g.fillRect(ent.getPosition().getX(), ent.getPosition().getY(), ent.getHitbox().getWidth(), ent.getHitbox().getHeight());
		}
	    }

	}
    }

}
