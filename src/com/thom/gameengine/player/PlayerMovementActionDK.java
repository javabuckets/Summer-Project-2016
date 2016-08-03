package com.thom.gameengine.player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.thom.gameengine.*;
import com.thom.gameengine.sprite.*;

/**
 * @author Thomas Boel Micheelsen
 * @since 01-08-2016
 */
public class PlayerMovementActionDK implements ActionListener
{	
	private Game2D game;
	private Player player;
	
	public PlayerMovementActionDK(Game2D game, Player player, int delay) 
	{
		this.game = game;
		this.player = player;
	
		game.timer = new Timer(delay, this);
		game.timer.setInitialDelay(0);
	}
	
	private final static String PRESSED = "pressed ", RELEASED = "released ";
	
	public void addMoveAction(Player player, String keyStroke, int deltaX, int deltaY)
	{
		int offset = keyStroke.lastIndexOf(" ");
		String key = offset == -1 ? keyStroke : keyStroke.substring(offset + 1);
		String modifiers = keyStroke.replace(key, "");
		
		InputMap inputMap = player.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = player.getActionMap();
		
		Action pressedAction = new AnimationAction(key, new Point(deltaX, deltaY), player, PRESSED);
		String pressedKey = modifiers + PRESSED + key;
		KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(pressedKey);
		inputMap.put(pressedKeyStroke, pressedKey);
		actionMap.put(pressedKey, pressedAction);
		
		Action releasedAction = new AnimationAction(key, null, player, RELEASED);
		String releasedKey = modifiers + RELEASED + key;
		KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(releasedKey);
		inputMap.put(releasedKeyStroke, releasedKey);
		actionMap.put(releasedKey, releasedAction);
	}
	
	// Animation
	int stage = 1;
	
	@SuppressWarnings("serial")
	public class AnimationAction extends AbstractAction implements ActionListener 
	{
		private Point moveDelta;
		private String key, keyState;
		private Player player;

		public AnimationAction(String key, Point moveDelta, Player player, String keyState)
		{
			super(key);
			this.key = key;
			this.keyState = keyState;
			this.player = player;
			this.moveDelta = moveDelta;
		}

		public void actionPerformed(ActionEvent e)
		{
			handleKeyEvent((String)getValue(NAME), moveDelta);
			
			handleAnimation(keyState+key);
		}
		
		public void handleAnimation(String key)
		{
			System.out.println(key);
			
			switch (key) 
			{
			case "pressed W":
				player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 3));
				break;
			case "pressed A":
				player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 1));
				break;
			case "pressed S":
				player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 0));
				break;
			case "pressed D":
				player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 2));
				break;
			}
			
			stage++;
			if (stage == 3)
				stage = 0;
		}
	}
	
	public void handleKeyEvent(String key, Point moveDelta)
	{
		if (moveDelta == null)
			game.pressedKeys.remove(key);
		else
			game.pressedKeys.put(key, moveDelta);
		
		if (game.pressedKeys.size() == 1)
			game.timer.start();
		
		if (game.pressedKeys.size() == 0)
			game.timer.stop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		moveComponent();
	}

	private void moveComponent() 
	{
		int componentWidth = player.getSize().width;
		int componentHeight = player.getSize().height;
		
		Dimension parentSize = player.getParent().getSize();
		int parentWidth = parentSize.width;
		int parentHeight = parentSize.height;
		
		// Calc
		
		int deltaX = 0;
		int deltaY = 0;
		
		for (Point delta : game.pressedKeys.values())
		{
			deltaX += delta.x;
			deltaY += delta.y;
		}
		
		// New Pos
		
		int nextX = Math.max(player.getLocation().x + deltaX, 0);
		
		if (nextX + componentWidth > parentWidth)
		{
			nextX = parentWidth - componentWidth;
		}
		
		int nextY = Math.max(player.getLocation().y + deltaY, 0);
		
		if (nextY + componentHeight > parentHeight)
		{
			nextY = parentWidth - componentHeight;
		}
		
		player.setLocation(nextX, nextY);
	}
}