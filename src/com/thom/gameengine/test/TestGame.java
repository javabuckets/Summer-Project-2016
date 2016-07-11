package com.thom.gameengine.test;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.Game;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.ImagerHandler;
import com.thom.gameengine.spritesystem.SpriteSheet;

@SuppressWarnings("serial")
public class TestGame extends Game
{
	SpriteSheet ss;
	AnimatedSprite sprite;
	
	public TestGame() 
	{
		super(new Dimension(800, 600), true);
		
		ss = new SpriteSheet(ImagerHandler.getImage("C:\\Users\\Thomas\\Desktop\\spritesheet_character.png"), new Dimension(48, 48));
		sprite = new AnimatedSprite(ss, 1, 0);
		
		ComponentHandler.addSprite(sprite, new Point(10, 10));
		addComponent(sprite);
		
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
		KeyBinding.addKeyBind(sprite, KeyBind.W, new CharacterMovementAction(sprite, AnimationState.back, 6));
		KeyBinding.addKeyBind(sprite, KeyBind.A, new CharacterMovementAction(sprite, AnimationState.left, 6));
		KeyBinding.addKeyBind(sprite, KeyBind.S, new CharacterMovementAction(sprite, AnimationState.front, 6));
		KeyBinding.addKeyBind(sprite, KeyBind.D, new CharacterMovementAction(sprite, AnimationState.right, 6));
	}
}