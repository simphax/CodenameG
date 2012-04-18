package edu.chl.codenameg.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;
import org.newdawn.slick.tests.ParticleTest;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.controller.SlickGame;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class TestView {
	
	private GameModel model;
	private JPanel panel;
	private JFrame jf;
	
	public TestView(final GameModel model) {
		AppGameContainer agc = null;
		try {
			agc = new AppGameContainer(new SlickGame("TEST"),1280,800,true);
			agc.start();
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(agc != null) {
			
		}
		
		jf = new JFrame();
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
	
	public void addKeyListener(KeyListener kl) {
		jf.addKeyListener(kl);
	}
	
	public void repaint() {
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
	}
	
}
