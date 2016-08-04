package com.thom.mapcreator.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.thom.mapcreator.MapCreator;
import com.thom.mapcreator.worldobjects.Tile;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
public class TileMouseListener implements MouseListener 
{
	Tile tile;
	
	public TileMouseListener(Tile tile) 
	{
		this.tile = tile;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		tile.attachTexture(MapCreator.textureSelected);
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