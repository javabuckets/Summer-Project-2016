package com.thom.mapcreator.gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.thom.mapcreator.action.TileMouseListener;
import com.thom.mapcreator.action.TilePainterListener;
import com.thom.mapcreator.util.CustomImageIcon;
import com.thom.mapcreator.util.TileTextureUtil;
import com.thom.mapcreator.worldobjects.Tile;
import com.thom.mapcreator.worldobjects.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 02-08-2016
 */
public class GuiScreen 
{
	public static JLabel addImage(JLabel label, Point position, ImageIcon image)
	{
		label.setIcon(image);
		label.setBounds(position.x, position.y, image.getIconWidth(), image.getIconHeight());
		label.setVisible(true);
		return label;
	}
	
	public static JLabel addLabel(JLabel label, Point pos, String text, JPanel panel)
	{
		label.setText(text);
		label.setBounds(pos.x, pos.y, 200, 12);
		label.setVisible(true);
		panel.add(label, 9, 0);
		return label;
	}
	
	public static JButton addButton(JButton button, Point pos, String text, JPanel panel, ActionListener action)
	{
		button.setBounds(pos.x, pos.y, 100, 20);
		button.setText(text);
		button.addActionListener(action);
		button.setVisible(true);
		panel.add(button, 9, 0);
		return button;
	}
	
	/**
	 * Adds a tile to the interactable tile-grid at the specified Point in the specified World.
	 * @since 04-08-2016
	 */
	public static Tile addTile(Point position, JPanel panel, World world)
	{
		Tile tile = new Tile(position);
		tile.setVisible(true);
		tile.addMouseListener(new TileMouseListener(tile, world));
		tile.setImageIcon(new CustomImageIcon("null"));
		panel.add(tile, 5, 0);
		world.getTileList().add(tile);
		return tile;
	}
	
	public static JLabel addTileInfo(Point pos, JPanel panel, World world)
	{
		JLabel label = new JLabel();
		label.setBounds(pos.x, pos.y, 200, 12);
		label.setVisible(true);
		panel.add(label, 4, 0);
		world.getTileInfoList().add(label);
		return label;
	}
	
	public static JLabel addTilePainter(Point position, JPanel panel, String textureAssigner)
	{
		JLabel tilePainter = new JLabel(TileTextureUtil.getSpriteFromTextureName(textureAssigner.toLowerCase()));
		tilePainter.setBounds(position.x, position.y, 16, 16);
		tilePainter.setBorder(new LineBorder(Color.darkGray));
		tilePainter.setVisible(true);
		tilePainter.setName(textureAssigner);
		tilePainter.addMouseListener(new TilePainterListener(tilePainter));
		panel.add(tilePainter, 9, 0);
		return tilePainter;
	}
	
	public static void addTilePainters(JPanel panel, BufferedImage spritesheet, BufferedImage nullTexture)
	{
		Point startPos = new Point(875, 100);
		
		for (int i = 0; i < spritesheet.getWidth(); i+=16)
		{
			for (int j = 0; j < spritesheet.getHeight(); j+=16)
			{
				BufferedImage subImg = spritesheet.getSubimage(i, j, 16, 16);
				
				if (!ImageHandler.compareImages(subImg, nullTexture))
				{
					JLabel tilePainter = new JLabel(new ImageIcon(subImg));
					tilePainter.setBounds(startPos.x, startPos.y, 16, 16);
					tilePainter.setBorder(new LineBorder(Color.darkGray));
					tilePainter.setVisible(true);
					tilePainter.setName(i + "," + j);
					tilePainter.addMouseListener(new TilePainterListener(tilePainter));
					panel.add(tilePainter, 9, 0);
				
					startPos.y += 20;
					
					if (startPos.y == 220) {
						startPos.y = 100;
						startPos.x += 20; }
				}
			}
		}
	}
	
	public static JLabel addToggler(JLabel toggler, Point position, String name, JPanel panel, ImageIcon offState, MouseListener mouseListener)
	{
		GuiScreen.addImage(toggler, position, offState);
		toggler.setName(name);
		toggler.addMouseListener(mouseListener);
		panel.add(toggler, 9, 0);
		return toggler;
	}
}