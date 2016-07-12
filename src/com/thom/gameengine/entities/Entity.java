package com.thom.gameengine.entities;

import java.awt.Point;

import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class Entity extends AnimatedSprite
{
	private AnimatedSprite sprite;
	private Point position;
	
	public Entity(AnimatedSprite sprite) 
	{
		super(sprite.getSpriteSheet(), sprite.getRow(), sprite.getColumn());
		this.setSprite(sprite);
	}

	public AnimatedSprite getSprite() 
	{
		return sprite;
	}

	public void setSprite(AnimatedSprite sprite) 
	{
		this.sprite = sprite;
	}
	
	public Point getPosition() 
	{
		return position;
	}

	public void setPosition(Point position) 
	{
		this.position = position;
	}	
	
	public void setPosition(int x, int y) 
	{
		this.setPosition(new Point(x, y));
	}	
}