package com.thom.gameengine.spritesystem;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.thom.gameengine.gui.Label;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class SpriteSheet extends Label
{
	private BufferedImage spritesheet;
	private Dimension spriteSizes;
	
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