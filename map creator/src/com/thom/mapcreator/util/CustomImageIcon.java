package com.thom.mapcreator.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author Thomas Boel Micheelsen
 * @since 08-08-2016
 */
@SuppressWarnings("serial")
public class CustomImageIcon extends ImageIcon
{
	String localPath;
	
	public CustomImageIcon(Image img) 
	{
		super(img);
	}
	
	public CustomImageIcon(String path)
	{
		super(path);
		this.localPath = path;
	}
	
	public void setLocalPath(String path)
	{
		this.localPath = path;
	}
	
	public String getLocalPath()
	{
		return localPath;
	}
}