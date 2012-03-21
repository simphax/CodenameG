package edu.chl.codenameg.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import edu.chl.codenameg.model.entity.Block;

public class WorldTest {

	@Test
	public void testAdd() {
		World world = new World();
		Block block = new Block();
		world.add(block);
		assertTrue(world.getEntities().size() == 1);
	}
	
	@Test
	public void testEntityCollide() {
		World world = new World();
		Block block = new Block();
		Block block2 = new Block();
		block.setPosition(new Point(10,10));
		block2.setPosition(new Point(10,10));
		world.add(block);
		world.add(block2);
		world.update(10);
		assertTrue(block.isColliding() && block2.isColliding());
	}
	
	@Test
	public void testEntityMove() {
		World world = new World();
		Block block = new Block() {
			@Override
			public Vector2D getVector2D() {
				return new Vector2D(2,2);
			}
		};
		Block block2 = new Block() {
			@Override
			public Vector2D getVector2D() {
				return new Vector2D(3,3);
			}
		};
		block.setPosition(new Point(10,10));
		block2.setPosition(new Point(10,10));
		world.add(block);
		world.add(block2);
		world.update(10);
		world.update(10);
		world.update(10);
		assertTrue(block.getPosition().getY() < block2.getPosition().getY() && block.getPosition().getX() < block2.getPosition().getX());
	}
	
	@Test
	public void testEntityMoveAndCollide() {
		World world = new World();
		Block block = new Block() {
			@Override
			public Vector2D getVector2D() {
				return new Vector2D(2,2);
			}
		};
		Block block2 = new Block() {
			@Override
			public Vector2D getVector2D() {
				return new Vector2D(3,3);
			}
		};
		block.setPosition(new Point(10,10));
		block2.setPosition(new Point(10,10));
		world.add(block);
		world.add(block2);
		world.update(10);
		world.update(10);
		world.update(10);
		assertTrue(block.getPosition().getY() < block2.getPosition().getY() && block.getPosition().getX() < block2.getPosition().getX());
	}
	
	

}
