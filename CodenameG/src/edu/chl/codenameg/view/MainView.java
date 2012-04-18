package edu.chl.codenameg.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.AnimationTest;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.view.entity.BasicEntityView;

public class MainView {
	
	GameView gv;
	MenuView mv;
	LevelMenuView lmv;
	PauseMenuView pmv;
	
	public MainView(final GameModel model) {
		AppGameContainer agc = null;
		try {
			agc = new AppGameContainer(new AnimationTest(),500,500,false);
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
		
		jf.add(new Gameview(model));
	}
	
	public void addKeyListener(KeyListener kl) {
		jf.addKeyListener(kl);
	}
	
	public void repaint() {
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
	}
	
	
	
}
