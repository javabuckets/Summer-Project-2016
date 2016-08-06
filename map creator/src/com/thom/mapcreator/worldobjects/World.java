package com.thom.mapcreator.worldobjects;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
public class World 
{
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private ArrayList<JLabel> tileInfoList = new ArrayList<JLabel>();
	
	public World() 
	{
		
	}
	
	public ArrayList<Tile> getTileList() 
	{
		return tileList;
	}

	public void setTileList(ArrayList<Tile> tileList) 
	{
		this.tileList = tileList;
	}
	
	/**
	 * @return Returns the Tile at a given TilePos.
	 */
	public Tile getTileAt(Point pos)
	{
		for (int i = 0; i < tileList.size(); i++)
		{
			if (tileList.get(i).getTilePosition() == pos)
			{
				return tileList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Replaces the tile at a given TilePos to the specified Tile.
	 * @since 02-08-2016
	 */
	public void setTile(Point tilePos, Tile tile)
	{
		for (int i = 0; i < tileList.size(); i++)
		{
			if (tileList.get(i).getTilePosition() == tilePos)
			{
				tileList.set(i, tile);
			}
		}
	}

	public ArrayList<JLabel> getTileInfoList() 
	{
		return tileInfoList;
	}
}