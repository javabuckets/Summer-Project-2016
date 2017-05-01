package com.thom.gameengine.animation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class AnimationSequence 
{
	List<ImageIcon> sprites = new ArrayList<ImageIcon>();
	ImageIcon currentSprite;
	
	public AnimationSequence() 
	{
		
	}
	
	public void addSequence(ImageIcon image) 
	{
		sprites.add(image);
	}
	
	public void setCurrentSprite(ImageIcon imageIcon)
	{
		this.currentSprite = imageIcon;
	}
}