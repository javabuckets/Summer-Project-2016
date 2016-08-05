package com.thom.mapcreator;

public class MapCreatorUtil 
{
	private static String textureSelected = "GRASS";
	
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