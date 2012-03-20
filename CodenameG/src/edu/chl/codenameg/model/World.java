package edu.chl.codenameg.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	List<Entity> entities;
	
	public World() {
		this.entities = new ArrayList<Entity>();
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public List<Entity> getEntities() {
		return new ArrayList<Entity>(this.entities);
	}
	
	public Camera getCamera() {
		return new Camera();
	}
	
	public void update(int elapsedTime) {
		for(Entity e : this.getEntities()) {
			e.update(elapsedTime);
			/*if(this.getCollideList(e).size()) {
				
			}*/
		}
		
	}
	
	/*private List<Entity> getCollideList(Entity e) {
		for(Entity )
	}*/
	
}
