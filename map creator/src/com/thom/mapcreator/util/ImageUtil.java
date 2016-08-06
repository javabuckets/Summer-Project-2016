package com.thom.mapcreator.util;

import java.awt.image.BufferedImage;

/**
 * @author Thomas Boel Micheelsen
 * @since 06-08-2016
 */
public class ImageUtil 
{
	public int x, y;
	public int[][] pixels;
	
	public ImageUtil(BufferedImage img) 
	{
		x = img.getWidth();
		y = img.getHeight();
		pixels = new int[x][y];
		
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				pixels[i][j] = img.getRGB(i, j);
			}
		}
	}
	
	public int getRGB(int x, int y)
	{
		return pixels[x][y];
	}
}