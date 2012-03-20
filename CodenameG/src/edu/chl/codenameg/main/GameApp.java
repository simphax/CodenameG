package edu.chl.codenameg.main;

import javax.swing.JFrame;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.World;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.view.GameView;

public class GameApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameModel model = new GameModel();

		GameView view = new GameView(model);

		GameController controller = new GameController(model,view);
		
		World world = new World();
		world.add(new Block());
		
		model.startGame(world);
		
		model.update(10);
		view.repaint();
		
	}
	
	

}
