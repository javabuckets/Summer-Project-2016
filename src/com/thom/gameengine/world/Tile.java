package com.thom.gameengine.world;

import com.thom.gameengine.gameobjects.GameObjectCollider;
import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
@SuppressWarnings("serial")
public class Tile extends AnimatedSprite
{
	private boolean containsCollisionBox = false;
	private GameObjectCollider collider = null;
	
	private TilePos tilePosition;
	
	public Tile(AnimatedSprite sprite) 
	{
		super(sprite.getSpriteSheet(), sprite.getRow(), sprite.getColumn());
	}
	
	public boolean hasCollider()
	{
		return this.containsCollisionBox;
	}
	
	public Tile addCollider(GameObjectCollider collider)
	{
		this.collider = collider;
		this.containsCollisionBox = true;
		return this;
	}

	public GameObjectCollider getCollider() 
	{
		return collider;
	}

	public TilePos getTilePosition() 
	{
		return tilePosition;
	}

	public void setTilePosition(TilePos tilePosition) 
	{
		this.tilePosition = tilePosition;
	}
}