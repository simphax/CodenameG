package edu.chl.codenameg.main;

import java.awt.Point;

import javax.swing.JFrame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.Position;
import edu.chl.codenameg.model.World;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.PlayerCharacter;
import edu.chl.codenameg.view.GameView;
import edu.chl.codenameg.view.LevelView;
import edu.chl.codenameg.view.MainView;

public class GameApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameModel model = new GameModel();
		//GameView view = new MainView(model);
		AppGameContainer agc = null;
		GameController controller = new GameController(model);
		
		try {
			agc = new AppGameContainer(controller,500,600,false);
			agc.setTargetFrameRate(60);
			agc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
