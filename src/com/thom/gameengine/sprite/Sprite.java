package com.thom.gameengine.sprite;

import javax.swing.ImageIcon;

import com.thom.gameengine.gameobject.GameObject;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
@SuppressWarnings("serial")
public class Sprite extends GameObject
{
	protected SpriteSheet spritesheet;
	private int row, column;
	
	public Sprite(SpriteSheet spritesheet, int x, int y, int u, int v) 
	{
		super(new ImageIcon(spritesheet.getSpriteSheetImage().getSubimage(x, y, u, v)));
		this.spritesheet = spritesheet;
	}
	
	public Sprite(SpriteSheet spritesheet, int row, int column)
	{
		this(spritesheet, row * spritesheet.getSpriteSizes().width, column * spritesheet.getSpriteSizes().height, spritesheet.getSpriteSizes().width, spritesheet.getSpriteSizes().height);
		setRow(row);
		setColumn(column);
	}
	
	public SpriteSheet getSpriteSheet()
	{
		return spritesheet;
	}
	
	public int getRow() 
	{
		return row;
	}

	public void setRow(int row) 
	{
		this.row = row;
	}

	public int getColumn() 
	{
		return column;
	}

	public void setColumn(int column) 
	{
		this.column = column;
	}
}