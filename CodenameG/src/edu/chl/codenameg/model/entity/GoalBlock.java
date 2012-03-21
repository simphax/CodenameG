package edu.chl.codenameg.model.entity;

import java.awt.Point;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.Hitbox;

public class GoalBlock extends Block{
	
	@Override
	public void collide(Entity e){
		super.collide(e);
		if(e instanceof PlayerCharacter){
			PlayerCharacter skilledPlayer = (PlayerCharacter)e;
			skilledPlayer.winGame();
		}
	}
	public GoalBlock(/*Graphic ,*/Hitbox hb, Point pt){
		super(/*g,*/hb,pt);
	}
}
