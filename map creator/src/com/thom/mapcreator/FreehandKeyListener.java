package com.thom.mapcreator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FreehandKeyListener implements KeyListener 
{
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == 70)
		{
			MapCreatorUtil.isFPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == 70)
		{
			MapCreatorUtil.isFPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}