package edu.chl.codenameg.view.entity;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.view.EntityView;

public class MovingBlockView implements EntityView{
	private Image img = null;
	
	public MovingBlockView(){
		try {
			img = new Image("res/th_marioblock.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render(Entity ent, Graphics g) {
		g.drawImage(img,ent.getPosition().getX(),ent.getPosition().getY());
	}
}
