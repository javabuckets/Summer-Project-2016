package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.gui.GuiScreen;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class OpenGuiAction extends GameAction
{
	private GuiScreen gui;
	private GuiScreen currentGui;
	
	public <T extends GuiScreen> OpenGuiAction(GuiScreen gui, GuiScreen currentGui) 
	{
		this.gui = gui;
		this.currentGui = currentGui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		gui.setVisible(true);
		gui.setLocation(currentGui.getLocation().x, currentGui.getLocation().y);
		currentGui.dispose();
	}
}