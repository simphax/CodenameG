package edu.chl.codenameg.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.controller.GameController;

/**
 * This is the runnable main class that starts Romijam
 * @author ???
 *
 */
public class GameApp {

	public static void main(String[] args) {
		AppGameContainer agc = null;
		GameController controller = new GameController();
		
		try {
			// Sets the settings of the game and then starts it
			agc = new AppGameContainer(controller,500,500,false);
			agc.setTargetFrameRate(60);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
