package com.thom.gameengine.sprite;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.thom.gameengine.gameobject.GameObject;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
@SuppressWarnings("serial")
public class SpriteSheet extends GameObject
{
	private BufferedImage spritesheet;
	private Dimension spriteSizes;;
	
	/**
	 * @param spritesheet The BufferedImage that the SpriteSheet will represent.
	 * @param spriteSizes The size of each sprite to use in the SpriteSheet. Custom sizes can be used through the constructor Sprite(ss, x, y, u, v).
	 */
	public SpriteSheet(BufferedImage spritesheet, Dimension spriteSizes) 
	{
		super(new ImageIcon(spritesheet));
		this.spritesheet = spritesheet;
		this.spriteSizes = spriteSizes;
	}
	
	public SpriteSheet(BufferedImage spritesheet) 
	{
		this(spritesheet, new Dimension(16, 16));
	}
	
	public BufferedImage getSpriteSheetImage()
	{
		return this.spritesheet;
	}
	
	public Dimension getSpriteSizes()
	{
		return this.spriteSizes;
	}
	
	public Dimension getSpriteSize()
	{
		return new Dimension(getWidth(), getHeight());
	}
}