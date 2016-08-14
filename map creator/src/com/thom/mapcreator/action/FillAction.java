package com.thom.mapcreator.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thom.mapcreator.util.CustomImageIcon;
import com.thom.mapcreator.util.MapCreatorUtil;
import com.thom.mapcreator.util.TileTextureUtil;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 03-08-2016
 */
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
			CustomImageIcon imgIcon = TileTextureUtil.getSpriteFromTextureName(MapCreatorUtil.getTextureSelected());
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).attachTexture(MapCreatorUtil.getTextureSelected(), imgIcon);
				lastFill = MapCreatorUtil.getTextureSelected();
			}
		}
	}
}