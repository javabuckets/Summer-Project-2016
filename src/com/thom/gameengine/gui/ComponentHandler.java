package com.thom.gameengine.gui;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.gameobjects.GameObject;
import com.thom.gameengine.gameobjects.GameObjectCollider;
import com.thom.gameengine.gameobjects.Particle;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.gameengine.spritesystem.Sprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
public class ComponentHandler 
{
	public static Player addPlayer(Player player, Point position, EntityCollider collider)
	{
		player.setBounds(position.x, position.y, player.getSprite().getSpriteSheet().getSpriteSizes().width, player.getSprite().getSpriteSheet().getSpriteSizes().height);
		player.setVisible(true);
		player.setCollider(collider);
		return player;
	}
	
	public static GameObject addGameObject(GameObject object, Point position, GameObjectCollider collider)
	{
		object.setBounds(position.x, position.y, object.getIcon().getIconWidth(), object.getIcon().getIconHeight());
		object.setVisible(true);
		return object;
	}
	
	/**
	 * @since 23-04-2017
	 */
	public static Particle addParticle(Particle particle, Point position)
	{
		particle.setBounds(position.x, position.y, particle.getSprite().getSpriteSheet().getSpriteSizes().width, particle.getSprite().getSpriteSheet().getSpriteSizes().height);
		particle.setVisible(true);
		return particle;
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
	
	public static Label addScaledImageLabel(Label label, Point position, ImageIcon image, int widthScale, int heightScale)
	{
		Image img = image.getImage().getScaledInstance(widthScale, heightScale, Image.SCALE_DEFAULT);
		addImageLabel(label, position, new ImageIcon(img));
		return label;
	}
}
