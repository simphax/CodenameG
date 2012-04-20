package edu.chl.codenameg.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class TestView {
	
	private GameModel model;
	private JPanel panel;
	private JFrame jf;
	
	public TestView(final GameModel model) {
		
		jf = new JFrame();
		jf.setSize(new Dimension(400,400));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				for(Entity e : model.getWorld().getEntities()) {
					g.setColor(Color.blue);
					g.fillRect((int)(e.getPosition().getX()+0.5), (int)(e.getPosition().getY()+0.5), e.getHitbox().getWidth(), e.getHitbox().getHeight());
				}
			}
		};
		jf.add(this.panel);
		
		this.model = model;
	}
	
	public void addKeyListener(KeyListener kl) {
		jf.addKeyListener(kl);
	}
	
	public void repaint() {
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
	}
	
}
