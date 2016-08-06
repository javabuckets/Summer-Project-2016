package com.thom.mapcreator.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.thom.mapcreator.util.MapCreatorUtil;

/**
 * @author Thomas Boel Micheelsen
 * @since 05-08-2016
 */
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