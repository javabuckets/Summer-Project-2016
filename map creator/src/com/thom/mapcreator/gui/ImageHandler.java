package com.thom.mapcreator.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	
	public static ImageIcon getIcon(String localPath)
	{
		return new ImageIcon(localPath);
	}
}