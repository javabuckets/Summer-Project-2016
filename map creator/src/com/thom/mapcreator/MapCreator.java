package com.thom.mapcreator;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.thom.mapcreator.gui.GuiScreen;
import com.thom.mapcreator.gui.ImageHandler;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 02-08-2016
 */
@SuppressWarnings("serial")
public class MapCreator extends JFrame
{
	public static String textureSelected = "GRASS";
	
	public static void main(String[] args) 
	{
		new MapCreator();
	}
	
	protected String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	
	private World world = new World();
	
	JPanel panel;
	
	public MapCreator() 
	{
		setSize(new Dimension(1150, 637));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		setVisible(true);
		
		panel = new JPanel(null);
		add(panel);
		
		drawUI();
	}

	JLabel worktemplate = new JLabel();
	
	private void drawUI() 
	{
		// Background Template Image
		GuiScreen.addImage(worktemplate, new Point(0, 0), ImageHandler.getIcon("C:\\Users\\Thomas\\Desktop\\workplate_small.png"));
		panel.add(worktemplate, 10, 0);
		
		/**
		 * Interactable Tile-Grid
		 */
		for (int i = 0; i < 800; i+=16)
		{
			for (int j = 0; j < 608; j+=16)
			{
				GuiScreen.addTile(new Point(i, j), panel, world);
			}
		}
		
		/**
		 * Tile Painters
		 */
		GuiScreen.addTilePainter(new Point(875, 100), panel, "GRASS");
		GuiScreen.addTilePainter(new Point(875+20, 100), panel, "WATER");
		GuiScreen.addTilePainter(new Point(875+40, 100), panel, "STONE");
		
		repaint();
	}
}