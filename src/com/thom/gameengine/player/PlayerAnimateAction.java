package com.thom.gameengine.player;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.sprite.Sprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 01-08-2016
 */
@SuppressWarnings("serial")
public class PlayerAnimateAction extends GameAction
{
	private Player player;
	private AnimationState state;
	
	private int stage = 1;
	
	public PlayerAnimateAction(Player player, AnimationState state) 
	{
		this.player = player;
		this.state = state;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (this.state) 
		{
		case front:
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 0));
			break;
		case back:
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 3));
			break;
		case left:
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 1));
			break;
		case right:
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 2));
			break;
		}
		stage++;
		if (stage == 3)
			stage = 0;
	}
}