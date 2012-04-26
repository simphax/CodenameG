package edu.chl.codenameg.model.levels;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;

public class LevelThree implements Level{
	// TODO: List of enteties - LevelDesign
	// TODO: Background, startpos, camera, speed of level?/timelimit etc.
	// TODO: Other blocks , just a frame-copy from level one.

		private List<Entity> entityList1;
		private List<Entity> entityList2;
		
		private Position startPos;
		private Position startPos2; // only multiplayer
		
		private int amountOfPlayers;
		
		//constructor
		public LevelThree(){
			//Singleplayer
			this.entityList1 = new ArrayList<Entity>();
			//Multiplayer
			this.entityList2 = new ArrayList<Entity>(); // so far Unused.
			this.setAmountOfPlayers(1);
			//TODO: Change startpos
			this.startPos = new Position(40,20);
			
			
			
		}

		@Override
		public List<Entity> getListOfEnteties() {
			if(this.amountOfPlayers == 1){
				return this.entityList1;
			}else{
				return this.entityList2;
			}
		}
		@Override
		public void setAmountOfPlayers(int aop) throws IllegalArgumentException {
			if(aop >2 || aop <1){
				throw new IllegalArgumentException();
			}else{
				this.amountOfPlayers = aop;
			}
		}

		@Override
		public Position getStartPosition() {
			return new Position(this.startPos);
		}

		@Override
		public int getAmountOfPlayers() {
			return this.amountOfPlayers;
		}

		@Override
		public void createBlockAndAdd(int amountOfBlocks, Entity e) {
			// TODO Auto-generated method stub
			
		}

}
