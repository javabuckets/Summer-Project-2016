package com.thom.gameengine.test;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.Game;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.ImagerHandler;
import com.thom.gameengine.spritesystem.SpriteSheet;

@SuppressWarnings("serial")
public class TestGame extends Game
{
	private final String assetsPath = "C:\\Users\\Thomas\\Desktop\\Programming\\Summer Project 2016 - Game Engine\\SpriteSheets\\";
	
	SpriteSheet ss = new SpriteSheet(ImagerHandler.getImage(assetsPath + "spritesheet_character.png"), new Dimension(48, 48));;
	AnimatedSprite sprite = new AnimatedSprite(ss, 1, 0);
	Player player = new Player(sprite);
	
	EntityCollider playerCollider = new EntityCollider(player, new Dimension(25, 25), new Point(10, 15));
	
	public TestGame()
	{
		super(new Dimension(800, 600), true);
		
		Label bg = new Label();
		ComponentHandler.addImageLabel(bg, new Point(0, 0), ImagerHandler.getIcon(assetsPath + "bg.png"));
		addComponent(bg, 0);
		
		ComponentHandler.addPlayer(player, new Point(95, 115));
		addComponent(player, 0);
		
		ComponentHandler.addLabel(playerCollider, new Point(5, 5));
		addComponent(playerCollider, 0);
		
		Label house = new Label();
		ComponentHandler.addImageLabel(house, new Point(96, 325), ImagerHandler.getIcon(assetsPath + "house.png"));
		addComponent(house, 0);
		
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
	}
}