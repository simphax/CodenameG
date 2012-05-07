package edu.chl.codenameg.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.controller.GameController;

public class GameApp {

	public static void main(String[] args) {
		AppGameContainer agc = null;
		GameController controller = new GameController();
		
		try {
			agc = new AppGameContainer(controller,500,500,false);
			agc.setTargetFrameRate(60);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	

}
