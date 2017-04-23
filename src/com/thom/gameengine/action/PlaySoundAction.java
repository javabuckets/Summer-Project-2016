package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.soundsystem.SoundHandler;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
@SuppressWarnings("serial")
public class PlaySoundAction extends GameAction
{
	private String soundPath;
	
	public PlaySoundAction(String soundFolder, String sound) 
	{
		this.soundPath = soundFolder + sound;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		SoundHandler.playSound(soundPath);
	}
}