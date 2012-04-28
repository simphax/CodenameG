package edu.chl.codenameg.model;

import edu.chl.codenameg.model.entity.PlayerCharacter;
public class Camera {
	private int width = 500;
	private int height = 600;
	private float camerax = 0;
	private float cameray;
	private World world;
	private PlayerCharacter pc;

	public Camera(World world) {
		this.world = world;
	}
	
	public float getX(){
		return camerax;
	}
	public float getY(){
		return cameray;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public void update() {
		this.update(10);
	}
	
	public void update(int elapsedTime) {
		for (Entity e : world.getEntities()){
			if (e instanceof PlayerCharacter){
				this.pc = (PlayerCharacter)e;	
			}
		}
		if (pc.isCrouching()){		//TODO whats that smell?
			this.camerax = (pc.getPosition().getX()-this.getWidth()/2);
			this.cameray = (pc.getPosition().getY()-this.getHeight()/2-25);	
		}else{
			this.camerax = (pc.getPosition().getX()-this.getWidth()/2);
			this.cameray = (pc.getPosition().getY()-this.getHeight()/2);
		}
		
	}
	
}

