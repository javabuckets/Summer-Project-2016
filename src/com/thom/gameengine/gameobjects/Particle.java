package com.thom.gameengine.gameobjects;

import com.thom.gameengine.entities.Entity;
import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class Particle extends Entity
{
	private boolean isAlive = true;
	
	public Particle(AnimatedSprite sprite) 
	{
		super(sprite);
	}
	
	public boolean isAlive() 
	{
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) 
	{
		this.isAlive = isAlive;
	}
}