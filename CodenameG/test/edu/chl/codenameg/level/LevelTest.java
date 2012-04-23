package edu.chl.codenameg.level;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chl.codenameg.model.levels.*;


public class LevelTest {


	@Test
	public void testGetEnteties(){
		LevelOne l1 = new LevelOne();
		assertTrue(!l1.getListOfEntities.isEmpty() && l1.getListOfEntities.contains(Entity));
	}
	@Test
	public void testSetAmountOfPlayers(){
		Level l1 = new LevelOne();
		l1.setAmountOfPlayer(2);
		int aop1 = l1.getAmountOfPlayers();
		l1.setAmountOfPlayers(1);
		int aop2 = l1.getAmountOfPlayers();
		assertTrue(aop1<aop2);
	}

}

