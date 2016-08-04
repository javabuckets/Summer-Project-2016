package com.thom.mapcreator.gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.thom.mapcreator.MapCreator;
import com.thom.mapcreator.worldobjects.Tile;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
public class TileMouseListener implements MouseListener 
{
	Tile tile;
	World world;
	
	public TileMouseListener(Tile tile, World world) 
	{
		this.tile = tile;
		this.world = world;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		if (MapCreator.regionSelectorSetting != 0)
		{
			if (MapCreator.regionSelectorSetting == 2)
			{
				world.getRegionSelectionList().add(tile);
				regionSelect();
			}
			else
			{
				world.getRegionSelectionList().add(tile);
				MapCreator.regionSelectorSetting++;
			}
		}
		else if (MapCreator.regionSelectorSetting == 0)
			tile.attachTexture(MapCreator.getTextureSelected());
	}
	
	private void regionSelect() 
	{
		int scenario = getScenario();
		
		Point tile1 = world.getRegionSelectionList().get(0).getTilePosition();
		Point tile2 = world.getRegionSelectionList().get(1).getTilePosition();
		
		if (scenario == 1)
		{
			for (int x = tile2.x; x < tile1.x; x++)
			{
				for (int y = tile2.y; y < tile1.y; y++)
				{
					tile.attachTexture(MapCreator.getTextureSelected());
				}
			}
		}
		else if (scenario == 2)
		{
			
		}
		else if (scenario == 3)
		{
			
		}
		else if (scenario == 4)
		{
			
		}
	}
	
	private int getScenario()
	{
		Point tile1 = world.getRegionSelectionList().get(0).getTilePosition();
		Point tile2 = world.getRegionSelectionList().get(1).getTilePosition();
		
		if (tile1.x > tile2.x)
		{
			if (tile1.y > tile2.y)
				return 1;
			else
				return 3;
		}
		else
		{
			if (tile1.y > tile2.y)
				return 2;
			else
				return 4;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}