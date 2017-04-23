package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

public class ExitProgramAction extends GameAction
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.exit(0);
	}
}