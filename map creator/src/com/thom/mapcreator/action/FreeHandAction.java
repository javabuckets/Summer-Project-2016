package com.thom.mapcreator.action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.thom.mapcreator.MapCreatorUtil;
import com.thom.mapcreator.worldobjects.World;

public class FreeHandAction implements ActionListener 
{
	JButton button;
	World world;
	
	public FreeHandAction(JButton button, World world) 
	{
		this.button = button;
		this.world = world;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if (!MapCreatorUtil.isFreehand()) 
		{
			MapCreatorUtil.setFreehand(true);
			button.setBackground(Color.cyan);
		}
		else
		{
			MapCreatorUtil.setFreehand(false);
			button.setBackground(null);
		}
	}
}