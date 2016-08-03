package com.thom.gameengine.player;

import com.thom.gameengine.entity.Entity;
import com.thom.gameengine.gameobject.GameObjectCollider;
import com.thom.gameengine.sprite.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 01-08-2016
 */
@SuppressWarnings("serial")
public class Player extends Entity
{
	private GameObjectCollider collider;
	
	public Player(AnimatedSprite sprite)
	{
		super(sprite);
	}
	
	public GameObjectCollider getCollider()
	{
		return collider;
	}
	
	public void setCollider(GameObjectCollider collider) 
	{
		this.collider = collider;
	}
}