package edu.chl.codenameg.view.entity;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.EntityView;

public class PlayerCharacterView implements EntityView {
	private SpriteSheet spriteSheet = null;
	private Animation walkLeft = null;
	private Animation jumpLeft = null;
	private Animation crouchLeft = null;
	private Animation standLeft = null;
	private Animation walkRight = null;
	private Animation jumpRight = null;
	private Animation crouchRight = null;
	private Animation standRight = null;
	
	public PlayerCharacterView(){
		try {
			spriteSheet = new SpriteSheet("res/micho_double.png",64,64,Color.magenta);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		crouchLeft = new Animation();
		for (int i=19; i>14; i--){
			crouchLeft.addFrame( spriteSheet.getSprite(i, 10), 150);
		}
		jumpLeft = new Animation();
		for (int i=11; i>7; i--){
			jumpLeft.addFrame( spriteSheet.getSprite(i, 10), 150);
		}
		standLeft = new Animation();
		for (int i=19; i>10; i--){
			standLeft.addFrame( spriteSheet.getSprite(i, 6), 150);
		}
		walkLeft = new Animation();
		for (int i=19; i>9; i--){
			walkLeft.addFrame( spriteSheet.getSprite(i, 7), 150);
		}
		jumpLeft.setLooping(false);
		crouchLeft.setLooping(false);
	
	crouchRight = new Animation();
	for (int i=0; i<5; i++){
		crouchRight.addFrame( spriteSheet.getSprite(i, 4), 150);
	}
	jumpRight = new Animation();
	for (int i=8; i<12; i++){
		jumpRight.addFrame( spriteSheet.getSprite(i, 4), 150);
	}
	standRight = new Animation();
	for (int i=0; i<9; i++){
		standRight.addFrame( spriteSheet.getSprite(i, 0), 150);
	}
	walkRight = new Animation();
	for (int i=0; i<10; i++){
		walkRight.addFrame( spriteSheet.getSprite(i, 1), 150);
	}
	jumpRight.setLooping(false);
	crouchRight.setLooping(false);
}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof PlayerCharacter){
			PlayerCharacter pc = (PlayerCharacter)ent;
			
			switch(pc.getDirection()) {
			case LEFT:
				if (pc.isCrouching()){
					crouchLeft.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isJumping()){
					jumpLeft.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isMoving()){
					walkLeft.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}else{
					standLeft.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}
				break;
			case RIGHT:
				if (pc.isCrouching()){
					crouchRight.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isJumping()){
					jumpRight.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isMoving()){
					walkRight.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}else{
					standRight.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}
				break;
			}
		}
	}
		
	
}
