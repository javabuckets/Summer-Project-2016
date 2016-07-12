package com.thom.gameengine.player;

import com.thom.gameengine.entities.Entity;
import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
@SuppressWarnings("serial")
public class Player extends Entity
{
	public Player(AnimatedSprite sprite) 
	{
		super(sprite);
	}
}