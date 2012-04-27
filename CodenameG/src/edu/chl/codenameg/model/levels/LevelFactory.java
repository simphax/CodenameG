package edu.chl.codenameg.model.levels;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class LevelFactory {

	public static Level getLevel(int i)throws IllegalArgumentException{
		if(i == 1){
			return LevelFactory.loadLevelFromFile("level/level1.tmx");
		}else if (i == 2){
			return new LevelTwo();
		}else if (i == 3){
			return new LevelThree();
		}else if (i == 4){
			return new LevelFour();
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public static Level loadLevelFromFile(String path) {
		try {
			TiledMap map = new TiledMap(path,"level");
			map.getLayerIndex("Block");
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LevelOne();
		
	}
	
	public static String getLevelFilePath(int i) {
		return "level/level1.tmx";
	}
	
}
