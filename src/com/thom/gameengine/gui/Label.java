package com.thom.gameengine.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
@SuppressWarnings("serial")
public class Label extends JLabel
{
	public Label() 
	{
		super("");
	}
	
	public Label(String text)
	{
		super(text);
	}
	
	public Label(ImageIcon icon)
	{
		super(icon);
	}
}