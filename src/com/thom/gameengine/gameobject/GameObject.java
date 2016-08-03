package com.thom.gameengine.gameobject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.thom.gameengine.zTesting.ColorIcon;

/**
 * @author Thomas Boel Micheelsen
 * @since 01-08-2016
 */
@SuppressWarnings("serial")
public class GameObject extends JLabel
{
	public GameObject(String text)
	{
		super(text);
	}
	
	public GameObject(ImageIcon icon)
	{
		super(icon);
	}
	
	public GameObject(ColorIcon icon)
	{
		super(icon);
	}
	
	public GameObject() 
	{
		this("");
	}
}