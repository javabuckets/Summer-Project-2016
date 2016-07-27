package com.thom.gameengine.player;

import com.thom.gameengine.entities.Entity;
import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
@SuppressWarnings("serial")
public class Player extends Entity
{
	private EntityCollider collider;
	
	public Player(AnimatedSprite sprite) 
	{
		super(sprite);
	}

	public EntityCollider getCollider() 
	{
		return collider;
	}

	public void setCollider(EntityCollider collider) 
	{
		this.collider = collider;
	}
}