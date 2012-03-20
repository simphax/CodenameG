package edu.chl.codenameg.model;

public class Hitbox {
	

	private int width;
	private int height;
	
	public Hitbox(Hitbox hb) {
		this.setWidth(hb.width);
		this.setHeight(hb.height);
	}
	public Hitbox(int w, int h){
		this.width = w;
		this.height = h;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hitbox other = (Hitbox) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
