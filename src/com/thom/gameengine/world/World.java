package com.thom.gameengine.world;

import java.util.ArrayList;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
public class World 
{
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	
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
	
	public Tile getTileAt(TilePos pos)
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
}
