package com.thom.gameengine.test;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.gui.Label;

@SuppressWarnings("serial")
public class MoveImageAction extends GameAction
{
	Label image;
	
	public MoveImageAction(Label image) 
	{
		this.image = image;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		image.setLocation(image.getLocation().x + 5, image.getLocation().y + 10);
	}
}