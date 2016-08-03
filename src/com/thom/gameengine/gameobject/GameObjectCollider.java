package com.thom.gameengine.gameobject;

import java.awt.Dimension;
import java.awt.Point;

/**
 * @author Thomas Boel Micheelsen
 * @since 01-08-2016
 */
@SuppressWarnings("serial")
public class GameObjectCollider extends GameObject
{
	private GameObject mother;
	private Dimension collisionBox;
	private Point collisionBoxPosition;
	
	public GameObjectCollider(GameObject gameObject, Dimension collisionBoxSize, Point collisionBoxPosition)
	{
		super();
		this.setGameObject(gameObject);
		this.setCollisionBox(collisionBoxSize);
		this.setCollisionBoxPosition(collisionBoxPosition);
	}

	public GameObject getGameObject() 
	{
		return mother;
	}

	public void setGameObject(GameObject mother) 
	{
		this.mother = mother;
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