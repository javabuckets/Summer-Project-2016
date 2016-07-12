package com.thom.gameengine.entities;

import java.awt.Point;

import com.thom.gameengine.gui.Label;
import com.thom.gameengine.spritesystem.AnimatedSprite;

@SuppressWarnings("serial")
public class Entity extends Label
{
	private AnimatedSprite sprite;
	private Point position;
	
	public Entity(AnimatedSprite sprite) 
	{
		super();
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
}