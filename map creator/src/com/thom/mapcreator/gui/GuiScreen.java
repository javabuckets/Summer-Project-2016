package com.thom.mapcreator.gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	
	/**
	 * Adds a tile to the interactable tile-grid at the specified Point in the specified World.
	 * @since 04-08-2016
	 */
	public static Tile addTile(Point position, JPanel panel, World world)
	{
		Tile tile = new Tile(position);
		tile.setVisible(true);
		tile.addMouseListener(new TileMouseListener(tile));
		panel.add(tile, 5, 0);
		world.getTileList().add(tile);
		return tile;
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
}