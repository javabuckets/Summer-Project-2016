package com.thom.gameengine.zTesting;

import java.awt.Dimension;

import com.thom.gameengine.Game2D;
import com.thom.gameengine.gametype.GameType;

@SuppressWarnings("serial")
public class TestGame extends Game2D
{
	public TestGame() 
	{
		super(new Dimension(800, 800));
	}
	

	public GameType getGameType() 
	{
		return GameType.BIRDVIEW;
	}
	
	public static void main(String args[])
	{
		TestGame testGame = new TestGame();
		testGame.setVisible(true);
	}


	@Override
	public void handleKeyBinds() {
	}
}