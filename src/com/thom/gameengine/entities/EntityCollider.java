package com.thom.gameengine.entities;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.gameobjects.GameObject;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class EntityCollider extends GameObject
{
	private Entity entity;
	private Dimension collisionBox;
	private Point collisionBoxPosition;
	
	public EntityCollider(Entity entity, Dimension collisionBoxSize, Point collisionBoxPosition) 
	{
		super();
		this.setEntity(entity);
		this.setCollisionBox(collisionBox);
		this.setCollisionBoxPosition(collisionBoxPosition);
	}

	public Entity getEntity() 
	{
		return entity;
	}

	public void setEntity(Entity entity) 
	{
		this.entity = entity;
	}

	public Dimension getCollisionBox() 
	{
		return collisionBox;
	}

	public void setCollisionBox(Dimension collisionBox) 
	{
		this.collisionBox = collisionBox;
	}

	public Point getCollisionBoxPosition() 
	{
		return collisionBoxPosition;
	}

	public void setCollisionBoxPosition(Point collisionBoxPosition) 
	{
		this.collisionBoxPosition = collisionBoxPosition;
	}
}