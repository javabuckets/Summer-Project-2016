package com.thom.gameengine.gameobjects;

import javax.swing.ImageIcon;

import com.thom.gameengine.gui.Label;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.Sprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class GameObject extends Label
{
	public GameObject()
	{
		super();
	}
	
	public GameObject(ImageIcon imageIcon) 
	{
		super(imageIcon);
	}
	
	public GameObject(Sprite sprite) 
	{
		super();
	}
	
	public GameObject(AnimatedSprite sprite) 
	{
		super();
	}
}