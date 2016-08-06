package com.thom.mapcreator.util;

import com.thom.mapcreator.MapCreator;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
public class MapCreatorUtil 
{
	private static String textureSelected = "0,0";
	
	private static boolean isFreehand = false;
	public static boolean isFPressed = false;
	
	public static String getTextureSelected()
	{
		return textureSelected;
	}
	
	public static void setTextureSelected(String text)
	{
		textureSelected = text;
		MapCreator.tps.setText("Selected Tile Painter: " + textureSelected);
	}

	public static boolean isFreehand() 
	{
		return isFreehand;
	}

	public static void setFreehand(boolean isFreehand) 
	{
		MapCreatorUtil.isFreehand = isFreehand;
	}
}