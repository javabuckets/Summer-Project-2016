package com.thom.gameengine.gui;

import java.awt.Point;

import javax.swing.ImageIcon;

import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.Sprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
public class ComponentHandler 
{
	public static Player addPlayer(Player player, Point position)
	{
		player.setBounds(position.x, position.y, player.getSprite().getSpriteSheet().getSpriteSizes().width, player.getSprite().getSpriteSheet().getSpriteSizes().height);
		player.setVisible(true);
		return player;
	}
	
	/**
	 * Graphical User Interface
	 */
	public static Sprite addSprite(Sprite sprite, Point position)
	{
		sprite.setBounds(position.x, position.y, sprite.getSpriteSheet().getSpriteSizes().width, sprite.getSpriteSheet().getSpriteSizes().height);
		sprite.setVisible(true);
		return sprite;
	}
	
	public static Label addLabel(Label label, Point position)
	{
		label.setBounds(position.x, position.y, label.getText().length()*6, 12);
		label.setVisible(true);
		return label;
	}
	
	public static Label addImageLabel(Label label, Point position, ImageIcon image)
	{
		label.setIcon(image);
		label.setBounds(position.x, position.y, image.getIconWidth(), image.getIconHeight());
		label.setVisible(true);
		return label;
	}
}
