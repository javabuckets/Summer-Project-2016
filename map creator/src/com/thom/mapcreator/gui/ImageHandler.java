package com.thom.mapcreator.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thom.mapcreator.util.CustomImageIcon;
import com.thom.mapcreator.util.ImageUtil;

/**
 * @author Thomas Boel Micheelsen
 * @since 02-07-2016
 */
public class ImageHandler 
{
	public static BufferedImage getImage(String path)
	{
		File file = new File(path);
		BufferedImage img = null;
		
		try 
		{
			img = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static CustomImageIcon getIcon(String localPath)
	{
		return new CustomImageIcon(localPath);
	}
	
	public static boolean compareImages(BufferedImage img1, BufferedImage img2)
	{
		ImageUtil imgUtil1 = new ImageUtil(img1);
		ImageUtil imgUtil2 = new ImageUtil(img2);
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				if (imgUtil1.pixels[i][j] == imgUtil2.pixels[i][j])
				{
					if (i == 15 && j == 15)
						return true;
				}
				else
					return false;
			}
		}
		return false;
	}
}