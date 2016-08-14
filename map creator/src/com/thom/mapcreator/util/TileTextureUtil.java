package com.thom.mapcreator.util;

import com.thom.mapcreator.gui.ImageHandler;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
public class TileTextureUtil 
{
	private static String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	
	public static CustomImageIcon getSpriteFromTextureName(String texture) 
	{
		CustomImageIcon icon = new CustomImageIcon(ImageHandler.getImage(assetsPath + "gamesprite.png").getSubimage(Integer.valueOf(texture.substring(0, texture.indexOf(','))), Integer.valueOf(texture.substring(texture.indexOf(',')+1, texture.length())), 16, 16));
		icon.setLocalPath(assetsPath + "gamesprite.png");
		return icon;
	}
}