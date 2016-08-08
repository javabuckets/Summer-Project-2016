package com.thom.mapcreator;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.thom.mapcreator.action.FillAction;
import com.thom.mapcreator.action.FreeHandAction;
import com.thom.mapcreator.action.FreehandKeyListener;
import com.thom.mapcreator.action.SaveLoadAction;
import com.thom.mapcreator.action.ToggleGridListener;
import com.thom.mapcreator.action.ToggleTileNrAction;
import com.thom.mapcreator.gui.GuiScreen;
import com.thom.mapcreator.gui.ImageHandler;
import com.thom.mapcreator.util.MapCreatorUtil;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 02-08-2016
 */
@SuppressWarnings("serial")
public class MapCreator extends JFrame
{
	public static void main(String[] args) 
	{
		new MapCreator();
	}
	
	protected String assetsPath = new String("C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\");
	private World world = new World();
	private JPanel panel;
	
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

	private JLabel worktemplate = new JLabel();
	public static JLabel tps = new JLabel();
	
	private JLabel toggleGrid = new JLabel();
	private JLabel toggleTileNumbers = new JLabel();
	
	private JButton fillButton = new JButton();
	//private JButton regionSelectionButton = new JButton();
	private JButton freehandButton = new JButton();
	
	private JButton save = new JButton();
	private JButton load = new JButton();
	
	private void drawUI() 
	{
		// Background Template Image
		GuiScreen.addImage(worktemplate, new Point(0, 0), ImageHandler.getIcon(assetsPath + "workplate_small.png"));
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
		GuiScreen.addLabel(tps, new Point(875, 80), "Selected Tile Painter: " + MapCreatorUtil.getTextureSelected(), panel);
		// Adds all the sprites from spritesheet as Tile Painters
		GuiScreen.addTilePainters(panel, ImageHandler.getImage(assetsPath + "gamesprite.png"), ImageHandler.getImage(assetsPath + "null.png"));

		/**
		 * Togglers
		 */
		GuiScreen.addToggler(toggleGrid, new Point(1095, 10), "GRID OFF", panel, ImageHandler.getIcon(assetsPath + "switch_off.png"), new ToggleGridListener(toggleGrid, world));
		GuiScreen.addToggler(toggleTileNumbers, new Point(1050, 10), "TILENR OFF", panel, ImageHandler.getIcon(assetsPath + "switch_off.png"), new ToggleTileNrAction(toggleTileNumbers, world));
		
		/**
		 * Actions
		 */
		// Fill
		GuiScreen.addButton(fillButton, new Point(875, 250), "Fill", panel, new FillAction(world));
		// Freehand
		GuiScreen.addButton(freehandButton, new Point(875, 280), "Freehand", panel, new FreeHandAction(freehandButton, world));
		freehandButton.addKeyListener(new FreehandKeyListener());
		
		// Test Subjects
		GuiScreen.addButton(save, new Point(990, 250), "Save", panel, new SaveLoadAction("SAVE", world));
		GuiScreen.addButton(load, new Point(990, 280), "Load", panel, new SaveLoadAction("LOAD", world));
		
		GuiScreen.addButton(new JButton(), new Point(875, 310), "makeFile", panel, new MakeFileAction("write", world));
		GuiScreen.addButton(new JButton(), new Point(990, 310), "readFile", panel, new MakeFileAction("read", world));
		
		repaint();
	}
}