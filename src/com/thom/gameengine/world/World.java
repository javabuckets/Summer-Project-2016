package com.thom.gameengine.world;

import java.util.ArrayList;

import com.thom.gameengine.entity.Entity;
import com.thom.gameengine.utility.LogHelper;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
public class World 
{
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	public World() 
	{
		
	}
	
	public ArrayList<Entity> getEntityList()
	{
		return entityList;
	}
	
	public void addEntityToEntityList(Entity entity)
	{
		entityList.add(entity);
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
	
	/**
	 * Replaces the tile at a given TilePos to the specified Tile.
	 * @since 02-08-2016
	 */
	public void setTile(TilePos tilePos, Tile tile)
	{
		for (int i = 0; i < tileList.size(); i++)
		{
			if (tileList.get(i).getTilePosition() == tilePos)
			{
				LogHelper.info("Tile at " + tilePos.getX() + ", " + tilePos.getY() + " has been replaced from " + tileList.get(i).getName() + " with " + tile.getName());
				tileList.set(i, tile);
			}
		}
	}
}