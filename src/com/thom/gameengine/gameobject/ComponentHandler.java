package com.thom.gameengine.gameobject;

import java.awt.Point;

import javax.swing.ImageIcon;

import com.thom.gameengine.gameobject.GameObject;
import com.thom.gameengine.gameobject.GameObjectCollider;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.sprite.Sprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
public class ComponentHandler 
{
	//addPlayer - Collision Box
	public static Player addPlayer(Player player, Point position, GameObjectCollider collider)
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
	 * Graphical User Interface
	 */
	public static Sprite addSprite(Sprite sprite, Point position)
	{
		sprite.setBounds(position.x, position.y, sprite.getSpriteSheet().getSpriteSizes().width, sprite.getSpriteSheet().getSpriteSizes().height);
		sprite.setVisible(true);
		return sprite;
	}
	
//	public static Label addLabel(Label label, Point position)
//	{
//		label.setBounds(position.x, position.y, label.getText().length()*6, 12);
//		label.setVisible(true);
//		return label;
//	}
	
	public static GameObject addImage(GameObject label, Point position, ImageIcon image)
	{
		label.setIcon(image);
		label.setBounds(position.x, position.y, image.getIconWidth(), image.getIconHeight());
		label.setVisible(true);
		return label;
	}
}
