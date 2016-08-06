package com.thom.mapcreator.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.thom.mapcreator.gui.ImageHandler;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 03-08-2016
 */
public class ToggleTileNrAction implements MouseListener 
{
	JLabel toggleTileNumbers;
	protected String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	World world;
	
	public ToggleTileNrAction(JLabel toggler, World world) 
	{
		this.toggleTileNumbers = toggler;
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
		if (toggleTileNumbers.getName() == "TILENR OFF")
		{
			toggleTileNumbers.setIcon(ImageHandler.getIcon(assetsPath + "switch_on.png"));
			toggleTileNumbers.setName("TILENR ON");
			
			int k = 0;
			int stage = 0;
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{		
				world.getTileInfoList().get(i).setText(""+(k+stage));
				k++;
				if (k > 37) { k = 0; stage++; }			
			}
		}
		else if (toggleTileNumbers.getName() == "TILENR ON")
		{
			toggleTileNumbers.setIcon(ImageHandler.getIcon(assetsPath + "switch_off.png"));
			toggleTileNumbers.setName("TILENR OFF");
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{		
				world.getTileInfoList().get(i).setText(null);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
