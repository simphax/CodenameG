package edu.chl.codenameg.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class GameView {
	
	private GameModel model;
	private JPanel panel;
	
	public GameView(final GameModel model) {
		JFrame jf = new JFrame();
		jf.setSize(new Dimension(400,400));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				for(Entity e : model.getWorld().getEntities()) {
					//g.setClip((int)e.getPosition().getX(), (int)e.getPosition().getY(), Integer.MAX_VALUE, Integer.MAX_VALUE);
					(new BasicEntityView()).render(e,g);
				}
			}
		};
		jf.add(this.panel);
		
		this.model = model;
	}
	
	public void repaint() {
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
	}
	
}
