package com.thom.mapcreator;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.thom.mapcreator.action.FillAction;
import com.thom.mapcreator.action.RegionFillAction;
import com.thom.mapcreator.action.ToggleGridListener;
import com.thom.mapcreator.action.ToggleTileNrAction;
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
	private static String textureSelected = "GRASS";
	
	// Settings
	public static int regionSelectorSetting = 0;
	
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
	static JLabel tps = new JLabel();
	
	JLabel toggleGrid = new JLabel();
	JLabel toggleTileNumbers = new JLabel();
	
	JButton fillButton = new JButton();
	JButton regionSelectionButton = new JButton();
	
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
				GuiScreen.addTileInfo(new Point(i, j), panel, world);
			}
		}
		
		/**
		 * Tile Painters
		 */
		GuiScreen.addLabel(tps, new Point(875, 80), "Selected Tile Painter: " + getTextureSelected(), panel);
		
		GuiScreen.addTilePainter(new Point(875, 100), panel, "GRASS");
		GuiScreen.addTilePainter(new Point(875+20, 100), panel, "WATER");
		GuiScreen.addTilePainter(new Point(875+40, 100), panel, "STONE");

		// Togglers
		
		GuiScreen.addToggler(toggleGrid, new Point(1095, 10), "GRID OFF", panel, ImageHandler.getIcon(assetsPath + "switch_off.png"), new ToggleGridListener(toggleGrid, world));
		GuiScreen.addToggler(toggleTileNumbers, new Point(1050, 10), "TILENR OFF", panel, ImageHandler.getIcon(assetsPath + "switch_off.png"), new ToggleTileNrAction(toggleTileNumbers, world));
		
		// Action Buttons
		GuiScreen.addButton(fillButton, new Point(875, 250), "Fill", panel, new FillAction(world));
		GuiScreen.addButton(regionSelectionButton, new Point(875, 360), "Region Sel.", panel, new RegionFillAction(world));
		
		repaint();
	}
	
	
	
	public static String getTextureSelected()
	{
		return textureSelected;
	}
	
	public static void setTextureSelected(String text)
	{
		textureSelected = text;
		tps.setText("Selected Tile Painter: " + textureSelected);
	}
}