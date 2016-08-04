package com.thom.mapcreator.worldobjects;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.thom.mapcreator.util.TileTextureUtil;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
@SuppressWarnings("serial")
public class Tile extends JLabel
{
	private Point tilePosition;
	private String textureAttached = "NULL";
	
	public Tile(Point pos) 
	{
		super();
		setBounds(pos.x, pos.y, 16, 16);
		setTilePosition(pos);
		setTileName();
	}
	
	private void setTileName() 
	{
		setName(";"+tilePosition.x + "," + tilePosition.y+","+textureAttached+";");
	}

	public void setSprite(ImageIcon texture)
	{
		this.setIcon(texture);
	}

	public Point getTilePosition() 
	{
		return tilePosition;
	}

	public void setTilePosition(Point tilePosition) 
	{
		this.tilePosition = tilePosition;
	}

	public String getAttachedTexture() 
	{
		return textureAttached;
	}

	public void attachTexture(String texture) 
	{
		this.textureAttached = texture;
		setSprite(TileTextureUtil.getSpriteFromTextureName(texture));
		setTileName();
	}
	
	public String getLocalizedName()
	{
		String s = getName().replace(";", "");
		return s;
	}
}