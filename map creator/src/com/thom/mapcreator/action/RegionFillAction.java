package com.thom.mapcreator.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
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
		
	}
}
