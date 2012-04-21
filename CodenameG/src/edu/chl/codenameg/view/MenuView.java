package edu.chl.codenameg.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class MenuView {
	public void repaint(Graphics g) {
		g.setColor(Color.red);
		g.drawString("START GAME", 100, 100);
	}
}
