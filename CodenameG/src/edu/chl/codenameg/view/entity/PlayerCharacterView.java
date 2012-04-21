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
	private Animation walk = null;
	private Animation jump = null;
	private Animation crouch = null;
	private Animation stand = null;
	
	public PlayerCharacterView(){
		try {
			spriteSheet = new SpriteSheet("res/micho_double.png",64,64,Color.magenta);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		crouch = new Animation();
		for (int i=0; i<5; i++){
			crouch.addFrame( spriteSheet.getSprite(i, 4), 150);
		}
		jump = new Animation();
		for (int i=8; i<12; i++){
			jump.addFrame( spriteSheet.getSprite(i, 4), 150);
		}
		stand = new Animation();
		for (int i=0; i<9; i++){
			stand.addFrame( spriteSheet.getSprite(i, 0), 150);
		}
		walk = new Animation();
		for (int i=0; i<10; i++){
			walk.addFrame( spriteSheet.getSprite(i, 1), 150);
		}
		jump.setLooping(false);
		crouch.setLooping(false);
	}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof PlayerCharacter){
			PlayerCharacter pc = (PlayerCharacter)ent;
			
			switch(pc.getDirection()) {
			case LEFT:
				if (pc.isCrouching()){
					crouch.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isJumping()){
					jump.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isMoving()){
					walk.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}else{
					stand.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}
				break;
			case RIGHT:
				if (pc.isCrouching()){
					crouch.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isJumping()){
					jump.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
				}else if (pc.isMoving()){
					walk.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}else{
					stand.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
				}
				break;
			}
		}
	}
		
	
}
