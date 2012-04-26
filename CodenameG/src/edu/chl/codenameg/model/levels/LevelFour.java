package edu.chl.codenameg.model.levels;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Direction;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.entity.Block;

public class LevelFour implements Level {
	
	List<Entity> list;
	
	public LevelFour() {
		list = new ArrayList<Entity>();
		
		Block block1 = new Block();
		
		list.addAll(LevelHelper.generateBlock(block1, 20, Direction.RIGHT, new Position(0,500), null, 0));
		
	}

	@Override
	public List<Entity> getListOfEnteties() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void setAmountOfPlayers(int aop) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getStartPosition() {
		// TODO Auto-generated method stub
		return new Position(50,50);
	}

	@Override
	public int getAmountOfPlayers() {
		// TODO Auto-generated method stub
		return 1;
	}

}
