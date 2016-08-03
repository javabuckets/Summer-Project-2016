package com.thom.gameengine.sprite;

import java.util.ArrayList;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class AnimatedSprite extends Sprite
{
	private ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
	
	public AnimatedSprite(SpriteSheet spritesheet, int x, int y, int u, int v) 
	{
		super(spritesheet, x, y, u, v);
		this.spritesheet = spritesheet;
		initializeSpriteList();
	}

	public AnimatedSprite(SpriteSheet spritesheet, int row, int column)
	{
		this(spritesheet, row * spritesheet.getSpriteSizes().width, column * spritesheet.getSpriteSizes().height, spritesheet.getSpriteSizes().width, spritesheet.getSpriteSizes().height);
		setRow(row);
		setColumn(column);
	}
	
	private void initializeSpriteList() 
	{
		for (int i = 0; i < getSpriteSheet().getSpriteSheetImage().getWidth(); i+=getSpriteSheet().getSpriteSizes().width)
		{
			for (int j = 0; j < getSpriteSheet().getSpriteSheetImage().getHeight(); j+=getSpriteSheet().getSpriteSizes().height)
			{
				addSprite(new Sprite(getSpriteSheet(), i, j, getSpriteSheet().getSpriteSizes().width, getSpriteSheet().getSpriteSizes().height));
			}
		}
	}
	
	public void setSprite(Sprite sprite)
	{
		setIcon(sprite.getIcon());
	}

	public ArrayList<Sprite> getSpriteList() 
	{
		return spriteList;
	}

	public void setSpriteList(ArrayList<Sprite> spriteList) 
	{
		this.spriteList = spriteList;
	}
	
	public void addSprite(Sprite sprite)
	{
		this.spriteList.add(sprite);
	}
	
	public void replaceSprite(Sprite sprite, int index)
	{
		this.spriteList.set(index, sprite);
	}
}