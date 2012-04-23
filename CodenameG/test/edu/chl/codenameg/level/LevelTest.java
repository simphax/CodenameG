package edu.chl.codenameg.level;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.chl.codenameg.model.Entity;
import edu.chl.codenameg.model.levels.*;


public class LevelTest {


	@Test
	public void testGetEnteties(){
		LevelOne l1 = new LevelOne();
		ArrayList<Entity> al= (ArrayList<Entity>)l1.getListOfEnteties();
		assertTrue(al.isEmpty());
	}
	@Test
	public void testSetAmountOfPlayers(){
		Level l1 = new LevelOne();
		l1.setAmountOfPlayers(2);
		int aop1 = l1.getAmountOfPlayers();
		l1.setAmountOfPlayers(1);
		int aop2 = l1.getAmountOfPlayers();
		assertTrue(aop1<aop2);
	}

}

