package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

/**
 * A block that is movable by a player character pushing it
 * It is affected by gravity
 */
public class MovableBlock extends Block{

	public MovableBlock(Position ps){
		super(ps);
	}
	
	public MovableBlock(Position ps, Hitbox hb){
		super(ps, hb);
	}
	
	public MovableBlock() {
		super();
	}
	
	public void update() {
		this.update(10);
	}
	
	/**
	 * Adds gravity to the block
	 */
	@Override
	public void update(int elapsedTime) {
		this.setVector2D(new Vector2D(0, 3));
	}
	
	@Override
	public List<String> getCollideTypes() {
		List<String> list = new ArrayList<String>();
		list.add("Block");
		list.add("MovableBlock");
		list.add("PlayerCharacter");
		list.add("LethalBlock");
		list.add("MovingBlock");
		list.add("FallingBlock");
		return list;
	}
	
	@Override
	public String getType() {
		return "MovableBlock";
	}
}

