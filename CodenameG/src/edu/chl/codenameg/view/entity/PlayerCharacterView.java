package edu.chl.codenameg.view.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.EntityView;
import edu.chl.codenameg.view.GSound;

// There are comments to be cleaned in here
public class PlayerCharacterView implements EntityView {
	private SpriteSheet spriteSheet;
	private Animation	walkLeft;
	private Animation 	jumpLeft;
	private Animation 	crouchLeft;
	private Animation 	standLeft;
	private Animation 	walkRight;
	private Animation 	jumpRight;
	private Animation 	crouchRight;
	private Animation 	standRight;
	private GSound 		jumpSound;
	private GSound 		waterSplashSound;
	private boolean 	jumping;
	private boolean 	inWater;
	
	public PlayerCharacterView() {
		spriteSheet = null;
		walkLeft 	= null;
		jumpLeft 	= null;
		crouchLeft 	= null;
		standLeft 	= null;
		walkRight 	= null;
		jumpRight 	= null;
		crouchRight = null;
		standRight 	= null;
		jumping 	= false;
		inWater 	= false;
		
		try {
			spriteSheet = new SpriteSheet("res/character_lr.png", 64, 64,Color.white);
			
			jumpSound = new GSound("res/sounds/Mario Jump.wav");
			waterSplashSound = new GSound("res/sounds/Mario Jump.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		crouchLeft = new Animation();
		for (int i = 15; i > 1; i--) {
			crouchLeft.addFrame(spriteSheet.getSprite(i, 23), 80);
		}
		jumpLeft = new Animation();
		for (int i = 15; i > 6; i--) {
			jumpLeft.addFrame(spriteSheet.getSprite(i, 25), 80);
		}
		standLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			standLeft.addFrame(spriteSheet.getSprite(i, 16), 80);
		}
		walkLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			walkLeft.addFrame(spriteSheet.getSprite(i, 17), 20);
		}
		crouchRight = new Animation();
		for (int i = 0; i < 15; i++) {
			crouchRight.addFrame(spriteSheet.getSprite(i, 7), 80);
		}
		jumpRight = new Animation();
		for (int i = 0; i <10; i++) {
			jumpRight.addFrame(spriteSheet.getSprite(i, 9), 80);
		}
		standRight = new Animation();
		for (int i = 0; i < 16; i++) {
			standRight.addFrame(spriteSheet.getSprite(i, 0), 80);
		}
		walkRight = new Animation();
		for (int i = 0; i < 16; i++) {
			walkRight.addFrame(spriteSheet.getSprite(i, 1), 20);
		}
		jumpRight.setLooping(false);
		crouchRight.setLooping(false);
		jumpLeft.setLooping(false);
		crouchLeft.setLooping(false);
	}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof PlayerCharacter) {
			PlayerCharacter pc = (PlayerCharacter) ent;
			//speed = ent.getVector2D().getX();
			
			this.playSounds(pc);
			
			switch (pc.getDirection()) {
			case LEFT:
				if (pc.isCrouching()) {
					crouchLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY() - 64 / 2);
					jumpLeft.restart();
				} else if (pc.isJumping()) {
					jumpLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()-9);
					crouchLeft.restart();
				} else if (pc.isMoving()) {
					//walkLeft.setSpeed(Math.abs(5/speed));
					walkLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					jumpLeft.restart();
					crouchLeft.restart();
				} else {
					standLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()-9);
					crouchLeft.restart();
					jumpLeft.restart();
				}

				break;
			case RIGHT:
				if (pc.isCrouching()) {
					crouchRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY() - 64 / 2 );
					jumpRight.restart();
				} else if (pc.isJumping()) {
					jumpRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					crouchRight.restart();						//whats that smell??
				} else if (pc.isMoving()) {
					//walkRight.setSpeed(Math.abs(5/speed));
					walkRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					crouchRight.restart();
					jumpRight.restart();
				} else {
					standRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					crouchRight.restart();
					jumpRight.restart();
				}
				break;
			}
		}
	}
	
	public void playSounds(PlayerCharacter pc) {
		if(pc.isJumping() && !jumping) {
			jumping = true;
			jumpSound.play();
		} else if(!pc.isJumping()) {
			jumping = false;
		}
		if(pc.isInWater() && !inWater) {
			inWater = true;
			waterSplashSound.play();
		} else if(!pc.isInWater()) {
			inWater = false;
		}
	}
}
