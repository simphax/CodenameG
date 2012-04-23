package edu.chl.codenameg.model.levels;

import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;

public class LevelTwo implements Level{
	// TODO: List of enteties - LevelDesign
	// TODO: Background, startpos, camera, speed of level?/timelimit etc.
	// TODO: Other blocks , just a frame-copy from level one.

		private List<Entity> entityList1;
		private List<Entity> entityList2;
		
		private Position startPos;
		private Position startPos2; // only multiplayer
		
		private int amountOfPlayers;
		
		// LevelDesign/Blocks - Singleplayer
		// Solid blocks
		private static Block b1p1 = new Block(new Hitbox(35, 3*64), new Position(0,20));
		private static Block b1p2 = new Block(new Hitbox(60,25),new Position(0,212));
		private static Block b1p3 = new Block(new Hitbox(35,25),new Position(70,20));
		private static Block b1p4 = new Block(new Hitbox(135,25), new Position(100,212));
		private static Block b1p5 = new Block(new Hitbox(100,25), new Position(100,45));
		private static Block b1p6 = new Block(new Hitbox(70,25), new Position(200,50));
		private static Block b1p7 = new Block(new Hitbox(35,25), new Position(235,237));
		private static Block b1p8 = new Block(new Hitbox(150,25), new Position(270,212));
		private static Block b1p9 = new Block(new Hitbox(35,50), new Position(420,187));
		private static Block b1p10 = new Block(new Hitbox(70,25),new Position(385,45));
		private static Block b1p11 = new Block(new Hitbox(150,50),new Position(480,45));
		//lethal blocks
		private static LethalBlock lb1p1 = new LethalBlock(new Hitbox(35,25), new Position(70,45));
		private static LethalBlock lb1p2 = new LethalBlock(new Hitbox(115,25), new Position(270,50));
		private static LethalBlock lb1p3 = new LethalBlock(new Hitbox(35,25), new Position(550,162));
		//Moving blocks
		private static MovingBlock mb1p1 = new MovingBlock(new Hitbox(50,25), new Position(455,212), new Position(615,212), 10000);
		//Movable blocks
		private static MovableBlock m1p1 = new MovableBlock(new Hitbox(35,25), new Position(135,187));
		
		//constructor
		public LevelTwo(){
			//Singleplayer
			this.entityList1 = new ArrayList<Entity>();
			//Multiplayer
			this.entityList2 = new ArrayList<Entity>(); // so far Unused.
			this.setAmountOfPlayers(1);
			this.startPos = new Position(40,20);
			

			//adding to list entityList1 - singleplayer
			this.entityList1.add(b1p1);this.entityList1.add(b1p2);this.entityList1.add(b1p3);
			this.entityList1.add(b1p4);this.entityList1.add(b1p5);this.entityList1.add(b1p6);
			this.entityList1.add(b1p7);this.entityList1.add(b1p8);this.entityList1.add(b1p9);
			this.entityList1.add(b1p10);this.entityList1.add(b1p11);
			
			this.entityList1.add(lb1p1);this.entityList1.add(lb1p2);this.entityList1.add(lb1p3);
			
			this.entityList1.add(mb1p1);
			this.entityList1.add(m1p1);
			

			
			
			
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
	}

