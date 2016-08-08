package com.thom.mapcreator.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.thom.mapcreator.util.MapCreatorUtil;
import com.thom.mapcreator.util.TileTextureUtil;
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
		attachTextureToTile(tile);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		if (MapCreatorUtil.isFreehand() && MapCreatorUtil.isFPressed)
		{
			attachTextureToTile(tile);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
	
	private void attachTextureToTile(Tile tile)
	{
		tile.attachTexture(MapCreatorUtil.getTextureSelected(), TileTextureUtil.getSpriteFromTextureName(MapCreatorUtil.getTextureSelected()));
	}
}