package com.thom.gameengine.test;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.Sprite;

@SuppressWarnings("serial")
public class CharacterMovementAction extends GameAction
{
	Player player;
	AnimationState state;
	int speed;
	
	int stage = 1;
	
	public CharacterMovementAction(Player player, AnimationState state, int speed) 
	{
		this.player = player;
		this.state = state;
		this.speed = speed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (this.state == AnimationState.front)
		{
			this.player.setLocation(this.player.getLocation().x, this.player.getLocation().y + this.speed);
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 0));
		}
		else if (this.state == AnimationState.back)
		{
			this.player.setLocation(this.player.getLocation().x, this.player.getLocation().y - this.speed);
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 3));
		}
		else if (this.state == AnimationState.left)
		{
			this.player.setLocation(this.player.getLocation().x - this.speed, this.player.getLocation().y);
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 1));
		}
		else if (this.state == AnimationState.right)
		{
			this.player.setLocation(this.player.getLocation().x + this.speed, this.player.getLocation().y);
			player.setSprite(new Sprite(player.getSprite().getSpriteSheet(), stage, 2));
		}
		stage++;
		if (stage == 3)
			stage = 0;
	}
}