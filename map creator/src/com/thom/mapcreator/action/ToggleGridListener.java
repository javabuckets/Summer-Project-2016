package com.thom.mapcreator.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.thom.mapcreator.gui.ImageHandler;
import com.thom.mapcreator.worldobjects.World;

public class ToggleGridListener implements MouseListener 
{
	JLabel toggleGrid;
	protected String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	World world;
	
	public ToggleGridListener(JLabel toggleGrid, World world) 
	{
		this.toggleGrid = toggleGrid;
		this.world = world;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		if (toggleGrid.getName() == "GRID OFF")
		{
			toggleGrid.setIcon(ImageHandler.getIcon(assetsPath + "switch_on.png"));
			toggleGrid.setName("GRID ON");
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).setBorder(new LineBorder(Color.darkGray));	
			}
		}
		else if (toggleGrid.getName() == "GRID ON")
		{
			toggleGrid.setIcon(ImageHandler.getIcon(assetsPath + "switch_off.png"));
			toggleGrid.setName("GRID OFF");
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).setBorder(null);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
