package com.thom.mapcreator.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 07-08-2016
 */
public class SaveLoadAction implements ActionListener 
{
	String action;
	World world;
	
	public SaveLoadAction(String action, World world) 
	{
		this.action = action;
		this.world = world;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch (action) 
		{
		case "SAVE":
			if (world.getTileIconList().size() > 0)
			{
				world.getTileIconList().clear();
			}
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileIconList().add(world.getTileList().get(i).getIcon());
				System.out.println(world.getTileList().get(i).getIcon().toString());
			}
			break;
		case "LOAD":
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).setIcon(world.getTileIconList().get(i));
			}
			break;
		}
	}
}