package com.thom.mapcreator.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thom.mapcreator.MapCreator;
import com.thom.mapcreator.worldobjects.World;

public class RegionFillAction implements ActionListener 
{
	World world;
	
	public RegionFillAction(World world) 
	{
		this.world = world;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if (MapCreator.regionSelectorSetting == 0)
		{
			MapCreator.regionSelectorSetting++;
		}
	}
}
