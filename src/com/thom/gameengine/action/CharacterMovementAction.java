package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.animation.AnimationState;
import com.thom.gameengine.player.Player;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 */
@SuppressWarnings("serial")
public class CharacterMovementAction extends GameAction
{
	private Player player;
	private AnimationState state;
	private int speed;
	
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
		}
		else if (this.state == AnimationState.back)
		{
			this.player.setLocation(this.player.getLocation().x, this.player.getLocation().y - this.speed);
		}
		else if (this.state == AnimationState.left)
		{
			this.player.setLocation(this.player.getLocation().x - this.speed, this.player.getLocation().y);
		}
		else if (this.state == AnimationState.right)
		{
			this.player.setLocation(this.player.getLocation().x + this.speed, this.player.getLocation().y);
		}
	}
}