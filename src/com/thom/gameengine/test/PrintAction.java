package com.thom.gameengine.test;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;

@SuppressWarnings("serial")
public class PrintAction extends GameAction
{
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Success!");
	}
}