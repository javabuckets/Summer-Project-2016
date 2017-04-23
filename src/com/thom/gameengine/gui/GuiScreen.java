package com.thom.gameengine.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GuiScreen extends JFrame
{
	public JPanel panel;
	public String assetsPath;
	
	public GuiScreen(String title, Dimension size) 
	{
		setSize(size);
		setTitle(title);
		
		panel = new JPanel(null);
		this.add(panel);
		
		drawScreen(size.width, size.height);
	}
	
	public void setAssetsPath(String assetsPath) 
	{
		this.assetsPath = assetsPath;
	}
	
	public abstract void drawScreen(int width, int height);
}