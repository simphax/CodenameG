package edu.chl.codenameg.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.newdawn.slick.geom.Rectangle;

import edu.chl.codenameg.model.entity.Block;

public class WorldTest1 {

	@Test
	public void testAdd() {
		World world = new World();
		Block block = new Block();
		world.add(block);
		assertTrue(world.getEntities().size() == 1);
	}
	
//	@Test
//	public void testEntityCollide() {
//		World world = new World();
//		Block block = new Block();
//		Block block2 = new Block();
//		block.setPosition(new Position(10,10));
//		block2.setPosition(new Position(10,10));
//		world.add(block);
//		world.add(block2);
//		world.update(10);
//		world.update(10);
//		world.update(10);
//		assertTrue(block.isColliding() && block2.isColliding());
//	}
	
	@Test
	public void testEntityMove() {
		World world = new World();
		Block block = new Block();
		Block block2 = new Block();
		
		block.setVector2D(new Vector2D(2,2));
		block2.setVector2D(new Vector2D(3,3));
		block.setPosition(new Position(10,10));
		block2.setPosition(new Position(10,10));
		world.add(block);
		world.add(block2);
		world.update(10);
		world.update(10);
		world.update(10);
		assertTrue(block.getPosition().getY() < block2.getPosition().getY() && block.getPosition().getX() < block2.getPosition().getX());
	}
	
	@Test
	public void testEntityMoveAndCollideX() {
		World world = new World();
		Block block = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		Block block2 = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setVector2D(new Vector2D(10,0));
		block2.setVector2D(new Vector2D(-10,0));
		block.setPosition(new Position(0,0));
		block2.setPosition(new Position(20,0));
		world.add(block);
		world.add(block2);
		world.update(10);
		System.out.println(block.getPosition().getX() + " " + block.getPosition().getY());
		System.out.println(block2.getPosition().getX() + " " + block2.getPosition().getY());
		assertTrue(block.isColliding() && block2.isColliding() && block.getPosition().getX() == 5 && block2.getPosition().getX() == 15);
	}
	
	@Test
	public void testEntityMoveAndCollideY() {
		World world = new World();
		Block block = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		Block block2 = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setVector2D(new Vector2D(0,10));
		block2.setVector2D(new Vector2D(0,-10));
		block.setPosition(new Position(0,0));
		block2.setPosition(new Position(0,20));
		world.add(block);
		world.add(block2);
		world.update(10);
		System.out.println(block.getPosition().getX() + " " + block.getPosition().getY());
		System.out.println(block2.getPosition().getX() + " " + block2.getPosition().getY());
		assertTrue(block.isColliding() && block2.isColliding() && block.getPosition().getY() == 5 && block2.getPosition().getY() == 15);
	}
	
	@Test
	public void testEntityMoveAndPushX() {
		World world = new World();
		Block block = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				
				return list;
			}
		};
		Block block2 = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setVector2D(new Vector2D(20,0));
		block2.setVector2D(new Vector2D(-10,0));
		block.setPosition(new Position(0,0));
		block2.setPosition(new Position(20,0));
		world.add(block);
		world.add(block2);
		world.update(10);
		System.out.println(block.getPosition().getX() + " " + block.getPosition().getY());
		System.out.println(block2.getPosition().getX() + " " + block2.getPosition().getY());
		assertTrue(block.getPosition().getX() == 10f && block2.getPosition().getX() == 30f);
	}
	
	@Test
	public void testEntityMoveAndPushY() {
		World world = new World();
		Block block = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				
				return list;
			}
		};
		Block block2 = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setVector2D(new Vector2D(0,20));
		block2.setVector2D(new Vector2D(0,-10));
		block.setPosition(new Position(0,0));
		block2.setPosition(new Position(0,20));
		world.add(block);
		world.add(block2);
		world.update(10);
		System.out.println(block.getPosition().getX() + " " + block.getPosition().getY());
		System.out.println(block2.getPosition().getX() + " " + block2.getPosition().getY());
		assertTrue(block.getPosition().getY() == 10f && block2.getPosition().getY() == 30f);
	}

	@Test
	public void testEntityFrictionX() {
		World world = new World();
		Block block = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				
				return list;
			}
		};
		Block block2 = new Block() {
			@Override
			public List<String> getCollideTypes() {
				List<String> list = new ArrayList<String>();
				list.add("Block");
				return list;
			}
		};
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setVector2D(new Vector2D(20,0));
		block2.setVector2D(new Vector2D(0,10));
		block.setPosition(new Position(0,11));
		block2.setPosition(new Position(0,0));
		world.add(block);
		world.add(block2);
		world.update(10);
		System.out.println(block.getPosition().getX() + " " + block.getPosition().getY());
		System.out.println(block2.getPosition().getX() + " " + block2.getPosition().getY());
		assertTrue(block2.getPosition().getX() == block2.getPosition().getX());
	}
	
	@Test
	public void testGetEntitiesAtRectangle() {
		World world = new World();
		
		Block block = new Block();
		Block block2 = new Block();
		
		block.setHitbox(new Hitbox(10,10));
		block2.setHitbox(new Hitbox(10,10));
		block.setPosition(new Position(0,0));
		block2.setPosition(new Position(5,0));
		
		world.add(block);
		world.add(block2);
		
		Rectangle testrect = new Rectangle(2,2,10,10);
		Rectangle testrect2 = new Rectangle(16,0,20,20);
		
		System.out.println(world.getEntitiesAt(testrect).toString());
		System.out.println(world.getEntitiesAt(testrect2).toString());
		
		assertTrue(world.getEntitiesAt(testrect).contains(block) && world.getEntitiesAt(testrect).contains(block2) && world.getEntitiesAt(testrect2).size() == 0);
	}
	
	

}
