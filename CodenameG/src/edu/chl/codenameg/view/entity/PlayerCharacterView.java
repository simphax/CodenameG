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

	public PlayerCharacterView() {
		try {
			spriteSheet = new SpriteSheet("res/character_lr.png", 64, 64,Color.white);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		crouchLeft = new Animation();
		for (int i = 15; i > 1; i--) {
			crouchLeft.addFrame(spriteSheet.getSprite(i, 23), 150);
		}
		jumpLeft = new Animation();
		for (int i = 15; i > 6; i--) {
			jumpLeft.addFrame(spriteSheet.getSprite(i, 25), 150);
		}
		standLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			standLeft.addFrame(spriteSheet.getSprite(i, 16), 150);
		}
		walkLeft = new Animation();
		for (int i = 15; i >= 0; i--) {
			walkLeft.addFrame(spriteSheet.getSprite(i, 17), 150);
		}
		crouchRight = new Animation();
		for (int i = 0; i < 15; i++) {
			crouchRight.addFrame(spriteSheet.getSprite(i, 7), 150);
		}
		jumpRight = new Animation();
		for (int i = 0; i <10; i++) {
			jumpRight.addFrame(spriteSheet.getSprite(i, 9), 150);
		}
		standRight = new Animation();
		for (int i = 0; i < 16; i++) {
			standRight.addFrame(spriteSheet.getSprite(i, 0), 150);
		}
		walkRight = new Animation();
		for (int i = 0; i < 16; i++) {
			walkRight.addFrame(spriteSheet.getSprite(i, 1), 150);
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
			
			switch (pc.getDirection()) {
			case LEFT:
				if (pc.isCrouching()) {
					crouchLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY() - 64 / 2 +7);
					jumpLeft.restart();
				} else if (pc.isJumping()) {
					jumpLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()+7);
					crouchLeft.restart();
				} else if (pc.isMoving()) {
					walkLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()+7);
					jumpLeft.restart();
					crouchLeft.restart();
				} else {
					standLeft.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()+7);
					crouchLeft.restart();
					jumpLeft.restart();
				}

				break;
			case RIGHT:
				if (pc.isCrouching()) {
					crouchRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY() - 64 / 2 +7);
					jumpRight.restart();
				} else if (pc.isJumping()) {
					jumpRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY() +7);
					crouchRight.restart();						//whats that smell??
				} else if (pc.isMoving()) {
					walkRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()+7);
					crouchRight.restart();
					jumpRight.restart();
				} else {
					standRight.draw(pc.getPosition().getX()
							+ (pc.getHitbox().getWidth() / 2) - 64 / 2, pc
							.getPosition().getY()+7);
					crouchRight.restart();
					jumpRight.restart();
				}
				break;
				
			}
		}
	}

}
