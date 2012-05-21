package edu.chl.codenameg.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameModelTest {

	@Test
	public final void testStartGame() {
		GameModel gm = new GameModel();
		gm.startGame();
		assertTrue(gm.isRunning());
	}

	@Test
	public final void testRestartGame() {
		GameModel gm = new GameModel();
		gm.startGame();
		gm.restartGame();
		assertTrue(gm.isRunning());
	}

	@Test
	public final void testPauseGame() {
		GameModel gm = new GameModel();
		gm.startGame();
		boolean started = gm.isRunning();
		gm.pauseGame(gm.getWorld());
		boolean paused = !gm.isRunning();
		assertTrue(started && paused);
	}

	@Test
	public final void testEndGame() {
		GameModel gm = new GameModel();
		gm.startGame();
		gm.endGame();
		assertTrue(!gm.isRunning());
	}

	@Test
	public final void testSelectLevel() {
		GameModel gm = new GameModel();
		gm.selectLevel(2);
		boolean changedLevel = gm.getSelectedLevel() == 2;
		assertTrue(changedLevel);
	}

	@Test
	public final void testUpdate() {
		GameModel gm = new GameModel();
		gm.startGame();
		boolean started = gm.isRunning();
		assertTrue(started);
	}

}
