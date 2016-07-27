package com.thom.gameengine.test;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.Game;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.gameobjects.GameObject;
import com.thom.gameengine.gameobjects.GameObjectCollider;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.gameengine.spritesystem.SpriteSheet;

@SuppressWarnings("serial")
public class TestGame extends Game
{
	private final String assetsPath = "C:\\Users\\Thomas\\Desktop\\Programming\\Summer Project 2016 - Game Engine\\SpriteSheets\\";
	
	SpriteSheet ss = new SpriteSheet(ImageHandler.getImage(assetsPath + "spritesheet_character.png"), new Dimension(48, 48));
	AnimatedSprite sprite = new AnimatedSprite(ss, 1, 0);
	Player player = new Player(sprite);
	
	EntityCollider playerCollider = new EntityCollider(player, new Dimension(25, 25), new Point(10, 15));
	
	GameObject house, house2;
	
	// World Implementation
	
	public TestGame()
	{
		super(new Dimension(800, 600), true);
		
		Label bg = new Label();
		ComponentHandler.addImageLabel(bg, new Point(0, 0), ImageHandler.getIcon(assetsPath + "bg.png"));
		addComponent(bg, 0);
		
		ComponentHandler.addPlayer(player, new Point(95, 115), playerCollider);
		addComponent(player, 2);
		
		house = new GameObject(ImageHandler.getIcon(assetsPath + "house.png"));
		ComponentHandler.addGameObject(house, new Point(96, 325), new GameObjectCollider());
		addComponent(house, 1);
		
		house2 = new GameObject(ImageHandler.getIcon(assetsPath + "house.png"));
		ComponentHandler.addGameObject(house2, new Point(196, 325), new GameObjectCollider());
		addComponent(house2, 1);
		
		initialize();
	}
	
	@Override
	public void initialize()
	{
		super.initialize();
	}
	
	@Override
	public GameType getGameType()
	{
		return GameType.BIRDVIEW;
	}
	
	@Override
	public void handleKeyBinds()
	{
		KeyBinding.addKeyBind(player, KeyBind.W, new CharacterMovementAction(player, AnimationState.back, 6));
		KeyBinding.addKeyBind(player, KeyBind.A, new CharacterMovementAction(player, AnimationState.left, 6));
		KeyBinding.addKeyBind(player, KeyBind.S, new CharacterMovementAction(player, AnimationState.front, 6));
		KeyBinding.addKeyBind(player, KeyBind.D, new CharacterMovementAction(player, AnimationState.right, 6));
		
		KeyBinding.addKeyBind(gamePanel, KeyBind.Z, new MoveAction(house, house2));
	}
}