package com.thom.gameengine.soundsystem;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class SoundHandler 
{
	public static void playSound(String soundPath)
	{
		try 
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} 
		catch (Exception e) 
		{
			System.err.println("Couldn't play sound at: " + soundPath);
			e.printStackTrace();
		}
	}
}