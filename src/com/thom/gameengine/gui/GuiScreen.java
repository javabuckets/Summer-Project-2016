package com.thom.gameengine.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.thom.gameengine.keybinding.KeyStrokeList;

public abstract class GuiScreen extends JFrame
{
	public JPanel panel;
	public String assetsPath;
	
	public GuiScreen(String title, Dimension size) 
	{
		initialize();
		
		setSize(size);
		setTitle(title);
		
		panel = new JPanel(null);
		this.add(panel);
		
		drawScreen(size.width, size.height);
		new KeyStrokeList();
		handleKeyBinds();
	}
	
	public void setAssetsPath(String assetsPath) 
	{
		this.assetsPath = assetsPath;
	}
	
	// Initialize is always called first
	public void initialize() { }
	
	public abstract void drawScreen(int width, int height);
	
	public abstract void handleKeyBinds();
}