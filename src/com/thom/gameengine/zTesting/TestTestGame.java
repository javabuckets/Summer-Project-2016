package com.thom.gameengine.zTesting;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.Game2D;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.gameobject.ComponentHandler;
import com.thom.gameengine.gameobject.GameObject;
import com.thom.gameengine.gameobject.GameObjectCollider;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.player.PlayerMovementAction;
import com.thom.gameengine.sprite.AnimatedSprite;
import com.thom.gameengine.sprite.SpriteSheet;
import com.thom.gameengine.utility.ImageHandler;

@SuppressWarnings("serial")
public class TestTestGame extends Game2D
{
	private final String assetsPath = "C:\\Users\\Thomas\\Desktop\\Projects\\Summer Project 2016 - Game Engine\\SpriteSheets\\";
	
	SpriteSheet ss = new SpriteSheet(ImageHandler.getImage(assetsPath + "spritesheet_character.png"), new Dimension(48, 48));
	AnimatedSprite sprite = new AnimatedSprite(ss, 1, 0);
	Player player = new Player(sprite);
	GameObjectCollider playerCollider = new GameObjectCollider(player, new Dimension(25, 25), new Point(10, 15));
	
	public TestTestGame() 
	{
		super(new Dimension(512, 512));
		
		GameObject background = new GameObject();
		ComponentHandler.addImage(background, new Point(0, 0), ImageHandler.getIcon(assetsPath + "bgselfmade2.png"));
		addComponent(background, 0);
		
		ComponentHandler.addPlayer(player, new Point(10, 10), playerCollider);
		addComponent(player, 1);
		
		initialize();
	}

	public GameType getGameType() 
	{
		return GameType.BIRDVIEW;
	}
	
	public static void main(String args[])
	{
		TestTestGame testGame = new TestTestGame();
		testGame.setVisible(true);
		
		while (true)
		{
			
		}
	}

	public void handleKeyBinds() 
	{
//		PlayerMovementActionDK pma = new PlayerMovementActionDK(this, player, 24);
//		pma.addMoveAction(player, "A", -2, 0);
//		pma.addMoveAction(player, "D", 2, 0);
//		pma.addMoveAction(player, "W", 0, -2);
//		pma.addMoveAction(player, "S", 0, 2);
		
		KeyBinding.addKeyBind(player, KeyBind.W, new PlayerMovementAction(player, AnimationState.back, 4));
		KeyBinding.addKeyBind(player, KeyBind.A, new PlayerMovementAction(player, AnimationState.left, 4));
		KeyBinding.addKeyBind(player, KeyBind.S, new PlayerMovementAction(player, AnimationState.front, 4));
		KeyBinding.addKeyBind(player, KeyBind.D, new PlayerMovementAction(player, AnimationState.right, 4));
		
		KeyBinding.addKeyBind(player, KeyBind.T, new PlayerTeleportAction(player, 10, 10));
	}
}