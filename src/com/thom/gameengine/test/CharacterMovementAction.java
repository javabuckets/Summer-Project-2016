package com.thom.gameengine.test;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.Sprite;

@SuppressWarnings("serial")
public class CharacterMovementAction extends GameAction
{
	AnimatedSprite character;
	AnimationState state;
	int speed;
	
	int stage = 1;
	
	public CharacterMovementAction(AnimatedSprite character, AnimationState state, int speed) 
	{
		this.character = character;
		this.state = state;
		this.speed = speed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (this.state == AnimationState.front)
		{
			this.character.setLocation(this.character.getLocation().x, this.character.getLocation().y + this.speed);
			character.setSprite(new Sprite(character.getSpriteSheet(), stage, 0));
		}
		else if (this.state == AnimationState.back)
		{
			this.character.setLocation(this.character.getLocation().x, this.character.getLocation().y - this.speed);
			character.setSprite(new Sprite(character.getSpriteSheet(), stage, 3));
		}
		else if (this.state == AnimationState.left)
		{
			this.character.setLocation(this.character.getLocation().x - this.speed, this.character.getLocation().y);
			character.setSprite(new Sprite(character.getSpriteSheet(), stage, 1));
		}
		else if (this.state == AnimationState.right)
		{
			this.character.setLocation(this.character.getLocation().x + this.speed, this.character.getLocation().y);
			character.setSprite(new Sprite(character.getSpriteSheet(), stage, 2));
		}
		stage++;
		if (stage == 3)
			stage = 0;
	}
}