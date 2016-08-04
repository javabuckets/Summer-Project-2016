package com.thom.mapcreator.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.thom.mapcreator.MapCreator;

public class TilePainterListener implements MouseListener 
{
	JLabel tilePainter;
	
	public TilePainterListener(JLabel tilePainter) 
	{
		this.tilePainter = tilePainter;
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		MapCreator.textureSelected = tilePainter.getName();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}
