package com.thom.gameengine.spritesystem;

import javax.swing.ImageIcon;

import com.thom.gameengine.gui.Label;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
@SuppressWarnings("serial")
public class Sprite extends Label
{
	SpriteSheet spritesheet;
	
	public Sprite(SpriteSheet spritesheet, int x, int y, int u, int v) 
	{
		super(new ImageIcon(spritesheet.getSpriteSheetImage().getSubimage(x, y, u, v)));
		this.spritesheet = spritesheet;
	}
	
	public Sprite(SpriteSheet spritesheet, int row, int column)
	{
		this(spritesheet, row * spritesheet.getSpriteSizes().width, column * spritesheet.getSpriteSizes().height, spritesheet.getSpriteSizes().width, spritesheet.getSpriteSizes().height);
	}
	
	public SpriteSheet getSpriteSheet() 
	{
		return spritesheet;
	}
}