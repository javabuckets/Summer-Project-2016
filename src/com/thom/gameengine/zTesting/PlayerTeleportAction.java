package com.thom.gameengine.zTesting;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.player.Player;

@SuppressWarnings("serial")
public class PlayerTeleportAction extends GameAction 
{
	private Player player;
	private int x, y;
	
	public PlayerTeleportAction(Player player, int x, int y) 
	{
		this.player = player;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		player.setLocation(x, y);
	}
}