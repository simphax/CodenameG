package edu.chl.codenameg.model.levels;

import java.util.List;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Position;

/**
 * The interface for levels
 */
public interface Level {
	
	public List<Entity> getListOfEntities();
	
	public Position getPlayerSpawnPosition(int playerno);
	
	public int getAmountOfPlayers();
}
