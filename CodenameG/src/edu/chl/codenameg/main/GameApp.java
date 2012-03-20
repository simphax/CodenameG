package edu.chl.codenameg.main;

import java.awt.Point;

import javax.swing.JFrame;

import edu.chl.codenameg.controller.GameController;
import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.GameModel;
import edu.chl.codenameg.model.Hitbox;
import edu.chl.codenameg.model.World;
import edu.chl.codenameg.model.entity.Block;
import edu.chl.codenameg.model.entity.PlayerCharacter;
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
		
		Block block = new Block();
		block.setPosition(new Point(100,200));
		block.setHitbox(new Hitbox(200,20));
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setPosition(new Point(200,50));
		
		world.add(block);
		world.add(pc);
		
		model.startGame(world);
		
		model.update(10);
		view.repaint();
		model.update(10);
		view.repaint();
		
	}
	
	

}
