package edu.chl.codenameg.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	List<Entity> entities;
	
	public World() {
		
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public List<Entity> getEntities() {
		return new ArrayList<Entity>();
	}
	
	public Camera getCamera() {
		return new Camera();
	}
	
	public void update() {
		for(Entity e : this.getEntities()) {
			e.update();
		}
	}
	
}
