package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.spritesystem.AnimatedSprite;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class CharacterMovementAction extends GameAction
{
	private AnimatedSprite character;
	private AnimationState state;
	private int speed;
	
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
		}
		else if (this.state == AnimationState.back)
		{
			this.character.setLocation(this.character.getLocation().x, this.character.getLocation().y - this.speed);
		}
		else if (this.state == AnimationState.left)
		{
			this.character.setLocation(this.character.getLocation().x - this.speed, this.character.getLocation().y);
		}
		else if (this.state == AnimationState.right)
		{
			this.character.setLocation(this.character.getLocation().x + this.speed, this.character.getLocation().y);
		}
	}
}