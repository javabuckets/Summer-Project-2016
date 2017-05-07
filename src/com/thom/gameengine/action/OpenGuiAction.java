package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.gui.GuiScreen;

/**
 * @author Thomas Boel Micheelsen
 * @since 07-05-2017
 */
public class OpenGuiAction extends GameAction
{
	private Class<GuiScreen> gui;
	private GuiScreen currentGui;
	
	public OpenGuiAction(Class<? extends GuiScreen> clazz, GuiScreen currentGui) 
	{
		this.gui = (Class<GuiScreen>) clazz;
		this.currentGui = currentGui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			GuiScreen gs;
			gs = gui.newInstance();		
			gs.setVisible(true);
			gs.setLocation(currentGui.getLocation().x, currentGui.getLocation().y);
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