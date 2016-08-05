package com.thom.mapcreator.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thom.mapcreator.MapCreatorUtil;
import com.thom.mapcreator.worldobjects.World;

public class FillAction implements ActionListener 
{
	World world;
	private String lastFill = "NULL";
	
	public FillAction(World world) 
	{
		this.world = world;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if (lastFill != MapCreatorUtil.getTextureSelected())
		{
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).attachTexture(MapCreatorUtil.getTextureSelected());
				lastFill = MapCreatorUtil.getTextureSelected();
			}
		}
	}
}