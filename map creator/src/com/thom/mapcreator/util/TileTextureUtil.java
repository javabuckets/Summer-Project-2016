package com.thom.mapcreator.util;

import javax.swing.ImageIcon;

import com.thom.mapcreator.gui.ImageHandler;

public class TileTextureUtil 
{
	private static String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	
	public static ImageIcon getSpriteFromTextureName(String texture) 
	{
		return ImageHandler.getIcon(assetsPath + texture.toLowerCase()+".png");
	}
	
}