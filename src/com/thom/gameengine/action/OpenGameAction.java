package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.Game;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.soundsystem.SoundHandler;

/**
 * @author Thomas Boel Micheelsen
 * @since 05-05-2017
 */
public class OpenGameAction extends GameAction
{
	private Class<Game> game;
	private GuiScreen currentGui;

	public OpenGameAction(Class<? extends Game> clazz, GuiScreen currentGui) 
	{
		this.game = (Class<Game>) clazz;
		this.currentGui = currentGui;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			Game g = game.newInstance();
			g.setVisible(true);
			g.setLocation(currentGui.getLocation().x, currentGui.getLocation().y);
			SoundHandler.stopAllSounds();
			currentGui.dispose();
		} 
		catch (InstantiationException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IllegalAccessException e1) 
		{
			e1.printStackTrace();
		}
	}
}