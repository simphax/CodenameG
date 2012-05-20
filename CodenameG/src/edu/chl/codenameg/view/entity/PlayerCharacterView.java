package edu.chl.codenameg.view.entity;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	private SpriteSheet		spriteSheet;
	private Animation		walkLeft;
	private Animation 		jumpLeft;
	private Animation 		crouchLeft;
	private Animation 		standLeft;
	private Animation 		walkRight;
	private Animation 		jumpRight;
	private Animation 		crouchRight;
	private Animation 		standRight;
	private List<GSound>	hurtSounds;
	private List<GSound> 	jumpSounds;
	private List<GSound> 	stepSounds;
	private List<GSound> 	crouchSounds;
	private List<GSound> 	waterSplashSounds;
	private boolean 		dead;
	private Animation		lastAnimation;
	private boolean 		jumping;
	private boolean 		walking;
	private boolean 		crouching;
	private boolean 		inWater;
	
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
		lastAnimation = null;
		jumping 	= false;
		inWater 	= false;
		
		try {
			spriteSheet = new SpriteSheet("res/character_lr.png", 64, 64,Color.white);
			
			hurtSounds = loadSounds("res/sounds/hurt");
			jumpSounds = loadSounds("res/sounds/jump");
			stepSounds = loadSounds("res/sounds/steps");
			crouchSounds = loadSounds("res/sounds/crouch");
			waterSplashSounds = loadSounds("res/sounds/water_splash");
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		crouchLeft = new Animation();
		for (int i = 15; i > 1; i--) {
			crouchLeft.addFrame(spriteSheet.getSprite(i, 23), 10);
		}
		jumpLeft = new Animation();
		for (int i = 15; i > 6; i--) {
			jumpLeft.addFrame(spriteSheet.getSprite(i, 25), 10);
		}
		standLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			standLeft.addFrame(spriteSheet.getSprite(i, 16), 40);
		}
		walkLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			walkLeft.addFrame(spriteSheet.getSprite(i, 17), 10);
		}
		crouchRight = new Animation();
		for (int i = 0; i < 15; i++) {
			crouchRight.addFrame(spriteSheet.getSprite(i, 7), 10);
		}
		jumpRight = new Animation();
		for (int i = 0; i <10; i++) {
			jumpRight.addFrame(spriteSheet.getSprite(i, 9), 10);
		}
		standRight = new Animation();
		for (int i = 0; i < 16; i++) {
			standRight.addFrame(spriteSheet.getSprite(i, 0), 40);
		}
		walkRight = new Animation();
		for (int i = 0; i < 16; i++) {
			walkRight.addFrame(spriteSheet.getSprite(i, 1), 10);
		}
		jumpRight.setLooping(false);
		crouchRight.setLooping(false);
		jumpLeft.setLooping(false);
		crouchLeft.setLooping(false);
	}
	
	private List<GSound> loadSounds(String path) throws SlickException {
		List<GSound> sounds = new ArrayList<GSound>();
		File soundsDir = new File(path);
		for(String s : soundsDir.list()) {
			sounds.add(new GSound(path + "/"+s));
		}
		
		return sounds;
	}

	@Override
	public void render(Entity ent, Graphics g) {
		if (ent instanceof PlayerCharacter) {
			PlayerCharacter pc = (PlayerCharacter) ent;
			//speed = ent.getVector2D().getX();
			
			this.playSounds(pc);
			
			switch (pc.getDirection()) {
			case LEFT:
				jumpRight.restart();
				crouchRight.restart();
				if (pc.isCrouching()) {
					if(lastAnimation.equals(crouchRight)){
						crouchLeft.setCurrentFrame(crouchLeft.getFrameCount()-1);
					}
					crouchLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY() - 64 / 2);	
					lastAnimation = crouchLeft;
					jumpLeft.restart();
					
				} else if (pc.isJumping()) {
					jumpLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = jumpLeft;
					crouchLeft.restart();
				} else if (pc.isMoving()) {
					//walkLeft.setSpeed(Math.abs(5/speed));
					walkLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = walkLeft;
					jumpLeft.restart();
					crouchLeft.restart();
				} else {
					standLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = standLeft;
					crouchLeft.restart();
					jumpLeft.restart();
				}

				break;
			case RIGHT:
				jumpLeft.restart();
				crouchLeft.restart();
				if (pc.isCrouching()) {
					if(lastAnimation.equals(crouchLeft)){
						crouchRight.setCurrentFrame(crouchRight.getFrameCount()-1);
						}
						crouchRight.draw(pc.getPosition().getX()
								+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
								.getPosition().getY() - 64 / 2);	
					lastAnimation = crouchRight;
					jumpRight.restart();
				} else if (pc.isJumping()) {
					jumpRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = jumpRight;
					crouchRight.restart();						//whats that smell??
				} else if (pc.isMoving()) {
					//walkRight.setSpeed(Math.abs(5/speed));
					walkRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = walkRight;
					crouchRight.restart();
					jumpRight.restart();
				} else {
					standRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2+3) - 64 / 2, pc
							.getPosition().getY()-9);
					lastAnimation = standRight;
					crouchRight.restart();
					jumpRight.restart();
				}
				break;
			}
		}
	}
	
	public void playSounds(PlayerCharacter pc) {
		if(!pc.isAlive() && !dead) {
			dead = true;
			hurtSounds.get((int)(Math.random()*hurtSounds.size())).play();
		} else if(!pc.isJumping()) {
			dead = false;
		}
		if(pc.isJumping() && !jumping) {
			jumping = true;
			jumpSounds.get((int)(Math.random()*jumpSounds.size())).play();
		} else if(!pc.isJumping() || pc.isOnGround()) {
			jumping = false;
		}
		if(pc.isMoving() && pc.isOnGround() && !walking) {
			walking = true;
			int rand = (int)(Math.random()*stepSounds.size());
			stepSounds.get(rand).play();
		} else if(!pc.isMoving() || !pc.isOnGround()) {
			walking = false;
			for(GSound sound : stepSounds) {
				sound.stop();
			}
		}
		if(pc.isCrouching() && !crouching) {
			crouching = true;
			crouchSounds.get((int)(Math.random()*crouchSounds.size())).play();
		} else if(!pc.isCrouching()) {
			crouching = false;
		}
		if(pc.isInWater() && !inWater) {
			inWater = true;
			waterSplashSounds.get((int)(Math.random()*waterSplashSounds.size())).play();
		} else if(!pc.isInWater()) {
			inWater = false;
		}
	}
}
