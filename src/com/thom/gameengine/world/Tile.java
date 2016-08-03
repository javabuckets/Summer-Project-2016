package com.thom.gameengine.world;

import com.thom.gameengine.gameobject.GameObject;
import com.thom.gameengine.gameobject.GameObjectCollider;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
@SuppressWarnings("serial")
public class Tile extends GameObject
{
	private boolean hasCollider = false;
	private GameObjectCollider collider = null;
	
	private TilePos tilePosition;
	
	private String tileType;

	public Tile(TilePos tilePos, GameObjectCollider collider, String type)
	{
		this.setTilePosition(tilePos);
		this.addCollider(collider);
		this.setTileTypeName(type);
	}
	
	public Tile(TilePos tilePos, String type)
	{
		this(tilePos, null, type);
	}
	
	public boolean isCollidable() 
	{
		return hasCollider;
	}
	
	public GameObjectCollider getCollider() 
	{
		return collider;
	}
	
	public Tile addCollider(GameObjectCollider collider)
	{
		if (collider != null)
		{
			this.collider = collider;
			this.hasCollider = true;
			return this;
		}
		return this;
	}
	
	public void setTilePosition(TilePos pos)
	{
		this.tilePosition = pos;
	}
	
	public TilePos getTilePosition()
	{
		return tilePosition;
	}

	public String getTileTypeName() 
	{
		return tileType;
	}

	public void setTileTypeName(String name) 
	{
		this.tileType = name;
	}
}