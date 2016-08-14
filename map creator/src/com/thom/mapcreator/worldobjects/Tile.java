package com.thom.mapcreator.worldobjects;

import java.awt.Point;

import javax.swing.JLabel;

import com.thom.mapcreator.util.CustomImageIcon;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
@SuppressWarnings("serial")
public class Tile extends JLabel
{
	private Point tilePosition;
	private String textureAttached = "NULL";
	private CustomImageIcon icon;
	
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

	public void attachTexture(String texture, CustomImageIcon imageIcon) 
	{
		this.textureAttached = texture;
		setImageIcon(imageIcon);
		setTileName();
	}
	
	public String getLocalizedName()
	{
		String s = getName().replace(";", "");
		return s;
	}

	public CustomImageIcon getImageIcon() 
	{
		return icon;
	}

	public void setImageIcon(CustomImageIcon icon) 
	{
		this.icon = icon;
		setIcon(icon);
	}
}