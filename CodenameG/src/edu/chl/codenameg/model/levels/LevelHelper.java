package edu.chl.codenameg.model.levels;
import java.util.ArrayList;
import java.util.List;

import edu.chl.codenameg.model.*;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.GoalBlock;
import edu.chl.codenameg.model.entity.LethalBlock;
import edu.chl.codenameg.model.entity.LethalMovingBlock;
import edu.chl.codenameg.model.entity.MovableBlock;
import edu.chl.codenameg.model.entity.MovingBlock;

public class LevelHelper {
	private List<Entity> helpList;
	
	public List<Entity> generateBlock(Entity e, 
			int amountOfBlocks, 
			Direction d,
			Position initPos,
			Position endPos,
			int travelTime){
			
			helpList = new ArrayList<Entity>();
			if(d.equals(Direction.RIGHT)){
				if(endPos ==null || travelTime == 0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalBlock){
							helpList.add(new LethalBlock(new Position(initPos.getX()+32*(i+1),initPos.getY())));
						}else if(e instanceof GoalBlock){
							helpList.add(new GoalBlock(new Position(initPos.getX()+32*(i+1),initPos.getY())));
						}else if(e instanceof MovableBlock){
							helpList.add(new MovableBlock(new Position(initPos.getX()+32*(i+1),initPos.getY())));
						}else{
							helpList.add(new Block(new Position(initPos.getX()+32*(i+1),initPos.getY())));
						}
						
					}
				}else if(endPos!=null && travelTime>0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalMovingBlock){
							helpList.add(new LethalMovingBlock(new Position(initPos.getX()+32*(i+1),initPos.getY()),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}else{
							helpList.add(new MovingBlock(new Position(initPos.getX()+32*(i+1),initPos.getY()),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}
					}
				}
			}else if(d.equals(Direction.LEFT)){
				if(endPos ==null || travelTime == 0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalBlock){
							helpList.add(new LethalBlock(new Position(initPos.getX()-32*(i+1),initPos.getY())));
						}else if(e instanceof GoalBlock){
							helpList.add(new GoalBlock(new Position(initPos.getX()-32*(i+1),initPos.getY())));
						}else if(e instanceof MovableBlock){
							helpList.add(new MovableBlock(new Position(initPos.getX()-32*(i+1),initPos.getY())));
						}else{
							helpList.add(new Block(new Position(initPos.getX()-32*(i+1),initPos.getY())));
						}
						
					}
				}else if(endPos!=null && travelTime>0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalMovingBlock){
							helpList.add(new LethalMovingBlock(new Position(initPos.getX()-32*(i+1),initPos.getY()),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}else{
							helpList.add(new MovingBlock(new Position(initPos.getX()-32*(i+1),initPos.getY()),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}
					}
				}
			}else if(d.equals(Direction.TOP)){
				if(endPos ==null || travelTime == 0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalBlock){
							helpList.add(new LethalBlock(new Position(initPos.getX(),initPos.getY()+32*(i+1))));
						}else if(e instanceof GoalBlock){
							helpList.add(new GoalBlock(new Position(initPos.getX(),initPos.getY())));
						}else if(e instanceof MovableBlock){
							helpList.add(new MovableBlock(new Position(initPos.getX(),initPos.getY())));
						}else{
							helpList.add(new Block(new Position(initPos.getX(),initPos.getY())));
						}
						
					}
				}else if(endPos!=null && travelTime>0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalMovingBlock){
							helpList.add(new LethalMovingBlock(new Position(initPos.getX(),initPos.getY()),
									new Position(endPos.getX(),endPos.getY()),travelTime));
						}else{
							helpList.add(new MovingBlock(new Position(initPos.getX(),initPos.getY()),
									new Position(endPos.getX(),endPos.getY()),travelTime));
						}
					}
				}
			}else if(d.equals(Direction.BOTTOM)){
				if(endPos ==null || travelTime == 0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalBlock){
							helpList.add(new LethalBlock(new Position(initPos.getX(),initPos.getY()-32*(i+1))));
						}else if(e instanceof GoalBlock){
							helpList.add(new GoalBlock(new Position(initPos.getX(),initPos.getY()-32*(i+1))));
						}else if(e instanceof MovableBlock){
							helpList.add(new MovableBlock(new Position(initPos.getX(),initPos.getY()-32*(i+1))));
						}else{
							helpList.add(new Block(new Position(initPos.getX(),initPos.getY()-32*(i+1))));
						}
						
					}
				}else if(endPos!=null && travelTime>0){
					for(int i = 0; i<amountOfBlocks;i++){
						if(e instanceof LethalMovingBlock){
							helpList.add(new LethalMovingBlock(new Position(initPos.getX(),initPos.getY()-32*(i+1)),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}else{
							helpList.add(new MovingBlock(new Position(initPos.getX(),initPos.getY()-32*(i+1)),
									new Position(endPos.getX()+32*(i+1),endPos.getY()),travelTime));
						}
					}
				}
			}
				return this.helpList;
		
	}

}
