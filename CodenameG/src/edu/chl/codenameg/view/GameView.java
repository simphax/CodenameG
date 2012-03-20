package edu.chl.codenameg.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;

public class GameView {
	
	GameModel model;
	JFrame jf;
	
	public GameView(GameModel model) {
		this.jf = new JFrame();
		jf.setVisible(true);
		
		this.model = model;
	}
	
	public void repaint() {
		this.jf.removeAll();
		for(Entity e : model.getWorld().getEntities()) {
			JLabel jl = new JLabel();
			jl.setBackground(Color.black);
			jl.setPreferredSize(new Dimension(e.getHitbox().getWidth(),e.getHitbox().getHeight()));
			jf.add(jl);
		}
	}
	
}
