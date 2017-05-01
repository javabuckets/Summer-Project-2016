package com.thom.gameengine.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class Button extends Label
{
	public ImageIcon idle, hover;
	
	public Button(ImageIcon icon)
	{
		super(icon);
		addMouseHoverListener();
	}
	
	public Button(String text) 
	{
		super(text);
		addMouseHoverListener();
	}
	
	public Button()
	{
		this("");
	}
	
	public Button addIdleState(ImageIcon image)
	{
		idle = image;
		return this;
	}
	
	public Button addHoverState(ImageIcon image)
	{
		hover = image;
		return this;
	}
	
	public void addMouseHoverListener()
	{
		this.addMouseListener(new MouseListener() 
		{	
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) 
			{
				setIcon(hover);
			}
			
			public void mouseExited(MouseEvent e) 
			{
				setIcon(idle);
			}
		});
	}
}