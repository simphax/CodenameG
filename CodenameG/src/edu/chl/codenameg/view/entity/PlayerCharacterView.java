package edu.chl.codenameg.view.entity;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.EntityView;

public class PlayerCharacterView implements EntityView {
	private SpriteSheet spriteSheet = null;
	private Animation walk = null;
	private Image jump = null;
	private Image crouch = null;
	
	public PlayerCharacterView(){
		
		try {
			spriteSheet = new SpriteSheet("res/base_0.png",64,64,Color.magenta);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		walk = new Animation();
		for (int i=1; i<5; i++){
			walk.addFrame( spriteSheet.getSprite(i, 1), 150);
		}
		
		crouch = spriteSheet.getSprite(4, 4);
		walk = new Animation();
		for (int i=1; i<5; i++){
			walk.addFrame( spriteSheet.getSprite(i, 1), 150);
		}
		walk.setLooping(true);
	}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof PlayerCharacter){
			PlayerCharacter pc = (PlayerCharacter)ent;
			if (pc.isCrouching()){
				crouch.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY()-64/2);
			}else{
				walk.draw(pc.getPosition().getX()+(pc.getHitbox().getWidth()/2)-64/2, pc.getPosition().getY());
			}
		}
	}
		
	
}
