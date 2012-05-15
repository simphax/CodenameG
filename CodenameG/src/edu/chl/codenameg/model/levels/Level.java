package edu.chl.codenameg.model.levels;

import java.util.List;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Position;

public interface Level {
	//Just a suggestion , different list for singleplayer / multiplayer to enhance the difficulty relative to players.
	
	public List<Entity> getListOfEntities();
	public Position getPlayerSpawnPosition(int playerno);
	public int getAmountOfPlayers();
	
		
}
