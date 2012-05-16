package edu.chl.codenameg.model.entity;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.Vector2D;

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
	
	@Override
	public void update(int elapsedTime) {
		this.setVector2D( new Vector2D(0, 1));
	}
	
	@Override
	public List<String> getCollideTypes() {
		List<String> list = new ArrayList<String>();
		list.add("Block");
		list.add("MovableBlock");
		list.add("PlayerCharacter");
		list.add("LethalBlock");
		
		return list;
	}
	
	@Override
	public String getType() {
		return "MovableBlock";
	}
}

