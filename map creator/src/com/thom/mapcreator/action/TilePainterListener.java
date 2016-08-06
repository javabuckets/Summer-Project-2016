package com.thom.mapcreator.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.thom.mapcreator.util.MapCreatorUtil;

/**
 * @author Thomas Boel Micheelsen
 * @since 04-08-2016
 */
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
		MapCreatorUtil.setTextureSelected(tilePainter.getName());
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
